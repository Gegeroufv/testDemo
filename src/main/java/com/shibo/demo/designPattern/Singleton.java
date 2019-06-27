package com.shibo.demo.designPattern;
//https://www.runoob.com/design-pattern/singleton-pattern.html

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**创建者模式
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * 主要解决：一个全局使用的类频繁地创建与销毁
 * 如何使用：控制实例数目，节约资源
 * 关键代码：构造函数是私有的
 *
 * 应用实例：bean
 * 优点：减少内存开销
 * 缺点：没有接口，不能继承
 */
public class Singleton {
    /**
     *
     */
    @Getter
    @Setter
    private static class SingleObject{
        private Instant timeStamp;
        private static SingleObject instance=new SingleObject();
        private SingleObject(){}
        private static synchronized SingleObject getInstance(){
            if(instance==null){
                instance=new SingleObject();
                instance.setTimeStamp(Instant.now());
                System.out.println("instance is null");
            }
            return instance;
        }
        private static void cleanUp(){
            instance=null;
            System.out.println("Clean Up!");

        }
    }

    /**
     * 线程安全饿汉式
     */
    private static class HungerySingleObject{
        private volatile static HungerySingleObject instance=new HungerySingleObject();
        private HungerySingleObject(){}

    }

    /**
     * 注意值传递和引用传递!!!
     * @param args
     */
    public static void main(String[] args) {
        SingleObject instance = SingleObject.getInstance();
        System.out.println(instance);
        System.out.println(instance.getTimeStamp());
        //所以我们每次获取对象要求的直接通过类名调用方法获取
        System.out.println(SingleObject.getInstance());

        SingleObject.cleanUp();
        //创建完毕之后instance在外存储的
        System.out.println(instance);
        SingleObject instance2 = SingleObject.getInstance();
        System.out.println(instance2);
        System.out.println(instance.getTimeStamp());
        System.out.println(SingleObject.getInstance().getTimeStamp());
    }
}
