package com.helloworld.demo.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.stream.Stream;

public class UserConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return Stream.of(conditionContext.getEnvironment().getActiveProfiles()).anyMatch(p->!p.equals("prod"));
    }
}
