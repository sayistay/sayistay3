package tr.gov.sayistay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.entity.Personel;
import tr.gov.sayistay.service.PersonelService;

@RestController
public class PersonelController {
	@Autowired
	private PersonelService personelService;

	@GetMapping
	public List<Personel> getPersoneller() {
		return personelService.getPersoneller();
	}

//	@GetMapping("/{sicil}")
//	public Personel getPersonel(@PathVariable int sicil) {
//		return personelService.getPersonel(sicil);
//	}

	@PostMapping
	public Personel kaydet(@RequestBody Personel personel) {
		return personelService.personelKaydet(personel);
	}

}
