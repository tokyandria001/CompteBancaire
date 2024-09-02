import exceptions.CompteInexistantException;
import exceptions.FondInsuffisantException;

import java.util.HashMap;
import java.util.Map;

public class Banque {
    private Map<String, CompteBancaire> comptes = new HashMap<>();

    public void ajouterCompte(CompteBancaire compte) {
        comptes.put(compte.getNumeroCompte(), compte);
    }

    public CompteBancaire obtenirCompte(String numeroCompte) throws CompteInexistantException {
        CompteBancaire compte = comptes.get(numeroCompte);
        if (compte == null) {
            throw new CompteInexistantException("Le compte avec le numéro " + numeroCompte + " n'existe pas.");
        }
        return compte;
    }

    public void transferer(String numeroCompteSource, String numeroCompteDestination, double montant) 
            throws CompteInexistantException, FondInsuffisantException {
        CompteBancaire compteSource = obtenirCompte(numeroCompteSource);
        CompteBancaire compteDestination = obtenirCompte(numeroCompteDestination);
        
        compteSource.retirer(montant);
        compteDestination.deposer(montant);
    }
}