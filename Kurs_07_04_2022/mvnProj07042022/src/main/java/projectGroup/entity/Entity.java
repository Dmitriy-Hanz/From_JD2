package projectGroup.entity;

import lombok.*;
import projectGroup.entity.anotations.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@MyTable(name = "car")
public class Entity {

    @MyColumn(name = "id")
    private int id;

    @MyColumn(name = "name")
    private String name;

    @MyColumn(name = "color")
    private String color;

    @MyColumn(name = "price")
    private String price;
}


