import java.util.Arrays;
import java.util.Scanner;

public class Replanteamiento {
    /*====== Cartas de baraja y jugador estáticas ====== */
    static int carta0 = 12;
    static int carta1 = 12;
    static int carta2 = 12;
    static int carta3 = 12;
    static int carta4 = 12;
    static int carta5 = 12;
    static int carta6 = 12;
    static int carta7 = 12;
    static int carta8 = 12;
    static int carta9 = 12;
    static int bloqueo = 4;
    static int reversa = 4;
    static int[] p1 = new int[7];
    static int[] p2 = new int[7];
    static int[] p3 = new int[7];
    static int[] p4 = new int[7];
    static int[] bot1 = new int[7];
    static int[] bot2 = new int[7];
    static int[] bot3 = new int[7];

    public static void main(String[] args) {
        /*====== Lector entrada de consola ====== */
        Scanner lector = new Scanner(System.in);
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
                int cartaActual = CartaInicial();
                Repartidor(p1);
                Repartidor(p2);
                while (!VFstate) {
                    int tirada = 0;
                    if (p1.length > 0) {
                        tarjeta(String.valueOf(cartaActual));
                        System.out.println();
                        boolean VFcartaComida = false;
                        while (!VFcartaComida){
                            Impresor(p1);
                            System.out.print("Quieres comer? \n1. Si \n2. No \nOpción: ");
                            int comida = lector.nextInt();
                            boolean VFcomida = false;
                            while (!VFcomida) {
                                if (comida < 1 || comida > 2) {
                                    System.out.print("El valor ingresado no existe, intenta de nuevo: ");
                                    comida = lector.nextInt();
                                } else {
                                    tarjeta(String.valueOf(cartaActual));
                                    System.out.println();
                                    VFcomida = true;
                                }
                            }
                            if (comida == 1) {
                                Impresor(p1);
                                int numeroRandom = nRandom(11);
                                p1 = addElement(p1, numeroRandom);
                                if (numeroRandom == 0) {
                                    carta0 -= 1;
                                } else if (numeroRandom == 1) {
                                    carta1 -= 1;
                                } else if (numeroRandom == 2) {
                                    carta2 -= 2;
                                } else if (numeroRandom == 3) {
                                    carta3 -= 3;
                                } else if (numeroRandom == 4) {
                                    carta4 -= 4;
                                } else if (numeroRandom == 5) {
                                    carta5 -= 5;
                                } else if (numeroRandom == 6) {
                                    carta6 -= 6;
                                } else if (numeroRandom == 7) {
                                    carta7 -= 7;
                                } else if (numeroRandom == 8) {
                                    carta8 -= 8;
                                } else if (numeroRandom == 9) {
                                    carta9 -= 9;
                                } else if (numeroRandom == 10) {
                                    bloqueo -= 10;
                                } else if (numeroRandom == 11) {
                                    reversa -= 11;
                                }
                            } else if (comida == 2) {
                                VFcartaComida = true;
                            }
                        }
                        tirada = validacionCartaTurnoJugador(p1, 1, cartaActual);
                        turnoJugador1(tirada);
                        cartaActual = tirada;
                    } else {
                        Ganador(1);
                        VFstate = true;
                    }
                    if (p2.length > 0) {
                        tarjeta(String.valueOf(cartaActual));
                        System.out.println();
                        boolean VFcartaComida = false;
                        while (!VFcartaComida){
                            Impresor(p2);
                            System.out.print("Quieres comer? \n1. Si \n2. No \nOpción: ");
                            int comida = lector.nextInt();
                            boolean VFcomida = false;
                            while (!VFcomida) {
                                if (comida < 1 || comida > 2) {
                                    System.out.print("El valor ingresado no existe, intenta de nuevo: ");
                                    comida = lector.nextInt();
                                } else {
                                    tarjeta(String.valueOf(cartaActual));
                                    System.out.println();
                                    VFcomida = true;
                                }
                            }
                            if (comida == 1) {
                                Impresor(p2);
                                int numeroRandom = nRandom(11);
                                p2 = addElement(p2, numeroRandom);
                                if (numeroRandom == 0) {
                                    carta0 -= 1;
                                } else if (numeroRandom == 1) {
                                    carta1 -= 1;
                                } else if (numeroRandom == 2) {
                                    carta2 -= 2;
                                } else if (numeroRandom == 3) {
                                    carta3 -= 3;
                                } else if (numeroRandom == 4) {
                                    carta4 -= 4;
                                } else if (numeroRandom == 5) {
                                    carta5 -= 5;
                                } else if (numeroRandom == 6) {
                                    carta6 -= 6;
                                } else if (numeroRandom == 7) {
                                    carta7 -= 7;
                                } else if (numeroRandom == 8) {
                                    carta8 -= 8;
                                } else if (numeroRandom == 9) {
                                    carta9 -= 9;
                                } else if (numeroRandom == 10) {
                                    bloqueo -= 10;
                                } else if (numeroRandom == 11) {
                                    reversa -= 11;
                                }
                            } else if (comida == 2) {
                                VFcartaComida = true;
                            }
                        }
                        tirada = validacionCartaTurnoJugador(p2, 2, cartaActual);
                        turnoJugador2(tirada);
                        cartaActual = tirada;
                    } else {
                        Ganador(2);
                        VFstate = true;
                    }
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

    /*====== Impresor ====== */
    public static void Impresor(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            tarjeta(String.valueOf(arreglo[i]));
        }
        System.out.println();
    }

    public static void ImpresorCartas() {
        System.out.println("Carta 0:" + carta0);
        System.out.println("Carta 1:" + carta1);
        System.out.println("Carta 2:" + carta2);
        System.out.println("Carta 3:" + carta3);
        System.out.println("Carta 4:" + carta4);
        System.out.println("Carta 5:" + carta5);
        System.out.println("Carta 6:" + carta6);
        System.out.println("Carta 7:" + carta7);
        System.out.println("Carta 8:" + carta8);
        System.out.println("Carta 9:" + carta9);
        System.out.println("Carta Bloqueo:" + bloqueo);
        System.out.println("Carta Reversa:" + reversa);
    }

    /*====== Tamaño arreglo ====== */
    public static void TamañoArreglo(int[] array) {
        System.out.println("\uD83D\uDCE6" + array.length);
    }

    /*====== Impresor Ganador ====== */
    public static void Ganador(int p) {
        System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89Felicidades, el jugador " + p + " ha ganado la partida \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
    }

    /*====== Eliminador de elementos de un array ====== */
    public static int[] removeElement(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        if (arr.length != index) {
            System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        }
        return result;
    }

    /*====== Agregador de elementos a un array ====== */
    private static int[] addElement(int[] arr, int element) {
        int[] array = new int[arr.length + 1];
        System.arraycopy(arr, 0, array, 0, arr.length);
        array[arr.length] = element;
        return array;
    }

    /*====== REPARTIDOR ====== */
    public static void Repartidor(int[] jugador) {
        for (int i = 0; i < 7; i++) {
            int random = nRandom(11);
            if (random == 0) {
                VerificadorCarta(jugador, carta0, 0, i);
                carta0 -= 1;
            } else if (random == 1) {
                VerificadorCarta(jugador, carta1, 1, i);
                carta1 -= 1;
            } else if (random == 2) {
                VerificadorCarta(jugador, carta2, 2, i);
                carta2 -= 1;
            } else if (random == 3) {
                VerificadorCarta(jugador, carta3, 3, i);
                carta3 -= 1;
            } else if (random == 4) {
                VerificadorCarta(jugador, carta4, 4, i);
                carta4 -= 1;
            } else if (random == 5) {
                VerificadorCarta(jugador, carta5, 5, i);
                carta5 -= 1;
            } else if (random == 6) {
                VerificadorCarta(jugador, carta6, 6, i);
                carta6 -= 1;
            } else if (random == 7) {
                VerificadorCarta(jugador, carta7, 7, i);
                carta7 -= 1;
            } else if (random == 8) {
                VerificadorCarta(jugador, carta8, 8, i);
                carta8 -= 1;
            } else if (random == 9) {
                VerificadorCarta(jugador, carta9, 9, i);
                carta9 -= 1;
            } else if (random == 10) {
                VerificadorCarta(jugador, bloqueo, 10, i);
                bloqueo -= 1;
            } else if (random == 11) {
                VerificadorCarta(jugador, reversa, 11, i);
                reversa -= 1;
            }
        }
    }

    /*====== Generador de carta inicial aleatoria ====== */
    public static int CartaInicial() {
        int random = nRandom(9);
        if (random == 0) {
            carta0 -= 1;
        } else if (random == 1) {
            carta1 -= 1;
        } else if (random == 2) {
            carta2 -= 1;
        } else if (random == 3) {
            carta3 -= 1;
        } else if (random == 4) {
            carta4 -= 1;
        } else if (random == 5) {
            carta5 -= 1;
        } else if (random == 6) {
            carta6 -= 1;
        } else if (random == 7) {
            carta7 -= 1;
        } else if (random == 8) {
            carta8 -= 1;
        } else if (random == 9) {
            carta9 -= 1;
        }
        return random;
    }

    /*====== Verificador carta ====== */
    public static void VerificadorCarta(int[] jugador, int carta, int vCarta, int i) {
        if (carta > 0) {
            jugador[i] = vCarta;
        } else {
            System.out.println("No hay cartas disponibles de esta denominación");
        }
    }

    /*====== Turno Jugador ====== */
    public static int validacionCartaTurnoJugador(int[] jugador, int nJugador, int cartaActual) {
        Scanner lector = new Scanner(System.in);
        Impresor(jugador);
        System.out.println("Turno del jugador " + nJugador);
        System.out.print("Elige la carta que deseas tirar: ");
        int cartaTirar = lector.nextInt();
        boolean VFcartaTirar = false;
        while (!VFcartaTirar) {
            int finalCartaTirar = cartaTirar;
            if (!Arrays.stream(jugador).anyMatch(i -> i == finalCartaTirar)) {
                System.out.print("La carta que ingresaste no existe, intenta de nuevo: ");
                cartaTirar = lector.nextInt();
            }
            if (finalCartaTirar > (cartaActual + 1) || finalCartaTirar < (cartaActual - 1)) {
                System.out.print("Solo puedes tirar una carta con una denominación por 1 numero mayor, el número igual o por un número menor al actual, intenta de nuevo: ");
                cartaTirar = lector.nextInt();
            } else {
                VFcartaTirar = true;
            }
        }
        return cartaTirar;
    }

    /*====== Comer random ====== */
    public static void ComerCarta(int[] player) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Quieres comer? \n1. Si \n2. No \nOpción: ");
        int comida = lector.nextInt();
        boolean VFcomida = false;
        while (!VFcomida) {
            if (comida < 1 || comida > 2) {
                System.out.print("El valor ingresado no existe, intenta de nuevo: ");
                comida = lector.nextInt();
            } else {
                VFcomida = true;
            }
        }
        if (comida == 1) {
            Impresor(player);
            int numeroRandom = nRandom(11);
            player = addElement(player, numeroRandom);
            if (numeroRandom == 0) {
                carta0 -= 1;
            } else if (numeroRandom == 1) {
                carta1 -= 1;
            } else if (numeroRandom == 2) {
                carta2 -= 2;
            } else if (numeroRandom == 3) {
                carta3 -= 3;
            } else if (numeroRandom == 4) {
                carta4 -= 4;
            } else if (numeroRandom == 5) {
                carta5 -= 5;
            } else if (numeroRandom == 6) {
                carta6 -= 6;
            } else if (numeroRandom == 7) {
                carta7 -= 7;
            } else if (numeroRandom == 8) {
                carta8 -= 8;
            } else if (numeroRandom == 9) {
                carta9 -= 9;
            } else if (numeroRandom == 10) {
                bloqueo -= 10;
            } else if (numeroRandom == 11) {
                reversa -= 11;
            }
        }
    }

