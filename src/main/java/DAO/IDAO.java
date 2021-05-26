package DAO;

import java.util.List;

public interface IDAO <T> {

    public T Ajouter(T obj);

    public Boolean Supprimer(int id);

    public T Modifier(T obj);

    public T RechercherParId(int id);

    public List<T> rechercherTous();

}

