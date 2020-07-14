package in.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/*@CrossOrigin(origins="http://localhost:9090")*/
public class SpringbootScurityAppWithCrossOriginResourcesSharingProducerApplication {

	/*@CrossOrigin(origins="http://localhost:9090")*/
	@GetMapping("/access")
	public String greeting()
	{
		return "Welcome to the website";
	}
	
	@Bean
	public WebMvcConfigurer configure()
	{
		return new WebMvcConfigurer(){
			       @Override
			    public void addCorsMappings(CorsRegistry registry) {
			    	
			    	   registry.addMapping("/*").allowedOrigins("http://localhost:9090");
			    }
			};
	}
	
	/*
	 * 'http://localhost:8080/access' from origin 'http://localhost:9090' has been
	 * blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on
	 * the requested resource.
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringbootScurityAppWithCrossOriginResourcesSharingProducerApplication.class, args);
	}

}
