package verma;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
//https://grokonez.com/spring-framework/spring-amqp/springboot-rabbitmq-exchange-exchange-topology
public class ToobApplication {
	
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(ToobApplication.class, args);
	}
	//We can create a separate class for these configs with @Confuguration annotations
	//-----------------SQL Configuration----------------------------------------------
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password"))
				.url(env.getProperty("spring.datasource.url"))
				.driverClassName(env.getProperty("spring.datasource.driver-class-name"))
				.build();
	};

}

