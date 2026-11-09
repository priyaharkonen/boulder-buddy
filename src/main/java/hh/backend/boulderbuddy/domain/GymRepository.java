package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GymRepository extends CrudRepository<Gym, Long> {
    List<Gym> findByCompany(String company);
    List<Gym> findByLocation(String location);

}
