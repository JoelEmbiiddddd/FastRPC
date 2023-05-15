package cn.fastrpc.rpc.core.serialization;

/**
 * @File : SerializationFactory.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public class SerializationFactory {

    public static RpcSerialization getRpcSerialization(SerializationTypeEnum typeEnum) {
        switch (typeEnum) {
            case HESSIAN:
                return new HessianSerialization();
            case JSON:
                return new JsonSerialization();
            default:
                throw new IllegalArgumentException("serialization type is illegal");
        }
    }

}
