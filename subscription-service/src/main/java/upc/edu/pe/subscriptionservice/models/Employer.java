package upc.edu.pe.subscriptionservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employer {
    private Long id;
    private String nombres;
    private String apellidos;
    private Long dni;
    private String correo;
    private Long celular;
    private String contraseña;
    private String createAt;
    private String status;
}