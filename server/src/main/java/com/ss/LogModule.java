package com.ss;

import com.ss.entity.LogEntry;

/**
 * 日志接口
 */
public interface LogModule extends LifeCycle {
    void write(LogEntry logEntry);

    LogEntry read(Long index);

    void removeOnStartIndex(Long startIndex);

    LogEntry getLast();

    Long getLastIndex();
}
