package proj14042022.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
@DiscriminatorValue("W")
public class WorkTask extends Task {
    private String cost;
}
