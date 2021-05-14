package co.simplon.springticketapi.dao;

import java.util.List;

public interface Dao<T> {

    /**
     * Fonction de récupération d'un objet en base de données grâce à son ID.
     *
     * @param id l'identifiant de l'objet à trouver.
     * @return l'objet si trouvé, null sinon.
     */
    T get(Long id);

    /**
     * Fonction de récupération de la liste de tous les objets en base de données.
     *
     * @return la liste des objets.
     */
    List<T> getAll();

    /**
     * Fonction de sauvegarde d'un objet en base de données.
     *
     * @param t l'objet à sauvegarder (à créer ou mettre à jour).
     */
    void save(T t);

    /**
     * Fonction de suppression d'un objet en base de données.
     *
     * @param id l'identifiant de l'objet à supprimer.
     */
    void delete(Long id);


    /**
     * Fonction de mise à jour du nom d'un objet en base de données.
     *
     * @param id l'identifiant de l'objet à modifier.
     *           et nom c'est le nouveau nom
     */
    void update(Long id);
}
