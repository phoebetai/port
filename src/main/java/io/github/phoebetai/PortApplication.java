package io.github.phoebetai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class PortApplication extends SpringBootServletInitializer {
//?
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PortApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PortApplication.class, args);
	}
}
