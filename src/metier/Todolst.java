package metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Todolst {

    private ArrayList<Tache> lst;

    public Todolst(){
        lst = new ArrayList<>();
    }

    public void creer(Createur createur, String description, String date) throws planifTacheException, ParseException {
        Tache tache = new Tache(createur, description, date, Status.open, null);

        Date ajd = new Date();
        if(tache.getDate().compareTo(ajd) > 0){
            lst.add(tache);
            System.out.println("La tâche a été créée avec succès !");
        }else{
            throw new planifTacheException("La tache ne peut pas être créer dans le passer !");
        }

    }

    public void annuler(String desc) throws planifTacheException{
        Tache tache = null;
        for(Tache t: lst){
            if(t.getDescription().equals(desc)){
                tache = t;
            }
        }
        if(tache == null){
            throw new planifTacheException("La tâche n'existe pas !");
        }
        if(tache.getStatus() == Status.open){
            tache.setStatus(Status.canceled);
            System.out.println("La tâche a été annulée avec succès !");
        }else{
            throw new planifTacheException("La tache est déjà annulée ou a été terminée !");
        }
    }

    public void replanifier(String desc, String date) throws planifTacheException, ParseException {
        Tache tache = null;
        for(Tache t: lst){
            if(t.getDescription().equals(desc)){
                tache = t;
            }
        }
        if(tache == null){
            throw new planifTacheException("La tâche n'existe pas !");

        }
        tache.setDate(date);
        System.out.println("La tâche a été replanifiée avec succès !");
    }

    public void affichage(){
        for(Tache t: lst){
            System.out.println("- " + t);
        }
    }

    public void affichage(String tri) throws planifTacheException{
        if(!tri.toLowerCase().equals("date") && !tri.toLowerCase().equals("status")){
            throw new planifTacheException("Le tri ne peut être fait que sur la date ou le status !");
        }else{
            fonctionTrierList(tri);
            affichage();
        }

    }

    private void fonctionTrierList(String tri){
        lst.sort(new Comparator<Tache>() {

            public int compare(Tache o1, Tache o2) {
                if(tri.equals("date")){
                    return Integer.compare(o1.getDate().compareTo(o2.getDate()), 0);
                }else{
                    return Integer.compare(o1.getStatus().compareTo(o2.getStatus()), 0);
                }

            }
        });
    }

}
