package com.shibo.demo.jpaTest.entity.testAnno;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor()
@Data
//可以在entity中使用的普通java对象
@Embeddable
public class Battle {
    private String battle_name;
    private LocalDate battle_time;
    private String des;
}
