public class ClienteRepetidoException extends Exception{
    public ClienteRepetidoException(){
        super("El cliente está repetido");
    }
}