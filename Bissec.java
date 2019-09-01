package br.unifil.dc.lab2;
import java.io.PrintStream;

import static java.lang.Math.*;

public class Bissec {
    double controle;
    boolean sinais[] = new boolean[2];
    double resultado[] = new double[5];
    int raizes[] = new int[10];
    double a, b, c, d, e, f;
    int epslon;

    public Bissec(double g, double h , double i, double j, double k, double l, double m) {
        this.a = g;
        this.b = h;
        this.c = i;
        this.d = j;
        this.e = k;
        this.f = l;
        this.epslon = (int) m;
        for(int x = 0; x < raizes.length; x++){
            raizes[x] = 200;
        }
        for(int x = 0; x < resultado.length; x++){
            resultado[x] = 0;
        }
        sinais[0] = true;
        sinais[1] = true;
        localizar();
        bisseccao();
    }

    public void localizar(){
        int z = 0;
        int p = -100;
        while (p <= 100){
            controle = calcula(p);
            if (controle < 0){
                sinais[0] = sinais[1];
                sinais[1] = true;
            }
            else{
                sinais[0] = sinais[1];
                sinais[1] = false;
            }
            if(p > -100){
                if(sinais[0] != sinais[1]){
                    raizes[z] = p-1;
                    raizes[z+1] = p;
                    z++;
                    z++;
                }
            }
            p++;
        }
    }

    public void bisseccao(){
        double parar = Math.pow(10,epslon);
        int cont = 0;
        for(int x = 0; x < raizes.length; x = x +2){
            double aa = raizes[x];
            double ba = raizes[x+1];
            for(int y = 0; y < 1000; y++){
                System.out.println("começou a comparar");
                double ca = (aa+ba)/2;
                double ab = calcula(aa);
                double bb = calcula(ba);
                double cb = calcula(ca);
                if(cb*ab < 0){
                    ba = ca;
                }else{
                    aa = ca;
                }
                if(((ba-aa)/2)< parar){break;}
                resultado[cont] = ca;
            }
            cont++;
        }
    }


    public String getRaiz(){
        String r = "";
        for(int i = 0; i < raizes.length; i = i + 2) {
            if(raizes[i] != 200 ) {
                String aaa = "" + raizes[i];
                String bbb = "" + raizes[i+1];
                r += "0" + (((int)(i)/2)+1) + " - Entre " + aaa + " e " + bbb  +'\n';
            }
        }
        return r;
    }

    public String getResultado(){
        String r2 = "";
        for(int k = 0; k < resultado.length; k++) {
            if(resultado[k] != 200 && resultado[k] != 0){
                r2 += "0" + (k+1) + " - Raiz aproximada em " + resultado[k]  + '\n';
            }
        }
        return r2;
    }
    public double calcula(double valor){
        double caculado = (double) (a*Math.pow(valor,5) + b*Math.pow(valor, 4)+ c*Math.pow(valor, 3)+ d*Math.pow(valor, 2) + e*valor + f);
        return caculado;
    }
}
