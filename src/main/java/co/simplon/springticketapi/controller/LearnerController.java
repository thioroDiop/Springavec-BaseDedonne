package co.simplon.springticketapi.controller;
import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import java.util.List;

@RequestMapping("/api/learners")
@RestController
public class LearnerController {
private  final LearnerDao learnerDao;


public LearnerController(LearnerDao learnerDao){
    this.learnerDao=learnerDao;
}


    //méthode pour avoir la liste de tous les learners
    @GetMapping

    public List<Learner> getAllLearners() {
        return learnerDao.getAll();
    }

    //méthode pour avoir un learner en particulier

    @GetMapping("/{id}")
    public Learner getLearner(@PathVariable Long id) {
        return learnerDao.get(id);
    }

    //méthode pour enregistrer un nouveau learner
    @PostMapping (value = "/{learner}")
    // @PostMapping

    public void addLearner(@RequestBody Learner learner)  {
        learnerDao.save(learner);
    }

    //méthode pour suppimer un ticket
    @DeleteMapping("/{id}")
    public void deleteLearner(@PathVariable Long id){
        learnerDao.delete(id);
    }

    //méthode pour modifier un learner à partir de l' id et le nouveau nom
//    @PutMapping("/{id}")
//    public void updateLearner(@PathVariable Long id){
//        learnerDao.update(id);
//    }

}
