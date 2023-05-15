package cn.fastrpc.rpc.client.transport;

import cn.fastrpc.rpc.core.common.RpcResponse;
import cn.fastrpc.rpc.core.protocol.MessageProtocol;

/**
 * @File : NetClientTransport.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/13
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public interface NetClientTransport {

    /**
     *  发送数据
     * @param metadata
     * @return
     * @throws Exception
     */
    MessageProtocol<RpcResponse> sendRequest(RequestMetadata metadata) throws Exception;

}

