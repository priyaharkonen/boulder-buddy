package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GymRepository extends CrudRepository<Gym, Long> {
    List<Gym> findByName(String name);

}
