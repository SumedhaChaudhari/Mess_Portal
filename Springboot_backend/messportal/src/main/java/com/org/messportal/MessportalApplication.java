package com.org.messportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@EnableJpaRepositories("com.org.messportal.*")
@ComponentScan(basePackages = { "com.org.messportal.*" })
@EntityScan("com.org.messportal.*") */
@SpringBootApplication
public class MessportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessportalApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
}
