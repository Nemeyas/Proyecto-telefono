package Empresa;

public class Empresa{

    private Planes[] planes;
    private String nombreDeLaEmpresa;
    private String[] clientes; // Clientes[] clientes;
    private int tallaPlanes;
    private int tallaCliente;

    public void Empresa(int talla, String nombreEmpresa){
        tallaPlanes = talla
        planes = new Planes[tallaPlanes];
        nombreDeLaEmpresa = nombreEmpresa;
        clientes = new String[tallaPlanes];
        tallaCliente = 0;
    }

    public void agregarCliente(String newClient){
        clientes[tallaCliente] = newClient;
        planes.agregarClientePlan(newClient);
        tallaCliente++;
    }

    /public void borrarPlan( String nombreDelPlan){

        planes.borrar(nombreDelPlan);
    }/

    public void buscarPlanes(String clienteBuscado){
        for(int i)

    }

    public void mostrarPlanes( int choice){
        for( int i = 0 ; i < tallaPlanes; i++){
            planes[i].mostrarPlan( choice );
        }
    }




}