package com.cafe24.cat24.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.SecurityConfig;
import com.cafe24.config.web.SwaggerConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.cat24.controller"})
//@Import({MVCConfig.class, SecurityConfig.class, FileuploadConfig.class, MessageConfig.class, SwaggerConfig.class})
@Import({MVCConfig.class,  FileuploadConfig.class, MessageConfig.class, SwaggerConfig.class})
public class WebConfig 
{

}
