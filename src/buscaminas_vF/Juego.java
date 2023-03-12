/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas_vF;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Oswald
 */
public class Juego {

    private static boolean matriz[][] = new boolean[5][5];
    private static int contador; //contador para posicionar mina dentro de la matriz
    private static ArrayList<Integer> lista = new ArrayList<>(); //Agregar minas dentro de la matriz
    private static Scanner leer = new Scanner(System.in);
    public static int cantidadVidas = 5;
    public static int partidasGanadas = 0, partidasPerdidas = 0;
    public static int contadorMinas = 0;

    public Juego() {
        //inicializar juego
        inicializar();
    }//constructor

    //metodo inicializar
    public void inicializar() {
        contador = 0;
        contadorMinas = 0;
        cantidadVidas = 5;
        lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = false; //inicializa matriz con todos los campos sin minas
            }//for int j
        }//for int i
    }//void inicializar

    public void imprimir() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println("");
        }
    }//imprimir

    //seleccionar minas
    public boolean seleccionarMinas(int cantidad) {
        Random objNuevoNumero = new Random();
        boolean iniciar = false;
        boolean repetido = false;
        if (cantidad < 3 || cantidad > 10) {
            JOptionPane.showMessageDialog(null, "La cantidad de minas debe estar entre 3 y 10");
        } else {
            iniciar = true;
            for (int i = 0; i < cantidad && !repetido; i++) {

                int mina = objNuevoNumero.nextInt(25);
                while(lista.contains(mina)){ //evitar repeticion de numeros para no repetir casilla de mina
                    mina = objNuevoNumero.nextInt(25);
                }
                lista.add(mina);
                
                
                iniciar = true;
                
            }

        }
        return iniciar;
    }//seleccionarMinas

    //asginar minas en la matriz
    public void asignarMinas() {

        for (int i = 0; i < lista.size(); i++) { //recorrido por los elementos del ArrayList lista
            int posicion = lista.get(i);
            contador = 0;
            System.out.println(lista.get(i));

            for (int j = 0; j < 5; j++) { //recorrido por la matriz
                for (int k = 0; k < 5; k++) {
                    if (posicion == contador) {
                        matriz[j][k] = true; //asignando mina en matriz
                        contador++;
                    }//no repetir numeros 

                }//for k matriz
            }//for j matriz
        }
    }//asignarMinas

    //buscar mina
    public boolean buscarMina(int boton) {
        boolean existe = false;
        for (int i = 0; i < lista.size(); i++) { //recorrer lista
            if (boton == lista.get(i)) {
                existe = true;
                break;
            }
        }
        return existe;
    }//buscarMina

}//class
