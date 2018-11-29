package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;
import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien> { //implements Comparable<Technicien>

    private Integer grade;
    //private Double PrimeAnnuelle;

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) throws TechnicienException { //throws Exception {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        //this.grade = grade; ne donne pas le résultat attendu (si je passe 1000, le résultat sera 1000 et non pas 1500 encluant les %)
        this.setGrade(grade);
    }

    @Override
	public Double getPrimeAnnuelle() {
		Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
		return primeAnnuelleBase + primeAnnuelleBase * ((double) grade / 10) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }
    
    public Integer getNbConges() { 
        return Entreprise.NB_CONGES_BASE + this.getNombreAnneeAnciennete(); 
    }

    public Integer getGrade() {
        return this.grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if (grade < 1 || grade > 5) {
            throw new TechnicienException(TechnicienException.GRADE, this, grade);
        }
        else {
            this.grade = grade;
        }
    }

    @Override
    public void setSalaire(Double salaire) { 
        super.setSalaire( salaire * (1 + (double) grade / 10)); 
    }

    public Technicien grade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public int compareTo(Technicien o) {
        //return Double.compare(grade, o.grade);
        if(grade < o.getGrade()) {
            return -1;
        }
        else if (grade > o.getGrade()) {
            return 1;
        }
        return 0;
    }

    @Override
	public String toString() {
		return "Technicien{" +
				"grade=" + grade +
				"} " + super.toString();
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), grade);
	}
    
}
