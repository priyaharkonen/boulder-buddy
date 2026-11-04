package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExecutionRepository extends CrudRepository<Execution, Long> {

    List<Execution> findByRoute(Boulder route);

}
