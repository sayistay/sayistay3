package tr.gov.sayistay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

import tr.gov.sayistay.beans.Canli;
import tr.gov.sayistay.beans.Hayvan;

// @Component
public class Calistir implements CommandLineRunner {
	@Autowired
	private Hayvan hayvan;
	@Autowired
	@Qualifier("bitki")
	private Canli canli;

	@Autowired
	private List<Canli> canlilar;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hayvan: " + hayvan);
		System.out.println("canli: " + canli);
		System.out.println("******");
		canlilar.forEach(System.out::println);
	}

}
