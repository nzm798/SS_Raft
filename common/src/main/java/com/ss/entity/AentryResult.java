package com.ss.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * RPC日志复制情况返回值
 */
@Getter
@Setter
@ToString
public class AentryResult implements Serializable {
    //当前的任期号
    Long term;
    //跟随者包含了匹配上 prevLogIndex 和 prevLogTerm 的日志时为真
    boolean success;
    public AentryResult(boolean success){
        this.success=success;
    }
    public AentryResult(Long term, boolean success){
        this.term=term;
        this.success=success;
    }
    public AentryResult(Builder builder){
        setTerm(builder.term);
        setSuccess(builder.success);
    }
    public static AentryResult fail(){
        return new AentryResult(false);
    }
    public static AentryResult ok(){
        return new AentryResult(true);
    }
    public static Builder newBuilder(){return new Builder();}
    public static final class Builder{
        Long term;
        boolean success;
        public Builder(){}
        public Builder Term(Long term){
            this.term=term;
            return this;
        }
        public Builder Success(boolean success){
            this.success=success;
            return this;
        }
        public AentryResult build(){
            return new AentryResult(this);
        }
    }

}
