package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "etudiants", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	Set<Professeur> professeurs = new HashSet<>();

	public Etudiant(Long id, String name, Set<Professeur> professeurs) {
		super();
		this.id = id;
		this.name = name;
		this.professeurs = professeurs;
	}

	public Etudiant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(Set<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", name=" + name + ", professeurs=" + professeurs + "]";
	}

	public void addProfesseur(Professeur prof) {
		professeurs.add(prof);
		prof.getEtudiants();
	}

}
