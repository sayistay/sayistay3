package tr.gov.sayistay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sayistay.entity.Hasta;

public interface HastaRepository extends JpaRepository<Hasta, Integer> {
	public List<Hasta> findByDoktorlarAdi(String doktorAdi);
}
