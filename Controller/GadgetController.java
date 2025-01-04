package Controller;

import List.GadgetManager;
import Node.GadgetNode;
import Object.Gadget;

public class GadgetController {
    public GadgetManager gadgetManager;

    public GadgetController() {
        this.gadgetManager = new GadgetManager();
    }

    private static int GadgetCounter = 1;

    public void creategadget( String namaGadget, double price, int stock) {
     
        Gadget newGadget = new Gadget(GadgetCounter++,namaGadget, price, stock);
        gadgetManager.insert(newGadget);
        System.out.println("Gadget registered successfully: " + namaGadget);

    }

    public void deleteGadget(String gadgetName) {
        GadgetNode node = gadgetManager.findGadgetNode(gadgetName);
        if (node != null) {
            int result = gadgetManager.delete(node.data);
            if (result == 1) {
                System.out.println("Gadget deleted successfully: " + node.data.getnamaGadget());
            } else {
                System.out.println("Failed to delete gadget.");
            }
        } else {
            System.out.println("Gadget not found: " + gadgetName);
        }
    }

    public void viewAllGadgets() {
        System.out.println("Gadget List:");
        gadgetManager.printList();
    }

    public boolean reduceGadgetStock(String gadgetName, int amount) {
        boolean result = gadgetManager.reduceStock(gadgetName, amount);
        if (result) {
            System.out.println("Stock successfully reduced for gadget: " + gadgetName);
        } else {
            System.out.println("Failed to reduce stock for gadget: " + gadgetName);
        }

        return true;
    }

     public GadgetNode findGadgetNode(String gadgetName) {
        return gadgetManager.findGadgetNode(gadgetName);
    }
}
