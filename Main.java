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
                System.out.println("Ingrese la cantidad de clientes maxima del plan");
                int cantMax = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los minutos del plan");
                int minutos = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los gigas del plan");
                int gigas = Integer.parseInt(lector.readLine());
                empresa.agregarPlan(cantMax, valorPlan, gigas, minutos, nombrePlan);
            }
            if (opcion == 2){
                


            }
            if (opcion == 3){
                



            }
            if (opcion == 4){
                


            }
            if (opcion == 5){
                


            }
            if (opcion == 6){
                

                
            }
            if (opcion == 7){
                return;
            }
            
        }
        

        



    }





}
