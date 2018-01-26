package cn.fqfx.GoodByeFQFX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GoodByeFqfxApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodByeFqfxApplication.class, args);
	}
}
