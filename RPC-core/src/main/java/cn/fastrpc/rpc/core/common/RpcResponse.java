package cn.fastrpc.rpc.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @File : RpcResponse.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Data
public class RpcResponse implements Serializable {

    private Object data;
    private String message;

}