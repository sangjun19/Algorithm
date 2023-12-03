public class Main {
    public static void main(String[] args)	{
        Entry[] a;  // a[0]�� ��� ����
        a = new Entry[6];

        a[0] = new Entry(60, "a", null, null, null);
        a[1] = new Entry(20, "b", null, null, null);
        a[2] = new Entry(30, "c", null, null, null);
        a[3] = new Entry(35, "d", null, null, null);
        a[4] = new Entry(40, "e", null, null, null);
        a[5] = new Entry(90, "f", null, null, null);

        Huffman h = new Huffman(a,6);
        System.out.print("Before Sort : ");
        h.print();

        h.createHeap();
        System.out.print("Priority Queue : ");
        h.print();

        System.out.println("Huffman Code : ");
        Entry root = h.createTree();
        h.preorder(root);
        System.out.println();
    }
}
