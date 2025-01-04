package Node;

import Object.User;

public class UserNode {
    public User data;
    public UserNode next;

    public UserNode(User data){
        this.data = data;
        next = null;
    }

    public String info(){
        return data.info();
    }
}