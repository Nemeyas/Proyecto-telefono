
import java.util.*;

public class Empresa{
    private Hashtable<String,Planes> tablaHash;
    private ArrayList<String> listaNombreHash;
    private ArrayList<Clientes> listaClientes;
    private String nombreDeLaEmpresa;
  
    public Empresa(String nombreEmpresa){
      tablaHash = new Hashtable<String,Planes>();
      listaNombreHash = new ArrayList<String>();
      listaClientes = new ArrayList<Clientes>();
      nombreDeLaEmpresa = nombreEmpresa;
    }
    //funcion que retorna true si ya existe un cliente o false si no 
    public Boolean existeCliente(String nombreCliente){
      for( int i = 0 ; i < listaClientes.size(); i++){
        if(nombreCliente.equals(listaClientes.get(i).getNombre())){
          return true;
        }
      }
      return false;
    }

    //funcion que retorna true si existe un plan o false si no existe
    public Boolean existePlan(String nombrePlan){
      if(listaNombreHash.contains(nombrePlan) == true){
        return true;
      }
      else{
        return false;
      }
    }


    //funcion que retorna la cantidad de clientes
    public int cantidadClientes(){
      return listaClientes.size();
    }

    //funcion que retorna la cantidad de planes
    public int cantidadPlanes(){
      return listaNombreHash.size();
    }
    //funcion que retorna el nombre de un plan de la lista de la casilla ingresada
    public String listaNombrePlanes(int i){
      return listaNombreHash.get(i);
    }
    //funcion que retorna el nombre de la empresa
    public String mostrarNombre(){
      return nombreDeLaEmpresa;
    }
    //funcion que retorna el monto del plan mediante el hashTable
    public int getMonto(String clave){
      return tablaHash.get(clave).getMonto();
    }
    //funcion que retorna los gigas del plan mediante el hashTable
    public int getGigas(String clave){
      return tablaHash.get(clave).getGigas();
    }
    //funcion que retorna los minutos del plan mediante el hashTable
    public int getMinutos(String clave){
      return tablaHash.get(clave).getMinutos();
    }
    //funcion que retorna la lista de clientes de un plan mediante el hashTable
    public ArrayList<String> getListClientes(String clave){
      return tablaHash.get(clave).getListClientes();
    }
    //funcion que retorna el nombre de un cliente mediante la lista de clientes
    public String getNombreCliente(int i){
      return listaClientes.get(i).getNombre();
    }
    //funcion que retorna el rut de un cliente mediante la lista de clientes
    public String getClienteRut(int i ){
      return listaClientes.get(i).getRut();
    }
    //funcion que retorna la deuda de un cliente mediante la lista de clientes
    public int getClienteDeuda(int i ){
      return listaClientes.get(i).getDeuda();
    }
    //funcion que retorna la lista de planes de un cliente meidante la lista de clientes
    public ArrayList<String> getClientePlanes(int i){
      return listaClientes.get(i).getPlanesCliente();
    }
    //funcion que retorna la posicion de un cliente en la lista, esta retorna -1 si no se encuentra
    public int posicionClienteLista(String nombreCliente){
      for(int i = 0 ; i < listaClientes.size() ; i++){
        if( nombreCliente.equals(listaClientes.get(i).getNombre())){
          return i;
        }
      }
      return -1;
    }
    
    //funcion que retorna true si existe un plan dentro de un cliente o false si no
    public Boolean existePlanCliente(String nombrePlan){
      for(int i = 0 ; i < listaClientes.size() ; i++){
        if( listaClientes.get(i).tienePlan(nombrePlan)){
          return true;
        }
      }
      return false;
    }

    public void agregarPlanCliente(String nombreCliente, String nombrePlan, int posicionCliente){
      listaClientes.get(posicionCliente).agregarPlan(nombrePlan);
      tablaHash.get(nombrePlan).agregarClientePlan(nombreCliente);
    }

    public Clientes agregarCliente(String nombreCliente, String nombrePlan, int deuda ,String rut){
      Clientes clienteNuevo = new Clientes(nombreCliente,nombrePlan, deuda, rut);
      tablaHash.get(nombrePlan).agregarClientePlan(nombreCliente);
      listaClientes.add(clienteNuevo);
      return clienteNuevo;
    }
 
    public void crearPlan(String PlanNombre, int valorPlan, int cantMinutos, int cantGigas) {
      Planes plan2 = new Planes(valorPlan, cantGigas, cantMinutos, PlanNombre);
      if(listaNombreHash.contains(PlanNombre)){
        return;
      }
      listaNombreHash.add(PlanNombre);
      tablaHash.put(PlanNombre, plan2);
    }

    //funcion que elimina un plan de una empresa, si un cliente posee este plan, se le eliminara de su lista de planes tambien
    public void eliminarPlan(String nombrePlan){
      tablaHash.remove(nombrePlan);
      int posicion = listaNombreHash.indexOf(nombrePlan);
      listaNombreHash.remove(posicion);
      for(int i = 0 ; i < listaClientes.size(); i++){
        listaClientes.get(i).borrarPlan(nombrePlan);
      }
    }
    //funcion que elimina un cliente de la empresa
    //sobreCarga
    public void eliminarCliente(String nombreCliente){
      int posicion = posicionClienteLista(nombreCliente);
      listaClientes.remove(posicion);
      for(int i = 0 ; i < listaNombreHash.size() ; i++){
        String posicionHash = listaNombreHash.get(i);
        tablaHash.get(posicionHash).eliminarCliente(nombreCliente);
      }
    
    }
    //funcion que elimina un plan de un cliente
    //sobreCarga
    public void eliminarCliente(String nombreCliente, String nombrePlan){
      int posicion = posicionClienteLista(nombreCliente);
      listaClientes.get(posicion).borrarPlan(nombrePlan);
      tablaHash.get(nombrePlan).eliminarCliente(nombreCliente);
    }

    /*public void eliminarPlan(String nombrePlan){
        for (int i = 0 ; i < listaNombreHash.size() ; i++){
            if (nombrePlan.equals(listaNombreHash.get(i))){
                listaNombreHash.remove(listaNombreHash.get(i));
            } 
        }
        tablaHash.remove(nombrePlan);
        
        for (int i = 0 ; i < listaClientes.size() ; i++){
            if (nombrePlan.equals(listaClientes.get(i).encontrarPlan(nombrePlan))){
            listaClientes.remove(listaClientes.get(i));
        } 
      }
    }*/

/*    public void eliminarCliente(String nombreCliente){
        //para otro dia
      for(int i=0; i<listaClientes.size(); i++){
        if(listaClientes(get(i))==NULL){
          System.out.println("No existe el cliente");
        }
        listaClientes.remove(listaClientes.get(i));
      }
    }*/
  
}