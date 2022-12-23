package soloProject.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soloProject.todo.entity.Schedule;

import java.util.Optional;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByTitle(String title);
}
