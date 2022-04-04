package tr.gov.sayistay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.model.HesapModel;

@RestController
public class HesapController {
	@GetMapping
	public double islemYap(HesapModel model) {
		// @formatter:off
		return model.getIslem().equals("+") ? model.getSayi1() + model.getSayi2() :
			   model.getIslem().equals("-") ? model.getSayi1() - model.getSayi2() :
			   model.getIslem().equals("*") ? model.getSayi1() * model.getSayi2() :
			   model.getSayi1() / (double) model.getSayi2();
		// @formatter:on
		/*
		 * double sonuc = 0.0; switch (model.getIslem()) { case "+": sonuc =
		 * model.getSayi1() + model.getSayi2(); break; case "-": sonuc =
		 * model.getSayi1() - model.getSayi2(); break; case "*": sonuc =
		 * model.getSayi1() * model.getSayi2(); break; case "/": sonuc =
		 * model.getSayi1() / (double) model.getSayi2(); break; } return sonuc;
		 */

	}
}
