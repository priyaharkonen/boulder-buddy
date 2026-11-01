package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends CrudRepository<Route, Long> {

    List<Route> findByColor(String color);

}
