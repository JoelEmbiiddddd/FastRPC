package cn.fastrpc.rpc.server.transport;

/**
 * @File : RpcServer.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/15
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public interface RpcServer {

    /**
     * 开启服务
     */
    void start(int port);

}