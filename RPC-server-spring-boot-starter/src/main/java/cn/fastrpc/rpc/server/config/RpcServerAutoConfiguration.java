package cn.fastrpc.rpc.server.config;

import cn.fastrpc.rpc.core.register.RegistryService;
import cn.fastrpc.rpc.core.register.ZookeeperRegistryService;
import cn.fastrpc.rpc.server.RpcServerProvider;
import cn.fastrpc.rpc.server.transport.NettyRpcServer;
import cn.fastrpc.rpc.server.transport.RpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @File : RpcServerAutoConfiguration.py
 * @Author : LiXin Huang, NWPU
 * @Desc : rpc server 配置
 * @Email : iHuanglixin@outlook.com
 */

@Configuration
@EnableConfigurationProperties(RpcServerProperties.class)
public class RpcServerAutoConfiguration {

    @Autowired
    private RpcServerProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public RegistryService registryService() {
        return new ZookeeperRegistryService(properties.getRegistryAddr());
    }

    @Bean
    @ConditionalOnMissingBean(RpcServer.class)
    public RpcServer RpcServer() {
        return new NettyRpcServer();
    }

    @Bean
    @ConditionalOnMissingBean(RpcServerProvider.class)
    public RpcServerProvider rpcServerProvider(@Autowired RegistryService registryService,
                                               @Autowired RpcServer rpcServer,
                                               @Autowired RpcServerProperties rpcServerProperties){
        return new RpcServerProvider(registryService, rpcServer, rpcServerProperties);
    }
}
