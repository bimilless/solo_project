package soloProject.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private Long order;
    private String completed;
}
