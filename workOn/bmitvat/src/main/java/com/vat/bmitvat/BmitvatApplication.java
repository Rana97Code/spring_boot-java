package com.vat.bmitvat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class BmitvatApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmitvatApplication.class, args);
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.addAllowedOrigin("http://localhost:5173/"); // Specify the allowed origin(s)
//		config.addAllowedHeader("*"); // You can specify allowed headers
//		config.addAllowedMethod("*"); // You can specify allowed HTTP methods
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//	}

}
