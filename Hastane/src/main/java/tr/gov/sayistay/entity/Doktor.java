package tr.gov.sayistay.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "hastalar")
@EqualsAndHashCode(exclude = "hastalar")
public class Doktor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adi;
	private String soyadi;
	// @formatter:off
	@ManyToMany
	@JoinTable(name = "doktor_hasta", 
	   joinColumns = @JoinColumn(name="doktor_id"),
	   inverseJoinColumns = @JoinColumn(name="hasta_id")
	)
	// @formatter:on
	private Set<Hasta> hastalar;
}
