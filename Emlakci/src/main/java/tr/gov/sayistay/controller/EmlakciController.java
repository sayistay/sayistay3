package tr.gov.sayistay.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import tr.gov.sayistay.dto.EmlakDTO;
import tr.gov.sayistay.dto.EmlakOdaDTO;
import tr.gov.sayistay.entity.Emlakci;
import tr.gov.sayistay.service.EmlakciService;

@RestController
@RequestMapping("/emlak")
@Api(value = "", tags = { "Emlakçı işlemleri" })

public class EmlakciController {
	@Autowired
	private EmlakciService emlakciService;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	@ApiOperation(value = "Tüm emlakçıları getirir", notes = "emlakçıları listele")
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

	@GetMapping("/id/{id}")
	@ApiOperation(value = "Sicili verilen emlakçıyı getirir", notes = "Id'si verilen emlakçıyı sorgulayıp getirir")
	// @formatter:off
	public EmlakDTO getEmlakci(
			@ApiParam(name = "id", type = "Integer", value = "Emlakçı id'si", example = "2", required = true)
			@PathVariable 
			int id) {
	// @formatter:on
		return modelMapper.map(emlakciService.getEmlakci(id), EmlakDTO.class);
	}

	@GetMapping("/adi/{adi}")
	public List<EmlakDTO> getTumEmlakcilar(@PathVariable String adi) {
		return emlakciService.getEmlakcilarByAdi(adi).stream()
				.map((e) -> modelMapper.map(e, EmlakDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/oda/{oda}")
	// oda bilgileri ile emlakcilar dönsün.
	public Set<EmlakOdaDTO> getTumEmlakcilarByOdaSayisi(
			@PathVariable("oda") int odaSayisi) {
		// @formatter:off
		return emlakciService.getTumEmlakcilarByOdaSayisi(odaSayisi).stream()
				.map((e) -> {
					EmlakOdaDTO dto = modelMapper.map(e, EmlakOdaDTO.class);
					dto.setIsmi(e.getAdi());
					return dto;
				}).collect(Collectors.toSet());
		// @formatter:on
	}

	@PostMapping
	public EmlakDTO emlakciKaydet(@RequestBody EmlakDTO emlakciDto) {
		Emlakci emlakci = modelMapper.map(emlakciDto, Emlakci.class);
		return modelMapper.map(emlakciService.emlakciKaydet(emlakci), EmlakDTO.class);
	}

	@PostMapping("/{id}")
	public EmlakOdaDTO emlakciGuncelle(@RequestBody EmlakDTO emlakciDto,
			@PathVariable long id) {
		Emlakci emlakci = modelMapper.map(emlakciDto, Emlakci.class);
		emlakci.setId(id);
		emlakci = emlakciService.emlakciKaydet(emlakci);
		EmlakOdaDTO dto = modelMapper.map(emlakci, EmlakOdaDTO.class);
		dto.setIsmi(emlakci.getAdi());
		return dto;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> emlakciSil(@PathVariable long id) {
		if (emlakciService.emlakciSil(id)) {
			return ResponseEntity.ok("Emlakçı silindi");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).header("mesaj", "hata olustu")
				.body("Silinecek emlakçı bulunamadı");
	}
}
