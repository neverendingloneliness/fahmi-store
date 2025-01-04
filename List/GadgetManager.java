package List;

import Node.GadgetNode;
import Node.UserNode;
import Object.Gadget;

public class GadgetManager {
    GadgetNode head;

    public int insert(Gadget data){
        GadgetNode nn = new GadgetNode(data); 
        GadgetNode current = head; 

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

    public GadgetNode findGadgetNode(String gadgetName) {
        GadgetNode current = head;
        while (current != null) {
            if (current.data.getnamaGadget().equalsIgnoreCase(gadgetName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int delete(Gadget data){
        if(head == null){
            System.out.println("List gadget kosong");
            return -1;
        }

        GadgetNode current = head;
        GadgetNode previous = null;

        if(current.data.getnamaGadget().equalsIgnoreCase(data.getnamaGadget())){
            head = current.next;
            System.out.println("Deleted : " + data.getnamaGadget());
            return 1;
        }

        while (current != null && !current.data.getnamaGadget().equalsIgnoreCase(data.getnamaGadget())) {
            previous = current;
            current = current.next;
        }

        if(current == null){
            System.out.println("Data gadget tidak ditemukan di dalam list");
            return -1;
        }

        previous.next = current.next;
        System.out.println("Deleted: " + data);
        return 1;
    }

    public void printList() {
        GadgetNode current = head;
        while (current != null) {
            System.out.println(current.data.info() + " ");
            current = current.next;
        }
    }

    public boolean reduceStock(String gadgetName, int amount) {

        if (head == null){
            System.out.println("There's no stock for the product");
            return false;
        }

        if (amount < 0){
            System.out.println("Its value cant be negative");
            return false;
        }

        GadgetNode current = head;
        while (current != null) {
            if (current.data.getnamaGadget().equalsIgnoreCase(gadgetName)) {
                int currentStock = current.data.getStock();
                if (currentStock >= amount) {
                    current.data.setStock(currentStock - amount);
                    System.out.println("Stock reduced. Remaining stock of " + gadgetName + ": " + current.data.getStock());
                    return true;
                } else {
                    System.out.println("Not enough stock for " + gadgetName);
                    return false;
                }
            }
            current = current.next;
        }
        System.out.println("Gadget not found: " + gadgetName);
        return false;
    }


    
}
