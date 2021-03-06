package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Ticket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/api/tickets")
@RestController
public class TicketController {

    private final TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    //méthode pour avoir la liste de tous les tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    }





    //méthode pour avoir un ticket en particulier
    @GetMapping("/{id}")//@PathVariable le variable apres /...
    public Ticket getTicket(@PathVariable Long id) {
        return ticketDao.get(id);
    }

    //méthode pour enregistrer un ticket

    @PostMapping
    //@PathVariable ne marche que si on est sur une variable qui sera apres l'url /"variable"
   // pour un object on utilise le @Request body
   public void addTicket(@RequestBody  Ticket ticket)  {
        ticketDao.save(ticket);
    }

    //méthode pour suppimer un ticket
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketDao.delete(id);
    }

    //méthode pour modifier un ticket à partir de  l' id pour modifier le nom de l'apprenant
    @PutMapping("/{id}")
    public void updateTicket(@PathVariable long id){
        ticketDao.update(id);
    }



    // apprenant fait le plus de tickets ?

    @GetMapping("/most")

    public String getBestLearner() throws SQLException {
        // Je récupère la connection à la base
        Connection dbConnection= ticketDao.getJdbcTemplate().getDataSource().getConnection();


        // Je prépare ma requête
        String  result = "";

        String selectReq = "select nom_apprenant, count(t.id) nb\n"+
                "from learner join ticket t on learner.id_apprenant = t.idx_apprenant\n"+
                " group by nom_apprenant order by nb desc limit 1;";

        try (PreparedStatement statement = dbConnection.prepareStatement(selectReq)) {
            // J'exécute ma requête
            ResultSet set = statement.executeQuery();


            System.out.println("L'apprenant avec le plus de ticket est : ");
            while (set.next()) {
                System.out.print(set.getString("nom_apprenant"));
                System.out.print(" - nombre de ticket:");
                System.out.println(set.getInt("nb"));
                result="L'apprenant avec le plus de ticket est :"+set.getString("nom_apprenant")+ " avec un nombre de tickets de :"+ set.getInt("nb");
            }

            set.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        // Je retourne le resultat
        return result;
    }


// Quelle promo fait le plus de tickets ? ?

    @GetMapping("/promo")

    public String promo() throws SQLException {
        // Je récupère la connection à la base
        Connection dbConnection= ticketDao.getJdbcTemplate().getDataSource().getConnection();


        // Je prépare ma requête
        String  result = "";

        String selectReq = "select promotion,count(t.id) nb1\n" +
                "from learner join ticket t on learner.id_apprenant = t.idx_apprenant\n" +
                "group by promotion\n" +
                "order by nb1 desc\n" +
                "limit 1;";

        try (PreparedStatement statement = dbConnection.prepareStatement(selectReq)) {
            // J'exécute ma requête
            ResultSet set = statement.executeQuery();



            while (set.next()) {

                result="La promo avec le plus de ticket est :"+set.getString("promotion")+ " avec un nombre de tickets de :"+ set.getInt("nb1");
            }

            set.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        // Je retourne le resultat
        return result;
    }

}
