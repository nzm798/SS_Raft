package com.ss;

import com.ss.entity.LogEntry;

/**
 * 状态机接口
 */
public interface StateMachine extends LifeCycle {
    //将日志应用到状态机
    void apply(LogEntry logEntry);

    LogEntry get(String key);

    String getString(String key);

    void setString(String key, String value);

    void delString(String... key);
}
