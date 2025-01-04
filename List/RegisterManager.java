package List;

import Node.UserNode;
import Object.User;


public class RegisterManager {
    public UserNode head;
    
    public int insert(User data){
        UserNode nn = new UserNode(data); 
        UserNode current = head; 

        if (current == null) {
            nn.next = null;
            head = nn;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nn;
        }
        return 1;
    }
    public void printList() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.data.info() + " ");
            current = current.next;
        }
    }
}
