package algorithm.linkedlist;

import junit.framework.TestCase;

/**
 * @author xingxi
 * @date 2019-05-05 19:43:19 星期日
 * <p>
 * 链表相关
 */
public class LinkListRelated extends TestCase {

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

    public void testIsCycle(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

    }
}
