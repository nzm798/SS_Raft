package com.ss.rpc;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Response<T> implements Serializable{
    private T result;
    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                '}';
    }
    public Response(T result){this.result=result;}
    public Response(Builder builder){
        setResult((T) builder.result);
    }
    public static final class Builder{
        private Object result;
        public Builder(){}
        public Builder result(Object result){
            this.result=result;
            return this;
        }
        public Response<?> build(){
            return new Response(this);
        }
    }
}
