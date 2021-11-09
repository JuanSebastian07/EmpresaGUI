package servidor.modelo.peticion;

//Esta clase es usada en la controlador
public class PeticionDTO {
    private String nombrePetición;//iniciar sesión, registrar cliente, consultar cliente, listar clientes, registrar comida
    private String argumentosPetición;// argumentos de la operación a ejecutar en el servidor
    // si voy a iniciar sesion los argumentos son usuario y contrasenia
    //si voy a registrar una comida el argumento seria un objeto de tipo comida en formato json

    public PeticionDTO() {
    }

    
    public PeticionDTO(String nombrePetición, String argumentosPetición) {
        this.nombrePetición = nombrePetición;
        this.argumentosPetición = argumentosPetición;
    }

    public String getNombrePetición() {
        return nombrePetición;
    }

    public void setNombrePetición(String nombrePetición) {
        this.nombrePetición = nombrePetición;
    }

    public String getArgumentosPetición() {
        return argumentosPetición;
    }

    public void setArgumentosPetición(String argumentosPetición) {
        this.argumentosPetición = argumentosPetición;
    }   
}
