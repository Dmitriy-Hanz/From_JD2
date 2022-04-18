package proj14042022.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class WorkTask extends Task {
    private String cost;
}
