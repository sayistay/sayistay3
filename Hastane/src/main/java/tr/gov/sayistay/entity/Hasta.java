package tr.gov.sayistay.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "doktorlar")
@EqualsAndHashCode(exclude = "doktorlar")
public class Hasta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adi;
	private String soyadi;
	@ManyToMany(mappedBy = "hastalar")
	private Set<Doktor> doktorlar;
}
