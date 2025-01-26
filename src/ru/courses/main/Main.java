package ru.courses.main;

import ru.stepup.karlashov.Sauce;
import static ru.stepup.karlashov.Sauce.Spiciness.*;

public class Main {
    public static void main(String[] args) {

        Sauce s1 = new Sauce("Tabasco", VERY_SPICY);
        System.out.println(s1);

        Sauce s2 = new Sauce("Mayonnaise", NOT_SPICES);
        System.out.println(s2);
    }



}

