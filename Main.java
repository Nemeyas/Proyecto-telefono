//package Empresa;
//package Planes;


public class Main{

    public static void main(String[] args){
      Menu menu = new Menu();
      Empresa empresa = new Empresa(menu.leerNombreEmpresa());

        while(true){
          menu.menu();
          String opcion = menu.opcion();
            if (opcion.equals("1")){
                empresa.crearPlan(menu.leerPrecio(), menu.leerGigas(), menu.leerMinutos(), menu.leerNombrePlan(1));
            }
            else if (opcion.equals("2")){
                empresa.agregarCliente(menu.leerNombreCliente(2), menu.leerNombrePlan(2), menu.leerMonto(), menu.leerRut());
            }
            else if (opcion.equals("3")){
                empresa.eliminarPlan(menu.leerNombrePlan(3));
            }
            else if (opcion.equals("4")){
                empresa.mostrar();
            }
            else if (opcion.equals("5")){
                empresa.mostrar(menu.leerNombrePlan(5));
            }
            else if (opcion.equals("6")){
                empresa.mostrarCliente(menu.leerNombreCliente(6));
            }
            else if (opcion.equals("7")){
              empresa.agregarPlanCliente(menu.leerNombreCliente(7), menu.leerNombrePlan(7));
            }
            else if (opcion.equals("8")){
              menu.finalPrograma();
              return;
            }
            else{
                menu.opcionInvalida();
            }
        }
    }
}
