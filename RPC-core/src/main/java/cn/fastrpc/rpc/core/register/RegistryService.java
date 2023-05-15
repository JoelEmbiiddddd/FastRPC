package cn.fastrpc.rpc.core.register;

import cn.fastrpc.rpc.core.common.ServiceInfo;

import java.io.IOException;

/**
 * @File : RegistryService.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/13
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public interface RegistryService {

    void register(ServiceInfo serviceInfo) throws Exception;

    void unRegister(ServiceInfo serviceInfo) throws Exception;

    void destroy() throws IOException;

}

