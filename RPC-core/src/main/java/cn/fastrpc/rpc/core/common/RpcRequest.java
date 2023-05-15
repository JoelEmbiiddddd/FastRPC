package cn.fastrpc.rpc.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @File : RpcRequest.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Data
public class RpcRequest implements Serializable {

    /**
     * 请求的服务名 + 版本
     */
    private String serviceName;
    /**
     * 请求调用的方法
     */
    private String method;

    /**
     *  参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     *  参数
     */
    private Object[] parameters;

}
