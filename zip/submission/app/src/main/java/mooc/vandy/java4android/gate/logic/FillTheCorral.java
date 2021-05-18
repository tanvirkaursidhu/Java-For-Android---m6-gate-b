package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gate, Random rand) { //set direction of each gate
        for (int i = 0; i < gate.length; i++) {
            gate[i].setSwing(rand.nextInt(3) - 1);
            mOut.println("Gate " + i + ": " + gate[i].toString());
        }
    }

    public boolean anyCorralAvailable(Gate[] corral) { //return boolean value
        boolean bool = false;
        for (Gate gate : corral) {
            if (gate.getSwingDirection() == 1) {
                bool = true;
                break; //exit loop as soon as an IN gate is found
            }
        }
        return bool;
    }

    // corral snails method
    public int corralSnails(Gate[] corral, Random rand) {
        int pasture = 5;
        int attempt = 0;
        while (pasture != 0) {
            ++attempt;
            int index = rand.nextInt(corral.length);
            int snails = rand.nextInt(pasture) + 1;

            pasture = pasture - corral[index].thru(snails);//updates no of snails left in pasture
            mOut.println(snails + " are trying to move through corral " + index);
        }
        mOut.println("It took " + attempt + " attempts to corral all of the snails.");
        return attempt; //return no of attempts done to corral out all snails
    }

}

