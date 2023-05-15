package cn.fastrpc.rpc.core.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @File : MessageProtocol.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Data
public class MessageProtocol<T> implements Serializable {

    /**
     *  消息头
     */
    private MessageHeader header;

    /**
     *  消息体
     */
    private T body;

}
