package com.shibo.demo.jpaTest.entity.resultName;

import lombok.*;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "findTheEmploy",
        entities = {
                @EntityResult(entityClass = result1.class,
                        fields = {
                                @FieldResult(name = "id",column = "id"),
                                @FieldResult(name = "age",column = "age"),
                                @FieldResult(name = "name",column = "name"),
                                @FieldResult(name = "department_id",column = "department_id"),
                                @FieldResult(name = "department_name",column = "department_name")
                        }
                )
        },
        classes = {
                @ConstructorResult(
                        targetClass = result1.class,
                        columns = {
                                @ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "age", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "department_id", type = Long.class),
                                @ColumnResult(name = "department_name", type = String.class)
                        }
                )
        }
)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class result1 {
    private Long id;
    private Integer age;
    private String name;
    private Long department_id;
    private String department_name;
}
