import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

        if (linea != null){
            parte = linea.split(",");
            leerDatosBase(parte);
            for (int i = 0 ; i < cantPlanes ; i++){
                linea = lector.readLine();
                parte = linea.split(",");
                leerPlanes(parte);
            }
            for (int i = 0 ; i < cantClientes ; i++){
                linea = lector.readLine();
                parte = linea.split(",");
                leerClientes(parte);
            }
        }

        /*while (linea != null){
            parte = linea.split(",");

            for (int i = 0 ; i < cantPlanes ; i++){
                leerPlanes(parte);
                linea = lector.readLine();
                parte = linea.split(",");
            }
            
            for (int i = 0 ; i < cantClientes ; i++){
                leerClientes(parte);
                linea = lector.readLine();
                parte = linea.split(",");
            }
            linea = lector.readLine();
        }*/
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
        String nombreCliente = parte[0];
        int deuda = Integer.parseInt(parte[1]);
        String rut = parte[2];
        int cantPlanes = Integer.parseInt(parte[3]);
        String nombrePlan;
        Clientes cliente = null;

        for (int i = 4 ; i < cantPlanes + 4 ; i++){
            nombrePlan = parte[i];
            cliente = empresa.agregarCliente(nombreCliente, nombrePlan, deuda, rut);
            System.out.println(empresa.cantidadClientes());
            cliente.agregarPlan(nombrePlan);
        }
        //((ArrayList<Clientes>)empresa.getListClientes()).add(cliente);
    }

    public void leerPlanes(String[] parte){
        String PlanNombre = parte[0];
        int valorPlan = Integer.parseInt(parte[1]);
        int cantMinutos = Integer.parseInt(parte[2]);
        int cantGigas = Integer.parseInt(parte[3]);

        empresa.crearPlan(PlanNombre, valorPlan, cantMinutos, cantGigas);
    }

    public void leerDatosBase(String[] parte){
        empresa = new Empresa(parte[0]);
        cantPlanes = Integer.parseInt(parte[1]);
        cantClientes = Integer.parseInt(parte[2]);
    }
}