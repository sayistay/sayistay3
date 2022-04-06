package tr.gov.sayistay.dto;

import java.util.List;

import lombok.Data;

@Data
public class EmlakOdaDTO {
	private String ismi;
	private String soyadi;
	private List<OdaDTO> evler;
}
