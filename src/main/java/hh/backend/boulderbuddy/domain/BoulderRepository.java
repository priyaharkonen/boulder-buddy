package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BoulderRepository extends CrudRepository<Boulder, Long> {

    List<Boulder> findByColor(String color);

}
