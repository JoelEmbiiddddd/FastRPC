package cn.fastrpc.rpc.client.config;

import lombok.Data;

/**
 * @File : RpcClientProperties.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

@Data
public class RpcClientProperties {

    /**
     *  负载均衡
     */
    private String balance;

    /**
     *  序列化
     */
    private String serialization;

    /**
     *  服务发现地址
     */
    private String discoveryAddr = "127.0.0.1:2181";

    /**
     *  服务调用超时
     */
    private Integer timeout;

}

