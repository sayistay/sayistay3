package tr.gov.sayistay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sayistay.entity.Emlakci;

public interface EmlakciRepository extends JpaRepository<Emlakci, Long> {
	public List<Emlakci> findByAdi(String adi);

	public List<Emlakci> findByEvlerOdaSayisiGreaterThanEqualOrderByAdi(int odaSayisi);

}
