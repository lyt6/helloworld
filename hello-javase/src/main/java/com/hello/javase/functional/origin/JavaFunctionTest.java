package com.hello.javase.functional.origin;

import java.util.function.Supplier;

public class JavaFunctionTest {
    /*
        BiConsumer
        BiFunction
        BinaryOperator
        BiPredicate
        BooleanSupplier
        Consumer
        DoubleBinaryOperator
        DoubleConsumer
        DoubleFunction
        DoublePredicate
        DoubleSupplier
        DoubleToIntFunction
        DoubleToLongFunction
        DoubleUnaryOperator
        Function
        IntBinaryOperator
        IntConsumer
        IntFunction
        IntPredicate
        IntSupplier
        IntToDoubleFunction
        IntToLongFunction
        IntUnaryOperator
        LongBinaryOperator
        LongConsumer
        LongFunction
        LongPredicate
        LongSupplier
        LongToDoubleFunction
        LongToIntFunction
        LongUnaryOperator
        ObjDoubleConsumer
        ObjIntConsumer
        ObjLongConsumer
        Predicate
        Supplier
        ToDoubleBiFunction
        ToDoubleFunction
        ToIntBiFunction
        ToIntFunction
        ToLongBiFunction
        ToLongFunction
        UnaryOperator
     */
    public static void main(String[] args) {
        // producer
        // get is invoke
        Supplier s = ()->"sss";
        Supplier<String> ss = ()->"sss";
        System.out.println(s.get());
        System.out.println(ss.get());
    }

}
