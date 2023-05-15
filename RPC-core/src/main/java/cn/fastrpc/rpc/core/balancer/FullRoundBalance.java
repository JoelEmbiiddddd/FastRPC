package cn.fastrpc.rpc.core.balancer;

import cn.fastrpc.rpc.core.common.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
/**
 * @File : FullRoundBalance.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public class FullRoundBalance implements LoadBalance {

    private static Logger logger = LoggerFactory.getLogger(FullRoundBalance.class);

    private int index;

    @Override
    public synchronized ServiceInfo chooseOne(List<ServiceInfo> services) {
        // 加锁防止多线程情况下，index超出services.size()
        if (index >= services.size()) {
            index = 0;
        }
        return services.get(index++);
    }
}