    /*====== Removedor de tarjeta ====== */
    public static void turnoJugadori(int cartaTirar, int[] p) {
        for (int i = 0; i <= 11; i++) {
            if (cartaTirar == i) {
                boolean VFborrarCarta = false;
                int j = 0;
                while (!VFborrarCarta) {
                    if (p[j] == i) {
                        p = removeElement(p, j);
//                        Impresor(p1);
                        VFborrarCarta = true;
                    }
                    j++;
                }
                if (cartaTirar == 0) {
                    carta0 += 1;
                } else if (cartaTirar == 1) {
                    carta1 += 1;
                } else if (cartaTirar == 2) {
                    carta2 += 1;
                } else if (cartaTirar == 3) {
                    carta3 += 1;
                } else if (cartaTirar == 4) {
                    carta4 += 1;
                } else if (cartaTirar == 5) {
                    carta5 += 1;
                } else if (cartaTirar == 6) {
                    carta6 += 1;
                } else if (cartaTirar == 7) {
                    carta7 += 1;
                } else if (cartaTirar == 8) {
                    carta8 += 1;
                } else if (cartaTirar == 9) {
                    carta9 += 1;
                } else if (cartaTirar == 10) {
                    bloqueo += 1;
                } else if (cartaTirar == 11) {
                    reversa += 1;
                }
            }
        }
    }

