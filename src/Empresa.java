public class Empresa extends Cliente{

    private int descuento = 15;

    //----------------- Constructor -------------------
    public Empresa (String nombre, String direccion, String telefono){
        super(nombre,direccion,telefono);
    }

    //----------------- Descuento -------------------
    public int getDescuento(){
        return this.descuento;
    }
    public void setDescuento(int descuento){
        this.descuento=descuento;
    }

}
