import exceptions.FondInsuffisantException;

public class CompteBancaire {
    private String numeroCompte;
    private double solde;

    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " effectué. Nouveau solde: " + solde);
        } else {
            System.out.println("Le montant du dépôt doit être positif.");
        }
    }

    public void retirer(double montant) throws FondInsuffisantException {
        if (montant > solde) {
            throw new FondInsuffisantException("Fonds insuffisants pour effectuer ce retrait.");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde: " + solde);
        }
    }

    public double getSolde() {
        return solde;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

}
