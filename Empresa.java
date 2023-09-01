
import java.util.*;

public class Empresa{
    
  //private Planes planes;
  private Hashtable<String,Planes> tablaHash = new Hashtable<String,Planes>();
  private ArrayList<Planes> lista = new ArrayList<Planes>();
  private ArrayList<Clientes> listaClientes = new ArrayList<Clientes>();
  private String nombreDeLaEmpresa;
  
    public Empresa(String nombreEmpresa){
        nombreDeLaEmpresa = nombreEmpresa;
    }

    public void mostrarNombre(){
        System.out.println(nombreDeLaEmpresa);
    }

    public void mostrarCliente(String nombreCliente){
      for( int i = 0 ; i < listaClientes.size() ; i++){
        if( nombreCliente.equals(listaClientes.get(i).nombreCliente())){
          listaClientes.get(i).mostrar();
        }
      }
    }

    public void agregarCliente(String nombreCliente, String nombrePlan){
        Clientes clienteNuevo = new Clientes(nombreCliente,nombrePlan);
        if( listaClientes.indexOf(clienteNuevo) != -1){
            System.out.println("El cliente ya existe");
            clienteNuevo = null;
            return;
        }
        tablaHash.get(nombrePlan).agregarClientePlan(nombreCliente);
        listaClientes.add(clienteNuevo);
    }
    
    public void agregarPlan(int valorPlan, int cantGigas, int cantMinutos, String PlanNombre) {
      Planes plan2 = new Planes(valorPlan, cantGigas, cantMinutos, PlanNombre);
      if(lista.contains(plan2)){
        return;
      }
      lista.add(plan2);
      tablaHash.put(PlanNombre, plan2);
    }

    public void eliminarPlan(String nombrePlan){
        if( tablaHash.get(nombrePlan) == null){
            System.out.println("No existe el plan");
            return;
        }
        
        for (int i = 0 ; i < lista.size() ; i++){
            if (nombrePlan.equals(lista.get(i).mostrarNombreR())){
                lista.remove(lista.get(i));
            } 
        }
        tablaHash.remove(nombrePlan);
        
        for (int i = 0 ; i < listaClientes.size() ; i++){
            if (nombrePlan.equals(listaClientes.get(i).encontrarPlan(nombrePlan))){
            listaClientes.remove(listaClientes.get(i));
        } 
      }
    }

    public void eliminarCliente(String nombreCliente){
        
    }

    public void mostrarPlan(String nombreDelPlan){
      for( int i = 0 ; i< lista.size() ; i++){
        if(nombreDelPlan.equals(lista.get(i).mostrarNombreR())){
          lista.get(i).mostrarPlan();
        }
      }

    }

    public void mostrar(){
        System.out.println(nombreDeLaEmpresa);
        for (int i = 0 ; i < lista.size() ; i++){
          lista.get(i).mostrarPlan();
          lista.get(i).mostrarClientes();
      }
    }
  
}