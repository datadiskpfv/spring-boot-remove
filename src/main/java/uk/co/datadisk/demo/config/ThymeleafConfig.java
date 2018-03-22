package uk.co.datadisk.demo.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver defaultTemplateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addTemplateResolver(defaultTemplateResolver);
        return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html");
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 5);
        return resolver;
    }

    @Bean
    public TemplateResolver defaultTemplateResolver() {
        TemplateResolver resolver = new TemplateResolver();
        resolver.setResourceResolver(thymeleafResourceResolver());
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(true);
        return resolver;
    }

    @Bean
    public SpringResourceResourceResolver thymeleafResourceResolver() {
        return new SpringResourceResourceResolver();
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
