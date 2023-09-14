
import java.util.*;

public class Empresa{
  //private Planes planes;
    private Hashtable<String,Planes> tablaHash;
    //private ArrayList<Planes> lista;
    private ArrayList<String> listaNombreHash;
    private ArrayList<Clientes> listaClientes;
    private String nombreDeLaEmpresa;
  
    public Empresa(String nombreEmpresa){
      tablaHash = new Hashtable<String,Planes>();
      //lista = new ArrayList<Planes>();
      listaNombreHash = new ArrayList<String>();
      listaClientes = new ArrayList<Clientes>();
      nombreDeLaEmpresa = nombreEmpresa;
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

    public Object retornarLista(){
      return listaNombreHash;
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


    /*public void mostrarCliente(String nombreCliente){
      for( int i = 0 ; i < listaClientes.size() ; i++){
        if( nombreCliente.equals(listaClientes.get(i).getNombre())){
          listaClientes.get(i).mostrar();
        }
      }
    }*/

    public void agregarPlanCliente(String nombreCliente, String nombrePlan){
      for(int i=0; i<listaClientes.size(); i++){
        if(nombreCliente.equals(listaClientes.get(i).getNombre())){
          if(tablaHash.get(nombrePlan) != null){
            listaClientes.get(i).agregarPlan(nombrePlan);
            tablaHash.get(nombrePlan).agregarClientePlan(nombreCliente);
            return;

          }

        }
      }
    }

    public void agregarCliente(String nombreCliente, String nombrePlan, int deuda ,String rut){
        Clientes clienteNuevo = new Clientes(nombreCliente,nombrePlan, deuda, rut);
        if( listaClientes.indexOf(clienteNuevo) != -1){
            System.out.println("El cliente ya existe");
            clienteNuevo = null;
            return;
        }
        tablaHash.get(nombrePlan).agregarClientePlan(nombreCliente);
        listaClientes.add(clienteNuevo);
    }
    //public void crearPlan(String PlanNombre, int valorPlan, int cantMinutos, int cantGigas)
    public void crearPlan(String PlanNombre, int valorPlan, int cantMinutos, int cantGigas) {
      Planes plan2 = new Planes(valorPlan, cantGigas, cantMinutos, PlanNombre);
      if(listaNombreHash.contains(PlanNombre)){
        return;
      }
      listaNombreHash.add(PlanNombre);
      tablaHash.put(PlanNombre, plan2);
    }

    public void eliminarPlan(String nombrePlan){
        if( tablaHash.get(nombrePlan) == null){
            System.out.println("No existe el plan");
            return;
        }
        
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
    }

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