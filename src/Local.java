import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Local {

    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Envio> envios = new ArrayList<>();

    //----------------- Constructor -------------------
    public Local(){}

    //----------------- Productos -------------------
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    //----------------- Envios -------------------
    public ArrayList<Envio> getEnvios() {
        return envios;
    }
    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }

    //----------------- Metodos -------------------
    public void agregaProductos (Producto producto){
        this.productos.add(producto);
    }

    public void agregaEnvios(Envio envio){

        if(!this.envios.isEmpty()){

            int i = 0;

            for(Envio aux : this.envios){

                if(aux.getCliente().getTelefono().equals(envio.getCliente().getTelefono())){
                    i = this.envios.indexOf(aux);
                    this.envios.add(i,envio);
                    break;
                }

                if(this.envios.size() == this.envios.indexOf(aux)+1){
                    this.envios.add(envio);
                    break;
                }
            }

        }else{

            this.envios.add(envio);
        }

    }

    public double getPromedioVentas (){

        double sumaCostoTotal = 0 ;
        double cantVentas = this.envios.size() ; //


        for (Envio aux : this.envios){

            sumaCostoTotal += aux.getCostoTotal();

        }

        return sumaCostoTotal/cantVentas;

    }

    public int cantClienteRepetidoEnEnvios(Cliente cliente){

        int cantClienteRepetido = 0;

        for(Envio aux : this.envios){

            if(aux.getCliente().getTelefono().equals(cliente.getTelefono())){
                cantClienteRepetido++;
            }

        }

        return cantClienteRepetido;

    }

    public Cliente getClienteConMasCompras () {

        Cliente auxCliente = this.envios.get(0).getCliente();
        int cantEnviosMayor = cantClienteRepetidoEnEnvios(auxCliente);

        for (Envio auxEnvio : this.envios) {

            if (!auxCliente.getTelefono().equals(auxEnvio.getCliente().getTelefono()) &&
                    cantClienteRepetidoEnEnvios(auxEnvio.getCliente()) > cantEnviosMayor ) {

                auxCliente = auxEnvio.getCliente();
                cantEnviosMayor = cantClienteRepetidoEnEnvios(auxEnvio.getCliente()) ;

            }
        }

        return auxCliente;

    }

    public String muestraListaEnvios(){

        String listaEnvios = "";

        for (Envio aux : this.envios){
            listaEnvios += aux.toString() + "\n";
        }

        return listaEnvios;
    }

}





