package com.ss.entity;

import lombok.*;

import java.io.Serializable;

/**
 * 日志条目
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogEntry implements Serializable,Comparable {
    private Long term;
    private Long index;
    //传递的具体的k-v日志数据
    private Command command;
    public int compareTo(Object o) {
        if (o==null){
            return -1;
        }
        if (this.getIndex()>((LogEntry) o).getIndex()){
            return 1;
        }
        return -1;
    }
}
