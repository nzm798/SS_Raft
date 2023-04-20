package com.ss.rpc;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Builder
@Data
public class Request implements Serializable {
    //请求投票
    public static final int R_VOTE = 0;
    //附加日志
    public static final int A_ENTRIES = 1;
    //客户端
    public static final int CLIENT_REQ = 2;
    //配置变更. add
    public static final int CHANGE_CONFIG_ADD = 3;
    //配置变更. remove
    public static final int CHANGE_CONFIG_REMOVE = 4;


    //请求类型
    public int cmd=-1;

    private Object object;

    private String url;

    public Request(){}
    public Request(int cmd,Object object,String url){
        this.cmd=cmd;
        this.object=object;
        this.url=url;
    }
}
