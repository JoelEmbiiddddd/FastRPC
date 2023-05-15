package cn.fastrpc.rpc.core.discovery;

import cn.fastrpc.rpc.core.common.ServiceInfo;

/**
 * @File : DiscoveryService.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/13
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public interface DiscoveryService {

    /**
     *  发现
     * @param serviceName
     * @return
     * @throws Exception
     */
    ServiceInfo discovery(String serviceName) throws Exception;

}
