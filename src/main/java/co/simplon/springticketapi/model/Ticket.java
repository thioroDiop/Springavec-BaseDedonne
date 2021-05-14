package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {

    private long id;
    private LocalDateTime date;
   private String description;
   private boolean resolve;
    private long idxApprenant;

/*
    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }

    public Ticket( LocalDateTime localDateTime,String description,String apprenant) {
       this.date = localDateTime;
        this.description=description;
        this.apprenant=apprenant;
    }
*/

    public Ticket(long id, LocalDateTime localDateTime, String description, boolean resolve, long idxApprenant) {
        this.id = id;
        this.date = localDateTime;
        this.description=description;
        this.resolve = resolve;
        this.idxApprenant = idxApprenant;
    }



    public Long getId() {
        return id;
    }

    public long getIdxApprenant() {
        return idxApprenant;
    }
    public String getDescription() {
        return description;
    }

    public boolean getResolve() {
        return resolve;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResolve(boolean resolve) {
        this.resolve = resolve;
    }

//    @Override
//    public String toString() {
//        return "Quote {" +
//                "id=" + id +
//                ", content='" + content + '\'' +
//                ", characterIdx=" + characterIdx +
//                '}';
//    }


}
