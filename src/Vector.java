/**
 * Created by Влад on 16.09.2017.
 */
public class Vector {

    private double [] x;  //квадратные - массив одномерный
    private double [] desireOutputs;

    public Vector (double [] x, double [] desireOutputs )
    {
        this.x = new double[x.length+1];
        this.x[0]=1;
        for (int i = 1; i<this.x.length; i++)
        {this.x[i] = x[i-1];}


        this.desireOutputs = desireOutputs;
    }

    public double[] getX() {
        return x;
    }

    public double[] getDesireOutputs() {
        return desireOutputs;
    }
}
