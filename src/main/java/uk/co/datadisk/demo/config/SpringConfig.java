package uk.co.datadisk.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "uk.co.datadisk.demo")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter{
}
