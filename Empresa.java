
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

    public int cantidadPlanes(){
      return listaNombreHash.size();
    }

    public String listaNombrePlanes(int i){
      return listaNombreHash.get(i);
    }

    public String mostrarNombre(){
      return nombreDeLaEmpresa;
    }

    public Object retornarLista(){
      return listaNombreHash;
    }

    public int getMonto(String clave){
      return tablaHash.get(clave).getMonto();
    }

    public int getGigas(String clave){
      return tablaHash.get(clave).getGigas();
    }

    public int getMinutos(String clave){
      return tablaHash.get(clave).getMinutos();
    }

    public ArrayList<String> getListClientes(String clave){
      return tablaHash.get(clave).getListClientes();
    }

    public void mostrarCliente(String nombreCliente){
      for( int i = 0 ; i < listaClientes.size() ; i++){
        if( nombreCliente.equals(listaClientes.get(i).getNombre())){
          listaClientes.get(i).mostrar();
        }
      }
    }

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
      System.out.println("El cliente ingresado no existe");
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