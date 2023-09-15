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
                String nombreCliente = menu.leerNombreCliente(2);
                if(empresa.existeCliente(nombreCliente)){
                    menu.existeCliente(nombreCliente);
                }
                else{
                    empresa.agregarCliente(nombreCliente, menu.leerNombrePlan(2), menu.leerMonto(), menu.leerRut());
                }
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
                if(empresa.existePlan(nombrePlan) == true){
                    menu.buscarPlan(nombrePlan, empresa.getMonto(nombrePlan), empresa.getGigas(nombrePlan), empresa.getMinutos(nombrePlan));
                }
                else{
                    menu.noExistePlan(nombrePlan);
                }
            }
            else if (opcion.equals("6")){
                String nombreCliente = menu.leerNombreCliente(6);
                int posicionCliente = empresa.posicionClienteLista(nombreCliente);
                if( posicionCliente == -1){
                    menu.clienteNoExiste(nombreCliente);
                }
                else{
                    menu.mostrarCliente(empresa.getNombreCliente(posicionCliente), empresa.getClienteRut(posicionCliente), empresa.getClienteDeuda(posicionCliente), empresa.getClientePlanes(posicionCliente));
                }
            }
            else if (opcion.equals("7")){
                String nombreCliente = menu.leerNombreCliente(7);
                int posicionCliente = empresa.posicionClienteLista(nombreCliente);
                String nombrePlan = menu.leerNombrePlan(7);
                Boolean tienePlan = empresa.existePlanCliente(nombrePlan);
                if( posicionCliente == -1 && empresa.existePlan(nombrePlan) == false){
                    menu.clienteNoExiste(nombreCliente);
                    menu.noExistePlan(nombrePlan);
                }
                else if ( empresa.existePlan(nombrePlan) == false){
                    menu.noExistePlan(nombrePlan);
                }
                else if( posicionCliente == -1){
                    menu.clienteNoExiste(nombreCliente);
                }
                else if( tienePlan == true){
                    menu.tienePlan(nombrePlan);
                }
                else{
                    empresa.agregarPlanCliente(nombreCliente, nombrePlan,posicionCliente);
                }

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
