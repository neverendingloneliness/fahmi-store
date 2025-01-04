package Node;

import Object.Transaction;

public class TransactionNode {
    public Transaction data;
    public TransactionNode next;

    public TransactionNode(Transaction data){
        this.data = data;
        next = null;
    }

    public String info(){
        return data.info();
    }
}
