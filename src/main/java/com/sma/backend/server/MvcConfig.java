package com.sma.backend.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
//@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.sma.backend")
@EnableTransactionManagement
@ImportResource(value = {"classpath:/persistence-db.xml"})
//@MapperScan("com.sma.backend.dao")
@PropertySource(name="application",value={"classpath:/application.properties"})
@Lazy
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    
    // -------------- Services -----------------------

    // -------------- Message Converters ----------------------

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://domain2.com")
            .allowedMethods("PUT", "DELETE")
            .allowedHeaders("header1", "header2", "header3")
            .exposedHeaders("header1", "header2")
            .allowCredentials(false).maxAge(3600);
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SkipNullObjectMapper skipNullMapper = new SkipNullObjectMapper();
        skipNullMapper.init();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(skipNullMapper);
        converters.add(converter);
    }
    // -------------- Serving Resources ----------------------

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*.html").addResourceLocations("classpath:/static/");
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    

    // -------------- Controllers ----------------------


    // -------------- View Stuff -----------------------

//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//      SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//      sessionFactory.setDataSource(dataSource());
//      return sessionFactory.getObject();
//    }
    
    
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(InternalResourceView.class);
        bean.setOrder(999);
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix("");
        return bean;
    }
   
    
}
