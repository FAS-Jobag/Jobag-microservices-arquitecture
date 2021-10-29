package upc.edu.pe.subscriptionservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Postulant {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String password;
    private String document;
    private String civil_status;
    private String createAt;
}
