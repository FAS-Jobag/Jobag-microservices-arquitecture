package upc.edu.pe.gestionempleadoresservice.resource;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EmpleadorResource {

    private Long id;

    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @NotNull
    private Long DNI;

    @NotNull
    private String correo;

    @NotNull
    private Long celular;

    @NotNull
    private String contraseña;

    @NotNull
    private Date createAt;

    @NotNull
    private String status;

    public EmpleadorResource() {
    }

    public EmpleadorResource(Long id, String nombres, String apellidos, Long DNI, String correo, Long celular, String contraseña, Date createAt, String status) {
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

    public Long getId() {
        return id;
    }

    public EmpleadorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombres() {
        return nombres;
    }

    public EmpleadorResource setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public EmpleadorResource setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public EmpleadorResource setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public EmpleadorResource setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public Long getCelular() {
        return celular;
    }

    public EmpleadorResource setCelular(Long celular) {
        this.celular = celular;
        return this;
    }

    public String getContraseña() {
        return contraseña;
    }

    public EmpleadorResource setContraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public EmpleadorResource setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public EmpleadorResource setStatus(String status) {
        this.status = status;
        return this;
    }
}
