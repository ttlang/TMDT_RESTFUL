package com.spring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.spring.mapper")
public class MybatisUtil {

}
