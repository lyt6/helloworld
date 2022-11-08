package com.hello.javase.functional.ordersave;

public class OrderServiceTest {
    public static void main(String[] args) {
        OrderServiceContext context1 = new OrderServiceContext((Long orderId) -> {
            System.out.println("implement function1");
        });
        context1.save(123L);

        OrderServiceContext context2 = new OrderServiceContext((Long orderId) -> {
            System.out.println("implement function2");
        });
        context1.save(456L);
    }
}
