package cliente.modelo.dominio;

public class Empleado {
    private String codigo;
    private String nombre;
    private float salario;
    private int cantidadHijos;
    private TipoEmpleado objTipoEmpleado;
 
   public Empleado(String codigo, String nombre, float salario, int cantidadHijos, TipoEmpleado objTipoEmpleado) {
        this.codigo = codigo;
        this.nombre = nombre;
     
        this.salario = salario;
        this.cantidadHijos = cantidadHijos;
        this.objTipoEmpleado = objTipoEmpleado;
    }
   
    public Empleado(){
    }

    public TipoEmpleado getObjTipoEmpleado() {
        return objTipoEmpleado;
    }

    public void setObjTipoEmpleado(TipoEmpleado objTipoEmpleado) {
        this.objTipoEmpleado = objTipoEmpleado;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    
    
}
