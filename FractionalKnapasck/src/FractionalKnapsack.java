public class FractionalKnapsack {
    public static void main(String[] args) {
        int N = 4;
        int cap = 110;
        double[] weight = {10, 15, 25, 50};
        double[] unit_value = {60, 50, 4, 1};
        int value = 0;
        int i=-1;
        System.out.print("unit : ");
        while(true) {
            i++;
            if(i == N) break;
            System.out.print(i+" ");
            if(cap-weight[i]<0) {
                value+=(unit_value[i]*cap);
                break;
            }
            cap -= weight[i];
            value += unit_value[i]*weight[i];
        }
        System.out.println("\nvalue: "+value);
        //System.out.println("remain_weight: "+cap);
    }
}