import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int carta0[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int carta1[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int carta2[] = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    static int carta3[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    static int carta4[] = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
    static int carta5[] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
    static int carta6[] = {6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
    static int carta7[] = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    static int carta8[] = {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
    static int carta9[] = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    static int bloqueo[] = {10, 10, 10, 10};
    static int reversa[] = {11, 11, 11, 11};

    public static void main(String[] args) {
        /*====== Sección pruebas inicio ====== */
        System.out.println("=========================INICIO PRUEBAS=========================");
        System.out.println("===========================FIN PRUEBAS==========================");
        /*====== Scanner Global ====== */
        Scanner lector = new Scanner(System.in);
        /*====== Arreglos de cartas     0=Baraja 1=jugador====== */

        int jugador1[] = new int[7];
        int jugador2[] = new int[7];
        int jugador3[] = new int[7];
        int jugador4[] = new int[7];
        int bot1[] = new int[7];
        int bot2[] = new int[7];
        int bot3[] = new int[7];
        /*====== Sumando la cantidad de cartas por toda la baraja ====== */
        int nCartas = carta0.length + carta1.length + carta2.length + carta3.length + carta4.length + carta5.length + carta6.length + carta7.length + carta8.length + carta9.length + bloqueo.length + reversa.length;
        System.out.println("El numero de cartas por toda la baraja son: " + nCartas);
        /*====== Estado del juego ====== */
        boolean VFJuego = false;
        /*====== Variables menú ====== */
        int opcionJuego = 0;
        boolean VFmodoJuego = false;
        /*====== Menú ====== */
        System.out.println("==============================================================");
        System.out.println("=                   BIENVENIDO A  UNO UPT                    =");
        System.out.println("==============================================================");
        System.out.println("= Elige tu modo de juego                                     =");
        System.out.println("= 1........ Singleplayer                                     =");
        System.out.println("= 2......... Multiplayer                                     =");
        System.out.println("==============================================================");
        System.out.print("= OPCION:");
        opcionJuego = lector.nextInt();
        /*====== Verificando que el valor ingresado sea válido ====== */
        while (!VFmodoJuego) {
            if (opcionJuego > 2 || opcionJuego < 1) {
                System.out.print("Valor incorrecto, intenta de nuevo:");
                opcionJuego = lector.nextInt();
            } else {
                VFmodoJuego = true;
            }
        }
        /*====== Acción por opción ====== */
        if (opcionJuego == 1) {
            /*====== Numero de jugadores ====== */
            int nJugadores = 0;
            boolean VFnJugadores = false;
            System.out.println("==============================================================");
            System.out.println("      Selecciona con cuantos jugadores más quieres jugar      ");
            System.out.println("1 ........................1 Jugador  ");
            System.out.println("2 ........................2 Jugadores  ");
            System.out.println("3 ........................3 Jugadores  ");
            System.out.println("==============================================================");
            System.out.print("Opción: ");
            nJugadores = lector.nextInt();
            /*====== Verificando que la opción sea válida ====== */
            while (!VFnJugadores) {
                if (nJugadores > 3 || nJugadores < 1) {
                    System.out.print("Opción no válida, intenta de nuevo: ");
                    nJugadores = lector.nextInt();
                } else {
                    VFnJugadores = true;
                }
            }
            /*====== Alterando el numero de jugadores para que coincida con la selección del usuario ====== */
            int jugadoresTotales = 0;
            if (nJugadores == 1) {
                jugadoresTotales = 2;
            } else if (nJugadores == 2) {
                jugadoresTotales = 3;
            } else if (nJugadores == 3) {
                jugadoresTotales = 4;
            }

            boolean VFstate = false;
            if (jugadoresTotales == 2) {
                System.out.println("Jugando con un werco");
                Repartidor(jugador1);
                Repartidor(jugador2);

                while (!VFstate) {
                    TurnoJugador(jugador1,1,lector);


//                    VFstate = true;
                }


            } else if (jugadoresTotales == 3) {

                System.out.println("Jugando con tres wercos");

            } else if (jugadoresTotales == 4) {
                System.out.println("Jugando con cuatro wercos");
            }


        } else if (opcionJuego == 2) {
        }
    }

    /*====== FUNCIONES ====== */

    /*====== Número random que incluye el numero 0 ====== */
    public static int nRandom(int max) {
        int n = max + 1;
        return (int) (Math.random() * n);
    }

    /*====== Tarjeta ====== */
    public static void tarjeta(String numero) {
        System.out.print("\uD83C\uDCCF" + numero + " "); // Mostrando cartas con el valor del índice de arreglo recibido junto a un emoji

        /*
        System.out.println("===========");
        System.out.println("=         =");
        System.out.println("=    " + numero + "    =");
        System.out.println("=         =");
        System.out.println("===========");
        */
    }

    /*====== Repartidor de 7 cartas ====== */
    public static void Repartidor(int[] jugador) {
        //Repartiendo las cartas conforme al número generado por la función nRandom
        for (int i = 0; i < 7; i++) {
            int random = nRandom(11);
            if (random == 0) {
                VerificadorCarta(carta0, 0, jugador, i);
            } else if (random == 1) {
                VerificadorCarta(carta1, 1, jugador, i);
            } else if (random == 2) {
                VerificadorCarta(carta2, 2, jugador, i);
            } else if (random == 3) {
                VerificadorCarta(carta3, 3, jugador, i);
            } else if (random == 4) {
                VerificadorCarta(carta4, 4, jugador, i);
            } else if (random == 5) {
                VerificadorCarta(carta5, 5, jugador, i);
            } else if (random == 6) {
                VerificadorCarta(carta6, 6, jugador, i);
            } else if (random == 7) {
                VerificadorCarta(carta7, 7, jugador, i);
            } else if (random == 8) {
                VerificadorCarta(carta8, 8, jugador, i);
            } else if (random == 9) {
                VerificadorCarta(carta9, 9, jugador, i);
            } else if (random == 10) {
                VerificadorCarta(bloqueo, 10, jugador, i);
            } else if (random == 11) {
                VerificadorCarta(reversa, 11, jugador, i);
            }
        }
    }

    public static void VerificadorCarta(int[] carta, int Vcarta, int[] jugador, int i) {
        if (Arrays.stream(carta).anyMatch(b -> b == Vcarta)) { // Si el arreglo contiene cartas válidas
            boolean VFcarta = false;
            int x = 0;
            while (!VFcarta) {
                if (carta[x] == Vcarta) {
                    jugador[i] = carta[x];
                    if (Vcarta == 0) { // Reiniciando variable a un valor nulo para identificar que esa carta ya no es válida
                        carta[x] = 1;
                    } else {
                        carta[x] = 0;
                    }
                    VFcarta = true;
                }
                x++;
            }
        }
//        tarjeta(String.valueOf(jugador[i]));
    }

    /*====== Impresor de Arreglos ====== */
    public static void Impresor(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            tarjeta(String.valueOf(arreglo[i]));
        }
        System.out.println();
    }

    /*====== Impresor Cartas ====== */
    public static void ImpresorCartas() {
        Impresor(carta0);
        Impresor(carta1);
        Impresor(carta2);
        Impresor(carta3);
        Impresor(carta4);
        Impresor(carta5);
        Impresor(carta6);
        Impresor(carta7);
        Impresor(carta8);
        Impresor(carta9);
        Impresor(bloqueo);
        Impresor(reversa);
    }

    /*====== Eliminador de elementos de un array ====== */
    public static void removeElement(int[] arr, int index) {
        int[] arrDestination = new int[arr.length - 1];
        int remainingElements = arr.length - (index + 1);
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
        System.out.println("Elements -- " + Arrays.toString(arrDestination));
    }

    /*====== Turno jugador ====== */
    public static void TurnoJugador(int[] jugador,int nJugador,Scanner lector){
        int nCartaTirada = 0;
        Impresor(jugador);
        System.out.print("Jugador " + nJugador + ", tira tu carta: ");
        nCartaTirada = lector.nextInt();
        /*====== Verificando que el valor ingresado exista en la baraja del jugador ====== */
        boolean VFnCartaTirada = false;
        while (!VFnCartaTirada) {
            int finalNCartaTirada = nCartaTirada;
            if (!Arrays.stream(jugador).anyMatch(i -> i == finalNCartaTirada)) {
                System.out.print("La carta que ingresaste no existe, intenta de nuevo: ");
                nCartaTirada = lector.nextInt();

            } else {
                VFnCartaTirada = true;
            }
        }

        if (nCartaTirada == jugador[0]) {
            if (nCartaTirada == 0) {
                removeElement(jugador,0);
                carta0[0] = nCartaTirada;
            } else if (nCartaTirada == 1) {
                removeElement(jugador,0);
            }
        }
    }
}
