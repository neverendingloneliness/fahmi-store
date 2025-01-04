package List;

import Node.UserNode;
import Object.User;

public class LoginManager {
    public UserNode head;     

    public User login(String email, String password){
        UserNode current = head;
        
        while (current != null) {
            User user = current.data;
            if (user.getEmail().trim().equalsIgnoreCase(email.trim()) && 
                user.getPassword().trim().equals(password.trim())) {
            return user; 
        }

            current = current.next;
        }
        return null;
    }
    public void printList() {
        UserNode current = head;
        while (current != null) {
            System.out.println(current.data.info() + " ");
            current = current.next;
        }
    }

    public UserNode findUserNode(String email) {
        UserNode current = head;
        while (current != null) {
            if (current.data.getEmail().equalsIgnoreCase(email)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
