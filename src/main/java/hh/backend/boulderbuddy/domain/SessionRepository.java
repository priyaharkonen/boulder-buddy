package hh.backend.boulderbuddy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;


public interface SessionRepository extends CrudRepository<Session, Long> {

    List<Session> findByDate(LocalDate date);

}
