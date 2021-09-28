package upc.edu.pe.gestionempleadoresservice.resource;

public class CompaniaResource {
    //Compania
    private Long id;
    private String nombreEmpresa;
    private String description;
    private Long ruc;
    private String logo;
    private String pais;
    private String ciudad;
    private String distrito;
    private String direccion;

    //Empleador
    private Long empleadorId;
    private String nombresEmpleador;
    private String apellidosEmpleador;
    private Long DNIEmpleador;
    private String correoEmpleador;
    private Long celularEmpleador;
    private String contraseñaEmpleador;

    //Sector
    private Long sectorId;
    private String nombre;
    private String descripcionSector;

    public Long getId() {
        return id;
    }

    public CompaniaResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public CompaniaResource setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompaniaResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getRuc() {
        return ruc;
    }

    public CompaniaResource setRuc(Long ruc) {
        this.ruc = ruc;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public CompaniaResource setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public CompaniaResource setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getCiudad() {
        return ciudad;
    }

    public CompaniaResource setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String getDistrito() {
        return distrito;
    }

    public CompaniaResource setDistrito(String distrito) {
        this.distrito = distrito;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public CompaniaResource setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Long getEmpleadorId() {
        return empleadorId;
    }

    public CompaniaResource setEmpleadorId(Long empleadorId) {
        this.empleadorId = empleadorId;
        return this;
    }

    public String getNombresEmpleador() {
        return nombresEmpleador;
    }

    public CompaniaResource setNombresEmpleador(String nombresEmpleador) {
        this.nombresEmpleador = nombresEmpleador;
        return this;
    }

    public String getApellidosEmpleador() {
        return apellidosEmpleador;
    }

    public CompaniaResource setApellidosEmpleador(String apellidosEmpleador) {
        this.apellidosEmpleador = apellidosEmpleador;
        return this;
    }

    public Long getDNIEmpleador() {
        return DNIEmpleador;
    }

    public CompaniaResource setDNIEmpleador(Long DNIEmpleador) {
        this.DNIEmpleador = DNIEmpleador;
        return this;
    }

    public String getCorreoEmpleador() {
        return correoEmpleador;
    }

    public CompaniaResource setCorreoEmpleador(String correoEmpleador) {
        this.correoEmpleador = correoEmpleador;
        return this;
    }

    public Long getCelularEmpleador() {
        return celularEmpleador;
    }

    public CompaniaResource setCelularEmpleador(Long celularEmpleador) {
        this.celularEmpleador = celularEmpleador;
        return this;
    }

    public String getContraseñaEmpleador() {
        return contraseñaEmpleador;
    }

    public CompaniaResource setContraseñaEmpleador(String contraseñaEmpleador) {
        this.contraseñaEmpleador = contraseñaEmpleador;
        return this;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public CompaniaResource setSectorId(Long sectorId) {
        this.sectorId = sectorId;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CompaniaResource setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getDescripcionSector() {
        return descripcionSector;
    }

    public CompaniaResource setDescripcionSector(String descripcionSector) {
        this.descripcionSector = descripcionSector;
        return this;
    }
}
