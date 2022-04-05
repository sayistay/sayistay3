package tr.gov.sayistay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ev {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private int metrekare;
	@Column(name = "oda_sayisi", nullable = false)
	private int odaSayisi;
	@Column(length = 1000, nullable = false)
	private String adres;
	@ManyToOne
	private Emlakci emlakci;
}
