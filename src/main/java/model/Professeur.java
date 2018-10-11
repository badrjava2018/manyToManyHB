package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professeur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Etudiant> etudiants = new HashSet<>();
	
	@JoinTable(
			
			name = "table_jointure",
			joinColumns = { @JoinColumn(name = "professeur_id") },
			inverseJoinColumns = { @JoinColumn(name = "etudiant_id")} 
			)
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
	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Professeur() {
		super();
	}

	public Professeur(Long id, String name, Set<Etudiant> etudiants) {
		super();
		this.id = id;
		this.name = name;
		this.etudiants = etudiants;
	}
	@Override
	public String toString() {
		return "Professeur [id=" + id + ", name=" + name + ", etudiants=" + etudiants + "]";
	}
	
	
}
