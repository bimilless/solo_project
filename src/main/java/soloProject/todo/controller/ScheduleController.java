package soloProject.todo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soloProject.todo.dto.SchedulePatchDto;
import soloProject.todo.dto.SchedulePostDto;
import soloProject.todo.dto.ScheduleResponseDto;
import soloProject.todo.entity.Schedule;
import soloProject.todo.mapper.ScheduleMapper;
import soloProject.todo.response.SingleResponseDto;
import soloProject.todo.service.ScheduleService;

import javax.validation.constraints.Positive;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/")
@Slf4j
public class ScheduleController {
    private final ScheduleService scheduleService;

    private final ScheduleMapper mapper;

    public ScheduleController(ScheduleService scheduleService, ScheduleMapper mapper) {
        this.scheduleService = scheduleService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postSchedule(@RequestBody SchedulePostDto scheduleDto) {
        Schedule schedule =
                scheduleService.createSchedule(mapper.schedulePostDtoToSchedule(scheduleDto));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.scheduleToScheduleResponseDto(schedule)),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchSchedule(@PathVariable("id") @Positive long id, @RequestBody SchedulePatchDto schedulePatchDto) {
        schedulePatchDto.setId(id);

        Schedule schedule =
                scheduleService.updateSchedule(mapper.schedulePatchDtoToSchedule(schedulePatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.scheduleToScheduleResponseDto(schedule)),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSchedule(@PathVariable("id") long id) {
        Schedule response = scheduleService.searchSchedule(id);
        return new ResponseEntity<>(mapper.scheduleToScheduleResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getSchedules() {
        List<Schedule> schedules = scheduleService.searchAll();
        List<ScheduleResponseDto> response = mapper.schedulesToScheduleResponseDtos(schedules);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSchedule(
            @PathVariable("id") long id) {
        scheduleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
