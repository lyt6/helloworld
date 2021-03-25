package com.helloworld.demo.design.strategy;

/**
 * 画图工厂
 */
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw circle ...");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw square ...");
    }
}

/**
 * 涂色工厂
 */
interface Color {
    void fill();
}

class Red implements Color {
    @Override
    public void fill() {
        System.out.println("fill red .. ");
    }
}

class Black implements Color {
    @Override
    public void fill() {
        System.out.println("fill black ...");
    }
}

/**
 * 抽象工厂
 */
abstract class AbstractFactory {
    abstract Shape getShape(String shape);

    abstract Color getColor(String color);
}

class ShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape.equals("CIRCLE")) {
            return new Circle();
        } else if (shape.equals("SQUARE")) {
            return new Square();
        } else {
            return null;
        }
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}

class ColorFactory extends AbstractFactory {
    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equals("RED")) {
            return new Red();
        } else if (color.equals("BLACK")) {
            return new Black();
        } else {
            return null;
        }
    }
}

class FactoryProducer {
    public AbstractFactory getFactory(String factoryType) {
        if (factoryType == null) {
            return null;
        }
        if (factoryType.equals("SHAPE")) {
            return new ShapeFactory();
        } else if (factoryType.equals("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

class TestFactory {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        AbstractFactory shape = factoryProducer.getFactory("SHAPE");
        shape.getShape("CIRCLE").draw();
        shape.getShape("SQUARE").draw();
        AbstractFactory color = factoryProducer.getFactory("COLOR");
        color.getColor("RED").fill();
        color.getColor("BLACK").fill();
    }
}

