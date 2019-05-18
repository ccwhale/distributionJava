package algorithm.linkedlist;


/**
 * @author xingxi
 * @date 2019-05-05 19:43:19 星期日
 * <p>
 * 链表相关
 */
public class LinkListRelated {

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获得环的入口
     *
     * @param head
     * @return
     */
    public static int getEntrance(Node head) {
        return 1;
    }

    /**
     * 获得环的数目
     * @param head
     * @return
     */
    public static int getCycleNodes(Node head) {
        Node p1 = head;
        Node p2 = head;
        int i=0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            i++;
            if (p1 == p2) {
                break;
            }
        }
        return i;
    }

    public void testIsCycle() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        System.out.println(getCycleNodes(node1));
        System.out.println(isCycle(node1));

    }
}
