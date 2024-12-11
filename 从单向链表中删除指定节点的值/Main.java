package 从单向链表中删除指定节点的值;

/**
 * @author klhu03
 * @since 2024/12/11 17:00
 **/

/**
 * @author klhu03
 * @since 2024/12/11 17:00
 **/
import java.util.Scanner;

class Node {
    int data;
    Node down;
    Node up;
    Node(int d) {
        data = d;
        up = null;
        down = null;
    }
    Node(int d, Node down, Node up) {
        data = d;
        this.up = up;
        this.down = down;
    }
}

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        Node head = new Node(in.nextInt());
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            Node temp = search(head, b);
            Node node = new Node(a, temp.down, temp);
            if(temp.down != null){
                temp.down.up = node;
            }
            temp.down = node;
        }
        int key = in.nextInt();
        Node temp = search(head, key);
        Node up = temp.up;
        Node down = temp.down;
        up.down = down;
        down.up = up;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.down;
        }
    }
    static Node search(Node head, int key) {
        Node temp = head;
        while (temp != null) {

            if (temp.data == key) {
                return temp;
            }
            temp = temp.down;
        }
        return null;
    }
}
