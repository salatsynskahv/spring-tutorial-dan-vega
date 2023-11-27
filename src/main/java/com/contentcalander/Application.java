package com.contentcalander;

import com.contentcalander.config.ContentCalendarProperties;
import com.contentcalander.model.Content;
import com.contentcalander.model.Status;
import com.contentcalander.model.Type;
import com.contentcalander.respository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(ContentCalendarProperties.class )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			 Content content = new Content(null, "Hello Chat GPT",
					 "All abot chatpgt", Status.IDEA, Type.VIDEO, LocalDateTime.now(),
					 null, "");

			 repository.save(content);
		};
	}

}
