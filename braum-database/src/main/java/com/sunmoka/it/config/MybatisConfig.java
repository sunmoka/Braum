package com.sunmoka.it.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan({"com.sunmoka.it.**.mapper"})
public class MybatisConfig {

    private Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    private static String MAPPER_XML_PATH = "classpath*:com/sunmoka/it/**/mapper/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(MAPPER_XML_PATH);
            sqlSessionFactoryBean.setMapperLocations(resources);
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("sqlSessionFactory", e);
        }
        return null;
    }
}
