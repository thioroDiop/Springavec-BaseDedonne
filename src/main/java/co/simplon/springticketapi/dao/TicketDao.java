package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDao implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }

    @Override
    //pourquoi  en paremetre on a la classe Long et non le type "long"?
    public Ticket get(Long id) {
        return jdbcTemplate.queryForObject("select * from ticket where id = ?", ticketRowMapper, id);
    }

    @Override
    public List<Ticket> getAll() {
        return jdbcTemplate.query("select * from ticket", ticketRowMapper);
    }

    //methode pour ajouter une nouveau ticket
    @Override
//    public void save(Ticket ticket) {
//      jdbcTemplate.queryForObject ("INSERT INTO ticket (id,date, description,resolve,idx_apprenant) VALUES ('" + ticket.getId() + "','" + ticket.getDate()+ "','" + ticket.getDescription()+ "','" + ticket.getResolve()  + "')", ticketRowMapper);
//    }


    public void save(Ticket ticket) {
        System.out.println(ticket.getIdxApprenant());
        // A vous de jouer
        jdbcTemplate.update("INSERT INTO ticket (id, date, description,resolve,idx_apprenant)" +
                "VALUES (DEFAULT , now(), ?,false,?)",ticket.getDescription(), ticket.getIdxApprenant() );

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE  from ticket Where id =?", id);
        // A vous de jouer
    }

    @Override
    //quel type de modif faire, sachant que le lien est maintenant la FK idx_apprenant?
    public void update(Long id) {
        jdbcTemplate.update("UPDATE ticket SET resolve = true Where id =?", id);
        // A vous de jouer
    }








}
