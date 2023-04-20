package com.ss.entity;

import lombok.*;

import java.io.Serializable;

/**
 * k-v存储的具体数据
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Command implements Serializable {
    String key;
    String value;
}
