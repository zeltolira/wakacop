package lira.wakacop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class WakacopApplication {
	@GetMapping
	public String testeHome(){
		return "teste Wakacop";
	}
	public static void main(String[] args) {
		SpringApplication.run(WakacopApplication.class, args);
	}

}
