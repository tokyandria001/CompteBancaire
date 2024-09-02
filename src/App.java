import java.util.Scanner;
import exceptions.FondInsuffisantException;
import exceptions.CompteInexistantException;

public class App {
    public static void main(String[] args) throws Exception {
        Banque banque = new Banque();

        CompteBancaire compte1 = new CompteBancaire("12345", 1000.00);
        CompteBancaire compte2 = new CompteBancaire("67890", 500.00);

        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Entrez le montant à déposer sur le compte 12345: ");
            double montantDepot = scanner.nextDouble();
            compte1.deposer(montantDepot);
            System.out.println("Dépôt effectué avec succès. Solde actuel: " + compte1.getSolde());

            System.out.print("Entrez le montant à retirer du compte 12345: ");
            double montantRetrait = scanner.nextDouble();
            compte1.retirer(montantRetrait);
            System.out.println("Retrait effectué avec succès. Solde actuel: " + compte1.getSolde());
        } catch (FondInsuffisantException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        try {
            System.out.print("Entrez le montant à transférer du compte 12345 au compte 67890: ");
            double montantTransfert = scanner.nextDouble();
            banque.transferer("12345", "67890", montantTransfert);
            System.out.println("Transfert effectué avec succès.");
            System.out.println("Solde du compte 12345: " + compte1.getSolde());
            System.out.println("Solde du compte 67890: " + compte2.getSolde());
        } catch (FondInsuffisantException | CompteInexistantException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        try {
            CompteBancaire compteInexistant = banque.obtenirCompte("11111");
        } catch (CompteInexistantException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        scanner.close();
    }
}
