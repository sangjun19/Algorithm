import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClosestPair {
    public static void main(String[] args) {
        int[][] num = {{0, 1}, {1, 3}, {5, 11}, {2, 3}, {2, 12}, {0, 4}};
        Arrays.sort(num, (n1, n2)->n1[0]-n2[0]);
        System.out.println(Arrays.deepToString(num));
        Double closestDistance = Math.sqrt(closestPair(num, 0, num.length-1));
        System.out.println("Min Dist : "+closestDistance);
        System.out.print("Closest Pair : ");

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int dx = num[i][0] - num[j][0];
                int dy = num[i][1] - num[j][1];
                int distance = dx * dx + dy * dy;

                if(Math.sqrt(distance) == closestDistance) {
                    System.out.print("("+num[i][0]+","+num[i][1]+"),("+num[j][0]+","+num[j][1]+") ");
                }
            }
        }
    }

    public static int dist(int i, int j, int x, int y) {
        return ((i-x)*(i-x))+((j-y)*(j-y));
    }

    static int closest(int[][] num, int start, int end) {
        int m = Integer.MAX_VALUE;
        for(int i=start;i<end;i++) {
            for(int j=i+1;j<=end;j++) {
                int d = dist(num[i][0],num[i][1],num[j][0],num[j][1]);
                m = Math.min(d, m);
            }
        }
        return m;
    }

    public static int closestPair(int[][] num, int start, int end) {

        int n = end - start + 1;
        if(n<=3) {
            return closest(num, start, end);
        }

        int center = (start+end)/2;
        int d = Math.min(closestPair(num, start, center), closestPair(num, center+1, end));

        ArrayList<Point> arr = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int t = num[center][0] - num[i][0];
            if (t * t < d) {
                arr.add(new Point(num[i][0], num[i][1]));
            }
        }

        arr.sort((n1, n2) -> n1.y - n2.y);

        for(int i=0;i<arr.size()-1;i++) {
            for(int j=i+1;j<arr.size();j++) {
                int t = arr.get(j).y - arr.get(i).y;

                if(t*t<d) {
                    d = Math.min(d, dist(arr.get(i).x, arr.get(i).y, arr.get(j).x, arr.get(j).y));
                }
                else {
                    break;
                }
            }
        }

        return d;
    }
}