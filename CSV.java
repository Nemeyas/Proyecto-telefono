import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class CSV{
    private String linea;
    private BufferedReader lector;
    private String parte[];
    private Empresa empresa;
    private int cantPlanes;
    private int cantClientes;


    // NO SE POR QUE PUSE CONT, BORRAR EN CASO DE NO ACORDARME A LA BREVEDAD XD
    public Empresa Importar(String FileName) throws IOException{
        lector = new BufferedReader(new FileReader(FileName));
        linea = lector.readLine();
        int cont = 0;
        while (linea != null){
            parte = linea.split(",");
            if (cont == 0){
                leerDatosBase(parte);
            }
            else if (cont == 1){
                for (int i = 0 ; i < cantPlanes ; i++){
                    leerPlanes(parte);
                    linea = lector.readLine();
                    parte = linea.split(",");
                }
            }
            else if (cont == 2){
                for (int i = 0 ; i < cantClientes ; i++){
                    leerClientes(parte);
                    linea = lector.readLine();
                    parte = linea.split(",");
                }
            }
            linea = lector.readLine();
            cont++;
        }
        lector.close();
        return empresa;
    }

    public void Exportar(String FileName, Empresa empresa) throws IOException{
        String clave;
        FileWriter archivo = new FileWriter(FileName);
        archivo.write(empresa.mostrarNombre() + "," + empresa.cantidadPlanes() + "," + empresa.cantidadClientes());
        archivo.write(System.getProperty( "line.separator"));

        for (int i = 0 ; i < empresa.cantidadPlanes() ; i++){
            clave = empresa.listaNombrePlanes(i);
            archivo.write(clave + "," + empresa.getMonto(clave) + "," + empresa.getMinutos(clave) + "," + empresa.getGigas(clave));
            archivo.write(System.getProperty( "line.separator"));
        }

        for (int i = 0 ; i < empresa.cantidadClientes() ; i++){
            archivo.write(empresa.getNombreCliente(i) + "," + empresa.getClienteDeuda(i) + "," + empresa.getClienteRut(i) + "," + ((ArrayList<String>)(empresa.getClientePlanes(i))).size());
            for (int k = 0 ; k < ((ArrayList<String>)(empresa.getClientePlanes(i))).size() ; k++){
                archivo.write("," + ((ArrayList<String>)(empresa.getClientePlanes(i))).get(k));
            }
            archivo.write(System.getProperty( "line.separator"));
        }
        archivo.close();
    }

    public void leerClientes(String[] parte){
        String nombreCliente = null;
        String nombrePlan = null;
        int deuda = 0;
        String rut = null;
        Clientes cliente;
        int cantPlanes = 0;

        for (int i = 0 ; i < parte.length ; i++){
            if (i == 0) nombreCliente = parte[i];
            else if (i == 1) deuda = Integer.parseInt(parte[i]);
            else if (i == 2) rut = parte[i];
            else if (i == 3){
                cantPlanes = Integer.parseInt(parte[i]);
                for (int k = 0 ; k < cantPlanes ; k++){
                    nombrePlan = parte[i];
                    cliente = empresa.agregarCliente(nombreCliente, nombrePlan, deuda, rut);
                    cliente.agregarPlan(nombrePlan);
                }
            } 
        }
    }

    public void leerPlanes(String[] parte){
        String PlanNombre = null;
        int valorPlan = 0;
        int cantMinutos = 0;
        int cantGigas = 0;

        for (int i = 0 ; i < parte.length ; i++){
            if (i == 0) PlanNombre = parte[i];
            else if (i == 1) valorPlan = Integer.parseInt(parte[i]);
            else if (i == 2) cantMinutos = Integer.parseInt(parte[i]);
            else if (i == 3) cantGigas = Integer.parseInt(parte[i]);
        }

        empresa.crearPlan(PlanNombre, valorPlan, cantMinutos, cantGigas);
    }

    public void leerDatosBase(String[] parte){
        for (int i = 0 ; i < parte.length ; i++){
            if (i == 0) empresa = new Empresa(parte[i]);
            else if (i == 1) cantPlanes = Integer.parseInt(parte[i]);
            else if (i == 2) cantClientes = Integer.parseInt(parte[i]);
        }
    }
}