package com.yk.iworkgo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sessionFactory")
public class DataSourceConfig {

  static final String PACKAGE = "com.yk.iworkgo.payment.mapper";
  private static final String mapperLocations = "classpath*:mapper/**/*.xml";
  private static final String typeAliasesPackage = "com.yk.iworkgo.payment.entity";
  @Bean(name = "dataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  @Primary
  public DataSource dataSource() {
    return new DruidDataSource();
  }

  @Bean(name = "transactionManager")
  @Primary
  public DataSourceTransactionManager transactionManager(
      @Qualifier("dataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "sessionFactory")
  @Primary
  public SqlSessionFactory sessionFactory(
      @Qualifier("dataSource") DataSource dataSource) throws Exception {

    //===1.mybatis-plus globalConfig配置
//    GlobalConfig globalConfig = new GlobalConfig();

    // 字段的驼峰下划线转换
//    globalConfig.setDbColumnUnderline(true);
//    globalConfig.setIdType(IdType.AUTO.getKey());
//    GlobalConfig.DbConfig config = new GlobalConfig.DbConfig();
//    config.setTablePrefix()
//    globalConfig.setBanner()

    //===2.构造sessionFactory(mybatis-plus)
    final MybatisSqlSessionFactoryBean sf = new MybatisSqlSessionFactoryBean();
    sf.setDataSource(dataSource);
    sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
    sf.setTypeAliasesPackage(typeAliasesPackage);
//    sf.setGlobalConfig(globalConfig);
    // 分页插件
    sf.setPlugins(new Interceptor[]{new PaginationInterceptor()});

    return sf.getObject();
  }
}  