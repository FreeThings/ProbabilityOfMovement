package ProbabilityMovement;

import java.util.ArrayList;

public class ProbMovementMain {
    public static void main(String[] args) {


        ProbMovement probMovementR = new ProbMovement(0.1, 0.85, 0.05, 100);
        int startingPosition = 0;

        runIterationsReset(probMovementR);
    }

    public static void printResults(ArrayList<Integer> startingPositions, ArrayList<Long> steps) {
        System.out.println("Starting Position , Steps");
        for (int i = 0; i < steps.size(); i++) {
            System.out.println(startingPositions.get(i) + " , " + steps.get(i));
        }
    }

    public static void runIterationsNoReset(ProbMovement probMovementNR) {
        probMovementNR = new ProbMovement(0.25, 0.75, 100);

        int startingPosition = 0;

        ArrayList<Long> steps = new ArrayList<>();
        ArrayList<Integer> startingPositions = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            startingPosition += 10;
            probMovementNR.setStartingPosition(startingPosition);
            steps.add(probMovementNR.moveNoResetIterations(10000));
            startingPositions.add(startingPosition);
        }

        printResults(startingPositions, steps);
    }

    public static void runIterationsReset(ProbMovement probMovementR) {

        int startingPosition = 0;

        ArrayList<Long> steps = new ArrayList<>();
        ArrayList<Integer> startingPositions = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            startingPosition += 10;
            probMovementR.setStartingPosition(startingPosition);
            steps.add(probMovementR.moveResetIterations(10000));
            startingPositions.add(startingPosition);
        }

        printResults(startingPositions, steps);
    }

}
