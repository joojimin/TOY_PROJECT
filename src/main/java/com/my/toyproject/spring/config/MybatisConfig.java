package com.my.toyproject.spring.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.LocalDateTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Configuration
@MapperScan(basePackages = "com.my.toyproject.*.mapper")
public class MybatisConfig {

	private static final String PATH_MAPPER_XML_FILE = "mapper/**/*.xml";

	private final WebApplicationContext webApplicationContext;

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(PATH_MAPPER_XML_FILE));
		sqlSessionFactoryBean.setConfiguration(sqlSessionConfig());
		sqlSessionFactoryBean.setTypeHandlers(getTypeHandlerInProject());
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public org.apache.ibatis.session.Configuration sqlSessionConfig(){
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setMapUnderscoreToCamelCase(true);
		return config;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}


	private TypeHandler<?>[] getTypeHandlerInProject(){
		List<TypeHandler> typeHandlers = webApplicationContext.getBeansOfType(TypeHandler.class)
															  .values()
															  .stream()
															  .collect(Collectors.toList());

		addDefaultTypeHandler(typeHandlers);

		return typeHandlers.toArray(new TypeHandler[typeHandlers.size()]);
	}

	private void addDefaultTypeHandler(List<TypeHandler> typeHandlers){
		typeHandlers.add(new LocalDateTypeHandler());
	}
}
