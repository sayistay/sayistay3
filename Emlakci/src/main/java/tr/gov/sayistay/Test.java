package tr.gov.sayistay;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.gov.sayistay.entity.Emlakci;
import tr.gov.sayistay.entity.Ev;
import tr.gov.sayistay.repository.EmlakciRepository;
import tr.gov.sayistay.repository.EvRepository;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	private EmlakciRepository emlakciRepository;
	@Autowired
	private EvRepository evRepository;

	@Override
	public void run(String... args) throws Exception {
		Set<Emlakci> emlakcilar = emlakciRepository
				.findByEvlerOdaSayisiGreaterThanEqualOrderByAdi(1);
		System.out.println(emlakcilar);
		Set<Ev> evler = evRepository.getEvlerByOdaSayisi(1);
		Set<Ev> evler2 = evRepository.getEvlerByOdaSayisi2(1);
		System.out.println(evler);
		System.out.println(evler2);
	}

}
