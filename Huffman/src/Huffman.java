import java.util.*;

public class Huffman {
    private Entry[] s;
    private int size;
    PriorityQueue<Entry> pq;
    Queue<Entry> q;
    Comparison comparison;

    static class Comparison implements Comparator<Entry> {
        public int compare(Entry x, Entry y) {
            return Integer.compare(x.getKey(), y.getKey());
        }
    }

    public Huffman(Entry[]s_, int size_) {
        s = s_;
        size = size_;
        comparison = new Comparison();
        pq = new PriorityQueue<>(comparison);
    }

    public void createHeap() {
        pq.addAll(Arrays.asList(s));
        s = pq.toArray(new Entry[0]);
    }

    public void print() {
        for(Entry e: s) System.out.print(e.getValue()+" ");
        System.out.println();
    }

    public Entry createTree() {
        while(pq.size() > 1) {
            Entry l = pq.poll();
            Entry r = pq.poll();
            Entry newE = new Entry(l.getKey()+r.getKey(),null, l, r, null);
            pq.add(newE);
        }
        binary(pq.peek(),"");
        return pq.poll();
    }

    private void binary(Entry root, String str) {
        if (root != null) {
            root.setCode(str);
            binary(root.getLeft(), str+"0");
            binary(root.getRight(), str+"1");
        }
    }

    public void preorder(Entry root) {
        if (root != null) {
            if(root.getValue()!=null) System.out.println(root.getValue()+" : "+root.getCode());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }
}
