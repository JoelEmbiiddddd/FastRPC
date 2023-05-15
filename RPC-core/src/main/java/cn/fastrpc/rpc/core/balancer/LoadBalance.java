package cn.fastrpc.rpc.core.balancer;

import cn.fastrpc.rpc.core.common.ServiceInfo;

import java.util.List;
/**
 * @File : LoadBalance.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/13
 * @Desc : 负载均衡算法接口
 * @Email : iHuanglixin@outlook.com
 */

public interface LoadBalance {
    ServiceInfo chooseOne(List<ServiceInfo> services);
}
