package cn.fastrpc.rpc.client.config;

import cn.fastrpc.rpc.client.proxy.ClientStubProxyFactory;
import cn.fastrpc.rpc.client.processor.RpcClientProcessor;
import cn.fastrpc.rpc.core.balancer.FullRoundBalance;
import cn.fastrpc.rpc.core.balancer.LoadBalance;
import cn.fastrpc.rpc.core.balancer.RandomBalance;
import cn.fastrpc.rpc.core.discovery.DiscoveryService;
import cn.fastrpc.rpc.core.discovery.ZookeeperDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

/**
 * @File : RpcClientAutoConfiguration.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Configuration
public class RpcClientAutoConfiguration {

    @Bean
    public RpcClientProperties rpcClientProperties(Environment environment) {
        BindResult<RpcClientProperties> result = Binder.get(environment).bind("rpc.client", RpcClientProperties.class);
        return result.get();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClientStubProxyFactory clientStubProxyFactory() {
        return new ClientStubProxyFactory();
    }


    @Primary
    @Bean(name = "loadBalance")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "rpc.client", name = "balance", havingValue = "randomBalance", matchIfMissing = true)
    public LoadBalance randomBalance() {
        return new RandomBalance();
    }

    @Bean(name = "loadBalance")
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "rpc.client", name = "balance", havingValue = "fullRoundBalance")
    public LoadBalance loadBalance() {
        return new FullRoundBalance();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean({RpcClientProperties.class, LoadBalance.class})
    public DiscoveryService discoveryService(@Autowired RpcClientProperties properties,
                                             @Autowired LoadBalance loadBalance) {
        return new ZookeeperDiscoveryService(properties.getDiscoveryAddr(), loadBalance);
    }

    @Bean
    @ConditionalOnMissingBean
    public RpcClientProcessor rpcClientProcessor(@Autowired ClientStubProxyFactory clientStubProxyFactory,
                                                 @Autowired DiscoveryService discoveryService,
                                                 @Autowired RpcClientProperties properties) {
        return new RpcClientProcessor(clientStubProxyFactory, discoveryService, properties);
    }

}
