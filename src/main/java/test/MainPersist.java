package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Etudiant;
import model.Professeur;

public class MainPersist {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many-to-many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();

			Professeur prof1 = new Professeur();
			prof1.setName("Creach");
			Professeur prof2 = new Professeur();
			prof2.setName("Karl");
			Professeur prof3 = new Professeur();
			prof3.setName("Newton");

			Etudiant e1 = new Etudiant();
			e1.setName("Badr");
			Etudiant e2 = new Etudiant();
			e2.setName("Hicham");
			Etudiant e3 = new Etudiant();
			e3.setName("Diea");
			Etudiant e4 = new Etudiant();
			e4.setName("Maroua");
			Etudiant e5 = new Etudiant();
			e5.setName("Madjid");

			prof1.getEtudiants().add(e5);
			prof1.getEtudiants().add(e4);
			prof2.getEtudiants().add(e3);
			prof2.getEtudiants().add(e2);
			prof2.getEtudiants().add(e1);
			em.persist(prof1);
			em.persist(prof2);
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {

				txn.rollback();
			}
			e.printStackTrace();

		} finally {

			if (em != null) {
				em.close();
			}

			if (emf != null) {
				emf.close();
			}
		}

	}

}
