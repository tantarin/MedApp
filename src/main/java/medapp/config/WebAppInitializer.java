package medapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan("medapp")
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[] {HibernateConfig.class, WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[] {WebAppInitializer.class};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] {"/"};
    }
}
