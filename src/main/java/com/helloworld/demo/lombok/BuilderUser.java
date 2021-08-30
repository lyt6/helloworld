package com.helloworld.demo.lombok;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuilderUser {
    private String name;
    private Integer age;
}

