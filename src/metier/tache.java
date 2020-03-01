package metier;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

class Tache {
    private Createur createur;
    private String description;
    private Date date;
    private Status status;
    private Resolution resolution;

    public Tache(Createur createur, String description, String date, Status status, Resolution resolution) throws ParseException {
        this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        this.createur = createur;
        this.description = description;
        this.status = status;
        this.resolution = null;
    }

    public Date getDate(){
        return this.date;
    }

    public Createur getCreateur() {
        return createur;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setDate(String date) throws ParseException {
        this.date =new SimpleDateFormat("dd/MM/yyyy").parse(date);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "createur=" + createur +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", resolution=" + resolution +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tache tache = (Tache) o;
        return Objects.equals(description, tache.description) &&
                Objects.equals(date, tache.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }
}
