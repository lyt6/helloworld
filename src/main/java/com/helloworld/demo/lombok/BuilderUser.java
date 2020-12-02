package com.helloworld.demo.lombok;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuilderUser {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        BuilderUser user = BuilderUser.builder().age(1).name("哈哈").build();
        System.out.println(JSONObject.toJSONString(user));
    }
}

