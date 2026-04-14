

class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
    }
}

public class LinkedList {

    
    public static ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    public static boolean isPallindrome(ListNode head){
        if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow);
        ListNode temp = newHead;
        slow = head;
        while(temp!=null){
            if(slow.data!=temp.data) return false;
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }

    public static ListNode mergeTwoList(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }
        if(temp1==null) temp.next = temp2;
        if(temp2==null) temp.next = temp1;
        return dummy.next;
    }

    public boolean isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            if(slow==fast)return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public ListNode AddTwoNumber(ListNode head1,ListNode head2){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        int carry = 0;
        while(temp1!=null||temp2!=null||carry>0){
            int val1 = temp1!=null? temp1.val : 0;
            int val2 = temp2!=null? temp2.val : 0;
            int sum = val1+val2+carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;
            temp = temp.next;
            temp1 = temp1!=null? temp1.next:0;
            temp2 = temp2!=null? temp2.next:0;
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static ListNode addTwoNumber(ListNode head1,ListNode head2){
        return helperFunc(head1,head2,0);
    }
    public static ListNode helperFunc(ListNode head1,ListNode head2,int carry){
        if(head1==null && head2==null && carry==0) return null;
        int sum = carry;
        if(head1!=null) sum+=head1.val;
        if(head2!=null) sum+=head2.val;
        ListNode node = ListNode(sum%10);
        node.next = helperFunc(head1!=null?head1.next:0,head2!=null?head2.next:null,carry);
        return node;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast==null) return head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
       
       
       
       
       
        
    }


}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key,int value){
        this.key = key;
        this.value = value;
    }

}

class LRUCache{
    private int capacity;
    private Map<Integer,Node>map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev  = head;
    }
    public void addInFront(Node node){
        node.next = head.next;
        node.prev= head;
        head.next.prev = node;
        head.next = node;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToFront(Node node){
        removeNode(node);
        addInFront(node);
    }
     private int removeLRU() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru.key;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                int lruKey = removeLRU();
                map.remove(lruKey);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

