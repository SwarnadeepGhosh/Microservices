package com.swarna.microservices.limitservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limits {
    private int limitId;
    private int minimum;
    private int maximum;
}
