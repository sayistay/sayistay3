package tr.gov.sayistay.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Emlakci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 30, nullable = false)
	private String adi;
	@Column(length = 30, nullable = false)
	private String soyadi;
	@OneToMany(mappedBy = "emlakci")
	private Set<Ev> evler;
}
