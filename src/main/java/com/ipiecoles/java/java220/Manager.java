package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public class Manager extends Employe {

	private HashSet<Technicien> equipe = new HashSet<>();

	public Manager(){
	}

	public HashSet<Technicien> getEquipe() {
		return this.equipe;
	}

	public void setEquipe(HashSet<Technicien> equipe) {
		this.equipe = equipe;
	}

	@Override
	public void setSalaire(Double salaire) { 
        super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10));
    }

	public Manager equipe(HashSet<Technicien> equipe) {
		this.equipe = equipe;
		return this;
	}

	public void ajoutTechnicienEquipe (Technicien technicien) {
		equipe.add(technicien);
	}

	public Double getPrimeAnnuelle() {
		//return Math.max(Math.ceil(this.getCaAnnuel() * 0.05), 500);
		return 0.0;
    }

    @Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}
}
