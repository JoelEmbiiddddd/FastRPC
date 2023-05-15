package cn.fastrpc.rpc.client.handler;

import cn.fastrpc.rpc.client.cache.LocalRpcResponseCache;
import cn.fastrpc.rpc.core.common.RpcResponse;
import cn.fastrpc.rpc.core.protocol.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @File : RpcResponseHandler.py
 * @Author : LiXin Huang, NWPU
 * @Description bean 后置处理器 获取所有bean
 * 判断bean字段是否被 {@link com.rrtv.rpc.client.annotation.RpcAutowired } 注解修饰
 * 动态修改被修饰字段的值为代理对象 {@link ClientStubProxyFactory}
 * @Email : iHuanglixin@outlook.com
 */

@Slf4j
public class RpcResponseHandler extends SimpleChannelInboundHandler<MessageProtocol<RpcResponse>> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol<RpcResponse> rpcResponseMessageProtocol) throws Exception {
        String requestId = rpcResponseMessageProtocol.getHeader().getRequestId();
        // 收到响应 设置响应数据
        LocalRpcResponseCache.fillResponse(requestId, rpcResponseMessageProtocol);
    }
}
