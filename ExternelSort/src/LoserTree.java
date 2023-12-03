import java.io.*;
import java.util.Arrays;

public class LoserTree {
    private int k;
    private int runSize;
    private int[][] array;
    private int[] tree;
    private int[][] tempArray;
    public LoserTree(int[][] array, int k, int runSize) {
        this.k = k;
        this.runSize = runSize;
        this.array = array;
        tree = new int[k*2];
    }

    public void sorting(String txtName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(txtName));
        tempArray = new int[array.length/k][]; //배열 첫 번째 차원 크기 축소

        for(int l=0;l<array.length;l+=k) { //생성되는 tree의 개수만큼 6400 (array.length/k)
            tempArray[l/8] = new int[runSize*k]; //배열 두 번째 차원 크기 확대
            Arrays.fill(tree, Integer.MAX_VALUE); //min을 찾기 위해 초기화

            for(int m=0;m<runSize*k;m++) { //한 트리를 만들때 사용될 데이터 수
                for(int i=l;i<k+l;i++) { //tree의 리프노드 수 만큼 (array[i] 접근 위해 k+l)
                    //100*512 -> 800*64
                    if(tree[k+i%k] != Integer.MAX_VALUE) continue; //비어 있지 않으면 패스
                    for(int j=0;j<runSize;j++) { //array 두 번째 차원의 데이터 수
                        if(array[i][j] != -1) { //비어있지 않으면
                            tree[k+i%k] = array[i][j];
                            array[i][j] = -1; //빈칸 표시
                            break;
                        }
                    }
                }
                //tree 처리
                makeTree(l/8, m);
            }
        }

        for (int[] ii : tempArray) {
            for (int intNum : ii) {
                bw.write(intNum +"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private void makeTree(int i_index, int j_index) {
        int temp = 1;
        int[] tempTree = Arrays.copyOf(tree, tree.length); //deep copy
        for(int l=1;l<=3;l++) { //log2(k)
            for(int i=k/temp;i<k*2;i+=2) { //각 깊이의 첫 번째 노드 인덱스 에서 2씩 증가 8 4 2 1
                tree[i/2] = Math.max(tempTree[i], tempTree[i+1]); //loser
                tempTree[i/2] = Math.min(tempTree[i], tempTree[i+1]); //winner
            }
            temp *= 2;
        }
        tree[0] = tempTree[1]; //winner
        tempArray[i_index][j_index] = tree[0];
        deleteTree(tree[0]);
    }

    private void deleteTree(int num) {
        for(int m=k;m<k*2;m++) {
            if(tree[m] == num) {
                tree[m] = Integer.MAX_VALUE;
                return;
            }
        }
    }
}
