public class UnionFind {
    protected int[] p;
    protected int[] rank;

    public UnionFind(int N) {
        p = new int[N];
        rank = new int [N];
        for(int i=0;i<N;i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    protected int find(int i) {
        if(i != p[i]) {
            p[i] = find(p[i]);
        }
        return p[i];
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);
        if(iroot == jroot) return;

        if(rank[iroot] > rank[jroot]) {
            p[jroot] = iroot;
        }
        else if(rank[iroot] < rank[jroot]) {
            p[iroot] = jroot;
        }
        else {
            p[jroot] = iroot;
            rank[iroot]++;
        }
    }
}
