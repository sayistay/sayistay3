package tr.gov.sayistay.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import tr.gov.sayistay.dao.HastaDAO;
import tr.gov.sayistay.entity.Hasta;

@Named
public class HastaService {
	@Inject
	private HastaDAO hastaDAO;

	public List<Hasta> getHastalar(String doktorAdi) {
		return hastaDAO.getHastalarByDoktorAdi(doktorAdi);
	}
}
