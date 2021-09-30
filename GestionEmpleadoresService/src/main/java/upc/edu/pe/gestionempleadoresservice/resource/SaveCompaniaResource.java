package upc.edu.pe.gestionempleadoresservice.resource;

import javax.persistence.Column;

public class SaveCompaniaResource{
    @Column(length = 30)
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

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public SaveCompaniaResource setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveCompaniaResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public SaveCompaniaResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public SaveCompaniaResource setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public SaveCompaniaResource setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public SaveCompaniaResource setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public SaveCompaniaResource setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public SaveCompaniaResource setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
}
