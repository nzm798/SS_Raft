package com.ss;

import com.ss.entity.AentryParam;
import com.ss.entity.AentryResult;
import com.ss.entity.RvoteParam;
import com.ss.entity.RvoteResult;

/**
 * 一致性模块接口
 * 实现Leader选举和日志复制的功能
 * @author Three-water
 */
public interface Consensus {
    /**
     * 请求投票RPC
     *
     * 接收者实现对投票者是否符合条件进行判断：
     *      如果term < currentTerm返回 false
     *      如果 votedFor 为空或者就是 candidateId，并且候选人的日志至少和自己一样新，那么就投票给他
     * @param param
     * @return
     */
    RvoteResult requestVote(RvoteParam param);

    /**
     * 附加日志同步RPC请求
     * 接收者实现：
     *    如果 term < currentTerm 就返回 false
     *    如果日志在 prevLogIndex 位置处的日志条目的任期号和 prevLogTerm 不匹配，则返回 false
     *    如果已经存在的日志条目和新的产生冲突（索引值相同但是任期号不同），删除这一条和之后所有的
     *    附加任何在已有的日志中不存在的条目
     *    如果 leaderCommit > commitIndex，令 commitIndex 等于 leaderCommit 和 新日志条目索引值中较小的一个
     * @param param
     * @return
     */
    AentryResult appendEntries(AentryParam param);
}
