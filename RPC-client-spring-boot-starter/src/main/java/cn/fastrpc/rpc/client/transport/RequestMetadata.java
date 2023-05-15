package cn.fastrpc.rpc.client.transport;

import cn.fastrpc.rpc.core.common.RpcRequest;
import cn.fastrpc.rpc.core.protocol.MessageProtocol;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @File : RequestMetadata.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Data
@Builder
public class RequestMetadata implements Serializable {

    /**
     *  协议
     */
    private MessageProtocol<RpcRequest> protocol;

    /**
     *  地址
     */
    private String address;

    /**
     *  端口
     */
    private Integer port;

    /**
     *  服务调用超时
     */
    private Integer timeout;

}