package com.cafe24.cat24frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.cat24frontend.service", "com.cafe24.cat24frontend.aspect"})
public class AppConfig {

}
