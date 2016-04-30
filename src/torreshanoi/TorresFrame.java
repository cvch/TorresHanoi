package torreshanoi;

import java.awt.*;
import java.awt.event.*;

/**
 * Programa aut�nomo para las torres de Hanoi.
 *
 * @author Maestros computaci�n II
 * @version Primavera 2003
 */
public class TorresFrame extends Frame implements ActionListener,
        WindowListener {

    private Button b1, b2;
    private Label l1;
    private TextField t1;
    private Hanoi h;
    private boolean resolver;

    /**
     * M�todo principal: se ejecuta al iniciar el programa
     */
    public static void main(String[] args) {

        TorresFrame f = new TorresFrame();
        f.setSize(500, 500);
        f.setVisible(true);
    }

    /**
     * Constructor: inicializa el frame
     */
    public TorresFrame() {

        setTitle("Las torres de Hanoi");
        setLayout(new FlowLayout());
        this.addWindowListener(this);

        b1 = new Button("# discos");
        b2 = new Button("Resolver");
        l1 = new Label("Número de discos");
        t1 = new TextField(10);
        h = new Hanoi(4); /* cuatro discos en la torre */

        add(l1);
        add(t1);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        resolver = false;
        t1.setText("4");
    }

    /**
     * dibujar el contenido del frame
     *
     * @param g the Graphics object for this frame
     */
    @Override
    public void paint(Graphics g) {

        h.dibuja(g);
        if (resolver) {
            h.resuelve(g);
        }
    }

    /**
     * Cazador de eventos
     *
     * @param e el evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        int n;
        if (e.getSource() == b1) {
            n = Integer.parseInt(t1.getText());
            if ((n >= 1) && (n <= 10)) {
                h = new Hanoi(n);  //crear un juego de n discos
            }
        }
        if (e.getSource() == b2) {
            if (!resolver) {
                b2.setLabel("Reiniciar");
                b1.setEnabled(false);
            } else {
                h.reinicia();
                b2.setLabel("Resolver");
                b1.setEnabled(true);
            }
            resolver = !resolver;
        }
        repaint();
    }

    //Eventos de ventana, en este caso solo usamos WindosClosing
    /**
     * Captura windowClosing cierra la aplicaci�n al capturar este evento.
     *
     * @param e WindowEvent
     */
    public void windowClosing(WindowEvent e) {

        System.exit(0);
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
