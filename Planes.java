//package Planes;

public class Planes{
    private String[] clientes;
    private int monto;
    private int gigas;
    private int minutos;
    private String nombreDelPlan;
    private int TallaP;
    private int largoOcupado;
    
    
    
    public void crearPlan(int talla, int valorPlan, int cantGigas, int cantMinutos, String PlanNombre){
        clientes = new String[talla];
        monto = valorPlan;
        gigas = cantGigas;
        minutos = cantMinutos;
        nombreDelPlan = PlanNombre;
    }

    public void agregarClientePlan(){

    }

    public void mostrarPlan( int opcion ){
        System.out.println( nombreDelPlan);
        if( opcion == 2){
            for ( int i = 0 ; i < TallaP ; i++){
                System.out.println( clientes[i]);
            }
        }
        if( opcion == 3){
            System.out.println("valor: $"+ monto);
            System.out.println("gigas: "+ gigas);
            System.out.println("minutos: "+ minutos);
        }

    }






}