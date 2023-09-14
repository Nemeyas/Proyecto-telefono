import java.util.*;

public class Clientes {
    private String nombre;
    private String rut;
    private int deuda;
    private ArrayList<String> planes;

    public Clientes(String nombreCliente, String nombrePlan,int deuda ,String rut){
        nombre = nombreCliente;
        planes = new ArrayList<String>();
        planes.add(nombrePlan);
        this.rut = rut;
        this.deuda = deuda;
        
    }
    //funcion que retorna el nombre del cliente
    public String getNombre(){
        return nombre;
    }
    //funcion que retorna el rut del cliente
    public String getRut(){
        return rut;
    }
    //funcion que retorna la deuda de un cliente
    public int getDeuda(){
        return deuda;
    }
    //funcion que retorna la lista de planes de un cliente
    public ArrayList<String> getPlanesCliente(){
        return planes;
    }

    /*public void mostrar(){
        System.out.println("Cliente : " + nombre);
        if ( planes.size() != 0){
            System.out.print("Planes : ");
            for( int i = 0 ; i < planes.size() ; i++){
            System.out.print(planes.get(i) + " ");
            }
            System.out.println(" ");    
        }
        else{
            System.out.println("El cliente no tiene planes");
        }
        
    }*/
    
    public String encontrarPlan(String nombrePlan){
        int indexPlan = planes.indexOf(nombrePlan);
        if(indexPlan != -1){
            return planes.get(indexPlan);
        }
        else{
            return "NO";
        }
    }

    public void borrarPlan(String nombrePlan){
        for(int i=0; i< planes.size(); i++){
            if(planes.get(i).equals(nombrePlan)){
                planes.remove(i);
            }
        }
    }

    public void agregarPlan(String nombrePlan){
        for(int i = 0 ; i < planes.size() ; i++){
            if(nombrePlan.equals(planes.get(i))){
                System.out.println("El cliente ya posee este plan");
                return;
            }
        }
        planes.add(nombrePlan);
    }
}
