package tr.gov.sayistay.dao;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.sayistay.entity.Doktor;
import tr.gov.sayistay.repository.DoktorRepository;

@Named
public class DoktorDAO {
	@Inject
	private DoktorRepository doktorRepository;

	public Set<Doktor> getDoktorlar() {
		return Set.copyOf(doktorRepository.findAll());
	}
}
