package upc.edu.pe.gestionempleadoresservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "sectores")
public class Sector{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 30)
    private String nombre;

    @Column(length = 150)
    private String descripcion;

    public Sector() {
    }

    public Sector(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public Sector setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Sector setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Sector setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
