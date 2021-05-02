public class Cliente {

    private String nombre;
    private String direccion;
    private String telefono;

    //----------------- Constructor -------------------
    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //----------------- Nombre -------------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //----------------- Direccion -------------------
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //----------------- Telefono -------------------
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //------------------- Metodos ---------------------
    @Override
    public String toString() {
        return "Cliente [ " +
                "Nombre = " + this.nombre +
                " | Direccion = " + this.direccion +
                " | Telefono = " + this.telefono +
                " ]";
    }
}
