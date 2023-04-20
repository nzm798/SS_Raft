package com.ss.entity;

import java.util.List;

/**
 * 节点配置
 */
public class NodeConfig {
    //自身节点的ID
    public int selfPort;
    //每个节点的地址
    public List<String> peerAddrs;
    //状态快照的存储类型
    public String stateMachineSaveType;

}
