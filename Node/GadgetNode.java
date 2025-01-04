package Node;

import Object.Gadget;

public class GadgetNode {
    public Gadget data;
    public GadgetNode next;

    public GadgetNode (Gadget data){
        this.data = data;
        data = null;
    }

    public String info(){
        return data.info();
    }

}
