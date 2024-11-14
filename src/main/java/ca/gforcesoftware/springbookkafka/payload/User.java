package ca.gforcesoftware.springbookkafka.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author gavinhashemi on 2024-11-14
 */
@Setter
@Getter
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
