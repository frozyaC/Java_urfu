public class task7_tail {
    public static void main(String[] args) {
        
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        
        node3.next = node2;
        node2.next = node1;
        node1.next = node0;

        Node ref = node3;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}
