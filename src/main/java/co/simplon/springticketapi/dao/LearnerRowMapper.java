package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LearnerRowMapper implements RowMapper<Learner> {

    @Override
    public Learner mapRow(ResultSet resultSet, int i) throws SQLException {
        // A vous de jouer
        return new Learner(resultSet.getLong("id_apprenant"),
                    resultSet.getString("nom_apprenant"),
                    resultSet.getString("prenom_apprenant"));
        }

    }
