package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime date;

    public Ticket(LocalDateTime localDateTime) {
        this.date = localDateTime;
    }

    public Ticket(Long id, LocalDateTime localDateTime) {
        this.id = id;
        this.date = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
