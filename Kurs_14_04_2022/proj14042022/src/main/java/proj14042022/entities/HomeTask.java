package proj14042022.entities;

import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
@DiscriminatorValue("H")
public class HomeTask extends Task {
    private LocalDate startDate;
    private LocalDate endDate;
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "executor_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "executor_surname"))
    })
    @Embedded
    private Person executor;

    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "checker_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "checker_surname"))
    })
    @Embedded
    private Person checker;
}
