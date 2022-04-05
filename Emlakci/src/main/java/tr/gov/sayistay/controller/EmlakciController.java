package tr.gov.sayistay.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.dto.EmlakDTO;
import tr.gov.sayistay.entity.Emlakci;
import tr.gov.sayistay.service.EmlakciService;

@RestController
@RequestMapping("/emlak")
public class EmlakciController {
	@Autowired
	private EmlakciService emlakciService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<EmlakDTO> getTumEmlakcilar() {
//		List<Emlakci> emlakcilar = emlakciService.getEmlakcilar();
//		List<EmlakDTO> sonuc = new ArrayList<EmlakDTO>();
//		for (Emlakci emlakci : emlakcilar) {
//			EmlakDTO dto = new EmlakDTO();
//			dto.setAdi(emlakci.getAdi());
//			dto.setSoyadi(emlakci.getSoyadi());
//			sonuc.add(dto);
//		}
//		return sonuc;
		return emlakciService.getEmlakcilar().stream().map(this::cevir)
				.collect(Collectors.toList());
	}

	public EmlakDTO cevir(Emlakci emlakci) {
		return modelMapper.map(emlakci, EmlakDTO.class);
//		EmlakDTO dto = new EmlakDTO();
//		dto.setAdi(emlakci.getAdi());
//		dto.setSoyadi(emlakci.getSoyadi());
//		return dto;
	}
}
