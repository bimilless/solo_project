package soloProject.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulePatchDto {
    private long id;

    private String title;

    private String completed;

    public void setId(long id) {
        this.id = id;
    }
}
