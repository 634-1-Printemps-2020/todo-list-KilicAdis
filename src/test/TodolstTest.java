package test;

import metier.*;

import java.text.ParseException;

import static org.junit.Assert.*;

public class TodolstTest {

    public static void main() throws planifTacheException, ParseException {
        TodolstTest tst = new TodolstTest();
        tst.creer();
        tst.affichage();
        tst.annuler();
        tst.replanifier();
        tst.testAffichage();
        tst.testAffichage2();
    }

    @org.junit.Test
    public void creer() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
    }

    @org.junit.Test (expected = planifTacheException.class)
    public void creerException() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.creer(crea, "test", "01/02/2020");
    }

    @org.junit.Test
    public void annuler() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.annuler("test");
    }

    @org.junit.Test (expected = planifTacheException.class)
    public void annulerException() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.annuler("tst");

    }

    @org.junit.Test
    public void replanifier() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.replanifier("test", "12/03/2020");
    }

    @org.junit.Test (expected = planifTacheException.class)
    public void replanifierException() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.replanifier("tst", "12/03/2020");
    }

    @org.junit.Test
    public void affichage() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.creer(crea, "tst2", "09/03/2020");
        todolist.creer(crea, "date2", "15/03/2020");
        todolist.affichage();

    }

    @org.junit.Test
    public void testAffichage() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.creer(crea, "tst2", "09/03/2020");
        todolist.creer(crea, "date2", "15/03/2020");
        todolist.affichage("date");
    }

    @org.junit.Test
    public void testAffichage2() throws planifTacheException, ParseException {
        Todolst todolist = new Todolst();
        Createur crea = new Createur("Kilic", "Adis");
        todolist.creer(crea, "test", "10/03/2020");
        todolist.creer(crea, "tst2", "09/03/2020");
        todolist.creer(crea, "date2", "15/03/2020");
        todolist.affichage("status");
    }

}