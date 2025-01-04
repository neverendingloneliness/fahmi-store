package Controller;

import java.sql.Timestamp;
import List.TransactionManager;
import Node.GadgetNode;
import Node.UserNode;
import Object.Transaction;

public class TransactionController {
    public TransactionManager transactionManager;
    private static int transactionCounter = 1;

    public TransactionController(){
        this.transactionManager = new TransactionManager();
    }

    public void createTransaction(UserNode user, GadgetNode gadget, int stock, double price){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        if (!isStockAvailable(gadget, stock)) {
            System.out.println("Transaction failed: Not enough stock for " + gadget.data.getnamaGadget());
            return;
        }
        gadget.data.setStock(gadget.data.getStock() - stock);

        Transaction newTransaction = new Transaction(transactionCounter++, user.data, gadget.data, currentTime, Transaction.Status.diproses);

        transactionManager.insert(newTransaction);
        System.out.println("Transaction created successfully with ID: " + newTransaction.getId());
    }

    public void viewAllTransaction() {
        System.out.println("Transaction List:");
        transactionManager.printList();
    }

    private boolean isStockAvailable(GadgetNode gadget, int requestedStock) {
        return gadget.data.getStock() >= requestedStock;
    }

    
    
}
