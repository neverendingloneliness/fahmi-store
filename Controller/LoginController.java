package Controller;

import List.LoginManager;
import List.RegisterManager;
import Node.UserNode;
import Object.User;

public class LoginController {

    public LoginManager loginManager;

    public LoginController() {
        this.loginManager = new LoginManager();
    }
    
    public User Login(String email, String password){
        System.out.println("Debug Input -> Email: " + email + ", Password: " + password);
        
        User loggedInUser = loginManager.login(email, password);
        if (loggedInUser != null) {
            System.out.println(loggedInUser);
            System.out.println("Login successful! Welcome, " + loggedInUser.getEmail() + " (" + loggedInUser.getRole() + ")");
        } else {
            System.out.println(loggedInUser);
            System.out.println("Invalid email or password.");
        }
        return loggedInUser;
    }
    public void loadRegisteredUser(RegisterController registerController){
        this.loginManager.head = registerController.getUserListHead();
    }

    public UserNode findUserNode(String email) {
        return loginManager.findUserNode(email);
    }

}