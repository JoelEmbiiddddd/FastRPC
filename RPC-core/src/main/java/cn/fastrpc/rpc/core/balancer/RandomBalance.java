package cn.fastrpc.rpc.core.balancer;

import cn.fastrpc.rpc.core.common.ServiceInfo;

import java.util.List;
import java.util.Random;

/**
 * @File : RandomBalance.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public class RandomBalance implements LoadBalance{

    private static Random random = new Random();

    @Override
    public ServiceInfo chooseOne(List<ServiceInfo> services) {
        return services.get(random.nextInt(services.size()));
    }
}
