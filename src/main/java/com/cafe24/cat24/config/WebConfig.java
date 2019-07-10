package com.cafe24.cat24.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.cat24.controller", "com.cafe24.cat24.exception"})
@Import({MVCConfig.class, SecurityConfig.class, FileuploadConfig.class, MessageConfig.class, SwaggerConfig.class})
public class WebConfig {

}
