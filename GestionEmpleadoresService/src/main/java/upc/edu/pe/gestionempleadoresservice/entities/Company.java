package upc.edu.pe.gestionempleadoresservice.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "companias")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_empresa", length = 30)
    private String nombreEmpresa;

    @Column(length = 150)
    private String description;

    private Long ruc;

    @Column(length = 250)
    private String logo;

    @Column(length = 50)
    private String pais;

    @Column(length = 50)
    private String ciudad;

    @Column(length = 50)
    private String distrito;

    @Column(length = 100)
    private String direccion;

    @OneToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_empelador_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empleador empleador;

    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sector_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sector sector;

    public Company() {
    }

    public Company(Long id, String nombreEmpresa, String description, Long ruc, String logo, String pais, String ciudad, String distrito, String direccion) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.description = description;
        this.ruc = ruc;
        this.logo = logo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public Company setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public Company setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public Company setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public Company setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Company setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public Company setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Company setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public Company setEmpleador(Empleador empleador) {
        this.empleador = empleador;
        return this;
    }

    public Sector getSector() {
        return sector;
    }

    public Company setSector(Sector sector) {
        this.sector = sector;
        return this;
    }
}
