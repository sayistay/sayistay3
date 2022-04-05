package tr.gov.sayistay.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Personel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sicil;
	private String adi;
}
