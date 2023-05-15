package cn.fastrpc.rpc.client.transport;

import lombok.extern.slf4j.Slf4j;
/**
 * @File : NetClientTransportFactory.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */
@Slf4j
public class NetClientTransportFactory {
    public static NetClientTransport getNetClientTransport(){
        return new NettyNetClientTransport();
    }
}
