package ru.courses.main;

public class Main {
    public static void main(String[] args) {
        System.out.println(Operation.SUM.method(1,2));
        System.out.println(Operation.MINUS.method(1,2));
        System.out.println(Operation.MULT.method(1,2));
        System.out.println(Operation.DIV.method(1,2));
    }

    public enum Operation{

        SUM{
            public int method(int x, int y){
                return x+y;
            }
        },
        MINUS {
            public int method(int x, int y) {
                return x - y;
            }
        },
        MULT {
            public int method(int x, int y) {
                return x * y;
            }
        },
        DIV {
            public int method(int x, int y) {
                if(y==0) {
                    throw new ArithmeticException("Деление на ноль! АЛЛО ...");
                }
                return x / y;
            }
        };

        abstract int method(int x, int y);
    }


}



