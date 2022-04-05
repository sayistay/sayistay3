package tr.gov.sayistay.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sayistay.entity.Emlakci;

public interface EmlakciRepository extends JpaRepository<Emlakci, Long> {
	public Set<Emlakci> findByAdi(String adi);

	public Set<Emlakci> findByEvlerOdaSayisiGreaterThanEqualOrderByAdi(int odaSayisi);

}
