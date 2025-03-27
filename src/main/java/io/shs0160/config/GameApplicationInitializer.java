package io.shs0160.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GameApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //service, repository -> root-context.xml에 등록 해야함 원래
    //root-context 를 대체
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {GameConfiguration.class};
    }

    //Controller -> servlet-context.xml 대체
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MonitorConfiguration.class};
    }

    //Dispatcher Servlet 매핑 설정-> url
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
