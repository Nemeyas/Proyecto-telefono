package Planes;

public class Planes{
    private String[] clientes;
    private int monto;
    private int gygas;
    private int minutos;
    private String nombreDelPLan;
    private int TallaP;
    private int largoTalla;

    public void Planes(int talla, int valorPlan , String PlanNombre){
        clientes = new String[talla];
        monto = valorPlan;
        nombreDelPlan = PlanNombre;
    }

    public void agregarClientePlan(){

    }

    public void mostrarPlan( int opcion ){
        System.out.println( nombreDelPlan);
        if( opcion == 2){
            for ( int i = 0 ; i < TallaP ; i++){
                System.out.println( clientes[i];
            }
        }
        if( opcion == 3){
            System.out.println("valor: $"+ monto);
            System.out.println("gygas: "+ gygas);
            System.out.println("minutos: "+ minutos);
        }

    }






}