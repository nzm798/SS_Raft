package com.ss.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class RvoteResult implements Serializable {
    Long term; //接收方的任期ID
    boolean voteGranted; //接收方是否同意给出选票
    public RvoteResult(boolean voteGranted){
        this.voteGranted=voteGranted;
    }
    public RvoteResult(Builder builder){
        setTerm(builder.term);
        setVoteGranted(builder.voteGranted);
    }
    public static RvoteResult fail(){
        return new RvoteResult(false);
    }
    public static RvoteResult ok(){
        return new RvoteResult(true);
    }
    public static Builder newBuilder(){
        return new Builder();
    }

    public static final class Builder{
        Long term;
        boolean voteGranted;
        public Builder(){}
        public Builder Term(Long term){
            this.term=term;
            return this;
        }
        public Builder VoteGranted(boolean voteGranted){
            this.voteGranted=voteGranted;
            return this;
        }
        public RvoteResult build(){
            return new RvoteResult(this);
        }
    }
}
