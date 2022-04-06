package tr.gov.sayistay.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.gov.sayistay.dto.EmlakDTO;
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
		List<Emlakci> emlakcilar = emlakciRepository
				.findByEvlerOdaSayisiGreaterThanEqualOrderByAdi(1);
		System.out.println(emlakcilar);
		Set<Ev> evler = evRepository.getEvlerByOdaSayisi(1);
		Set<Ev> evler2 = evRepository.getEvlerByOdaSayisi2(1);
		System.out.println(evler);
		System.out.println(evler2);
	}

	public static void main(String[] args) {
		// reflection api
		Arrays.stream(EmlakDTO.class.getDeclaredFields()).forEach(f -> {
			System.out.println(f.getName());
		});
		Arrays.stream(EmlakDTO.class.getDeclaredMethods()).forEach(m -> {
			System.out.println(m.getName());
		});

	}

}
