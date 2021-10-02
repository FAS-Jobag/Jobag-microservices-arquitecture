package upc.edu.pe.gestionempleadoresservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "companias")
public class Compania{

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_empleador_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Empleador empleador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sector_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Sector sector;

    public Compania() {
    }

    public Compania(Long id, String nombreEmpresa, String description, Long ruc, String logo, String pais, String ciudad, String distrito, String direccion) {
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

    public Compania setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public Compania setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Compania setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public Compania setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public Compania setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public Compania setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Compania setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public Compania setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Compania setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Sector getSector() {
        return sector;
    }

    public Compania setSector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public Compania setEmpleador(Empleador empleador) {
        this.empleador = empleador;
        return this;
    }
}
