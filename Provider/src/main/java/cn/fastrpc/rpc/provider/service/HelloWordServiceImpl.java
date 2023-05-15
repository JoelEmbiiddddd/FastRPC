package cn.fastrpc.rpc.provider.service;

import cn.fastrpc.rpc.api.service.HelloWordService;
import cn.fastrpc.rpc.server.annotation.RpcService;

/**
 * @File : HelloWordServiceImpl.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@RpcService(interfaceType = HelloWordService.class, version = "1.0")
public class HelloWordServiceImpl implements HelloWordService {

    @Override
    public String sayHello(String name) {
        return String.format("您好：%s, rpc 调用成功", name);
    }

}