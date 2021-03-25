package com.helloworld.demo.springboot;

import com.helloworld.demo.lombok.BuilderUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(UserConditional.class)
@Configuration
public class ConditionConfig {
    @Bean
    public BuilderUser builderUser() {
        BuilderUser user = new BuilderUser();
        user.setAge(18);
        user.setName("哈哈");
        return user;
    }
}
