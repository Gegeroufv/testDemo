package com.shibo.demo.designPattern;
//https://www.runoob.com/design-pattern/factory-pattern.html

/**创建模式
 *
 * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪个工厂，工厂模式使其创建过程延迟到子类进行
 * 主要解决：主要解决接口选择的问题
 * 何时使用：需要明确计划不同条件下创建不同实例
 * 如何解决：让其子类实现工厂接口，返回的也是一个抽象产品
 * 关键代码：创建其在子类执行
 * <p>
 * 优点：调用者只需要知道其名称，扩展性高，屏蔽产品的具体实现
 * 缺点：每增加产品都需要增加具体实现
 * 使用场景：日志记录器
 * 注意事项：需要复杂对象都可以使用工厂方法模式，一般使用new创建不要引入工厂模式，否则会增加复杂度
 */
public class simpleFactory {
    //接口不能用static修饰
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

    private static class ShapeFactory {
        public static Shape getShape(String shapeType) {
            switch (shapeType) {
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
    }

    public static void main(String[] args) {
        ShapeFactory.getShape("Rectangle").draw();
        ShapeFactory.getShape("Square").draw();
        ShapeFactory.getShape("Circle").draw();
        System.out.println(ShapeFactory.getShape("fuck")==null?"null":"sucker");
    }
}
