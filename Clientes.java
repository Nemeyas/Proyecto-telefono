import java.util.*;

public class Clientes {
    private String nombre;
    private ArrayList<String> planes = new ArrayList<String>();

    public Clientes(String nombreCliente, String nombrePlan){
        nombre = nombreCliente;
        planes.add(nombrePlan);
    }

    public void agregarPlan(String nombrePlan){
        planes.add(nombrePlan);

    }
    public void mostrar(){
        System.out.println("Cliente : " + nombre);
        if ( planes.size() != 0){
            for( int i = 0 ; i < planes.size() ; i++){
            System.out.println(planes.get(i));
            }    
        }
        else{
            System.out.println("El cliente no tiene planes");
        }
        
    }

    public String nombreCliente(){
        return nombre;
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
}
