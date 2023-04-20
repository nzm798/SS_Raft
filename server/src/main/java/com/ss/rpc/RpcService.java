package com.ss.rpc;

import com.ss.LifeCycle;

public interface RpcService extends LifeCycle {
    /**
     * 处理请求
     * @param request 请求
     * @return 返回值
     */
    Response<?> handlerRequest(Request request);
}
