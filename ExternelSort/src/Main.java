import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] txtList= {"data.txt", "run1.txt", "run2.txt", "result.txt"};
        for (String s : txtList) {
            File deleteFile = new File(s);
            if (deleteFile.exists()) {
                deleteFile.delete();
            }
        }
        File dFile = new File("run.txt");
        if(dFile.exists()) dFile.delete();

        BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
        Random random = new Random();
        for(int i=0;i<51200;i++) {
            bw.write(random.nextInt(100000) +"\n");
        }
        bw.flush();
        bw.close();
        Merge merge = new Merge();
        merge.merging(txtList);
    }
}