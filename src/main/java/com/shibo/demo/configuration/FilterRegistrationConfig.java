package com.shibo.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
//现在可以不使用手动的配置，可以使用springboot的注解进行二合一！
@Configuration
public class FilterRegistrationConfig {

}
