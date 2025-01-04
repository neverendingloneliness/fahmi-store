package Object;
import java.sql.Timestamp;

public class Transaction{
    public int id;
    public User user;
    public Gadget gadget;
    public Timestamp tanggalTransaksi;
    
    public enum Status{
        diterima, ditolak, diproses
    }

    public Status status;

    public Transaction(int id, User user, Gadget gadget, Timestamp tanggalTransaksi, Status status){
        this.id = id;
        this.user = user;
        this.gadget = gadget;
        this.tanggalTransaksi = tanggalTransaksi;
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public Timestamp tanggalTimestamp(){
        return tanggalTransaksi;
    }

    public User getUser(){
        return user;
    }

    public Status getStatus(){
        return status;
    }


    public Gadget getGadget(){
        return gadget;
    }

    public String info(){
        String userInfo = (user != null) ? user.info() : "user: belum ada";
        String gadgetInfo = (gadget != null) ? gadget.info() : "gadget: belum ada";
        return "Transaction ID: " + id + " | Status: " + status + " | Date: " + tanggalTransaksi + " | " + userInfo + " | " + gadgetInfo;
    }


}
