//package Empresa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Empresa{
    
    private Planes[] planes;
    private String nombreDeLaEmpresa;
    //private String[] clientes; // Clientes[] clientes;
    //private int tallaClientes;
    //private int tallaOcupadoClientes;
    private int tallaPlanes;
    private int tallaOcupada;
    BufferedReader lee = new BufferedReader( new InputStreamReader(System.in));

    public Empresa(int talla, String nombreEmpresa){
        tallaPlanes = talla; 
        planes = new Planes[tallaPlanes];

        for(int i = 0 ; i < tallaPlanes ; i++){
            planes[i] = new Planes();
        }
        
        nombreDeLaEmpresa = nombreEmpresa;
        //clientes = new String[tallaPlanes];
        tallaOcupada = 0;
    }

    public void agregarPlan(int talla, int valorPlan, int cantGigas, int cantMinutos, String PlanNombre) {
        planes[tallaOcupada].crearPlan(talla, valorPlan, cantGigas, cantMinutos, PlanNombre);
        tallaOcupada++;
    }

    public void mostrarEmpresa( ){
        System.out.println(nombreDeLaEmpresa);
    }

    public void agregarCliente(String newClient){
        //clientes[tallaCliente] = newClient;
        //planes.agregarClientePlan(newClient);
        //tallaCliente++;
    }

    public void borrarPlan( String nombreDelPlan){

        ////planes.borrar(nombreDelPlan);
        tallaOcupada--;
    }



    public void mostrarPlanes( int choice){
        for( int i = 0 ; i < tallaPlanes; i++){
            planes[i].mostrarPlan( choice );
        }
    }




}