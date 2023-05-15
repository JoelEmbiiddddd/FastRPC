package cn.fastrpc.rpc.core.serialization;

import java.io.IOException;

/**
 * @File : RpcSerialization.py
 * @Author : LiXin Huang, NWPU
 * @Date : 2023/5/13
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public interface RpcSerialization {
    <T> byte[] serialize(T obj) throws IOException;

    <T> T deserialize(byte[] data, Class<T> clz) throws IOException;
}
