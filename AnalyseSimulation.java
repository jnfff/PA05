package lesson19;

import java.util.Random;

public class AnalyseSimulation {
    // the maximum number of days the simulation will run
    private static int MAX_TICKS = 1000;
    private Random random = new Random();

    public static void main(String[] args) {

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numStayHome = Integer.parseInt(args[2]);
        int numEssential = Integer.parseInt(args[3]);
        int numSkeptic = Integer.parseInt(args[4]);
        int numFrequentFlier = Integer.parseInt(args[5]);
        int numHealthy = Integer.parseInt(args[6]);
        int numIterations = Integer.parseInt(args[7]);

        System.out.println("\nTracking the Infection");

        for(int i=0;i<numIterations;i++) {
            Population population;
            population = new MixedPopulation(numStayHome, numEssential, numSkeptic, numFrequentFlier, numHealthy);
            population.createPeople();
            Country country = new Country(width, height);
            country.population = population;
            population.placePeople(country);

            int numOfDays, numOfInfected=0, peakInfectedLevel=0;
            for (numOfDays = 0; numOfDays < MAX_TICKS; numOfDays++) {
                country.simulateOneStep();
//                country.printState(numOfDays);
                if(peakInfectedLevel < country.numInfected)
                    peakInfectedLevel = country.numInfected;

                if (country.numInfected == 0) {
                    break;
                }
            }
            // Since there are no reinfections, total infected = total recovered
            numOfInfected = country.numRecovered;

            System.out.println("Iteration " + i + " - Days: " + numOfDays + "\t Total Infections: " + numOfInfected + "/" + country.numPeople + "\t Peak Infected Level: " + peakInfectedLevel);
        }

    }

}
