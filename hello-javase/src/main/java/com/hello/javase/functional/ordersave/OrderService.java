package com.hello.javase.functional.ordersave;

/**
 * 只有一个方法的接口声明为函数
 */
@FunctionalInterface
public interface OrderService {
    void saveOrder(Long orderId);
}
