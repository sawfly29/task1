/**
 * Created by Влад on 09.09.2017.
 */
public class Solution {
    public static void main(String[] args) {

        Neuron and2Neural = new Neuron (3); //создаем нейрон с 3 син.весами
        double [] weights = {-1.5, 1.0, 1.5} ;
        and2Neural.setWeight(weights);

        double [] testVector1 = {1.0, 1.0, 1.0};
        and2Neural.calcOut (testVector1);
        System.out.println (and2Neural.getOut());
    };
}
