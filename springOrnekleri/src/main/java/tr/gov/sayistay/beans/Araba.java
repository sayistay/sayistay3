package tr.gov.sayistay.beans;

import lombok.Data;

@Data
public class Araba {
	private String marka;
	private String model;

	public Araba() {
		System.out.println("Araba oluşturuluyor");
	}
}
