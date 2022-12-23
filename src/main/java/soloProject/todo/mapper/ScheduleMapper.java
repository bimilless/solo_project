package soloProject.todo.mapper;

import org.mapstruct.Mapper;
import soloProject.todo.dto.SchedulePatchDto;
import soloProject.todo.dto.SchedulePostDto;
import soloProject.todo.dto.ScheduleResponseDto;
import soloProject.todo.entity.Schedule;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    Schedule schedulePostDtoToSchedule(SchedulePostDto schedulePostDto);
    Schedule schedulePatchDtoToSchedule(SchedulePatchDto schedulePatchDto);
    ScheduleResponseDto scheduleToScheduleResponseDto(Schedule schedule);
    List<ScheduleResponseDto> schedulesToScheduleResponseDtos(List<Schedule> schedules);
}
