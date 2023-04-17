package Ventana;
//@author MarcoVilera

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import static javax.swing.Spring.scale;

public class OperacionesVentana {

    //M es primo
    private static boolean nPrimRec(int n, int div) {
        if (div >= n) {
            return true;
        }
        if (n % div == 0) {
            return false;
        }
        return nPrimRec(n, div + 1);
    }

    public static boolean nPrim(int n) {
        if (n <= 1) {
            return false;
        }
        return nPrimRec(n, 2);
    }
    //Fin M es primo

    //Potencia N^M
//    public static int potRecur(int n, int m) {
//        if (m == 0) {
//            return 1;
//        } else if (m < 0) {
//            return 1 / potRecur(n, (m * -1));
//        } else {
//            return n * potRecur(n, (m - 1));
//        }
//    }
    public static BigDecimal potRecur(BigDecimal n1, int n2) {
        if (n2 == 0) {
            return BigDecimal.ONE;
        } else if (n2 < 0) {
            return BigDecimal.ONE.divide(n1,6,RoundingMode.HALF_UP).multiply(potRecur(n1, n2 + 1));
        } else {
            return n1.multiply(potRecur(n1, n2 - 1));
        }
    }
    //Fin Potencia N^M

    //Fibonacci hasta NxN
    public static int fibonacci(int n) {

        if (n == 0 || n == 1) { // Si el número es 0 o 1, retorna el mismo número
            return n;
        } else { // Si no, llamo recursivamente a la función con n-1 y n-2 y sumo ambos valores
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    //FinFibonacci hasta NxN

    //Factorial de N
//    public static int factoRecur(int n) {
//        if (n < 0) {
//            return 0;
//        }
//        if (n == 0) {
//            return 1;
//        } else {
//            return n * factoRecur(n - 1);
//        }
//    }
     public static BigInteger factoRecur(BigInteger n) {

      if (n.equals(BigInteger.ZERO)) { //Si n es 0, el factorial es 1
         return BigInteger.ONE;
      }
      else { //Si n es mayor que 0, se multiplica por (n-1)!
         return n.multiply(factoRecur(n.subtract(BigInteger.ONE)));
      }

   }

    public static String strFactoRecur(int facto, int comp) {
        if (comp < 0) {
            return "No se puede obtener el factorial de un número negativo";
        }
        if (comp == 0) {
            return "El factorial de 0 es 1";
        } else {
            return "El factorial de " + comp + " es " + facto;
        }
    }
    //Fin Factorial de N

    //Suma Digitos NxM
    public static int sumDigit(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10) + sumDigit(n / 10);
        }
    }
    //Fin Suma Digitos NxM
}
