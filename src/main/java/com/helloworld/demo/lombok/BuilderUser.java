package com.helloworld.demo.lombok;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class BuilderUser {
    private String name;
    private Integer age;
}

