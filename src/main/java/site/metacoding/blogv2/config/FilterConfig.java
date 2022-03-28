package site.metacoding.blogv2.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import site.metacoding.blogv2.config.filter.MyFilter1;
import site.metacoding.blogv2.config.filter.MyFilter2;

// IoC 컨테이너에 띄우는 어노테이션
// Controller, RestController, Repository, Service, Component, Configuration(설정파일)

//@Configuration
public class FilterConfig {

    @Bean // IoC 컨테이너 필터 설정파일 등록
    public FilterRegistrationBean<?> filter1() { // 필터를 등록해주는 메서드
        FilterRegistrationBean<MyFilter1> bean = new FilterRegistrationBean<>(new MyFilter1()); // 메모리에 떴지만 IoC에 뜬거아님.
        bean.addUrlPatterns("/*"); // 경로설정 (/ 니까 모든페이지에 적용된다)
        bean.setOrder(1); // 낮은 번호의 필터가 가장 먼저 실행됨.
        return bean;
    }

    @Bean // IoC 컨테이너 필터 설정파일 등록
    public FilterRegistrationBean<?> filter2() { // 필터를 등록해주는 메서드
        FilterRegistrationBean<MyFilter2> bean = new FilterRegistrationBean<>(new MyFilter2()); // 메모리에 떴지만 IoC에 뜬거아님.
        bean.addUrlPatterns("/*"); // 경로설정 (/ 니까 모든페이지에 적용된다)
        bean.setOrder(2); // 낮은 번호의 필터가 가장 먼저 실행됨.
        return bean;
    }
}