package tr.gov.sayistay.service;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.sayistay.dao.DoktorDAO;
import tr.gov.sayistay.entity.Doktor;

@Named
public class DoktorService {
	@Inject
	private DoktorDAO doktorDAO;

	public Set<Doktor> getDoktorlar() {
		return doktorDAO.getDoktorlar();
	}
}
