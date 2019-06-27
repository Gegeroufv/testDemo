package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.Student;
import lombok.Data;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpEL {
    @Data
    private static class Simple{
        private List<Boolean> list=new ArrayList(){{
           add(true);
           add(false);
           add(true);
        }};
    }
    public static void main(String[] args) {
        Student student=new Student();
        student.setGender('m');
        student.setAge(100);
        student.setName("123");
        student.setId(1l);
        System.out.println(student);

        ExpressionParser parser=new SpelExpressionParser();
        Expression expression=parser.parseExpression("name");
        EvaluationContext context=new StandardEvaluationContext(student);
        System.out.println((String)expression.getValue(context));

        Simple simple=new Simple();
        System.out.println(simple);
        //可以显式配置对象，指定在表达式中使用的变量和函数,并进行更改
        StandardEvaluationContext standardEvaluationContext=new StandardEvaluationContext(simple);
        parser.parseExpression("list[0]").setValue(standardEvaluationContext,"false");
        System.out.println(simple.getList().get(0));
        //SpelParserConfiguration编译器配置
        SpelParserConfiguration configuration=new SpelParserConfiguration(true,true);
        ExpressionParser expressionParser=new SpelExpressionParser(configuration);
        Expression expression1 = parser.parseExpression("list[1]");
        System.out.println(expression1.getValue(simple));

    }
}
