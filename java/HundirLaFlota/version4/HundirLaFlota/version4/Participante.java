package HundirLaFlota.version4;
public class Participante {
    // El agua se representa con el caracter 'X' 
    // El barco se representa con el caracter 'O'
    // El epacio en blano se representa con ' '
    private char tabDisparos[][]; // Tablero que marca mis disparos 
    private char tabBarcos[][]; // Tengo colocados mis barco
    public final char BARCO = 'O';
    public final char AGUA = 'X';
    public final char VACIO = ' ';
    public static int port=0, acora=0, fraga=0, subma=0; //Indicamos cuantos barcos tengo de cada tipo

    /*Crear un constructor*/
    public Participante() { 
        tabBarcos = new char[Datos.DIMTABLA][Datos.DIMTABLA];
        tabDisparos = new char[Datos.DIMTABLA][Datos.DIMTABLA];
        /*Incializar la tabla para que cuando vemos 
        un espacio en blanco sepamos que hay no hemos disparado*/
        for (int i=0; i<Datos.DIMTABLA; i++){
            for (int j=0; j<Datos.DIMTABLA; j++) {
                tabBarcos[i][j] = VACIO;
            }
        }
        for (int i=0; i<Datos.DIMTABLA; i++){
            for (int j=0; j<Datos.DIMTABLA; j++) {
                tabDisparos[i][j] = VACIO;
            }
        } 
    }
   
    /** GET -> Devuelve el valor de un componte deperminado */
    public char[][] getTablaBarco(){
        return tabBarcos;
    } 
    public char[][] getTablaDisparos(){
        return tabDisparos;
    }

    /*Crear métodos*/

