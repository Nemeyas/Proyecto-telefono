//package Planes;
import java.util.*;

public class Planes{
    private ArrayList<String> clientes;
    private int monto;
    private int gigas;
    private int minutos;
    private String nombreDelPlan;

    public  Planes(int valorPlan, int cantGigas, int cantMinutos, String PlanNombre){
        clientes = new ArrayList<String>();
        monto = valorPlan;
        gigas = cantGigas;
        minutos = cantMinutos;
        nombreDelPlan = PlanNombre;
    }

    //funcion que retorna el nombre del plan
    public String getNombreDelPlan(){
        return nombreDelPlan;
    }
    //funcion que retorna el monto del plan
    public int getMonto(){
        return monto;
    }
    //funcion que retorna los gigas del plan
    public int getGigas(){
        return gigas;
    }
    //funcion que retorna los minutos del plan
    public int getMinutos(){
        return minutos;
    }
    //funcion que retorna la lista de clientes del plan
    public ArrayList<String> getListClientes(){
        return clientes;
    }

    public void agregarClientePlan(String nombre){
        String cliente = nombre;
        if(clientes.contains(cliente)){
            return;
        }
        clientes.add(cliente);
    }

    public void eliminarCliente(String nombreCliente){
        clientes.remove(clientes.indexOf(nombreCliente));
    }

    public void eliminarCliente(){
        for (int i = 0 ; i < clientes.size() ; i++){
            clientes.remove(clientes.get(i));
        }
    }

    public void mostrarPlan(){
        System.out.println("");
        System.out.println(nombreDelPlan);
        System.out.println(monto);
        System.out.println(gigas);
        System.out.println(minutos);
    }

    public void mostrarClientes(){
        System.out.println("Clientes:");
        for ( int i = 0 ; i < clientes.size(); i++){
            System.out.println(clientes.get(i));
        }
    }

}