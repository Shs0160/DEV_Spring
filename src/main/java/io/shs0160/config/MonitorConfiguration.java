package io.shs0160.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "io.shs0160.controller")
public class MonitorConfiguration {

    //뷰 리졸버
    //템플릿엔진을 해석할 수 있는 것을 등록
    //타임리프 템플릿 엔진 설정
    @Bean
    public SpringTemplateEngine templateEngine(ApplicationContext applicationContext) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        //실제로 템플릿엔진의 종류를 등록
        engine.setTemplateResolver(templateResolver(applicationContext));
        return engine;
    };

    //타임리프 뷰 리졸버 설정
    @Bean
    public ITemplateResolver templateResolver(ApplicationContext applicationContext) {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();

        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);

        return resolver;
        //의존성이 필요 -> 뷰 리졸버 -> 그래야 타임리프한테 넘겨줄 수 있음
        //Spring Container를 넘겨줘야함
    }

    //타임리프를 이용하기 위한 뷰 리졸버 등럭
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

}
