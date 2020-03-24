package agente;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Ventana extends JFrame implements ActionListener {

    int filas = 0;
    int cols = 0;
    Color colorActual;

    JRadioButton rBtnMeta = new JRadioButton("Meta");
    JRadioButton rBtnInicio = new JRadioButton("Inicio");
    JRadioButton rBtnBloque = new JRadioButton("Bloque");
    JButton btnMover = new JButton("MOVER");
    JButton btnReiniciar = new JButton("REINICIAR");
    JButton[][] btn;
    int[][] arr;
    int[][] posEspeciales = new int[2][2];
    int[][] posRestringido;
    boolean meta = false, inicio = false;
    Movimiento movimiento;
    boolean terminado = false;

    public Ventana(int filas, int cols) { //Recibe como parametro el título de la ventana
        super("AGENTE INTELIGENTE");

        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.filas = filas;
        this.cols = cols;

        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(rBtnMeta);
        bGroup.add(rBtnInicio);
        bGroup.add(rBtnBloque);

        rBtnInicio.setSelected(true);
        //Panel selector
        JPanel panelSelector = new JPanel();
        panelSelector.setLayout(new FlowLayout());
        //panelSelector.setBackground(Color.DARK_GRAY);
        panelSelector.add(rBtnMeta);
        panelSelector.add(rBtnInicio);
        panelSelector.add(rBtnBloque);
        panelSelector.add(btnMover);
        panelSelector.add(btnReiniciar);
        btnMover.addActionListener(this);
        btnReiniciar.addActionListener(this);

        //Panel de botones (Matriz)
        btn = new JButton[filas][cols];
        arr = new int[filas][cols];

        JPanel panelMatriz = new JPanel();
        GridLayout gl = new GridLayout(filas, cols);
        gl.setHgap(2);
        gl.setVgap(2);
        panelMatriz.setLayout(gl);
        panelMatriz.setBackground(Color.BLACK);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                btn[i][j] = new JButton();
                //btn[i][j].setText("" + (i) + (j));
                arr[i][j] = 0;
                btn[i][j].setBackground(Color.RED);
                btn[i][j].addActionListener(this);
                panelMatriz.add(btn[i][j]);
            }
        }

        //Agregando objetos al formulario
        Container cp = getContentPane();
        cp.add(panelSelector, BorderLayout.NORTH);
        cp.add(panelMatriz, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnMover) {
            if(meta && inicio){
                //repetir();
                movimiento = new Movimiento(filas, cols, arr, posEspeciales, btn, terminado);
            }else{
                if(!inicio){
                    JOptionPane.showMessageDialog(null, "DEBE ESTABLECER EL INICIO");
                }else if(!meta){
                    JOptionPane.showMessageDialog(null, "DEBE ESTABLECER UNA META");
                }
            }
        } else if (e.getSource() == btnReiniciar) {
            reiniciar();
            terminado = false;
        } else {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    if (e.getSource() == btn[i][j]) {
                        if (rBtnMeta.isSelected() && !meta) {
                            meta = true;
                            posEspeciales[1][0] = i;//Fila META
                            posEspeciales[1][1] = j;//Columna META
                            arr[i][j] = 0;
                            btn[i][j].setBackground(Color.GREEN);
                        } else if (rBtnInicio.isSelected() && !inicio) {
                            inicio = true;
                            posEspeciales[0][0] = i; //Fila INICIO
                            posEspeciales[0][1] = j; //Columna INICIO
                            //arr[i][j] = 0;
                            btn[i][j].setBackground(Color.BLUE);
                        } else if (rBtnBloque.isSelected()) {
                            //arr[i][j] = -1;
                            btn[i][j].setBackground(Color.ORANGE);
                            arr[i][j] = 1000;
                        }
                    }
                }
            }
        }
    }

    public void reiniciar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = 0;
                btn[i][j].setBackground(Color.RED);
                btn[i][j].setText("");
                meta = false;
                inicio = false;
            }
        }
    }
}
