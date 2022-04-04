package tr.gov.sayistay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import tr.gov.sayistay.beans.Hayvan;

@Component
@RequiredArgsConstructor
public class Calistir2 implements CommandLineRunner {
	private final Hayvan hayvan;

//	public Calistir2(Hayvan hayvan) {
//		this.hayvan = hayvan;
//	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hayvan: " + hayvan);
	}

}
