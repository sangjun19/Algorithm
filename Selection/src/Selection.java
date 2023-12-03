public class Selection {
    public Selection() { }

    public int selec(int[] num, int left, int right, int k) {
        int p = partition(num, left, right);
        int s = (p - 1) - left + 1;
        if(k <= s) return selec(num, left, p-1, k);
        else if(k == s+1) return num[p];
        else return selec(num,  p+1, right, k-s-1);
    }

    private static int partition(int[] num, int left, int right) {
        int l = left, r = right;
        l++;
        int temp;

        while(l <= r) {
            if(num[left]>num[l]) l++;
            else if(num[left]<num[r]) r--;
            else {
                temp = num[l];
                num[l] = num[r];
                num[r] = temp;
                l++;
                r--;
            }
        }

        temp = num[r];
        num[r] = num[left];
        num[left] = temp;

        return r;
    }
}
