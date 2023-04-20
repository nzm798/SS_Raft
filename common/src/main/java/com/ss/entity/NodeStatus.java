package com.ss.entity;

import lombok.Getter;

/**
 * 节点的所处状态
 */
public interface NodeStatus {
    int FOLLOWER = 0;
    int CANDIDATE = 1;
    int LEADER = 2;

    @Getter
    enum Enum {
        FOLLOWER(0), CANDIDATE(1), LEADER(2);
        int code;

        Enum(int code) {
            this.code = code;
        }

        public static Enum value(int i) {
            for (Enum value : values()) {
                if (value.code == i) {
                    return value;
                }
            }
            return null;
        }
    }
}
