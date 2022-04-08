package tr.gov.sayistay.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.dto.DoktorDTO;
import tr.gov.sayistay.dto.HastaDTO;
import tr.gov.sayistay.service.HastaService;

@RestController
public class HastaController {
	@Inject
	private HastaService hastaService;
	@Inject
	private ModelMapper modelMapper;

	@GetMapping("/hasta/doktoradi/{adi}")

	public Set<HastaDTO> getHastalar(@PathVariable String adi) {
		return hastaService.getHastalar(adi).stream().map(h -> {
			HastaDTO dto = modelMapper.map(h, HastaDTO.class);
			List<DoktorDTO> doktorlar = h.getDoktorlar().stream()
					.map(d -> modelMapper.map(d, DoktorDTO.class))
					.collect(Collectors.toList());
			dto.setDoktorlar(doktorlar);
			return dto;
		}).collect(Collectors.toSet());
	}

}
