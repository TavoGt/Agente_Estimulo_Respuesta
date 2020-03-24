package agente;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Movimiento implements Runnable{
    
    Thread Hilo = new Thread(this); //Objeto para animar las piezas
    int[][] posEspeciales;
    int filas;
    int cols;
    int[][] arr;
    JButton[][] btn;
    boolean terminado;
    
    public Movimiento(int filas, int cols, int[][] arr, int[][] posEspeciales, JButton[][] btn, boolean terminado)
    {
        this.filas = filas;
        this.cols = cols;
        this.arr = arr;
        this.posEspeciales = posEspeciales;
        this.btn = btn;
        this.terminado = terminado;
        Hilo.start();
    }
       
    public void mover() {
        int i = posEspeciales[0][0];
        int j = posEspeciales[0][1];
        System.out.println("Posicion: " + (i) + (j));

        if ((i > 0) && (i < filas - 1)) { //
            if ((j < cols - 1) && (j > 0)) {
                if ((arr[i - 1][j] <= arr[i][j + 1]) && (arr[i - 1][j] <= arr[i + 1][j]) && (arr[i - 1][j] <= arr[i][j - 1]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if ((arr[i][j + 1] <= arr[i + 1][j]) && (arr[i][j + 1] <= arr[i][j - 1]) && (arr[i][j + 1] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                } else if ((arr[i + 1][j] <= arr[i][j - 1]) && (arr[i + 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            } else if (j == 0) { //PRIMERA COLUMNA
                if ((arr[i - 1][j] <= arr[i][j + 1]) && (arr[i - 1][j] <= arr[i + 1][j]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if ((arr[i][j + 1] <= arr[i - 1][j]) && (arr[i][j + 1] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                } else if (arr[i + 1][j] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                }
            } else if (j == cols - 1) { //ULTIMA COLUMNA
                if ((arr[i - 1][j] <= arr[i - 1][j]) && (arr[i - 1][j] <= arr[i][j - 1]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if ((arr[i + 1][j] <= arr[i][j - 1]) && (arr[i + 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            }
        } else if (i == 0) { //FILA 0

            if ((j > 0) && (j < cols - 1)) {
                if ((arr[i][j + 1] <= arr[i + 1][j]) && (arr[i][j + 1] <= arr[i][j - 1]) && (arr[i][j + 1] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                } else if ((arr[i + 1][j] <= arr[i][j - 1]) && (arr[i + 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            } else if (j == 0) {
                if ((arr[i][j + 1] <= arr[i + 1][j]) && (arr[i][j + 1] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                } else if (arr[i + 1][j] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                }
            } else if (j == cols - 1) {
                if ((arr[i + 1][j] <= arr[i][j - 1]) && (arr[i + 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i + 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i + 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            }
        } else if (i == filas - 1) {
            if ((j > 0) && (j < cols - 1)) {
                if ((arr[i - 1][j] <= arr[i][j + 1]) && (arr[i - 1][j] <= arr[i][j - 1]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if ((arr[i][j + 1] <= arr[i][j - 1]) && (arr[i][j + 1] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            } else if (j == 0) {
                if ((arr[i - 1][j] <= arr[i][j + 1]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j + 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j + 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j + 1;
                }
            } else if (j == cols - 1) {
                if ((arr[i - 1][j] <= arr[i][j - 1]) && (arr[i - 1][j] != -1)) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i - 1][j].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i - 1;
                    posEspeciales[0][1] = j;
                } else if (arr[i][j - 1] != -1) {
                    arr[i][j]++;
                    btn[i][j].setBackground(Color.RED);
                    btn[i][j - 1].setBackground(Color.BLUE);
                    posEspeciales[0][0] = i;
                    posEspeciales[0][1] = j - 1;
                }
            }
        }
        
        btn[i][j].setText("" + arr[i][j]);
        if ((posEspeciales[0][0] == posEspeciales[1][0]) && (posEspeciales[0][1] == posEspeciales[1][1])) {
            System.out.println("TERMINADO");
            JOptionPane.showMessageDialog(null, "JUEGO TERMINADO");
            terminado = true;
        }
    }
    
    @Override
    public void run() {
        try {
            while(!terminado){
                mover();
                //System.out.println("HOLA");
                Thread.sleep(300);  //La pieza bajará de segundo en segundo
            }
        } catch (Exception e) {
            System.out.println("Error en la Matrix - xD");
        }
    }
    
}
