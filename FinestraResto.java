import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FinestraResto extends JFrame implements WindowListener, ActionListener {
  JPanel pAll;
  private Thread t;
  JLabel grazie;
  JLabel eResto;
  String s;
  Cassa c;
  double d = 0.00;

  public FinestraResto(String s, double d) {
    super();
    pAll = new JPanel();
    grazie = new JLabel("Grazie");
    eResto = new JLabel("Erogazione resto");
    s = String.valueOf(d);
    this.d = d;
    if (d < 0.00) {
      pAll.add(eResto);
      c = new Cassa(d);
      c.dareResto(new Cassa(d));
      t = new Thread(new Runnable() {
        public void run() {
          try {
            Thread.sleep(5000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          eResto.setText("");
          pAll.add(grazie);
          revalidate();
        }
      });
      t.start();
    } else {
      revalidate();
      eResto.setText("");
      pAll.add(grazie);
    }
    this.add(pAll);
    this.addWindowListener(this);
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowDeiconified(WindowEvent e) {
  }

  public void windowActivated(WindowEvent e) {
  }

  public void windowDeactivated(WindowEvent e) {
  }

  public void windowOpened(WindowEvent e) {
  }

  public void windowClosed(WindowEvent e) {
  }

  public void windowClosing(WindowEvent e) {
  }

  public void actionPerformed(ActionEvent a) {

  }
}
