package br.unifil.dc.lab2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class Window extends JFrame {
    Double s1,s2,s3,s4,s5,s6, eps;
    JButton calc;
    JTextField t1, t2, t3, t4, t5, t6, teps;
    ActionListener a1;

    public Window() {
        setWindow();
        setElements();
    }

    public void setWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(null);
        setVisible(true);
    }

    public void setElements() {
        a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().isEmpty()) {
                    s1 = 0.0;
                } else {
                    s1 = parseDouble(t1.getText());
                }

                if(t2.getText().isEmpty()) {
                    s2 = 0.0;
                } else {
                    s2 = parseDouble(t2.getText());
                }

                if(t3.getText().isEmpty()) {
                    s3 = 0.0;
                } else {
                    s3 = parseDouble(t3.getText());
                }

                if(t4.getText().isEmpty()) {
                    s4 = 0.0;
                } else {
                    s4 = parseDouble(t4.getText());
                }

                if(t5.getText().isEmpty()) {
                    s5 = 0.0;
                } else {
                    s5 = parseDouble(t5.getText());
                }

                if(t6.getText().isEmpty()) {
                    s6 = 0.0;
                } else {
                    s6 = parseDouble(t6.getText());
                }

                if(teps.getText().isEmpty()) {
                    eps = 0.0;
                } else {
                    eps = parseDouble(teps.getText());
                }



                if(e.getSource() == calc) {
                    Bissec b1 = new Bissec(s1,s2,s3,s4,s5,s6,eps);
                    resultFrame(b1);
                }
            }
        };

        //Elementos Textuais
        JLabel g5, g4, g3, g2, g1, leps;
        g5 = new JLabel("X^5");
        g5.setBounds(175,100,100,50);
        g5.setFont(new Font("Arial", Font.PLAIN, 30));
        add(g5);
        g5.setVisible(true);

        g4 = new JLabel("X^4");
        g4.setBounds(275,100,100,50);
        g4.setFont(new Font("Arial",Font.PLAIN,30));
        add(g4);
        g4.setVisible(true);

        g3 = new JLabel("X^3");
        g3.setBounds(375,100,100,50);
        g3.setFont(new Font("Arial",Font.PLAIN,30));
        add(g3);
        g3.setVisible(true);

        g2 = new JLabel("X^2");
        g2.setBounds(475,100,100,50);
        g2.setFont(new Font("Arial",Font.PLAIN,30));
        add(g2);
        g2.setVisible(true);

        g1 = new JLabel("X");
        g1.setBounds(575,100,100,50);
        g1.setFont(new Font("Arial",Font.PLAIN,30));
        add(g1);
        g1.setVisible(true);

        leps = new JLabel("ε");
        leps.setBounds(145,187,100,50);
        leps.setFont(new Font("Arial",Font.PLAIN,30));
        add(leps);
        leps.setVisible(true);


        //JButtons calcular e mostrar gráfico
        calc = new JButton("Calcular");
        calc.setBounds(350,480,90,30);
        calc.addActionListener(a1);
        add(calc);


        //Campos de texto
        t1 = new JTextField();
        t1.setBounds(130,110, 40, 30);
        add(t1);
        t1.setVisible(false);
        t1.setVisible(true);

        t2 = new JTextField();
        t2.setBounds(230,110, 40, 30);
        add(t2);
        t2.setVisible(false);
        t2.setVisible(true);

        t3 = new JTextField();
        t3.setBounds(330,110, 40, 30);
        add(t3);
        t3.setVisible(false);
        t3.setVisible(true);

        t4 = new JTextField();
        t4.setBounds(430,110, 40, 30);
        add(t4);
        t4.setVisible(false);
        t4.setVisible(true);

        t5 = new JTextField();
        t5.setBounds(530,110, 40, 30);
        add(t5);
        t5.setVisible(false);
        t5.setVisible(true);

        t6 = new JTextField();
        t6.setBounds(600,110, 40, 30);
        add(t6);
        t6.setVisible(false);
        t6.setVisible(true);

        teps = new JTextField();
        teps.setBounds(175,200, 40, 30);
        add(teps);
        teps.setVisible(false);
        teps.setVisible(true);

    }

    public void resultFrame(Bissec b) {
        JTextArea t1 = new JTextArea();
        JTextArea t2 = new JTextArea();
        JFrame jr = new JFrame();

        jr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jr.setLayout(null);
        jr.setSize(1200,800);
        jr.setVisible(true);


        t1.setColumns(20);
        t1.setRows(5);
        t1.setFont(new Font("Arial", Font.PLAIN,12));
        t1.setBounds(40,25,550,700);

        t2.setColumns(20);
        t2.setRows(5);
        t2.setFont(new Font("Arial", Font.PLAIN,12));
        t2.setBounds(600,25,550,700);

        jr.add(t1);
        t1.setVisible(false);
        t1.setVisible(true);

        jr.add(t2);
        t2.setVisible(false);
        t2.setVisible(true);

        t1.setText(b.getRaiz());
        t2.setText(b.getResultado());

    }
}
