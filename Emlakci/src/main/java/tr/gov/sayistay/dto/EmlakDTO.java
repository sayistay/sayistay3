package tr.gov.sayistay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EmlakDTO (Emlakçı bilgilerini saklayan sınıf)", description = "Emlakçı sınıfı")
public class EmlakDTO {
	@ApiModelProperty(value = "Emlakçı adı")
	private String adi;
	@ApiModelProperty(value = "Emlakçı soyadı")
	private String soyadi;
}
