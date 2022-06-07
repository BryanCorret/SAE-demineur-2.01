import java.util.Scanner;

public class Demineur {    
    public static void main(String[] args) {
        // Jeu 
        boolean running = true;

        Grille jeu = new Grille(6,6,5);

        while (running){
            Scanner Read = new Scanner(System.in);  


            System.out.println("Que voulez-vous faire ?");
            System.out.println("1: Creuser  2: Placer un drapeau  3: Supprimer un drapeau 4: Afficher la carte");
            System.out.println("Il y a "+ jeu.getNbbombe() +" Bombes et il vous reste "+jeu.getNbDrapeuxRestant()+" Drapeaux.");

            String r = Read.nextLine();
    
            System.out.println("Vous avez choisi le choix n°"+r+".");
            
            // Choix n°1

            if (r.compareTo("1") == 0){
                System.out.println("Sur quelle ligne voulez vous creusez ? ");
                String repLigne = Read.nextLine();
                int rLigne=Integer.parseInt(repLigne);
    
    
                System.out.println("Sur quelle colone voulez vous creusez ? ");
                String repColonne = Read.nextLine();
                int rcol=Integer.parseInt(repColonne);
    
                jeu.creuser(rLigne, rcol);
                if (jeu.getCase(rLigne, rcol).getEstBombe()){
                    running = false;
                }                

                jeu.afficher();
    
            }
            // Choix n°2
            
            else if (r.compareTo("2") == 0){
            
                System.out.println("Sur quelle ligne voulez vous placez votre drapeaux ? ");
                String repLigne = Read.nextLine();
                int rLigne=Integer.parseInt(repLigne);
    
    
                System.out.println("Sur quelle colone voulez vous placez votre drapeaux ? ");
                String repColonne = Read.nextLine();
                int rcol=Integer.parseInt(repColonne);
                jeu.placerDrapeaux(rLigne, rcol);
                if (jeu.getlBombe().equals(jeu.getlDrapeux())){
                    running = false;}
                jeu.afficher();

                
            }
            // Choix n°3

            else if (r.compareTo("3") == 0){
            
                System.out.println("Sur quelle ligne voulez vous enlever votre drapeaux ? ");
                String repLigne = Read.nextLine();
                int rLigne=Integer.parseInt(repLigne);
    
    
                System.out.println("Sur quelle colone voulez vous enlever votre drapeaux ? ");
                String repColonne = Read.nextLine();
                int rcol=Integer.parseInt(repColonne);
                jeu.enleverDrapeaux(rLigne, rcol);
                jeu.afficher();

            }
            // Choix n°4
            
            else if (r.compareTo("4") == 0){
                jeu.afficher();
            }

            else if (r.compareTo("5") == 0){
                System.out.println(jeu.getlBombe());
            }


       }
       if (jeu.getlBombe().equals(jeu.getlDrapeux())){
        System.out.println("Vous avez gagné !");
       }
       else {
        System.out.println("Vous avez perdu !");
       }
    
    }
}

