package tr.gov.sayistay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.model.PersonelModel;

@RestController
public class PersonelController {
	@GetMapping("/1")
	public String giris(String adi, String soyadi, int yas) {
		return "Merhaba " + adi + ", " + soyadi + " yas:" + yas;
	}

	@GetMapping("/2")
	public String giris2(@RequestParam("adi") String isim) {
		return "Merhaba " + isim;
	}

	@GetMapping("/3")
	public String giris3(PersonelModel model) {
		return "Merhaba " + model;
	}
}
