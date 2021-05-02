public class Main {
    public static void main(String[] args) {


        //  Inciso 2

        //--------------------- Clientes -----------------------
        Cliente fran =  new Cliente("Franco Gomez","Casa de Fran","2236010566");
        Cliente omarPintureria = new Empresa("Omar Pintureria","Avellaneda 123","2235432193");

        //--------------------- Productos ----------------------
        Producto masilla = new Producto(10,"Masilla Anclaflex" , 300);
        Producto pintura = new Producto(12,"Pintura Alba Negra",500);
        Producto rodillo = new Producto(200,"Rodillo PaintZoom",123);

        //--------------------- Creo un Local -------------------
        Local pepePintureria = new Local();

        //------------ Agrego los productos al Local ------------
        pepePintureria.agregaProductos(masilla);
        pepePintureria.agregaProductos(pintura);
        pepePintureria.agregaProductos(rodillo);


        //  Inciso 3

        Envio envioFran1 = new Envio(fran,20,rodillo);


        //  Inciso 4

        //---------------------- Envios ------------------------
        Envio envioFran2 = new Envio(fran,20,masilla);
        Envio envioPintureriaOmar = new Envio(omarPintureria,20,masilla);
        Envio envioFran3 = new Envio(fran,20,rodillo);
        Envio envioPintureriaOmar2 = new Envio(omarPintureria,20,pintura);
        Envio envioFran4 = new Envio(fran,20,pintura);

        //----------- Agrego los envios al Local --------------
        pepePintureria.agregaEnvios(envioPintureriaOmar);
        pepePintureria.agregaEnvios(envioFran1);
        pepePintureria.agregaEnvios(envioFran2);
        pepePintureria.agregaEnvios(envioPintureriaOmar2);
        pepePintureria.agregaEnvios(envioFran3);
        pepePintureria.agregaEnvios(envioFran4);

        //-------- Muestro el promedio de ventas totales --------
        System.out.println("\nPromedio de ventas totales = "+pepePintureria.getPromedioVentas());

        //  Inciso 5

        System.out.println("Cliente con mas compras: \n"+(pepePintureria.getClienteConMasCompras().toString()));



    }
}
