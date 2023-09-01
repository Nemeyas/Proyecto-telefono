//package Empresa;
//package Planes;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader lector = new BufferedReader( new InputStreamReader(System.in));
        int opcion;
        
        System.out.println("Ingrese el nombre de su empresa");
        String lecturaNombre = lector.readLine();
        
        Empresa empresa = new Empresa(lecturaNombre);

        while(true){
            System.out.println("¿Que quiere hacer con su empresa?");
            System.out.println("1. Agregar otro plan");
            System.out.println("2. Agregar cliente nuevo");
            System.out.println("3  Borrar plan");
            System.out.println("4  Mostrar planes");
            System.out.println("5  Buscar plan");
            System.out.println("6  Buscar Cliente");
            System.out.println("7. Salir del programa y borrar la empresa");

            opcion = Integer.parseInt(lector.readLine());
            if (opcion == 1){
                System.out.println("Ingrese el nombre del plan");
                String nombrePlan = lector.readLine();
                System.out.println("Ingrese valor del plan");
                int valorPlan = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los minutos del plan");
                int minutos = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los gigas del plan");
                int gigas = Integer.parseInt(lector.readLine());
                empresa.agregarPlan(valorPlan, gigas, minutos, nombrePlan);
            }
            if (opcion == 2){
                System.out.println("Ingrese el nombre del cliente(Los clientes no se pueden repetir)");
                String nombreCliente = lector.readLine();
                System.out.println("Ingrese el plan del cliente");
                String nombrePlan = lector.readLine();
                empresa.agregarCliente(nombreCliente, nombrePlan);
            }
            if (opcion == 3){
                System.out.println("ingrese el nombre del plan a eliminar");
                String nombrePlanEliminar = lector.readLine();
                empresa.eliminarPlan(nombrePlanEliminar);
            }
            if (opcion == 4){
                empresa.mostrar();
            }
            if (opcion == 5){
                System.out.println("Ingrese el nombre del plan a mostrar");
                String nombrePlan = lector.readLine();
                empresa.mostrarPlan(nombrePlan);
            }
            if (opcion == 6){
                System.out.println("Ingrese el nombre del cliente a buscar");
                String nombreCliente = lector.readLine();
                empresa.mostrarCliente(nombreCliente);
            }
            if (opcion == 7){
                return;
            }
            
        }
        

        



    }





}
