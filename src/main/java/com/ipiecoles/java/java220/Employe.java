package com.ipiecoles.java.java220;
import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    String nom;
    String prenom;
    String matricule;
    LocalDate dateEmbauche;
    Double salaire;

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

    public void setNom(String nom) { 
        this.nom = nom; 
    }

    public void setPrenom(String prenom) { 
        this.prenom = prenom; 
    }

    public void setMatricule(String matricule) { 
        this.matricule = matricule; 
    }

    public void setDateEmbauche(LocalDate dateEmbauche) { 
        this.dateEmbauche = dateEmbauche; 
    }

    public void setSalaire(Double salaire) { 
        this.salaire = salaire; 
    }


}
