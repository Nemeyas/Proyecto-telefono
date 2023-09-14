import java.io.*;
import java.util.*;

public class Menu {
  BufferedReader lector;
  String barra = "----------------------------------";
  public Menu()throws IOException{
    lector = new BufferedReader(new InputStreamReader(System.in));
  }
  
  public void menu()throws IOException{
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
    System.out.println("9. Testeo de casting");
    System.out.println(barra);
  }

  public String leerNombreCliente(int opcion)throws IOException {
    if(opcion == 2){
      System.out.println("Ingrese el nombre del cliente (los clientes no se pueden repetir)");
      String nombreCliente = lector.readLine();
      return nombreCliente;
    }
    if(opcion == 6){
      System.out.println("Ingrese el nombre del cliente a buscar");
      String nombreCliente = lector.readLine();
      return nombreCliente;
    }
    if(opcion == 7){
      System.out.println("Ingrese el nombre del cliente existente al cual le quiere añadir el plan");
      String nombreCliente = lector.readLine();
      return nombreCliente;
    }
    return "hola";
  }

  public String leerNombrePlan(int opcion) throws IOException{
    if(opcion == 1){
      System.out.println("Ingrese el nombre del plan");
      String nombrePlan = lector.readLine();
      return nombrePlan;
      
    }
    if(opcion == 2){
      System.out.println("Ingrese el plan del cliente");
      String nombrePlan = lector.readLine();
      return nombrePlan;
      
    }
    if(opcion == 3){
      System.out.println("Ingrese el nombre del plan a eliminar");
      String nombrePlan = lector.readLine();
      return nombrePlan;
    
      
    }
    if(opcion == 5){
      System.out.println("Ingrese el nombre del plan a mostrar");
      String nombrePlan = lector.readLine();
      return nombrePlan;
      
    }
    if(opcion == 7){
      System.out.println("Ingrese el nombre del plan a añadir al cliente");
      String nombrePlan = lector.readLine();
      return nombrePlan;
    }
    return "hola";
  }
  
  public int leerPrecio()throws IOException{ 
    System.out.println("Ingrese valor del plan");
    int valorPlan = Integer.parseInt(lector.readLine());
    return valorPlan;
    
  }
  public int leerMinutos()throws IOException{
    System.out.println("Ingrese los minutos del plan");
    int minutos = Integer.parseInt(lector.readLine());
    return minutos;
    
  }
  public int leerGigas()throws IOException{
    System.out.println("Ingrese los gigas del plan");
    int gigas = Integer.parseInt(lector.readLine());
    return gigas;
  }

  public int leerMonto()throws IOException{
    System.out.println("Ingrese el monto del plan");
    int monto = Integer.parseInt(lector.readLine());
    return monto;
  }

  public String leerRut()throws IOException{
    System.out.println("Ingrese el rut del cliente");
    String rut = lector.readLine();
    return rut;
  }

  public void opcionInvalida()throws IOException{
    System.out.println("Ingrese una opcion valida");
  }
  public void finalPrograma(){
    System.out.println(barra);
    System.out.println("      FIN DEL PROGRAMA");
    System.out.println(barra);
  }
  public String opcion()throws IOException{
    System.out.println("Ingrese una de las opciones : ");
    String opcion = lector.readLine();
    return opcion;
  }
  public String leerNombreEmpresa()throws IOException{
    System.out.println("Ingrese el nombre de la empresa");
    String nombreEmpresa = lector.readLine();
    return nombreEmpresa;
  }

  public void mostrarNombreLista(Object lista){
    ArrayList lista2 = (ArrayList) lista;
    for (int i = 0 ; i < lista2.size()  ; i++){
      System.out.println("hola  " + ((String)lista2.get(i)));
    }
  }



  public void mostrarNombreEmpresa(String nombreEmpresa){
    System.out.println("Nombre de la empresa : " + nombreEmpresa);
  }

  public void mostrarNombrePlan(String nombrePlan, int monto, int gigas, int minutos, ArrayList<String> clientes){
    System.out.println("");
    System.out.println("Nombre del plan : " + nombrePlan);
    System.out.println("Monto : " + monto);
    System.out.println("Gigas : " + gigas);
    System.out.println("Minutos : " + minutos);
    System.out.println("");
    System.out.println("Clientes: ");
    for( int i = 0 ; i < clientes.size() ; i++){
      System.out.println("- " + clientes.get(i));
    }
  }

  public void buscarPlan(String nombrePlan, int monto, int gigas, int minutos){
    System.out.println("");
    System.out.println("Nombre del plan : " + nombrePlan);
    System.out.println("Monto : " + monto);
    System.out.println("Gigas : " + gigas);
    System.out.println("Minutos : " + minutos);
    System.out.println("");
  }

  public void noExistePlan(String nombrePlan){
    System.out.println("El plan : " + nombrePlan + " no Existe");
  }

  public void clienteNoExiste(String nombreCliente){
    System.out.println("El Cliente " + nombreCliente + " no existe");
  }

  public void mostrarCliente(String nombre, String rut, int deuda, ArrayList<String> planes){
    System.out.println("Nombre del Cliente : " + nombre);
    System.out.println("Rut : " + rut);
    System.out.println("Deuda : " + deuda);
    System.out.println("Planes Contratados : ");
    for( int i = 0 ; i < planes.size() ; i++){
      System.out.println("- " + planes.get(i));
    }

  }
}