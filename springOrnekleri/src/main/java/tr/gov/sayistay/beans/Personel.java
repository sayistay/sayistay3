package tr.gov.sayistay.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Personel {
	private String adi;

	public static Personel personelYarat() {
		Personel sonuc = new Personel("Dimitri");
		return sonuc;
	}
}
