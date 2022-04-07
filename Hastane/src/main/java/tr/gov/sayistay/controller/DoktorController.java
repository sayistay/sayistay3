package tr.gov.sayistay.controller;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sayistay.dto.DoktorDTO;
import tr.gov.sayistay.service.DoktorService;

@RestController
public class DoktorController {
	@Inject
	private DoktorService doktorService;
	@Inject
	private ModelMapper modelMapper;

	@GetMapping("/doktor")

	public Set<DoktorDTO> getDoktorlar() {
		return doktorService.getDoktorlar().stream()
				.map(d -> modelMapper.map(d, DoktorDTO.class))
				.collect(Collectors.toSet());
//		doktorService.getDoktorlar().stream().forEach(System.out::println);
//		doktorService.getDoktorlar().stream().forEach(d -> System.out.println(d));
//		doktorService.getDoktorlar().stream().forEach(d -> {
//			System.out.println(d);
//		});
//		doktorService.getDoktorlar().stream().forEach(new Consumer<Doktor>() {
//			 @Override
//			public void accept(Doktor d) {
//				 System.out.println(d);
//			}
//		});

	}

}
