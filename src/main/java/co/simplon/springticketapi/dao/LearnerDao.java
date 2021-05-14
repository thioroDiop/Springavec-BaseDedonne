package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Learner> learnerRowMapper;

    public LearnerDao(JdbcTemplate jdbcTemplate, RowMapper<Learner> learnerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.learnerRowMapper = learnerRowMapper;
    }
    @Override
    public Learner get(Long id) {
        // A vous de jouer
        return jdbcTemplate.queryForObject("Select * from learner Where id_apprenant =?", learnerRowMapper, id);

    }

    @Override
    public List<Learner> getAll() {
        return jdbcTemplate.query("Select * from learner  ", learnerRowMapper);

    }

    @Override
    public void save(Learner learner) {
        // A vous de jouer
        jdbcTemplate.queryForObject("INSERT INTO learner (id_apprenant, nom_apprenant,prenom_apprenant)\n" +
                "VALUES ( '"+learner.getId_apprenant()+"', '"+learner.getNom_apprenant()+"','"+learner.getPrenom_apprenant()+"')", learnerRowMapper );
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.queryForObject("DELETE  from learner Where id_apprenant=?", learnerRowMapper, id);
    }


    // methode pour modifier un nom dans la table apprenant(learner)
    @Override
    public void update(Long id){
        jdbcTemplate.queryForObject("UPDATE learner SET nom_apprenant = nouveau Where id_apprenant =?", learnerRowMapper, id);
    }
}
