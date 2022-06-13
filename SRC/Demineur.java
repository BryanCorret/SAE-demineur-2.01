import java.util.Scanner;

public class Demineur {    
    public static void main(String[] args) {
        // Jeu 
        
        boolean running = true;
        boolean r2 = true;
        int difficulter = 0;
        Grille jeu = new Grille(6,6,1);
    
        while (r2){
            System.out.println("Choisissez votre difficulté : ");
            System.out.println("1. Facile");
            System.out.println("2. Moyen");
            System.out.println("3. Difficile");
            Scanner sc = new Scanner(System.in);
            difficulter = sc.nextInt();
            if (difficulter < 0 && difficulter > 4){
                System.out.println("Veuillez choisir une difficulté valide");
                
            }
            switch(difficulter){
                case 1:
                    jeu = new Grille(6,6,4);
                    break;
                case 2: 
                    jeu = new Grille(8,8,10);
                    break;
                case 3:
                    jeu = new Grille(10,10,25);
                    break;
                
                default :
                    jeu = new Grille(6,6,4);
                    break;

            }
       
        jeu.toutLescasesVoisines();
        
        // Affichage du jeu
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

                    jeu.afficher(difficulter);
        
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
                    jeu.afficher(difficulter);

                    
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
                    jeu.afficher(difficulter);

                }
                // Choix n°4
                
                else if (r.compareTo("4") == 0){
                    jeu.afficher(difficulter);
                }

                else if (r.compareTo("5") == 0){
                    System.out.println(jeu.getlBombe());
                }


            }
            if (jeu.getlBombe().equals(jeu.getlDrapeux())){
                jeu.estGagne();
            }
            else {
                jeu.estPerdu();
            }

        
        }
    }
}

