package HundirLaFlota.version4;

import java.util.Random;
import java.util.Scanner;

public class Ordenador extends Participante {
    public static Scanner teclado = new Scanner(System.in); // Creamos un atributo scanner
    public Random aleatorio = new Random();


    public char ultimodisparo = Datos.ARRIBA; 
    public boolean ultimoDisparoAcertado = false;
    protected int coordenadaXI = 0; // coordendada x inicial 
    protected int coordenadaX = 0;
    protected int coordenadaYI = 0; // coordenada y inicial 
    protected int coordenadaY = 0;

    /* Constructor */
    public Ordenador() {
    }

    /* Métodos */
    public void indicaPosicionBarco() {
    int x; // Eje donde va las letras
    int y; // Eje donde va los numeros
    char orden; // Indicamos como queremos introducir las coordenadas en Horizontal o Vertical
    int barco = 0; // Indica cuantos barcos estamos introduciendo 
    
    System.out.println("El ordenador debe introduce los barcos en la tabla");
    System.out.println(" ");
        while (barco<10) {
            if (barco < Datos.numeroPortaAviones){
                boolean barcolocado = false;
                do{
                    //System.out.println("En que posición quieres introducir el Portaaviones");
                    orden = indicarOrden();
                    x = posicionX();
                    y = posicionY();
                    //eneif(comprobarTabBarcoX(x, y, orden, Datos.portTAM) == true){
                    if(colocarSeguridad(Datos.numeroPortaAviones, x, y, orden, Datos.portTAM)== true ){
                        colocarBarco(port, acora, fraga, subma, x, y, orden, port);
                        comprobarTabBarcoX(x, y, orden, Datos.portTAM);
                        barcolocado = true;
                    }
                    /*else{
                        System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                    } */    
                } while (barcolocado == false );
                //mostrarTabla(getTablaBarco());
                //colocarSeguridad(Datos.numeroPortaAviones, x, y, orden, port);
            }
            if (barco < Datos.numeroAcorazados){
                boolean barcolocado = false;
                do {
                   // System.out.println("En que posición quieres introducir el Acorazado");
                    orden = indicarOrden();
                    x = posicionX();
                    y = posicionY();
                    //if(comprobarTabBarcoX(x, y, orden, Datos.acoraTAM) == true){
                    if(colocarSeguridad(Datos.numeroAcorazados, x, y, orden, Datos.acoraTAM) == true ){                        
                        colocarBarco(port, acora, fraga, subma, x, y, orden, acora);
                        comprobarTabBarcoX(x, y, orden, Datos.acoraTAM);
                        barcolocado = true;
                    }
                    /*else {
                        System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                    }*/
                    } while (barcolocado == false);
                    //mostrarTabla(getTablaBarco());
                }
            if (barco< Datos.numeroFragatas) {
                boolean barcolocado = false;
                do {
                    //System.out.println("En que posición quieres introducir el Fragatas");
                    orden = indicarOrden();
                    x = posicionX();
                    y = posicionY(); 
                    //if (comprobarTabBarcoX(x, y, orden, Datos.fragaTAM) == true){
                    if( colocarSeguridad(Datos.numeroFragatas, x, y, orden, Datos.fragaTAM) == true ){    
                        colocarBarco(port, acora, fraga, subma, x, y, orden, fraga);
                        barcolocado = true;
                    }
                   /* else {
                        System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                    }*/
                } while (barcolocado == false);
                    //mostrarTabla(getTablaBarco());
            }
            if (barco< Datos.numeroSubmarinos){
                boolean barcolocado = false;
                do {
                    //System.out.println("En que posición quieres introducir el Submarino");
                    orden = indicarOrden();
                    x = posicionX();
                    y = posicionY();
                    // if (comprobarTabBarcoX(x, y, orden, Datos.submaTAM) == true){
                    if( colocarSeguridad(Datos.numeroSubmarinos, x, y, orden, Datos.submaTAM) == true ){    
                        colocarBarco(port, acora, fraga, subma, x, y, orden, subma);
                        barcolocado = true;
                    }
                    /*else {
                        System.out.println("El barco no se puede colocar en esa coordenada, reintentelo");
                    }*/
                } while (barcolocado == false);
               // mostrarTabla(getTablaBarco());
            }
            barco++;
        }
    }
    /*Nos permite indicar una posición en el eje X y comprobar si es correcta*/
    public int posicionX(){
        int x;
        boolean respuesta;
        do {
            x = aleatorio.nextInt(Datos.DIMTABLA); /*Indicamos que sale de forma aleatoria un número 
                                                    entre 0 y el tamaño de la tabla*/
            if (x>=0 && x<Datos.DIMTABLA) {
                respuesta = true;
            }
            else {
                respuesta = false;
            }
        }while (respuesta == false);
        return x;
    }
    /*Nos permite indicar una posición en el eje Y y comprobar si es correcta*/
    public int posicionY(){
        int y;
        boolean respuesta;
        do {
            y = aleatorio.nextInt(Datos.DIMTABLA); /*Indicamos que sale de forma aleatoria un número 
                                                    entre 0 y el tamaño de la tabla*/
            if (y>=0 &&y<Datos.DIMTABLA) {
                respuesta = true;
            }
            else {
                respuesta = false;
            }
        } while (respuesta == false);
        return y;
    }
    /*Indicamos en que posición va a introducir el barco*/
    public char indicarOrden (){
        //Horizontal -> 0
        //Vertical -> 1
        boolean orden;
        char respuesta;
            orden = aleatorio.nextBoolean(); //Indicamos que sale de forma aleatoria verdadero o falso
            if(orden == false) {
               respuesta = 'H'; 
            }
            else {
                respuesta = 'V';
            }
        return respuesta;
    }
    /*Disparo aleatorio*/
    public boolean dispararAleatorio (char [][] tablabaju) {        
        boolean hayDisparo = false;
        boolean opcionOrd = false;

        do {
            coordenadaXI = posicionX();
            coordenadaYI= posicionY();
            hayDisparo = comprobarTabDisparo(coordenadaXI, coordenadaYI);
            
        } while (hayDisparo == false);

        indicaValorDisparos(coordenadaXI, coordenadaYI,tablabaju);
        /*Indicamos que sino es barco, tenemos que ejecutar otra vez el metodo de generar posición aleatoria*/
        if (tablabaju[coordenadaXI][coordenadaYI] == BARCO) {
            /*Almacenamos las coordenadas que hemos creado*/
            coordenadaX = coordenadaXI;
            coordenadaY = coordenadaYI;
            opcionOrd = true;  
        }
        return opcionOrd;
    }
    /*Indicamos donde va a disparar*/
    public boolean indicarDisparos(char[][] tabDis, char [][] tabBarJug, int x, int y) {
        this.ultimoDisparoAcertado = false;
        int disparo = 0;
        boolean posicionOrd = false;

        while (disparo == 0){
           
                switch(this.ultimodisparo){
                    case Datos.ARRIBA: {
                        if (x-1>=0) {
                            if (tabDis[x -1][y] == VACIO) {
                                disparo++;
                                indicaValorDisparos(x - 1, y, tabBarJug);
                                if (tabDis[x - 1][y] == BARCO) {
                                    coordenadaX = x - 1;
                                    this.ultimodisparo= Datos.ARRIBA;
                                    posicionOrd = true;
                                }
                                else {
                                    if (coordenadaX  == coordenadaXI) {
                                        this.ultimodisparo = Datos.DERECHA;
                                        posicionOrd = true;
                                    }
                                    else {
                                        this.ultimodisparo = Datos.ABAJO;
                                        coordenadaX = coordenadaXI;
                                        posicionOrd = true;
                                    }
                                }
                            }
                        }
                        else {
                            if (coordenadaX  == coordenadaXI) {
                                this.ultimodisparo = Datos.DERECHA;
                            }
                            else {
                                this.ultimodisparo = Datos.ABAJO;
                                coordenadaX = coordenadaXI;
                                x = coordenadaX;
                            }
                        }
                    }
                     break;
                    case Datos.DERECHA: {
                        if (y+1<Datos.DIMTABLA) {
                            if (tabDis[x][y+1] == VACIO) {
                                disparo++;
                                indicaValorDisparos(x, y + 1, tabBarJug);
                                if (tabDis[x][y + 1] == BARCO) {
                                    coordenadaY = y + 1;
                                    this.ultimodisparo= Datos.DERECHA;
                                    posicionOrd = true;
                                }
                                else {
                                    if (coordenadaY  == coordenadaYI) {
                                        this.ultimodisparo = Datos.ABAJO;
                                        posicionOrd = true;
                                    }
                                    else {
                                        this.ultimodisparo = Datos.IZQUIERDA;
                                        coordenadaY = coordenadaYI;
                                        posicionOrd = true;
                                    }
                                }
                            }
                        }
                        else {
                            if (coordenadaY  == coordenadaYI) {
                                this.ultimodisparo = Datos.ABAJO;
                            }
                            else {
                                this.ultimodisparo = Datos.IZQUIERDA;
                                coordenadaY = coordenadaYI;
                                y = coordenadaY;
                            }
                        }
                    }
                    break;
                    case Datos.ABAJO: {
                        if (x+1<Datos.DIMTABLA) {
                            if (tabDis[x + 1][y] == VACIO) {
                                disparo++;
                                indicaValorDisparos(x + 1, y, tabBarJug);
                                if (tabDis[x + 1][y] == BARCO) {
                                    coordenadaX = x + 1;
                                    this.ultimodisparo= Datos.ABAJO;
                                    posicionOrd = true;
                                }
                                else {
                                    if (coordenadaX == coordenadaXI) {
                                        this.ultimodisparo = Datos.IZQUIERDA;
                                        coordenadaX = coordenadaXI;
                                        posicionOrd = true;
                                    }
                                }
                            }
                        }
                        else {
                            if (coordenadaX == coordenadaXI) {
                                this.ultimodisparo = Datos.IZQUIERDA;
                                coordenadaX = coordenadaXI;
                                x = coordenadaX;
                            }
                        }
                    }
                    break;
                    case Datos.IZQUIERDA: {
                        if (y-1>=0) {
                            if (tabDis[x][y - 1] == VACIO) {
                                disparo++;
                                indicaValorDisparos(x, y - 1, tabBarJug);
                                if (tabDis[x][y - 1] == BARCO) {
                                    coordenadaY = y - 1;
                                    this.ultimodisparo= Datos.IZQUIERDA;
                                    posicionOrd = true;
                                }
                                else {
                                    if (coordenadaY == coordenadaYI) {
                                        this.ultimodisparo = Datos.ARRIBA;
                                        posicionOrd = false;
                                    }
                                }
                            }
                        }
                        else {
                            if (coordenadaY == coordenadaYI) {
                                this.ultimodisparo = Datos.DERECHA;
                            }
                        }
                    }
                    break;
                    default:
                        disparo ++;
                        posicionOrd = false;
                        dispararAleatorio(tabDis);
                        this.ultimodisparo = Datos.ARRIBA;
                    break;
                }
            }
        return posicionOrd;
    }
}
