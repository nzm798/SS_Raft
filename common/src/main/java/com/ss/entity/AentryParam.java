package com.ss.entity;

import java.io.Serializable;

/**
 * RPC附加日志需要传递的参数
 */
public class AentryParam implements Serializable {
    //Leader的任期Id
    private Long term;
    //Leader的ID
    private String leaderId;
    //被请求者的ID
    private String serverId;
    //在正在备份的日志记录之前的日志记录的 index 值
    private Long prevLogIndex;
    //在正在备份的日志记录之前的日志记录的 Term ID
    private Long prevLogTerm;
    //正在备份的日志记录
    private LogEntry[] entries;
    //Leader 已经提交的最后一条日志记录的 index 值
    private Long leaderCommmit;
}
