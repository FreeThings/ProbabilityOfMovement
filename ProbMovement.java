package ProbabilityMovement;


import java.util.ArrayList;

public class ProbMovement {

    private final int ENDING_POSITION = 0;

    private final int TOO_MANY_STEPS = 1000000;

    private double p = 0.0;
    private double q = 0.0;
    private double r = 0.0;

    private int startingPosition = 0;

    private long steps = 0;

    public ProbMovement(double p, double q, double r, int startingPosition) {
        this.p = p;
        this.q = q;
        this.r = r;

        System.out.println("The sum of p, q, and r is " + (p + q + r));

        if (!(Math.abs((p+q+r) - 1.0) < 0.00001)) throw new IllegalArgumentException("The sum of p, q, and r must be equal to 1");

        this.startingPosition = startingPosition;
    }

    public ProbMovement(double p, double q, int startingPosition) {
        this.p = p;
        this.q = q;
        this.r = r;

        if (p + q != 1.0) throw new IllegalArgumentException("The sum of p and q must be equal to 1");

        this.startingPosition = startingPosition;
    }

    public void moveNoReset() {
        steps = 0;



        int currentPosition = startingPosition;
        while (currentPosition != ENDING_POSITION) {

            if (steps >= TOO_MANY_STEPS) {
                break;
            }

            double random = Math.random();
            if (random < p) {
                currentPosition++;
            } else if (random < p + q) {
                currentPosition--;
            }
            steps++;
        }

//        System.out.println("The particle moved " + steps + " steps");


    }

    public long moveNoResetIterations(int iterations){
        ArrayList<Long> stepsList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            moveNoReset();
            stepsList.add(steps);
        }


       long totalSteps = 0;
        for (long i : stepsList) {
            totalSteps += i;
        }

        long averageSteps = totalSteps / stepsList.size();

        System.out.println("For a movement of a particle starting at position " + startingPosition + " with p = " + p
                + " and q = " + q + " the average number of steps is " + averageSteps);

        return averageSteps;
    }

    public void move(){
        steps = 0;

        int currentPosition = startingPosition;
        while (currentPosition != ENDING_POSITION) {

            if (steps >= TOO_MANY_STEPS) {
                break;
            }

            double random = Math.random();
            if (random < p) {
                currentPosition++;
            } else if (random < p + q) {
                currentPosition--;
            } else {
                currentPosition = startingPosition;
            }

            steps++;
        }
    }

    public long moveResetIterations(int iterations){
        ArrayList<Long> stepsList = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            move();
            stepsList.add(steps);
        }

        long totalSteps = 0;
        for (long i : stepsList) {
            totalSteps += i;
        }

        long averageSteps = totalSteps / stepsList.size();

        System.out.println("For a movement of a particle starting at position " + startingPosition + " with p = " + p
                + ", q = " + q + " , and r = " + r + " the average number of steps is " + averageSteps);

        return averageSteps;
    }

    public long getSteps() {
        return steps;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

}
