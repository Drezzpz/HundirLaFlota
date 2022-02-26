package HundirLaFlota.version4;

public class Datos {
    /*Creamos una constante con el tamaño de nuestra tabla.Indicamos que 
    es protected para que solo accedan las personas de nuestro proyecto*/
    protected static final int DIMTABLA = 10;

    public static int contador;
	
	protected final int numeroTiposBarco = 3; // Indicamos cuantos modelos de barcos hay
	protected static final int BarcosTotales = 7; // Indicamos los barcos totales
	
	/*Indicamos cuantos barcos podemos poner de cada*/
    protected static final int numeroPortaAviones = 1; //1
    protected static final int numeroAcorazados = 2; //2
    protected static final int numeroFragatas = 3; // 3
    protected static final int numeroSubmarinos = 3; // 3
     
    /*Indicamos cuantas posiciones hay de cada uno*/
    public static final int portTAM=5;
    public static final int acoraTAM=4;
    public static final int fragaTAM=3;
    public static final int submaTAM=2; 

    /*Indica cuantos barcos hay en total*/
    public static final int numeroTotalBarcos=9;
    /*Indicamos el número de aciertos en total*/
    public static final int MAXACIERTOS=28;//28

    /*Indicamos hacía donde va a disparar*/
    public static final char DERECHA = 'D';
    public static final char IZQUIERDA = 'I';
    public static final char ARRIBA = 'A';
    public static final char ABAJO = 'B';   

    /*Si ponemos que es estático el constructor se crea directamente, de la otra forma
    tenemos que crearlo nosotros. Indicamos que es protected para que solo accedan las 
    personas de nuestro proyecto*/
    public static int convLetNum (int x){
        /*Indicamos que el caracter introducido sea restado por A y que lo convierta
        en un numero y lo devuelva*/
        return (x - 'A'); 
    }   
     /*Convertir un número a una letra*/
     public void convertNumEnLetra(char letra) {
        int numero = 'A';
        System.out.println(numero);
       
    }
}
