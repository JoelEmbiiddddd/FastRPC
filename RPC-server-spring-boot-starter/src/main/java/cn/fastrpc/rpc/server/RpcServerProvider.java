package cn.fastrpc.rpc.server;

import cn.fastrpc.rpc.core.common.ServiceInfo;
import cn.fastrpc.rpc.core.common.ServiceUtil;
import cn.fastrpc.rpc.core.register.RegistryService;
import cn.fastrpc.rpc.server.annotation.RpcService;
import cn.fastrpc.rpc.server.config.RpcServerProperties;
import cn.fastrpc.rpc.server.store.LocalServerCache;
import cn.fastrpc.rpc.server.transport.RpcServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * @File : RpcServerProvider.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Slf4j
public class RpcServerProvider implements BeanPostProcessor, CommandLineRunner {

    private RegistryService registryService;

    private RpcServerProperties properties;

    private RpcServer rpcServer;

    public RpcServerProvider(RegistryService registryService, RpcServer rpcServer, RpcServerProperties properties) {
        this.registryService = registryService;
        this.properties = properties;
        this.rpcServer = rpcServer;
    }


    /**
     * 所有bean 实例化之后处理
     * <p>
     * 暴露服务注册到注册中心
     * <p>
     * 容器启动后开启netty服务处理请求
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        RpcService rpcService = bean.getClass().getAnnotation(RpcService.class);
        if (rpcService != null) {
            try {
                String serviceName = rpcService.interfaceType().getName();
                String version = rpcService.version();
                LocalServerCache.store(ServiceUtil.serviceKey(serviceName, version), bean);

                ServiceInfo serviceInfo = new ServiceInfo();
                serviceInfo.setServiceName(ServiceUtil.serviceKey(serviceName, version));
                serviceInfo.setPort(properties.getPort());
                serviceInfo.setAddress(InetAddress.getLocalHost().getHostAddress());
                serviceInfo.setAppName(properties.getAppName());

                // 服务注册
                registryService.register(serviceInfo);
            } catch (Exception ex) {
                log.error("服务注册出错:{}", ex);
            }
        }
        return bean;
    }

    /**
     * 启动rpc服务 处理请求
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        new Thread(() -> rpcServer.start(properties.getPort())).start();
        log.info(" rpc server :{} start, appName :{} , port :{}", rpcServer, properties.getAppName(), properties.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                // 关闭之后把服务从ZK上清楚
                registryService.destroy();
            }catch (Exception ex){
                log.error("", ex);
            }

        }));
    }

}

