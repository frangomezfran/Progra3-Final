public class Main {
    public static void main(String[] args) {


        //  Inciso 2

        //--------------------- Clientes -----------------------
        Cliente fran =  new Cliente("Franco Gomez","Casa de Fran","2236010566");
        Cliente omarPintureria = new Empresa("Omar Pintureria","Avellaneda 123","2235432193");

        //--------------------- Productos ----------------------
        Producto masilla = new Producto(3,"Masilla Anclaflex" , 300);
        Producto pintura = new Producto(12,"Pintura Alba Negra",500);
        Producto rodillo = new Producto(200,"Rodillo PaintZoom",123);

        //--------------------- Creo un Local -------------------
        Local pepePintureria = new Local();

        //------------ Agrego los productos al Local ------------
        pepePintureria.nuevoProducto(masilla);
        pepePintureria.nuevoProducto(pintura);
        pepePintureria.nuevoProducto(rodillo);


        //  Inciso 3 e Inciso 4

        //----------- Agrego los envios al Local --------------
        System.out.println( pepePintureria.nuevaVenta( omarPintureria,20,masilla ) );
        System.out.println( pepePintureria.nuevaVenta( fran,20,masilla ) );
        System.out.println( pepePintureria.nuevaVenta( fran, 20, masilla ) );
        System.out.println( pepePintureria.nuevaVenta( omarPintureria,20,masilla ) );
        System.out.println( pepePintureria.nuevaVenta( fran,20,masilla) );
        System.out.println( pepePintureria.nuevaVenta( fran,20,rodillo ) );


        //-------- Muestro el promedio de ventas totales --------
        System.out.println("\nPromedio de ventas totales = "+pepePintureria.getPromedioVentas());

        //  Inciso 5

        System.out.println("\nCliente con mas compras: \n\t"+(pepePintureria.getClienteConMasCompras().toString()));

        // Muestro Lista de Envios
        System.out.println("Lista de Envios:\n"+pepePintureria.muestraListaEnvios());


    }
}
