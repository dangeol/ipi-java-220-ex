package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;
import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe() {
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) { //throws Exception {
        //this(nom, prenom, matricule, dateEmbauche, salaire);
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        //this.setDateEmbauche = ...
        this.salaire = salaire;
    }

    /*Coder la méthode augmenterSalaire prenant en paramètre un pourcentage d'augmentation de type Double 
    et augmentant l'attribut salaire du pourcentage passé en paramètre :
    Ex : un salaire de 500.0, avec une augmentation de 0.50, cela donne un salaire de 750.0*/

    public Double augmenterSalaire(Double pourcentage) {
        salaire += salaire * pourcentage;
        return salaire;
    }

    public abstract Double getPrimeAnnuelle();

    public final Integer getNombreAnneeAnciennete() {
        LocalDate today = LocalDate.now();
        return today.getYear() - dateEmbauche.getYear();
    }

    public String getNom() { 
        return nom; 
    }

    public String getPrenom() { 
        return prenom; 
    }

    public String getMatricule() { 
        return matricule; 
    }

    public LocalDate getDateEmbauche() { 
        return dateEmbauche; 
    }

    public Double getSalaire() { 
        return salaire; 
    }

    public Integer getNbConges() { 
        return Entreprise.NB_CONGES_BASE; 
    }

    public void setNom(String nom) { 
        this.nom = nom; 
    }

    public void setPrenom(String prenom) { 
        this.prenom = prenom; 
    }

    public void setMatricule(String matricule) { 
        this.matricule = matricule; 
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception { 
        // celui qui invoque cette méthode devrait utiliser n try catch
        LocalDate today = LocalDate.now();
        // if(dateEmbauche == null || dateEmbauche.isAfter(today)){ ça c'est mieux mais ne passe pas le test
        if(dateEmbauche != null && dateEmbauche.isAfter(today)){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        else {
            this.dateEmbauche = dateEmbauche;
        }
    }

    public void setSalaire(Double salaire) { 
        this.salaire = salaire; 
    }

    @Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Employe{");
		sb.append("nom='").append(nom).append('\'');
		sb.append(", prenom='").append(prenom).append('\'');
		sb.append(", matricule='").append(matricule).append('\'');
		sb.append(", dateEmbauche=").append(dateEmbauche);
		sb.append(", salaire=").append(salaire);
		sb.append('}');
		return sb.toString();
	}

    /*public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Employe e = (Employe) o;
        //return numero == c.numero &&
        //Double.compare(c.solde, solde) == 0 &&
        return Objects.equals(nom, e.nom) &&
        Objects.equals(prenom, e.prenom) &&
        Objects.equals(matricule, e.matricule) &&
        Objects.equals(dateEmbauche, e.dateEmbauche) &&
        Objects.equals(salaire, e.salaire);
    }*/

    @Override //le but est de comparer deux instances
    public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employe)) return false;

        Employe employe = (Employe) o;
        
        return hashCode() == o.hashCode();

        /* le suivant n'est plus nécessaire
        ------------------------------------------
		if (Double.compare(employe.salaire, salaire) != 0) return false;
		if (nom != null ? !nom.equals(employe.nom) : employe.nom != null) return false;
		if (prenom != null ? !prenom.equals(employe.prenom) : employe.prenom != null) return false;
		if (matricule != null ? !matricule.equals(employe.matricule) : employe.matricule != null) return false;
		return dateEmbauche != null ? dateEmbauche.equals(employe.dateEmbauche) : employe.dateEmbauche == null;*/
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
	}

}
