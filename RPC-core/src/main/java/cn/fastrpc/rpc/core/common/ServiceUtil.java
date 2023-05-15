package cn.fastrpc.rpc.core.common;

/**
 * @File : ServiceUtil.py
 * @Author : LiXin Huang, NWPU
 * @Desc :
 * @Email : iHuanglixin@outlook.com
 */

public class ServiceUtil {

    /**
     *
     * @param serviceName
     * @param version
     * @return
     */
    public static String serviceKey(String serviceName, String version) {
        return String.join("-", serviceName, version);
    }

}
