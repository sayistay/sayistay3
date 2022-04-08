package tr.gov.sayistay.test;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;

import tr.gov.sayistay.entity.Hasta;
import tr.gov.sayistay.repository.HastaRepository;

@Named
public class HastaTest implements CommandLineRunner {
	@Inject
	private HastaRepository hastaRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		List<Hasta> hastalar = hastaRepository.findByDoktorlarAdi("Murat");
		hastalar.forEach(h -> {
			System.out.print(h.getAdi());
			System.out.print(", " + h.getSoyadi());
			System.out.print(", doktorlar: ");
			h.getDoktorlar().stream().filter(d -> d.getAdi().equals("Murat"))
					.forEach(d -> {
						System.out.print(d.getAdi() + " " + d.getSoyadi() + ", ");
					});
			System.out.println();
		});
	}

}
