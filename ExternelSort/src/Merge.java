import java.io.*;
import java.util.*;

public class Merge {
    int k = 8;
    int dataNum = 51200;
    int runSize = 100;
    public Merge() throws IOException {}

    public void merging(String[] txtList) throws IOException {

        for(int i=1;i<4;i++) { //4
            BufferedReader br = new BufferedReader(new FileReader(txtList[i-1]));
            int[][] array = new int[dataNum/runSize][];
            int firstIndex = 0;

            String line;
            int linesRead = 0;

            while ((line = br.readLine()) != null) {
                if (array[firstIndex] == null) {
                    array[firstIndex] = new int[runSize];
                }
                array[firstIndex][linesRead % runSize] = Integer.parseInt(line);
                linesRead++;
                if (linesRead % runSize == 0) firstIndex++;
            }

            if(i == 1) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("run.txt"));
                for (int[] row : array) {
                    Arrays.sort(row);
                    for (int num : row) {
                        bw.write(num + "\n");
                    }
                }
                bw.flush();
                bw.close();
            }

            LoserTree loserTree = new LoserTree(array, k, runSize);
            loserTree.sorting(txtList[i]);
            runSize *= k;
            br.close();
        }
    }
}
