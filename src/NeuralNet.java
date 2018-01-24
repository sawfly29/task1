/**
 * Created by Влад on 16.09.2017.
 */
public class NeuralNet {

    //алгоритм обучения НС
    private int inputVectorSize;
    private Neuron[] layer;
    private int epochNumber;
    private volatile boolean complete;
    private double [] error;
    private final double eta = 0.5;

    public NeuralNet(int inputVectorSize, int outputNeuronsCount)
    {
        this.inputVectorSize = inputVectorSize;
        layer = new Neuron[outputNeuronsCount];  //создали массив из нейронов
        for (int j=0; j<outputNeuronsCount; j++)
        {
            layer[j] = new Neuron(inputVectorSize);
        }


        error = new double[layer.length];
    }

    public int getEpochNumber() {
        return epochNumber;
    }

    public double[] getError() {
        return error;
    }


    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public void train (Vector[] vectorSet) throws  InterruptedException
    {
        epochNumber = 0;
        do
        {
            for (int m = 0; m<vectorSet.length; m++ )
            {for (int j  = 0; j<layer.length; j++)
                {
                    layer[j].calcOut(vectorSet[m].getX());
                }
            error = new double [layer.length];
                double sumError = 0;
                for (int j=0; j<layer.length; j++)
                {
                    error [j] = vectorSet[m].getDesireOutputs() [j] - layer[j].getOut();
                    sumError += error[j];
                }

                Thread.sleep(10);


                for (int j = 0; j< layer.length; j++)
                {
                    //создаем пустой массив для хранения каждого синаптического веса
                    int n = layer[j].getWeight().length;
                    double [] deltaWeight = new double [n];
                   // double [] deltaWeight = new double [layer[j].getWeight().length];
                    // вычисляем величину изменения синаптических весов wj

                    for (int i  = 0; i<n; i++)
                    {
                        deltaWeight [i]+=eta*error[j]*vectorSet [m].getX() [i];
                    }

                    //коррекция син веса
                    layer[j].correctWeights(deltaWeight);
                }
            }
epochNumber ++;
        }
        while (epochNumber<=2);
        complete=true;
    }
    public double[] test (double [] vector)
    {
        //выход каждого j ого нейрона
        double [] outVector = new double[layer.length];
        for (int j = 0; j<layer.length; j++)
        {
            layer[j].calcOut(vector);
            outVector [j] = layer[j].getOut();
        }
        return outVector;
    }
}
