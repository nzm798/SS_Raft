package com.ss.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 客户端请求处理返回结果
 */
@Getter
@Setter
@ToString
public class ClientKVAck implements Serializable {
    Object result;
    public ClientKVAck (Object result){
        this.result=result;
    }
    public ClientKVAck(Builder builder){
        setResult(builder.result);
    }
    public static ClientKVAck fail(){
        return new ClientKVAck("fail");
    }
    public static ClientKVAck ok(){
        return new ClientKVAck("ok");
    }
    public static Builder newBuilder(){
        return new Builder();
    }
    public static final class Builder{
        Object result;
        public Builder(){

        }
        public Builder Result(Object result){
            this.result=result;
            return this;
        }
        public ClientKVAck build(){
            return new ClientKVAck(this);
        }
    }
}
