package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate() { //constructor
        close();
    }

    public int getSwingDirection() { //return swing direction
        return mSwing;
    }

    public boolean setSwing(int a) { //set swing direction  depending on whether parameter is valid or not
        if (a==1||a==-1||a==0) {
            mSwing = a;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean open(int b){ //opens the gate by calling setSwing method
        if(b==IN || b==OUT){
            setSwing(b);
            return true;
        }
        else{
            return false;
        }
    }

    public void close(){ //closes the gate
        setSwing(0);
    }

    public int thru(int count){ //return net change
        if(mSwing==IN) {
            return count;
        }

        else if(mSwing==OUT) {
            return -count;
        }

        else{
            return 0;
        }
    }

    public String toString(){  //overriding default toString method
        if(mSwing==CLOSED){
            return ("This gate is closed"); // for a gate that is closed
        }
        else if(mSwing==IN){
            return ("This gate is open and swings to enter the pen only"); // for a gate that has opened to swing IN
        }
        else if(mSwing==OUT){
            return ("This gate is open and swings to exit the pen only"); // for a gate that been opened swing OUT
        }
        else{
            return ("This gate has an invalid swing direction"); // for a gate that has a swing value other than IN, OUT, or CLOSED
        }
    }
}
