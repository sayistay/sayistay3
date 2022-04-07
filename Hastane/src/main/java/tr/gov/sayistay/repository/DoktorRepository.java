package tr.gov.sayistay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.gov.sayistay.entity.Doktor;

public interface DoktorRepository extends JpaRepository<Doktor, Integer> {

}
