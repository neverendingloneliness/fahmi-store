import Controller.GadgetController;
import Controller.LoginController;
import Controller.RegisterController;
import Controller.TransactionController;
import Node.GadgetNode;
import Node.UserNode;
import Object.User;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        GadgetController gadgetController = new GadgetController();
        RegisterController registerController = new RegisterController();
        LoginController loginController = new LoginController();
        TransactionController transactionController = new TransactionController();
        showMainMenu(registerController, loginController, gadgetController, transactionController);

    }

    static void showMainMenu(RegisterController registerController, LoginController loginController, 
                           GadgetController gadgetController, TransactionController transactionController) {
        Scanner inp = new Scanner(System.in);
        int pilihan;
        User loggedInUser = null;

        gadgetController.creategadget("xiaomi", 1400000, 6);
        gadgetController.creategadget("apple", 1400000, 6);
        gadgetController.creategadget("samsung", 1400000, 6);
        
        registerController.createAcoount("ivan", "ivan@mail", "123");
        registerController.createAcoount("tejo", "tejo@mail", "123");
        registerController.createAcoount("farhan kebab", "kebab0@mail", "123");
        registerController.createAcoountAdmin("admin", "admin@mail", "123");

        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Register Admin");
            System.out.println("3. Login");
            System.out.println("0. Exit");
            System.out.print("Masukkan Pilihanmu: ");
            pilihan = inp.nextInt();
            inp.nextLine();

            switch (pilihan) {
                case 1:
                    registerUser(inp, registerController);
                    break;
                case 2:
                    registerAdmin(inp, registerController);
                    break;
                case 3:
                    loginController.loadRegisteredUser(registerController);
                    loggedInUser = performLogin(inp, loginController);
                    if (loggedInUser != null) {
                        if (User.Role.Admin.equals(loggedInUser.getRole())) {
                            showAdminMenu(inp, loggedInUser, registerController, gadgetController, transactionController);
                        } else {
                            showUserMenu(inp, loggedInUser, loginController, gadgetController, transactionController);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (pilihan != 0);
    }

    private static void showAdminMenu(Scanner inp, User admin, RegisterController registerController,
                                    GadgetController gadgetController, TransactionController transactionController) {
        int choice;
        do {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View All Registered Users");
            System.out.println("2. View All Gadgets");
            System.out.println("3. Add Gadget");
            System.out.println("4. Remove Gadget");
            System.out.println("5. View All Transactions");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Registered Users -----");
                    registerController.viewAllUsers();
                    break;
                case 2:
                    System.out.println("----- View All Gadgets -----");
                    gadgetController.viewAllGadgets();
                    break;
                case 3:
                    addGadget(inp, gadgetController);
                    break;
                case 4:
                    removeGadget(inp, gadgetController);
                    break;
                case 5:
                    System.out.println("----- History Transaksi -----");
                    transactionController.viewAllTransaction();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void showUserMenu(Scanner inp, User user, LoginController loginController,
                                   GadgetController gadgetController, TransactionController transactionController) {
        int choice;
        do {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. View Available Gadgets");
            System.out.println("2. Buy Gadgets");
            System.out.println("3. View Transaction History");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = inp.nextInt();
            inp.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Available Gadgets -----");
                    gadgetController.viewAllGadgets();
                    break;
                case 2:
                    performPurchase(inp, user, loginController, gadgetController, transactionController);
                    break;
                case 3:
                    System.out.println("----- History Transaksi -----");
                    transactionController.viewAllTransaction();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void registerUser(Scanner inp, RegisterController registerController) {
        System.out.print("Enter username: ");
        String username = inp.nextLine();
        System.out.print("Enter email: ");
        String email = inp.nextLine();
        System.out.print("Enter password: ");
        String password = inp.nextLine();
        registerController.createAcoount(username, email, password);
    }

    private static void registerAdmin(Scanner inp, RegisterController registerController) {
        System.out.print("Enter admin username: ");
        String adminUsername = inp.nextLine();
        System.out.print("Enter admin email: ");
        String adminEmail = inp.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = inp.nextLine();
        registerController.createAcoountAdmin(adminUsername, adminEmail, adminPassword);
    }

    private static User performLogin(Scanner inp, LoginController loginController) {
        System.out.print("Enter email: ");
        String loginEmail = inp.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = inp.nextLine();
        return loginController.Login(loginEmail, loginPassword);
    }

    private static void addGadget(Scanner inp, GadgetController gadgetController) {
        System.out.print("Enter gadget name: ");
        String gadgetName = inp.nextLine();
        System.out.print("Enter gadget price: ");
        double price = inp.nextDouble();
        System.out.print("Enter gadget stock: ");
        int stock = inp.nextInt();
        gadgetController.creategadget(gadgetName, price, stock);
        System.out.println("Gadget added successfully!");
    }

    private static void removeGadget(Scanner inp, GadgetController gadgetController) {
        System.out.print("Enter gadget name: ");
        String gadgetName = inp.next();

        gadgetController.deleteGadget(gadgetName);
        System.out.println("Gadget removed successfully!");
    }

    private static void performPurchase(Scanner inp, User user, LoginController loginController,
                                      GadgetController gadgetController, TransactionController transactionController) {
        System.out.println("----- Beli Gadget -----");
        gadgetController.viewAllGadgets();
        System.out.print("Enter gadget name: ");
        String gadgetName = inp.nextLine();
        System.out.print("Enter how much you wanted to buy: ");
        int stock = inp.nextInt();
        
        if (stock <= 0) {
            System.out.println("Purchase failed: Invalid quantity. Please enter a positive value.");
            return;
        }

        boolean purchaseSuccess = gadgetController.reduceGadgetStock(gadgetName, stock);
        
        if (purchaseSuccess) {
            GadgetNode gadgetNode = gadgetController.gadgetManager.findGadgetNode(gadgetName);
            UserNode userNode = loginController.findUserNode(user.getEmail());

            if (gadgetNode != null && userNode != null) {
                transactionController.createTransaction(
                    userNode,
                    gadgetNode,
                    stock,
                    gadgetNode.data.getPrice() * stock
                );
                System.out.println("Gadget bought successfully!");
            }
        } else {
            System.out.println("Purchase failed. Please check stock availability.");
        }
    }
}