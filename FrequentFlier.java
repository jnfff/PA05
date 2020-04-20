package lesson19;

import java.util.Random;

public class FrequentFlier extends Person {


    public FrequentFlier() {
        super();
    }

    private Random random = new Random();

    public void tryToMove() {
        int i = random.nextInt(country.places.length);
        int j = random.nextInt(country.places[i].length);
        while (!isOK(i, j, this.country)) {
            // loop to make sure it is an open space ...
            i = random.nextInt(country.places.length);
            j = random.nextInt(country.places[i].length);
        }
        this.moveTo(i, j);
    }

}
