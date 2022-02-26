package HundirLaFlota.version4;

import java.util.Scanner;

public class Jugador extends Participante {
    public static Scanner teclado = new Scanner(System.in); // Creamos un atributo scanner
    /* Constructor */
    public Jugador() {
    }

    /* Métodos */
    public void indicaPosicionBarco() {
        int x; // Eje donde va las letras
        int y; // Eje donde va los numeros
        char orden; // Indicamos como queremos introducir las coordenadas en Horizontal o Vertical
        int barco = 0; // Indica cuantos barcos estamos introduciendo 
    
        System.out.println("El jugador debe introduce los barcos en la tabla");
        System.out.println(" ");
            while (barco<10) {
                if (barco < Datos.numeroPortaAviones){
                    boolean barcolocado = false;
                    do{
                        System.out.println("En que posición quieres introducir el Portaaviones");
                        orden = indicarOrden();
                        x = posicionX();
                        y = posicionY();
                        //if(comprobarTabBarcoX(x, y, orden, Datos.portTAM) == true)
                        if( colocarSeguridad(Datos.numeroPortaAviones, x, y, orden, Datos.portTAM) == true )
                        {
                            colocarBarco(port, acora, fraga, subma, x, y, orden, port);
                            comprobarTabBarcoX(x, y, orden, Datos.portTAM);
                            barcolocado = true;
                        }
                        else{
                            System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                        }     
                    } while (barcolocado == false );
                    mostrarTabla(getTablaBarco());
                    //colocarSeguridad(Datos.numeroPortaAviones, x, y, orden, port);
                }
                if (barco < Datos.numeroAcorazados){
                    boolean barcolocado = false;
                    do {
                        System.out.println("En que posición quieres introducir el Acorazado");
                        orden = indicarOrden();
                        x = posicionX();
                        y = posicionY();
                        //if(comprobarTabBarcoX(x, y, orden, Datos.acoraTAM) == true){
                        if( colocarSeguridad(Datos.numeroAcorazados, x, y, orden, Datos.acoraTAM) == true ){                        
                            colocarBarco(port, acora, fraga, subma, x, y, orden, acora);
                            comprobarTabBarcoX(x, y, orden, Datos.acoraTAM);
                            barcolocado = true;
                        }
                        else {
                            System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                        }
                    } while (barcolocado == false);
                    mostrarTabla(getTablaBarco());
                }
                if (barco< Datos.numeroFragatas) {
                    boolean barcolocado = false;
                    do {
                        System.out.println("En que posición quieres introducir el Fragatas");
                        orden = indicarOrden();
                        x = posicionX();
                        y = posicionY(); 
                        //if (comprobarTabBarcoX(x, y, orden, Datos.fragaTAM) == true){
                        if( colocarSeguridad(Datos.numeroFragatas, x, y, orden, Datos.fragaTAM) == true ){    
                            colocarBarco(port, acora, fraga, subma, x, y, orden, fraga);
                            barcolocado = true;
                        }
                        else {
                            System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                        }
                    } while (barcolocado == false);
                    mostrarTabla(getTablaBarco());
                }
                if (barco< Datos.numeroSubmarinos){
                    boolean barcolocado = false;
                    do {
                        System.out.println("En que posición quieres introducir el Submarino");
                        orden = indicarOrden();
                        x = posicionX();
                        y = posicionY();
                    // if (comprobarTabBarcoX(x, y, orden, Datos.submaTAM) == true){
                    if( colocarSeguridad(Datos.numeroSubmarinos, x, y, orden, Datos.submaTAM) == true ){    
                       colocarBarco(port, acora, fraga, subma, x, y, orden, subma);
                        barcolocado = true;
                    }
                    else {
                        System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                    }
                } while (barcolocado == false);
                mostrarTabla(getTablaBarco());
            }
            barco++;
        }
    }
    /*Nos permite indicar una posición en el eje X y comprobar si es correcta*/
    public int posicionX(){
        int x;
        char valor;
        boolean respuesta = false;
        do {
            System.out.println("Indica la letra de la fila");
            valor = teclado.next().charAt(0);
            valor = Character.toUpperCase(valor);
            x = Datos.convLetNum(valor); 
            if (x>=0 && x<Datos.DIMTABLA) {
                respuesta = true;
            }
        }while (respuesta == false);
        return x;
    }
    /*Nos permite indicar una posición en el eje Y y comprobar si es correcta*/
    public int posicionY(){
        int y;
        boolean respuesta = false;
        do {
            System.out.println("Indica el numero de la columna");
            y = teclado.nextInt();
            y--;
            if (y>=0 && y<Datos.DIMTABLA) {
                respuesta = true;
            }
        } while (respuesta == false);
        return y;
    }
    /*Indicamos en que posición queremos introducir el barco*/
    public char indicarOrden (){
        char orden;
        boolean respuesta;
        do {
            System.out.println("¿Quieres introducirlo en horizontal (H) o en vertical (V)?");
            orden = teclado.next().charAt(0);
            orden = Character.toUpperCase(orden);
            if(orden == 'H' ||orden == 'V') {
               respuesta = true; 
            }
            else {
                respuesta = false;
            }
        }while (respuesta == false);
        return orden;
    }
   
    /*Indicamos donde queremos disparar*/
    public boolean iniciarDisparos(char[][] tabDis, char[][] tabBarOrd) {
      int x;
      int y;
      boolean hayHueco;

       do {
        /*Indicamos las posiciones*/
        x = posicionX();
        y = posicionY();
        hayHueco = comprobarTabDisparo(x, y); // Comprobamos si esta vacío 

       } while (hayHueco == false);
       return indicaValorDisparos(x, y, tabBarOrd);
    }
}
