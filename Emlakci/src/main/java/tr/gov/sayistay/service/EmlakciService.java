package tr.gov.sayistay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sayistay.entity.Emlakci;
import tr.gov.sayistay.repository.EmlakciRepository;

@Service
public class EmlakciService {
	@Autowired
	private EmlakciRepository emlakciRepository;

	public List<Emlakci> getEmlakcilar() {
		return emlakciRepository.findAll();
	}

}
