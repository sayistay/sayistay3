package tr.gov.sayistay.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tr.gov.sayistay.entity.Ev;

public interface EvRepository extends JpaRepository<Ev, Long> {
	@Query(value = "from Ev e where e.odaSayisi>=?1 and e.odaSayisi<=?1 +1")
	public Set<Ev> getEvlerByOdaSayisi(int odaSayisi);

	@Query(value = "select * from ev e where e.oda_sayisi>=?1 and e.oda_sayisi<=?1 +1", nativeQuery = true)
	public Set<Ev> getEvlerByOdaSayisi2(int odaSayisi);
}
