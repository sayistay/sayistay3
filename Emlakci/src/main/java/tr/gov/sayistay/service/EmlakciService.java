package tr.gov.sayistay.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sayistay.entity.Emlakci;
import tr.gov.sayistay.exception.KayitBulunamadiException;
import tr.gov.sayistay.repository.EmlakciRepository;
import tr.gov.sayistay.repository.EvRepository;

@Service

public class EmlakciService {
	@Autowired
	private EmlakciRepository emlakciRepository;
	@Autowired
	private EvRepository evRepository;

	public List<Emlakci> getEmlakcilar() {
		return emlakciRepository.findAll();
	}

	public Emlakci getEmlakci(long id) {
		Emlakci sonuc = emlakciRepository.findById(id).orElseThrow(
				() -> new KayitBulunamadiException(id + " sicilli emlakçı bulunamadı"));
		return sonuc;
	}

	public List<Emlakci> getEmlakcilarByAdi(String adi) {
		return emlakciRepository.findByAdi(adi);
	}

	public List<Emlakci> getTumEmlakcilarByOdaSayisi(int odaSayisi) {
		return emlakciRepository
				.findByEvlerOdaSayisiGreaterThanEqualOrderByAdi(odaSayisi);
	}

	@Transactional
	public Emlakci emlakciKaydet(Emlakci emlakci) {
		if (emlakci.getId() != 0) {
			Emlakci emlakciDb = emlakciRepository.findById(emlakci.getId()).get();
			emlakciDb.setAdi(emlakci.getAdi());
			emlakciDb.setSoyadi(emlakci.getSoyadi());
			return emlakciRepository.save(emlakciDb);
		} else {
			return emlakciRepository.save(emlakci);
		}
	}

	public boolean emlakciSil(long id) {
		Optional<Emlakci> emlakci = emlakciRepository.findById(id);
		if (emlakci.isPresent()) {
			emlakci.get().getEvler().forEach(evRepository::delete);
			emlakciRepository.delete(emlakci.get());
			return true;
		}
		return false;

	}

}
