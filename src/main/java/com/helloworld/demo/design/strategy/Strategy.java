package com.helloworld.demo.design.strategy;

interface Strategy {
    int doOperate(int param1, int param2);
}

class AddStrategy implements Strategy {
    @Override
    public int doOperate(int param1, int param2) {
        return param1 + param2;
    }
}

class SubStrategy implements Strategy {
    @Override
    public int doOperate(int param1, int param2) {
        return param1 - param2;
    }
}

class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int p1, int p2) {
        return strategy.doOperate(p1, p2);
    }
}

class TestStrategy {
    public static void main(String[] args) {
        StrategyContext AddContext = new StrategyContext(new AddStrategy());
        StrategyContext subContext = new StrategyContext(new SubStrategy());
        int addResult = AddContext.execute(1, 2);
        int subResult = subContext.execute(1, 2);
        System.out.println("加法策略结果：" + addResult);
        System.out.println("减法策略结果：" + subResult);
    }
}
