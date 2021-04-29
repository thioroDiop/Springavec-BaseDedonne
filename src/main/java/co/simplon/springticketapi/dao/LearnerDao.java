package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {

    @Override
    public Learner get(Long id) {
        // A vous de jouer
        return null;
    }

    @Override
    public List<Learner> getAll() {
        // A vous de jouer
        return null;
    }

    @Override
    public void save(Learner learner) {
        // A vous de jouer
    }

    @Override
    public void delete(Long id) {
        // A vous de jouer
    }
}
