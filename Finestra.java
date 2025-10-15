import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Finestra extends JFrame implements WindowListener, ActionListener {
  JPanel pAll;
  JPanel pInsert;
  JPanel tastiera;
  JButton invia;
  JLabel insertPrice;
  JTextField text;
  JButton canc = new JButton("c");
  JButton dot = new JButton(".");
  String regEx = "(\\d)+((\\.){1}(\\d){1,2})?";
  JButton[] buttons = new JButton[10];

  public Finestra(String s) {
    super();
    pAll = new JPanel();
    pInsert = new JPanel();
    tastiera = new JPanel();
    tastiera.setLayout(new GridLayout(4, 4));
    pAll.setLayout(new GridLayout(2, 1));
    invia = new JButton("Invia");
    invia.setSize(2, 2);
    insertPrice = new JLabel("Inserisci il prezzo €");
    text = new JTextField(4);
    canc.addActionListener(this);
    dot.addActionListener(this);
    buttons = addButtons();
    for (int i = 1; i < 10; i++) {
      tastiera.add(buttons[i]);
    }
    tastiera.add(dot);
    tastiera.add(buttons[0]);
    tastiera.add(canc);
    pInsert.add(insertPrice);
    pInsert.add(text);
    pInsert.add(invia);
    invia.addActionListener(this);
    pAll.add(pInsert);
    pAll.add(tastiera);
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
    System.exit(0);
  }

  public void actionPerformed(ActionEvent a) {
    switch (a.getActionCommand()) {
      case "0":
        text.setText(text.getText() + "0");
        break;
      case "1":
        text.setText(text.getText() + "1");
        break;
      case "2":
        text.setText(text.getText() + "2");
        break;
      case "3":
        text.setText(text.getText() + "3");
        break;
      case "4":
        text.setText(text.getText() + "4");
        break;
      case "5":
        text.setText(text.getText() + "5");
        break;
      case "6":
        text.setText(text.getText() + "6");
        break;
      case "7":
        text.setText(text.getText() + "7");
        break;
      case "8":
        text.setText(text.getText() + "8");
        break;
      case "9":
        text.setText(text.getText() + "9");
        break;
      case ".":
        text.setText(text.getText() + ".");
        break;
      case "c":
        text.setText("");
        break;
    }
    if (a.getActionCommand().equals("Invia")) {
      if (text.getText().matches(regEx)) {
        FinestraUtente f = new FinestraUtente("Utente", text.getText());
        f.setSize(250, 250);
        f.setVisible(true);
        text.setText("");
      } else {
        JOptionPane.showMessageDialog(this, "Errore,numero non esistente", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private JButton[] addButtons() {
    JButton[] button = new JButton[10];
    for (int i = 0; i < 10; i++) {
      button[i] = new JButton(String.valueOf(i));
      button[i].addActionListener(this);
    }
    return button;
  }
}