
package cliente.modelo.dominio;

public class TipoEmpleado {
    private int idTipo;
    private String nombre;

    public TipoEmpleado() {
    }

    public TipoEmpleado(int idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString()
    {
        return nombre;
    }
    
}
