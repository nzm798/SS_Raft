package com.ss;

/**
 * 异常处理类
 */
public class RaftRemotingException extends RuntimeException{
    public RaftRemotingException(){
        super();
    }
    public RaftRemotingException(String message){
        super(message);
    }
    public RaftRemotingException(String message, Throwable cause){
        super(message,cause);
    }
    public RaftRemotingException(Throwable cause){
        super(cause);
    }
}
