package com.bafal.dev.patient.modele.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bafal.dev.patient.modele.entite.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	public static final String REQUETE_UPDATE_MDP = "UPDATE Utilisateur m SET m.motDePasse = :nouveaumdp "
			+ "WHERE m.codeUtilisateur = :personnel AND m.motDePasse = :mdpactuel";
	public static final String REQUETE_RESET_MDP = "UPDATE Utilisateur m SET m.motDePasse = :nouveaumdp "
			+ "WHERE m.courriel = :email";

    /**
     * Methode de changement de mot de passe.
     * 
     * @param codeUtilisateur le courriel de l'utilisateur
     * @param motDePasseActuel le mot de passe courant
     * @param nouveauMotDePasse le nouveau mot de passe
     */
    @Modifying
    @Transactional
    @Query(REQUETE_UPDATE_MDP)
    void setPersonnelMotDePasseFor(@Param("personnel") String codeUtilisateur,
        @Param("mdpactuel") String motDePasseActuel, @Param("nouveaumdp") String nouveauMotDePasse);

	Utilisateur findOneByCodeUtilisateur(String codeUtilisateur);

	Utilisateur findOneByCourriel(String courriel);

	@Modifying
	@Transactional
	@Query(REQUETE_RESET_MDP)
	void setMotDePasseFor(@Param("email") String courriel, @Param("nouveaumdp") String nouveauMotDePasse);
}
