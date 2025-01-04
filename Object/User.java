package Object;

public class User{
    public int id;
    public String username;
    public String email;
    public String password;


    // Define Role Cak
    public enum Role{
        Admin, User
    }

    // Nambah manja
    private Role role;

    // Constructor walah
    public User(int id, String username, String email, String password, Role role){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = Role.User;
    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

   
    public String getEmail(){
        return email;
    }


    public String getPassword(){
        return password;
    }


    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public String info(){
        return "ID: " + id + ", Username: " + username + ", Email: " + email + ", Role: " + role; 
    }

}
