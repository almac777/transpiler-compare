package at.fhcampus.we.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private Long id;

    private String firstName;
    private String lastName;

    private LocalDateTime dateOfBirth;

    private String password;

}
