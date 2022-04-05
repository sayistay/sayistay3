package tr.gov.sayistay.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sayistay.entity.Personel;
import tr.gov.sayistay.repository.PersonelRepository;

@Service
public class PersonelService {
	@Autowired
	private PersonelRepository personelRepository;

	public List<Personel> getPersoneller() {
		return (List<Personel>) personelRepository.findAll();
	}

	public Personel getPersonel(int sicil) {
		return personelRepository.findById(sicil)
				.orElseThrow(() -> new EntityNotFoundException(
						sicil + " sicilli personel bulunamadı"));
	}

	public Personel personelKaydet(Personel personel) {
		return personelRepository.save(personel);
	}
}
