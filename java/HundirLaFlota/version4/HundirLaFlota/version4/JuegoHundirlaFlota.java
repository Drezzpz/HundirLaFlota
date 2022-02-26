package HundirLaFlota.version4;
public class JuegoHundirlaFlota {
    public static void main(String[] args) {
        
        /*Indicamos el valor que hacer referencia a cada uno*/
        final  int numJugadores = 2;

        /*Crear objetos*/
        Jugador jug = new Jugador();
        Ordenador ord = new Ordenador();
        
        /*Colocar los barcos y mostrar la tabla de Jugador*/
        jug.indicaPosicionBarco();
        System.out.println("La colocación de los barcos de Jugador");
        System.out.println(" ");
        jug.mostrarTabla(jug.getTablaBarco());
    
        /*Colocar los barcos y mostrar la tabla de Ordenador*/
        ord.indicaPosicionBarco();
        System.out.println("La colocación de los barcos de Ordenador");
        System.out.println(" ");
        ord.mostrarTabla(ord.getTablaBarco());

        /*Disparos en la tabla barcos*/
            boolean acierto;
            int turno = 2;
            int contadorJug=0;
            int contadorOrd=0;
            boolean ganaJug = false; //Se representa con el 0
            boolean ganaOrd = false; //Se representa con el 1
            boolean opcionOrd = false;

            while(ganaJug == false && ganaOrd == false){
                turno = turno%numJugadores;
                switch (turno) {
                    case 0:
                            System.out.println("Indica donde quieres disparar Jugador");
                            acierto = jug.iniciarDisparos(jug.getTablaDisparos(), ord.getTablaBarco());
                            System.out.println("La tabla de disparos del Jugador");
                            jug.mostrarTabla(jug.getTablaDisparos());
                            if(acierto==true) {
                                contadorJug++;
                                if (contadorJug == Datos.MAXACIERTOS) {
                                    System. out.println("Enhorabuena, has ganado Jugador");
                                    ganaJug = true;
                                }
                            }
                            break;
                    case 1:
                            acierto = false;
                            System.out.println("Indica donde quieres disparar Ordenador");
                            if(opcionOrd == false) {
                                opcionOrd = ord.dispararAleatorio(jug.getTablaBarco());
                                acierto = opcionOrd;
                            }
                            else {
                                if(ord.coordenadaX == ord.coordenadaXI && ord.coordenadaY == ord.coordenadaYI) {
                                    acierto = ord.indicarDisparos(ord.getTablaDisparos(), jug.getTablaBarco(), ord.coordenadaXI, ord.coordenadaYI);
                                }
                                else {
                                    acierto = ord.indicarDisparos(ord.getTablaDisparos(), jug.getTablaBarco(), ord.coordenadaX, ord.coordenadaY);
                                }
                            }
                            System.out.println("La tabla de disparos del Ordenador");
                            ord.mostrarTabla(ord.getTablaDisparos());
                            if(acierto==true) {
                                contadorOrd++;
                                if (contadorOrd == Datos.MAXACIERTOS) {
                                    System. out.println("Enhorabuena, has ganado Ordenador");
                                    ganaOrd = true;
                                }
                            }
                            break;
                           
               }
                turno ++;
            }
    }
}
