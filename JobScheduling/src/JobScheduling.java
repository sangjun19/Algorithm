import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobScheduling {
    public static void main(String[] args) {
        int[][] jobs = {{0, 2},{1, 6},{1, 5},{3, 7},{5, 9},{6, 8},{7, 8}};
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        System.out.println(Arrays.deepToString(jobs));

        Map<Integer, List<Integer>> machine = new HashMap<>();
        int machineCount = 0;

        for (int k = 0; k < jobs.length; k++) {
            boolean assigned = false;
            for (int i = 0; i <= machineCount; i++) {
                List<Integer> list = machine.getOrDefault(i, new ArrayList<>()); //i가 존재하면 i 반환 없으면 default 반환
                if (list.isEmpty() || jobs[list.get(list.size() - 1)][1] <= jobs[k][0]) {
                    list.add(k);
                    machine.put(i, list);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                machine.put(++machineCount, new ArrayList<>(Arrays.asList(k)));
            }
        }

        for (int i = 0; i <= machineCount; i++) {
            System.out.printf("Machine %d : ", i + 1);
            for (int jobIndex : machine.get(i)) {
                System.out.print(jobIndex + " ");
            }
            System.out.println();
        }
    }
}
