package com.cafe24.cat24.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.cat24.service", "com.cafe24.cat24.repository", "com.cafe24.cat24.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {

}
