import java.util.Random;

/**
 * Created by Влад on 09.09.2017.
 */

public class Neuron {
    private double[] weight;
    //вектор синапт весов
    private double out;
    //значение выхода нейрона
    private double sum;  //summator neyrona
    public static Random random = new Random ();//бъявляем и задаем класс генератора
    //случайных чиселъ
    public static final double rangeMin = -0.05;
    public static final double rangeMax = 0.05;

    public Neuron(int weightCount) {
        weight = new double[weightCount];
        out = 0.0; //устанавл выход в 0
        randomizeWeights();
    }

    public void randomizeWeights()
    {
        for (int i=0; i<weight.length; i++)
        {
            weight [i]= rangeMin+ (rangeMax -rangeMin)*random.nextDouble();
        }


    }


    private double activationFunc(double val) {
        return val >= 0 ? 1 : 0;
    }

    public void calcOut(double[] x) {
        sum = 0.0;
        for (int i = 0; i < x.length; i++)

            sum += x[i] * weight[i];

        out = activationFunc(sum);
    }

    public double[] getWeight() {
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }

    public double getOut() {
        return out;
    }


    public void correctWeights (double[] deltaWeight)
    {
        for (int i = 0; i<weight.length; i++)
        {
         weight [i]+=deltaWeight[i];
        }

    }
}