package tr.gov.sayistay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import tr.gov.sayistay.beans.Bilgisayar;

@SpringBootApplication
public class SpringOrnekleri2Application implements CommandLineRunner {
	@Autowired
	private Bilgisayar bilgisayar;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication
				.run(SpringOrnekleri2Application.class, args);
		System.out.println("Context");
		System.out.println(context.getBean("Computer"));
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run");
		System.out.println(bilgisayar);
	}

}
