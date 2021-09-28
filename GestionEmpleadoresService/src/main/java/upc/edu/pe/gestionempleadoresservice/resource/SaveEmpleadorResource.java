package upc.edu.pe.gestionempleadoresservice.resource;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SaveEmpleadorResource {
    @NotNull
    private String nombres;

    @NotNull
    private String apellidos;

    @Column(unique = true)
    @NotNull
    private Long DNI;

    @Column(unique = true)
    @NotNull
    private String correo;

    @Column(unique = true)
    @NotNull
    private Long celular;

    @Column(unique = true)
    @NotNull
    private String contraseña;

    @NotNull
    private Date createAt;

    @NotNull
    private String status;

    public SaveEmpleadorResource() {
    }

    public SaveEmpleadorResource(String nombres, String apellidos, Long DNI, String correo, Long celular, String contraseña, Date createAt, String status) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.correo = correo;
        this.celular = celular;
        this.contraseña = contraseña;
        this.createAt = createAt;
        this.status = status;
    }

    public String getNombres() {
        return nombres;
    }

    public SaveEmpleadorResource setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public SaveEmpleadorResource setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public Long getDNI() {
        return DNI;
    }

    public SaveEmpleadorResource setDNI(Long DNI) {
        this.DNI = DNI;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public SaveEmpleadorResource setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public Long getCelular() {
        return celular;
    }

    public SaveEmpleadorResource setCelular(Long celular) {
        this.celular = celular;
        return this;
    }

    public String getContraseña() {
        return contraseña;
    }

    public SaveEmpleadorResource setContraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public SaveEmpleadorResource setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SaveEmpleadorResource setStatus(String status) {
        this.status = status;
        return this;
    }
}
