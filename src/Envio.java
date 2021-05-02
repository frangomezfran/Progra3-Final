public class Envio {

    private Cliente cliente ;
    private double cantKms;
    private double precioPorKm = 20 ;
    private Producto producto;

    //----------------- Constructor -------------------
    public Envio(Cliente cliente, double cantKms, Producto producto) {
        this.cliente = cliente;
        this.cantKms = cantKms;
        this.producto = producto;
    }

    //----------------- Cliente -------------------
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //----------------- CantKms -------------------
    public double getCantKms() {
        return cantKms;
    }
    public void setCantKms(double cantKms) {
        this.cantKms = cantKms;
    }

    //----------------- Precio por Km -------------------
    public double getPrecioPorKm() {
        return precioPorKm;
    }
    public void setPrecioPorKm(double precioPorKm){
        this.precioPorKm = precioPorKm;
    }

    //----------------- Producto -------------------
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    //----------------- Metodos -------------------
    public double getCostoTotal(){

        double costoTotal = 0;

        costoTotal = this.producto.getPrecio() + (this.cantKms * this.precioPorKm);

        if (this.cliente instanceof Empresa){

            costoTotal = costoTotal - ( ( ((Empresa) this.cliente).getDescuento() * costoTotal ) / 100 );

        }

        return costoTotal;

    }

    @Override
    public String toString() {
        return "Envio [  CantKms = " + this.cantKms +
                " | PrecioPorKm = " + this.precioPorKm +
                "$ | CostoTotal = "+ this.getCostoTotal()+"$ ]\n"
                +this.cliente.toString()+"\n"+this.producto.toString();
    }
}
