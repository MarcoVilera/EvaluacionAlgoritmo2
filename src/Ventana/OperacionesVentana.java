package Ventana;
//@author MarcoVilera

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
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
    public static BigDecimal potRecur(BigDecimal n1, int n2) {
        if (n2 == 0) {
            return BigDecimal.ONE;
        } else if (n2 < 0) {
            return BigDecimal.ONE.divide(n1, 6, RoundingMode.HALF_UP).multiply(potRecur(n1, n2 + 1));
        } else {
            return n1.multiply(potRecur(n1, n2 - 1));
        }
    }
    //Fin Potencia N^M

    //Fibonacci hasta NxN
    public static void fibonacciRecur(int n, ArrayList<Integer> vector, int i) {
        if (n == 0) {//Si n es igual a 0 solo agregará 0 al vector
            vector.add(0);
        } else if (n == 1) {//Si n es igual a 1, agregará solamente 0 y 1
            vector.add(0);
            vector.add(1);
        } else {
            if (i == 0 || i == 1) { //si el indice i es 0 o 1, colocará el elemento i en la posición i
                vector.add(i, i);    //Indice,Elemento 
                fibonacciRecur(n, vector, i + 1);
            } else {
                int fib = vector.get(i - 1) + vector.get(i - 2);//Obtiene los 2 valores anteriores a i actual
                if (fib <= n) {//Si es mayor que n, no se agregará al vector
                    vector.add(i, fib);
                    fibonacciRecur(n, vector, i + 1);
                }
            }
        }
    }

    public static String vectorToString(ArrayList<Integer> vector) {
        if (vector.isEmpty()) { // si el vector está vacío
            return ""; // retornar una cadena vacía
        } else {
            Integer first = vector.get(0); // obtener el primer elemento del vector
            vector.remove(0); // remover el primer elemento del vector
            if (vector.isEmpty()) {
                return first.toString() + "" + vectorToString(vector);
            } else {
                return first.toString() + ", " + vectorToString(vector);
            }
        }
    }
//FinFibonacci hasta NxN

//Factorial de N
    public static BigInteger factoRecur(BigInteger n) {

        if (n.equals(BigInteger.ZERO)) { //Si n es 0, el factorial es 1
            return BigInteger.ONE;
        } else { //Si n es mayor que 0, se multiplica por (n-1)!
            return n.multiply(factoRecur(n.subtract(BigInteger.ONE)));
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
