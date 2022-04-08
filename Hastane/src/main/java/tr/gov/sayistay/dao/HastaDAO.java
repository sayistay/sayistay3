package tr.gov.sayistay.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.sayistay.entity.Hasta;
import tr.gov.sayistay.repository.HastaRepository;

@Named
public class HastaDAO {
	@Inject
	private HastaRepository hastaRepository;

	public List<Hasta> getHastalarByDoktorAdi(String doktorAdi) {
		return hastaRepository.findByDoktorlarAdi(doktorAdi);
	}
}
