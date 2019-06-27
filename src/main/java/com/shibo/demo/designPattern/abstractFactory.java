package com.shibo.demo.designPattern;
//https://www.runoob.com/design-pattern/abstract-factory-pattern.html

import com.shibo.demo.jpaTest.entity.auditing.AbstractAutitable;

/**
 * 创建模式
 * <p>
 * 意图：提供一个创建一系列相关或相互依赖对象的接口，无需指定它们具体的类
 * 主要解决:接口选择问题
 * 何时使用：多个产品族，只消费其中某一族的产品
 * 如何解决：在一个产品族里面，定义多个产品
 * 关键代码：在一个工厂里聚合多个同类产品
 * 应用实例：所有的衣柜都是衣柜类的某一个，而每一个成套的衣服又包括具体的上衣等实例
 * <p>
 * 优点：当一个产品族中多个对象被设计成一起工作时，能保证客户端始终只使用同一个产品族中的对象
 * 缺点：扩展浑南
 * 使用场景：生成不同操作系统的程序
 * 注意事项：产品族难以扩展
 */
public class abstractFactory {
    private interface Shape {
        void draw();
    }

    private static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() Method.");
        }
    }

    private static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Square::draw() Method.");
        }
    }

    private static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() Method.");
        }
    }

    private interface Color {
        void fill();
    }

    private static class Red implements Color {
        @Override
        public void fill() {
            System.out.println("Inside Red::fill() method.");
        }
    }

    private static class Green implements Color {

        @Override
        public void fill() {
            System.out.println("Inside Green::fill() method.");
        }
    }

    private static class Blue implements Color {

        @Override
        public void fill() {
            System.out.println("Inside Blue::fill() method.");
        }
    }

    private static abstract class AbastractFactory {
        public abstract Shape getShape(String shape);

        public abstract Color getColor(String color);
    }

    private static class ShapeFactory extends AbastractFactory {
        @Override
        public Shape getShape(String shape) {
            switch (shape) {
                case "Rectangle":
                    return new Rectangle();
                case "Square":
                    return new Square();
                case "Circle":
                    return new Circle();
                default:
                    return null;
            }
        }

        @Override
        public Color getColor(String color) {
            return null;
        }
    }

    private static class ColorFactory extends AbastractFactory {
        @Override
        public Shape getShape(String shape) {
            return null;
        }

        @Override
        public Color getColor(String color) {
            switch (color) {
                case "Red":
                    return new Red();
                case "Blue":
                    return new Blue();
                case "Green":
                    return new Green();
                default:
                    return null;
            }
        }
    }

    private static class theFactory extends AbastractFactory {
        @Override
        public Shape getShape(String shape) {
            switch (shape) {
                case "Rectangle":
                    return new Rectangle();
                case "Square":
                    return new Square();
                case "Circle":
                    return new Circle();
                default:
                    return null;
            }
        }

        @Override
        public Color getColor(String color) {
            switch (color) {
                case "Red":
                    return new Red();
                case "Blue":
                    return new Blue();
                case "Green":
                    return new Green();
                default:
                    return null;
            }
        }
    }

    private static class FactoryProducer {
        public static AbastractFactory getFactory(String choice) {
            switch (choice) {
                case "Shape":
                    return new ShapeFactory();
                case "Color":
                    return new ColorFactory();
                case "The":
                    return new theFactory();
                default:
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        //获取形状工厂
        AbastractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();
        AbastractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color red = colorFactory.getColor("Red");
        red.fill();

        System.out.println("=================================================");
        //相当于一个族使用一个对应的方法
        AbastractFactory theFactory = FactoryProducer.getFactory("The");
        Color blue = theFactory.getColor("Blue");
        Shape rectangle = theFactory.getShape("Rectangle");
        blue.fill();
        rectangle.draw();

    }
}
