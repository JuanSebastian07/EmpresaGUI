package servidor.servicios;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
 
    private ServerSocket objServidor = null;  
    private DataInputStream objFlujoDeEntrada;//leer peticiones
    private DataOutputStream objFlujoDeSalida;//escribir respuesta
    private Controlador objControlador;
    
    public Servidor(int puerto,Controlador objControlador) throws IOException {
         objServidor = new ServerSocket(puerto);
         this.objControlador=objControlador;
    }
    
    public  void ejecutarServidor() {
 
       
        Socket objSocket = null;//representar el socket del cliente
 
        try {
           
            System.out.println("Servidor iniciado \uD83D\uDC80 \uD83D\uDC7E");
            //Siempre estara escuchando peticiones
            while (true) {
 
                //Espero a que un cliente se conecte
                objSocket = objServidor.accept();
                //System.out.println("Cliente nuevo conectado");
               
                objFlujoDeEntrada = new DataInputStream(objSocket.getInputStream());//referencia al canal para leer
                objFlujoDeSalida = new DataOutputStream(objSocket.getOutputStream());//referencia al canal para escribir
                
                //Aqui leemos el json recibido desde el cliente 
                String JSONRecibido = objFlujoDeEntrada.readUTF();
                //
                String resultado=objControlador.atenderPeticion(JSONRecibido);
                //
                objFlujoDeSalida.writeUTF(resultado);
 
                //Cierro el socket
                objSocket.close();
                //System.out.println("Cliente desconectado");
 
            }
 
        } catch (IOException ex) {
            System.out.println("error de conexión");
        }
 
    }
 
    
   
}