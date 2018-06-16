package com.cjp.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 完善druid 的配置，装配application.properties中的 initialSize等配置
 */
@Configuration
public class DruidConfig {


    /**
     * 配置 DruidDataSource 的参数
     *
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid 的监控
     */
    //1.配置一个管理Druid 的后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        //initParams.put("allow","localhost");//只有localhost能访问
        initParams.put("allow", "");//都能访问
        initParams.put("deny", "192.168.1.1");//拒绝192.168.1.1访问
        bean.setInitParameters(initParams);
        return bean;
    }


    //2.配置一个web 监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean<>();
        filter.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");//配置不拦截的请求
        filter.setUrlPatterns(Arrays.asList("/*"));//拦截所以请求
        filter.setInitParameters(initParams);
        return filter;
    }


}

