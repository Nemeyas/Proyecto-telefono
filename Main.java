//package Empresa;
//package Planes;

import java.io.*;

public class Main{

    public static void main(String[] args)throws IOException{
      Menu menu = new Menu();
      Empresa empresa = new Empresa(menu.leerNombreEmpresa());
        while(true){
          menu.menu();
          String opcion = menu.opcion();
            if (opcion.equals("1")){
                empresa.crearPlan(menu.leerNombrePlan(1), menu.leerPrecio(), menu.leerGigas(), menu.leerMinutos());
            }
            else if (opcion.equals("2")){
                empresa.agregarCliente(menu.leerNombreCliente(2), menu.leerNombrePlan(2), menu.leerMonto(), menu.leerRut());
            }
            else if (opcion.equals("3")){
                empresa.eliminarPlan(menu.leerNombrePlan(3));
            }
            else if (opcion.equals("4")){
                menu.mostrarNombreEmpresa(empresa.mostrarNombre());
                for(int i = 0 ; i < empresa.cantidadPlanes() ; i++){
                    menu.mostrarNombrePlan(empresa.listaNombrePlanes(i), empresa.getMonto(empresa.listaNombrePlanes(i)), empresa.getGigas(empresa.listaNombrePlanes(i)), empresa.getMinutos(empresa.listaNombrePlanes(i)), empresa.getListClientes(empresa.listaNombrePlanes(i)));
                }
            }
            else if (opcion.equals("5")){
                String nombrePlan = menu.leerNombrePlan(5);
                menu.buscarPlan(nombrePlan, empresa.getMonto(nombrePlan), empresa.getGigas(nombrePlan), empresa.getMinutos(nombrePlan));
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
            else if(opcion.equals("9")){
                menu.mostrarNombreLista(empresa.retornarLista());

            }
            else{
                menu.opcionInvalida();
            }
        }
    }
}
