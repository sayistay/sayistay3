package tr.gov.sayistay.dto;

import java.util.List;

import lombok.Data;

@Data
public class HastaDTO {
	private int id;
	private String adi;
	private String soyadi;
	private List<DoktorDTO> doktorlar;
}