    public static void turnoJugador1(int cartaTirar) {
        for (int i = 0; i <= 11; i++) {
            if (cartaTirar == i) {
                boolean VFborrarCarta = false;
                int j = 0;
                while (!VFborrarCarta) {
                    if (p1[j] == i) {
                        p1 = removeElement(p1, j);
//                        Impresor(p1);
                        VFborrarCarta = true;
                    }
                    j++;
                }
                if (cartaTirar == 0) {
                    carta0 += 1;
                } else if (cartaTirar == 1) {
                    carta1 += 1;
                } else if (cartaTirar == 2) {
                    carta2 += 1;
                } else if (cartaTirar == 3) {
                    carta3 += 1;
                } else if (cartaTirar == 4) {
                    carta4 += 1;
                } else if (cartaTirar == 5) {
                    carta5 += 1;
                } else if (cartaTirar == 6) {
                    carta6 += 1;
                } else if (cartaTirar == 7) {
                    carta7 += 1;
                } else if (cartaTirar == 8) {
                    carta8 += 1;
                } else if (cartaTirar == 9) {
                    carta9 += 1;
                } else if (cartaTirar == 10) {
                    bloqueo += 1;
                } else if (cartaTirar == 11) {
                    reversa += 1;
                }
            }
        }
    }

    public static void turnoJugador2(int cartaTirar) {
        for (int i = 0; i <= 11; i++) {
            if (cartaTirar == i) {
                boolean VFborrarCarta = false;
                int j = 0;
                while (!VFborrarCarta) {
                    if (p2[j] == i) {
                        p2 = removeElement(p2, j);
//                        Impresor(p1);
                        VFborrarCarta = true;
                    }
                    j++;
                }
                if (cartaTirar == 0) {
                    carta0 += 1;
                } else if (cartaTirar == 1) {
                    carta1 += 1;
                } else if (cartaTirar == 2) {
                    carta2 += 1;
                } else if (cartaTirar == 3) {
                    carta3 += 1;
                } else if (cartaTirar == 4) {
                    carta4 += 1;
                } else if (cartaTirar == 5) {
                    carta5 += 1;
                } else if (cartaTirar == 6) {
                    carta6 += 1;
                } else if (cartaTirar == 7) {
                    carta7 += 1;
                } else if (cartaTirar == 8) {
                    carta8 += 1;
                } else if (cartaTirar == 9) {
                    carta9 += 1;
                } else if (cartaTirar == 10) {
                    bloqueo += 1;
                } else if (cartaTirar == 11) {
                    reversa += 1;
                }
            }
        }
    }
}
