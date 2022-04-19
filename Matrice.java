/*
Ici je pose mon probleme
Je veux créez une matrice de taille x 
Pour rappel voici ce qu'on veut obetenir (representation humanaine)
    /| 0| 1| 2| 3| 
    1| 0| 0| 0| 0|
    2| 0| 0| 0| 0|
    3| 0| 0| 0| 0|
*/

// S1 crée deux un dico (HashCode) avec comme clé les ligne est en données les colonnes qui sont eux même des dico 
// S2 créé un double tableau

// Par défaut la matrice fait 5x5


public class Matrice {
    private char[][] matrice;
    public Matrice( int l, int c ){
        char [][] tableau = new char[l][c];
        matrice = tableau; 
        
        for(int lig = 0; lig < this.matrice.length; lig++){
            for(int col = 0; col < this.matrice[lig].length; col++){
                this.matrice[lig][col] = '?' ;
            }
        }
    }
  


    public  int getNbLigne() {
        return this.matrice.length;
    }
   
    public int getNbCol() {
        return this.matrice[0].length;
    }

    public char getValeur(int l, int c){
        return this.matrice[l][c];
    }

    public void affichage() {

        
        for(int lig1 = 0; lig1 < this.matrice.length; lig1++){
            System.out.print(lig1 + "| ");
            for(int col1 = 0; col1 < this.matrice[lig1].length; col1++)
                System.out.print(this.matrice[lig1][col1] + " ");
                System.out.println();
    
        }
        
    }
    
    public void setValeur(int lig , int col, char valeur){
        this.matrice[lig][col] = valeur;
    }

    @Override
    public String toString(){
        return "Il y a "+this.getNbLigne()+" ligne et "+this.getNbCol()+" colonnes. ";
    }



}

