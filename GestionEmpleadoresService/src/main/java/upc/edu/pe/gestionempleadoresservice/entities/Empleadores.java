package upc.edu.pe.gestionempleadoresservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleadores")
@Data
public class Empleadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nombres;

    @Column(length = 40)
    private String apellidos;

    @Column(length = 8)
    private Long DNI;

    @Column(length = 50)
    private String correo;

    @Column(length = 9, nullable = false)
    private Long celular;

    @Column(length = 30)
    private String contraseña;

    @Column(name = "create_at")
    //Se almacena la fecha, hora y segundos.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(length = 10, nullable = false)
    private String status;
}
