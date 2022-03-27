package packageScram2.T1;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor

public class Person implements Serializable {
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "Имя: " + name + " Фамилия: " + surname + " Возраст: " + age;
    }
}
