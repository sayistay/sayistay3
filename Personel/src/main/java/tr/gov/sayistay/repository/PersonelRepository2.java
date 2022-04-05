package tr.gov.sayistay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import tr.gov.sayistay.entity.Personel;

@RepositoryRestController
public interface PersonelRepository2 extends CrudRepository<Personel, Integer> {

}
