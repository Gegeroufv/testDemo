package com.shibo.demo.jpaTest.entity.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

public class MyAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //两种方式
        //1.和SecurityContextHolder获取
        //2.通过request里卖弄获取或者session里面取得
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String ip=servletRequestAttributes.getRequest().getRemoteAddr();
        return Optional.ofNullable(ip);
    }
}
