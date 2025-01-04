package Controller;
import List.RegisterManager;
import Node.UserNode;
import Object.User;
public class RegisterController {

    public RegisterManager registerManager;

    public RegisterController() {
        this.registerManager = new RegisterManager();
    }

    private static int UserCounter = 1;
    
    public User createAcoount(String username, String email, String password) {
        email = email.trim();
        password = password.trim();

        User newUser = new User(UserCounter++, username, email, password, User.Role.User);
        registerManager.insert(newUser);
        System.out.println("User registered successfully: " + email);

        return newUser;

    }

    public User createAcoountAdmin(String username, String email, String password) {
        email = email.trim();
        password = password.trim();

        User newUser = new User(UserCounter++, username, email, password, User.Role.Admin);
        registerManager.insert(newUser);
        System.out.println("Admin registered successfully: " + email);

        return newUser;

    }

    public void viewAllUsers() {
        System.out.println("User List:");
        registerManager.printList();
    }

      public UserNode getUserListHead() {
        return registerManager.head;
    }

    
}
