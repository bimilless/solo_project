package soloProject.todo.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "todos")
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true, name = "todo_order")
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

}
