package com.ss.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 请求投票传递参数
 */
@Setter
@Getter
@Builder
@Data
public class RvoteParam implements Serializable {
    //候选人的任期
    private Long term;
    //被请求者 ID(ip:selfPort)
    private String serverId;
    //请求选票的候选人ID
    private String candidateId;
    //候选人所持有的最后一条日志记录的index
    private Long lastLogIndex;
    //候选人所持有的最后一条日志记录的Term ID
    private Long lastLogTerm;
}
