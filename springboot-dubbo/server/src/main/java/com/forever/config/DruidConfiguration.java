//package com.forever.config;
//
//import com.alibaba.druid.filter.Filter;
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import com.alibaba.druid.wall.WallConfig;
//import com.alibaba.druid.wall.WallFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by duchong
// * 2017/3/2.
// */
//@Configuration
//@EnableConfigurationProperties(DruidProperties.class)
//public class DruidConfiguration {
//
//    @Autowired
//    private DataSourceProperties pro;
//    @Autowired
//    private DruidProperties druidOneProperties;
//
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//    }
//
//    @Bean
//    public DataSource druidDataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(pro.getDriverClassName());
//        druidDataSource.setUrl(pro.getUrl());
//        druidDataSource.setUsername(pro.getUsername());
//        druidDataSource.setPassword(pro.getPassword());
//        druidDataSource.setInitialSize(druidOneProperties.getInitialSize());
//        druidDataSource.setMinIdle(druidOneProperties.getMinIdle());
//        druidDataSource.setMaxActive(druidOneProperties.getMaxActive());
//        druidDataSource.setMaxWait(druidOneProperties.getMaxWait());
//        druidDataSource.setTimeBetweenEvictionRunsMillis(druidOneProperties.getTimeBetweenEvictionRunsMillis());
//        druidDataSource.setMinEvictableIdleTimeMillis(druidOneProperties.getMinEvictableIdleTimeMillis());
//        druidDataSource.setValidationQuery(druidOneProperties.getValidationQuery());
//        druidDataSource.setTestWhileIdle(druidOneProperties.getTestWhileIdle());
//        druidDataSource.setTestOnBorrow(druidOneProperties.getTestOnBorrow());
//        druidDataSource.setTestOnReturn(druidOneProperties.getTestOnReturn());
//        druidDataSource.setPoolPreparedStatements(druidOneProperties.getPoolPreparedStatements());
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidOneProperties.getMaxPoolPreparedStatementPerConnectionSize());
//        druidDataSource.setFilters(druidOneProperties.getFilters());
//
//        List<Filter> filterList = new ArrayList<Filter>();
//        WallFilter wf = new WallFilter();
//        WallConfig wallConfig = new WallConfig();
//        wallConfig.setMultiStatementAllow(true);
//        wf.setConfig(wallConfig);
//        filterList.add(wf);
//        druidDataSource.setProxyFilters(filterList);
//
//        return druidDataSource;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//}
