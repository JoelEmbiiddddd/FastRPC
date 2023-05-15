package cn.fastrpc.rpc.client.proxy;

import cn.fastrpc.rpc.client.config.RpcClientProperties;
import cn.fastrpc.rpc.core.discovery.DiscoveryService;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @File : ClientStubProxyFactory.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public class ClientStubProxyFactory {

    private Map<Class<?>, Object> objectCache = new HashMap<>();

    /**
     * 获取代理对象
     *
     * @param clazz   接口
     * @param version 服务版本
     * @param <T>
     * @return 代理对象
     */
    public <T> T getProxy(Class<T> clazz, String version, DiscoveryService discoveryService, RpcClientProperties properties) {
        return (T) objectCache.computeIfAbsent(clazz, clz ->
                Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new ClientStubInvocationHandler(discoveryService, properties, clz, version))
        );
    }
}
