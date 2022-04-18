package proj14042022.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task {
    private String cost;
}
