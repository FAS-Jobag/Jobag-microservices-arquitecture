package upc.edu.pe.gestionempleadoresservice.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleador")
public class Empleador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public Empleador(Long id, String nombres, String apellidos, Long DNI, String correo, Long celular, String contraseña, Date createAt, String status) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.correo = correo;
        this.celular = celular;
        this.contraseña = contraseña;
        this.createAt = createAt;
        this.status = status;
    }

    public Empleador() {
    }

    public Long getId() {
        return id;
    }

    public Empleador setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public Empleador setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Empleador setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public Empleador setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public Empleador setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public Long getCelular() {
        return celular;
    }

    public Empleador setCelular(Long celular) {
        this.celular = celular;
        return this;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Empleador setContraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Empleador setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Empleador setStatus(String status) {
        this.status = status;
        return this;
    }
}
