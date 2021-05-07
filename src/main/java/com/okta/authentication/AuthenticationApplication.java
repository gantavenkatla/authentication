package com.okta.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@SpringBootApplication
public class AuthenticationApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	public class CustomContainer implements
			WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

		@Override
		public void customize(TomcatServletWebServerFactory factory) {
			factory.setContextPath("");
			factory.setPort(8080);
		}
	}
}