    /*Nos permite mostrar como va nuestra tabla según introduzcamos los barcos y realicemos los disparos*/
    public void mostrarTabla(char[][] tabla) {
        int letra=65; //Hace referencia a la letra A
        System.out.print("  "); //Indicamos que nos deje espacio entre las letras y los números
        for (int i = 0; i < Datos.DIMTABLA; i++) {
            System.out.print(i+1+" ");
        }
        System.out.println("");
        for (int i = 0; i < Datos.DIMTABLA; i++) {//Indicamos que empiece en 0 hasta el tamaño de la tabla y le sumamos uno
            System.out.print((char)letra+" ");//Convertimos ese número en una letra
            letra++;//Sumamos uno a las letras
            for (int j = 0; j < Datos.DIMTABLA; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println("   ");//Indicamos que imprima tres espacios en blanco
        }
    }
    /*Comprobamos cuantos barcos nos queda de cada*/
	public void colocarBarco(int port, int acora, int fraga, int subma, int x, int y, char orden, int tamBarco){
        int TipoDeBarco = 0; //Indicamos que empieza por 0 cada tipo de barco

            if (this.port < Datos.numeroPortaAviones){//Comprobamos si cada uno de los barcos que hemos definido es menor al numero total de los barcos
                comprobarTabBarcoX(x, y, orden, tamBarco); //Invocamos al método para saber si está libre la casilla
                this.port++; //Indicamos que se le sume uno a cada uno de los tipos de los barcos
            }
            if (this.acora < Datos.numeroPortaAviones){
                comprobarTabBarcoX(x, y, orden, tamBarco);
                this.acora++;
            }   
            if (this.fraga < Datos.numeroFragatas){
                comprobarTabBarcoX(x, y, orden, tamBarco);
                this.fraga++;
            }
            if (this.subma < Datos.numeroSubmarinos){
                comprobarTabBarcoX(x, y, orden, tamBarco);
                this.subma++;
            }
    }

    /*Comprobamos si a tocado agua o barco a la hora de disparar, dependiendo de lo que haya dado 
    se introduce en la tabla*/
    public boolean indicaValorDisparos(int x, int y,char [][]tabBar) {
        if (tabBar[x][y]== BARCO) {//Comprabamos si en nuestra tabla hay un barco
            System.out.println("Tocado");//Has tocado barco
            tabDisparos[x][y] = BARCO; //Si hay un barco, indicamos que guarde en la tabla el valor que lo representa
            return true;
        }
        else {
            System.out.println("Agua");//Has tocado agua
            tabDisparos[x][y] = AGUA; // Si no hay un barco, indicamos que nos guarde en la tabla el valor con el que lo representamos
            return false;
        }
    }
    /*Comprobar si el hueco esta vacío*/
    public boolean comprobarTabDisparo (int x, int y){
        boolean hayHueco = false;
        if (tabDisparos[x][y] == VACIO){
            hayHueco = true;
        }
        return hayHueco;
    }
    /*Indicamos cuantos acierto lleva*/
    public boolean aciertaBarcos() {
        boolean acierta = false;
        for(int i = 0;i<Datos.DIMTABLA;i++){
            for(int j = 0;j<Datos.DIMTABLA;j++) {
                //Recorremos la tabla de disparos
                if (tabDisparos[i][j] == BARCO) {
                    return true;
                }
            }
        }
        return acierta;
    }
    /*Comprobamos si en la posición que quiere poner el barco se puede poner*/
    public boolean comprobarTabBarcoX(int x, int y, int orden, int tamBarco) {
        boolean hayHueco = true;
		int contador = 0;

        if (orden == 'H') {
            // Comprobamos el tamaño del barco con el tamaño de la tabla desde la posición indicada
            if (y +tamBarco<=Datos.DIMTABLA) {
				for( int i = y; i<y+tamBarco; i++){
					if (tabBarcos[x][i] == VACIO){ //Comprobamos si la casilla indicada esta vacía
                        contador++; //Si esta vacía introducimos un barco y le sumamos 1 para saber que está ocupada
                    }
				}
                if (contador==tamBarco) { //Comparamos si el número del contador es igual que el tamaño del barco
                    for( int i = y; i<y+tamBarco; i++){
                       tabBarcos[x][i] = BARCO; //Si es igual, insertamos el barco en la posición indicada
                    }
                }	
                else {
                    hayHueco = false;
                }
            }
        }
        else if (orden == 'V') { 
            if (x +tamBarco<=Datos.DIMTABLA){
                for( int j = x; j<x+tamBarco; j++){
					if (tabBarcos[j][y] == VACIO){
						contador++;
					}
				}
                if (contador==tamBarco) {
                    for( int j = x; j<x+tamBarco; j++){
                       tabBarcos[j][y] = BARCO;
                    }
                }	
                else {
                    hayHueco = false;
                }
            }
        }
		return hayHueco;
    }
    public boolean colocarSeguridad( int numerodeBarco, int fila, int columna, char direccionHV, int tiposBarco){
        int longitudBarco = tiposBarco;
        boolean barcoColocado = true;

        int filaInicial, filaFinal, columnaInicial, columnaFinal;
        int filaBordeTablero = 0;
        int columnaBordeTablero = 0;
        // Verificamos si el barco se puede colocar en esa posición, mirando alrededor que todo esté disponible

        if( direccionHV == 'V'){
            filaBordeTablero = fila + longitudBarco ;
            columnaBordeTablero = columna;
        }
        else if (direccionHV == 'H'){
            filaBordeTablero = fila  ;
            columnaBordeTablero = columna + longitudBarco;
        }

        if( filaBordeTablero > Datos.DIMTABLA || columnaBordeTablero > Datos.DIMTABLA){
            return false;
        }

        filaInicial = fila - 1;
        columnaInicial = columna - 1 ;
        
        if( direccionHV == 'H'){
            filaFinal = fila + 1;
            columnaFinal = columna + longitudBarco + 1;

        }
        else{
            filaFinal = fila + longitudBarco + 1;
            columnaFinal = columna + 1;
        }

        /*Indicamos que debe de cumplir lo que está entre parentesis, en caso de que lo cumpla devuelve 0,
        sino devuelve el valor que tiene la filaInicial y la columnaInicial*/
        filaInicial = ( filaInicial < 0 ) ? 0 : filaInicial;
        columnaInicial = ( columnaInicial < 0 ) ? 0 : columnaInicial;
        /*Comprbamos si nos salimos de la tabla a la hora de poner la zona de seguridad, indicamos que le reste uno al tamaño total 
        sino le decimos que nos muestre la información de la filaInicial y de la columnaInicial*/
        filaFinal = ( filaFinal >= Datos.DIMTABLA ) ? ( Datos.DIMTABLA - 1 ) : filaFinal;
        columnaFinal = ( columnaFinal >= Datos.DIMTABLA) ? ( Datos.DIMTABLA - 1 ): columnaFinal;

        for ( int i = filaInicial; i<= filaFinal;i++){
            for ( int j = columnaInicial; j <= columnaFinal; j++){
                if( tabBarcos[i][j] !=' '){
                    barcoColocado = false;
                    //break;
                }
            }
        }

        if( barcoColocado == true ){
            if ( direccionHV == 'V' ) /* A2 B2 C2 D2 ....*/ {
                /*Se le asigna el valor que contiene fila y columna a los nombres o valores indicados*/
                filaInicial = fila;
                columnaInicial = columna;
                filaFinal = fila + longitudBarco - 1; // Indicamos que se le suma una fila y se le resta 1 a la longitud del barco indicado
                columnaFinal = columna;
            }
            else{
                filaInicial = fila;
                columnaInicial = columna;
                filaFinal = fila;
                columnaFinal = columna + longitudBarco - 1; // Inidcamos que se le suma una columna y se le resta 1 a la longitud del barco indicadp
            }

            for( int i = filaInicial; i<= filaFinal;i++){
                for ( int j= columnaInicial; j <= columnaFinal; j++){
                    tabBarcos[i][j] = BARCO;
                }
            }  
        }
        return barcoColocado;
    }
}
