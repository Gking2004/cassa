class Cassa {
  private double m;
  private boolean restoM;

  public Cassa(double m) {
    this.m = m;
  }

  public Cassa resto(double tot, double utente) {
    double moneta;
    moneta = tot;
    if (moneta > 0.00) {
      moneta = moneta - utente;
    } else {
      if (moneta < 0.00) {
        restoM = true;
      } else {
        restoM = false;
      }
    }
    if (restoM) {
      moneta = restoMon(moneta);
    }
    Cassa c = new Cassa(moneta);
    c.dareResto(c);
    return c;
  }

  public double getM() {
    return m;
  }

  public void setM(double m) {
    this.m = m;
  }

  private double restoMon(double moneta) {
    return Math.abs(moneta);
  }

  public void dareResto(Cassa c) {
    double num = c.getM();
    while (num < 0) {
      if (num <= -500.00) {
        System.out.println("Banconota 500€");
        num = num + 500.00;
      } else if (num <= -200.00) {
        System.out.println("Banconota 200€");
        num = num + 200.00;
      } else if (num <= -100.00) {
        System.out.println("Banconota 100€");
        num = num + 100.00;
      } else if (num <= -50.00) {
        System.out.println("Banconota 50€");
        num = num + 50.00;
      } else if (num <= -20.00) {
        System.out.println("Banconota 20€");
        num = num + 20.00;
      } else if (num <= -10.00) {
        System.out.println("Banconota 10€");
        num = num + 10.00;
      } else if (num <= -5.00) {
        System.out.println("Banconota 5€");
        num = num + 5.00;
      } else if (num <= -2.00) {
        System.out.println("Moneta 2€");
        num = num + 2;
      } else if (num <= -1.00) {
        System.out.println("Moneta 1€");
        num = num + 1;
      } else if (num <= -0.50) {
        System.out.println("Moneta 0.50€");
        num = num + 0.50;
      } else if (num <= -0.20) {
        System.out.println("Moneta 0.20€");
        num = num + 0.20;
      } else if (num <= -0.10) {
        System.out.println("Moneta 0.10€");
        num = num + 0.10;
      } else if (num <= -0.05) {
        System.out.println("Moneta 0.05€");
        num = num + 0.05;
      } else if (num <= -0.02) {
        System.out.println("Moneta 0.02€");
        num = num + 0.02;
      } else {
        System.out.println("Moneta 0.01€");
        num = num + 0.01;
      }
    }
    c.setM(num);
  }
}