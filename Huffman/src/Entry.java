public class Entry {
    private int    frequency;  // �� ��
    private String word;       // ���ĸ� ����� ���� �Ǵ� ���γ���� �ռ��� ���ڿ�
    private Entry  left;       // ���� �ڽ�
    private Entry  right;      // ������ �ڽ�
    private String code;       // ������ �ڵ�

    public Entry (int newFreq, String newValue, Entry l, Entry r, String s){
        frequency = newFreq;
        word  = newValue;
        left  = l;
        right = r;
        code  = s;
    }
    public int    getKey()   { return frequency; }
    public String getValue() { return word; }
    public String getCode()  { return code; }
    public Entry  getLeft()  { return left; }
    public Entry  getRight() { return right; }

    public void   setCode(String newCode) { code = newCode; }
}
