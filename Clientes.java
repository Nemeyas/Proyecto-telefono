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

    public Clientes(String nombreCliente,int deuda ,String rut){
        nombre = nombreCliente;
        planes = new ArrayList<String>();
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

    public Boolean tienePlan(String nombrePlan){
        return planes.contains(nombrePlan);
    }

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
        planes.add(nombrePlan);
    }
}
