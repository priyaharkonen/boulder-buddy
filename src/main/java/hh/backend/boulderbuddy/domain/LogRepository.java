package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {

    List<Log> findByRoute(Boulder route);

}
