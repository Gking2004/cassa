import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FinestraUtente extends JFrame implements WindowListener, ActionListener {
  Double daPagare = 0.00;
  Double soldiUtente = 0.00;
  JPanel pAll;
  JPanel pDaPagare;
  JPanel pPagare;
  JPanel pResto;
  String regEx = "(\\d)+((\\.){1}(\\d){1,2})?";
  JTextField tDaPagare;
  JTextField tPagare;
  JTextField tResto;
  JButton invia;
  String num;

  public FinestraUtente(String s, String num) {
    super();
    daPagare = Double.valueOf(num);
    pAll = new JPanel();
    pDaPagare = new JPanel();
    pPagare = new JPanel();
    tDaPagare = new JTextField(5);
    tPagare = new JTextField(5);
    invia = new JButton("Invia");
    this.num = num;
    pAll.setLayout(new GridLayout(2, 1));
    pPagare.setLayout(new FlowLayout());
    tDaPagare.setEditable(false);
    tDaPagare.setText("€ " + num);
    pDaPagare.add(tDaPagare);
    pPagare.add(tPagare);
    invia.addActionListener(this);
    pPagare.add(invia);
    pAll.add(pDaPagare);
    pAll.add(pPagare);
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
    if (a.getActionCommand().equals("Invia")) {
      if (tPagare.getText().matches(regEx)) {
        soldiUtente = Double.valueOf(tPagare.getText());
        if (daPagare > 0) {
          daPagare = daPagare - soldiUtente;
          tDaPagare.setText("€ " + daPagare);
          tPagare.setText("");
          if (daPagare == 0.00 || daPagare < 0.00) {
            FinestraResto fr = new FinestraResto("Resto", daPagare);
            fr.setSize(250, 250);
            fr.setVisible(true);
            tDaPagare.setText("€ ");
            tPagare.setText("");
          }
        }
      } else {
        JOptionPane.showMessageDialog(this, "Errore,numero non esistente", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}