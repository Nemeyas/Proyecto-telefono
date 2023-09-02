//package Empresa;
//package Planes;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String opcion;
        String barra = "----------------------------------";
        
        System.out.println("Ingrese el nombre de su empresa");
        String lecturaNombre = lector.readLine();
        
        Empresa empresa = new Empresa(lecturaNombre);

        while(true){
            System.out.println(barra);
            System.out.println("¿Que quiere hacer con su empresa?");
            System.out.println(barra);
            System.out.println("1. Crear un plan nuevo");
            System.out.println("2. Agregar cliente nuevo");
            System.out.println("3. Borrar plan");
            System.out.println("4. Mostrar planes");
            System.out.println("5. Buscar plan");
            System.out.println("6. Buscar Cliente");
            System.out.println("7. Agregar plan a cliente existente");
            System.out.println("8. Salir del programa y borrar la empresa");
            System.out.println(barra);

            opcion = lector.readLine();
            if (opcion.equals("1")){
                System.out.println("Ingrese el nombre del plan");
                String nombrePlan = lector.readLine();
                System.out.println("Ingrese valor del plan");
                int valorPlan = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los minutos del plan");
                int minutos = Integer.parseInt(lector.readLine());
                System.out.println("Ingrese los gigas del plan");
                int gigas = Integer.parseInt(lector.readLine());
                empresa.crearPlan(valorPlan, gigas, minutos, nombrePlan);
            }
            else if (opcion.equals("2")){
                System.out.println("Ingrese el nombre del cliente(Los clientes no se pueden repetir)");
                String nombreCliente = lector.readLine();
                System.out.println("Ingrese el plan del cliente");
                String nombrePlan = lector.readLine();
                empresa.agregarCliente(nombreCliente, nombrePlan);
            }
            else if (opcion.equals("3")){
                System.out.println("ingrese el nombre del plan a eliminar");
                String nombrePlanEliminar = lector.readLine();
                empresa.eliminarPlan(nombrePlanEliminar);
            }
            else if (opcion.equals("4")){
                empresa.mostrar();
            }
            else if (opcion.equals("5")){
                System.out.println("Ingrese el nombre del plan a mostrar");
                String nombrePlan = lector.readLine();
                empresa.mostrar(nombrePlan);
            }
            else if (opcion.equals("6")){
                System.out.println("Ingrese el nombre del cliente a buscar");
                String nombreCliente = lector.readLine();
                empresa.mostrarCliente(nombreCliente);
            }
            else if (opcion.equals("7")){
                System.out.println("Ingrese el nombre del cliente existente al cual le quiere añadir el plan");
                String nombre = lector.readLine();
                System.out.println("Ingrese el nombre del plan a añadir al cliente");
                String planAñadir = lector.readLine();
                empresa.agregarPlanCliente(nombre, planAñadir);
            }
            else if (opcion.equals("8")){
                System.out.println(barra);
                System.out.println("      FIN DEL PROGRAMA");
                System.out.println(barra);
                return;
            }
            else{
                System.out.println("Ingrese una opcion valida");
            }
            
        }
    }
}
