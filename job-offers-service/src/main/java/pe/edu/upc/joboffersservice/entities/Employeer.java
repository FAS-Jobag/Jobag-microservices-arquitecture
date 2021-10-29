package pe.edu.upc.joboffersservice.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employeer {

    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private String contraseña;
    private String dni;

}
