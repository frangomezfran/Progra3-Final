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
    public void nuevoProducto (Producto producto){
        this.productos.add(producto);
    }

    public String nuevaVenta(Cliente cliente, double cantKms, Producto producto){
        //Se que si retornara algo deberia ser un boolean, Lo hago con un string para verlo mejor en consola

        if (verificaProductoEnInventario(producto)){//Si el producto existe y hay stock, continuamos

            Envio envioAux = new Envio(cliente,cantKms,producto);

            agregaEnviosFormaOrdenada(envioAux);

            return "Envio Exitoso";

        }

        return "No hay stock";

    }

    public boolean verificaProductoEnInventario(Producto producto){

        for(Producto aux : this.productos){

            if(aux.getNombre().equals(producto.getNombre()) && aux.getStock() > 0){
                //Si existe el producto a comprar y hay stock, podremos continuar haciendo el envio
                aux.descuentaStock();
                return true;
            }

        }
        return false;

    }

    public void agregaEnviosFormaOrdenada (Envio envio) { //De forma ordenada por cliente

        if (!this.envios.isEmpty()) {

            int i = 0;

            for (Envio aux : this.envios) {

                if (aux.getCliente().getTelefono().equals(envio.getCliente().getTelefono())) {
                    //Quiero los envios agrupados por clientes, los elementos no se pisan, se mueven
                    i = this.envios.indexOf(aux);
                    this.envios.add(i, envio);
                    break;
                }

                if( this.envios.size() == (this.envios.indexOf(aux)+1) ){//Si llego al final de la lista, es un nuevo cliente
                    this.envios.add(envio);
                    break;
                }
            }

        }else{

            this.envios.add(envio);//Si la lista esta vacia, lo agrego
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
        int i = 1;

        for (Envio aux : this.envios){
            listaEnvios += i+") "+aux.toString() + "\n";
            i++;
        }

        return listaEnvios;
    }

}





