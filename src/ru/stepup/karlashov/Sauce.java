package ru.stepup.karlashov;

public class Sauce {
    String name;
    Spiciness spiciness;

    public enum Spiciness {
        VERY_SPICY("Очень острый"),
        SPICY("острый"),
        NOT_SPICES("не острый");

        private final String description;

        Spiciness(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return this.description;
        }

    }

    public Sauce(String name, Spiciness spiciness) {
        this.name = name;
        this.spiciness = spiciness;
    }

    @Override
    public String toString() {
        return "Соус " + this.name + ": " + this.spiciness;
    }

}
