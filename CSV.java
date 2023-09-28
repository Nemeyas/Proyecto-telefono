import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class CSV{
    private String linea;
    private BufferedReader lector;
    private String parte[];
    private Empresa empresa;
    private int cantPlanes;
    private int cantClientes;


    // NO SE POR QUE PUSE CONT, BORRAR EN CASO DE NO ACORDARME A LA BREVEDAD XD
    public void Importar(String FileName) throws IOException{
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
    }

    public void Exportar(String FileName) throws IOException{

    }

    public void leerClientes(String[] parte){
        String nombreCliente = null;
        String nombrePlan = null;
        int deuda = 0;
        String rut = null;

        for (int i = 0 ; i < parte.length ; i++){
            if (i == 0) nombreCliente = parte[i];
            else if (i == 1) nombrePlan = parte[i];
            else if (i == 2) deuda = Integer.parseInt(parte[i]);
            else if (i == 3) rut = parte[i];
        }

        empresa.agregarCliente(nombreCliente, nombrePlan, deuda, rut);
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