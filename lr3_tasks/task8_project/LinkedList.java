package task8_project;
import java.util.Scanner;

public class LinkedList {

    public static final Scanner in = new Scanner(System.in);

    public static Node createHead() {
        Node head = null;
        System.out.println("Введите длину списка ");
        int listLength = in.nextInt();

        if (listLength <= 0) {
            return null;
        }

        for (int i = listLength; i > 0; i--) {
            System.out.println("Введите элемент ");
            head = new Node(in.nextInt(), head);
        }

        return head;
    }

    public static Node createTail() {
        System.out.println("Введите длину списка ");
        int listLength = in.nextInt();
        Node head, current;
        
        if (listLength <= 0) {
            return null;
        }

        System.out.println("Введите элемент ");
        head = new Node(in.nextInt(), null);
        current = head;

        for (int i = 0; i < listLength - 1; i++) {
            System.out.println("Введите элемент ");
            current.next = new Node(in.nextInt(), null);
            current = current.next;
        }

        return head;

    }

    public static void toString(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public static Node addFirst(Node head) {
        System.out.println("Введите элемент ");
        Node firstNode = new Node(in.nextInt(), head);
        head = firstNode;

        return head;
    }

    public static Node addLast(Node head) {

        if (head == null) {
            System.out.println("Введите элемент ");
            return new Node(in.nextInt(), null);
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        System.out.println("Введите элемент ");
        Node lastNode = new Node(in.nextInt(), null);
        current.next = lastNode;

        return head;
    }

    public static Node Insert(Node head) {
        if (head == null) {
            return null;
        }

        System.out.println("Введите порядковый номер элемента для вставки и само значение, через пробел ");
        int position = in.nextInt();
        int value = in.nextInt();

        if (position <= 0) {
            System.out.println("Позиция должна быть >= 1");
            return head;
        }

        if (position == 1) {
            return addFirst(head);
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Позиция вне диапазона");
                return head;
            }
            current = current.next;
        }

        Node newNode = new Node(value, current.next);
        current.next = newNode;

        return head;
    }

    public static Node removeFirst(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    public static Node removeLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        
        return head;
    }

    public static Node remove(Node head) {
        System.out.println("Введите номер в списке, который требуется удалить ");
        int position = in.nextInt();

        if (head == null || position <= 0) {
            System.out.println("Позиция должна быть >= 1");
            return head;
        }

        if (position == 1) {
            return removeFirst(head);
        }

        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current.next == null) {
                System.out.println("Выход за диапазон");
                return head;
            }
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Выход за диапазон");
            return head;
        }

        current.next = current.next.next;
        
        return head;
    }


    public static Node createHeadRec() {
        Node head = null;
        System.out.println("Введите длину списка ");
        int listLength = in.nextInt();

        if (listLength <= 0) {
            return null;
        }

        return createHeadRecHelper(head, listLength);
    }

    private static Node createHeadRecHelper(Node head, int leftPositions) {
        if (leftPositions == 0) {
            return head;
        }

        System.out.println("Введите элемент ");
        head = new Node(in.nextInt(), head);
        return createHeadRecHelper(head, leftPositions - 1);
    }

    public static Node createTailRec() {
        System.out.println("Введите длину списка ");
        int listLength = in.nextInt();

        if (listLength <= 0) {
            return null;
        }

        System.out.println("Введите элемент ");
        Node head = new Node(in.nextInt(), null);
        return createTailRecHelper(head, listLength - 1);
    }

    private static Node createTailRecHelper(Node head, int leftPositions) {
        if (leftPositions == 0) {
            return head;
        }

        System.out.println("Введите элемент ");
        Node current = new Node(in.nextInt(), null);
        head.next = current;
        return createTailRecHelper(current, leftPositions - 1);
    }

    public static void toStringRec(Node head) {
        if (head != null) {
            System.out.print(head.value + " ");
            toStringRec(head.next);
        }
    }
}
