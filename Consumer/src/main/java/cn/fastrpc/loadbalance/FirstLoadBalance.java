package cn.fastrpc.loadbalance;

import cn.fastrpc.rpc.core.balancer.LoadBalance;
import cn.fastrpc.rpc.core.common.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @File : FirstLoadBalance.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Slf4j
//@Component
public class FirstLoadBalance implements LoadBalance {

    @Override
    public ServiceInfo chooseOne(List<ServiceInfo> services) {
        log.info("---------FirstLoadBalance-----------------");
        return services.get(0);
    }
}

