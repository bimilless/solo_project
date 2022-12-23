package soloProject.todo.service;


import org.springframework.stereotype.Service;
import soloProject.todo.entity.Schedule;
import soloProject.todo.exception.BusinessLogicException;
import soloProject.todo.exception.ExceptionCode;
import soloProject.todo.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    public Schedule createSchedule(Schedule schedule) {
        verifyExistTitle(schedule.getTitle());
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Schedule schedule) {
        Schedule findSchedule = findVerifiedSchedule(schedule.getId());

        Optional.ofNullable(schedule.getTitle())
                .ifPresent(title -> findSchedule.setTitle(title));
        Optional.ofNullable(schedule.getOrder())
                .ifPresent(order -> findSchedule.setOrder(order));
        Optional.ofNullable(schedule.getCompleted())
                .ifPresent(completed -> findSchedule.setCompleted(completed));

        return scheduleRepository.save(findSchedule);
    }

    public Schedule searchSchedule(Long id) {
        return findVerifiedSchedule(id);

    }
    public List<Schedule> searchAll() {
        return this.scheduleRepository.findAll();
    }

    public void deleteById(Long id) {
        Schedule findSchedule = findVerifiedSchedule(id);
        scheduleRepository.delete(findSchedule);
    }

    public void deleteAll() {
        this.scheduleRepository.deleteAll();
    }

    public Schedule findVerifiedSchedule(long id) {
        Optional<Schedule> optionalSchedule =
                scheduleRepository.findById(id);
        Schedule findSchedule =
                optionalSchedule.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.SCHEDULE_NOT_FOUND));
        return findSchedule;
    }

    private void verifyExistTitle(String title) {
        Optional<Schedule> schedule = scheduleRepository.findByTitle(title);
        if (schedule.isPresent())
            throw new BusinessLogicException(ExceptionCode.SCHEDULE_EXISTS);
    }
}
