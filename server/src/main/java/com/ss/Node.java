package com.ss;

import com.ss.entity.*;

/**
 * 同时，为了聚合上面的几个接口，需要定义一个 Node 接口，即节点，Raft 抽象的机器节点。
 */
public interface Node extends LifeCycle{
    /**
     * 配置节点的信息
     * @param nodeConfig
     */
    void setConfig(NodeConfig nodeConfig);

    /**
     * RPC投票请求获取
     * @param param
     * @return
     */
    RvoteResult handlerRequestVote(RvoteParam param);

    /**
     * 附加日志RPC请求处理
     * @param param
     * @return
     */
    AentryResult handlerAppendEntries(AentryParam param);

    /**
     * 客户端请求处理
     * @param req
     * @return
     */
    ClientKVAck handlerClientRequest(ClientKVReq req);

    /**
     * 将请求转发给Leader节点
     * @param req
     * @return
     */
    ClientKVAck redirect(ClientKVReq req);
}
