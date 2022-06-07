import java.util.ArrayList;

public class Case {
   
   private boolean estBombe = false;
   private boolean estRelevee = false;
   private boolean estMarquee = false;
   private int lig; // permet de savoir sur quelle ligne est la grille
   private int col; // permet de savoir sur quelle colonne est la grille 
   private ArrayList<Case> LCaseVoisine ;
    
    public Case(int lig, int col){
        this.lig = lig;
        this.col = col;
        this.LCaseVoisine = new ArrayList<>();

    }

    // Getter
    public int getCol() {
        // retourne la colonne de la case
        return this.col;
    }
    public int getLig() {
        // retourne la ligne de la case
        return this.lig;
    }

    public boolean getEstBombe(){
        //  retourne vrai si la case est une bombe
        return this.estBombe;
    }

    public boolean getEstMarquee(){
        //  retourne vrai si la case est marquée
        return this.estMarquee;
    }

    public boolean getEstRelevee(){
        //  retourne vrai si la case est revelée
        return this.estRelevee;
    }

    public ArrayList<Case> getLCaseVoisine() {
        // retourne la liste des cases voisines
        return LCaseVoisine;
    }

    // Setter

    public void setEstBombe(boolean estBombe) {
        // permet de définir si la case est une bombe
        this.estBombe = estBombe;
    }

    public void setEstMarquee(boolean estMarquee) {
        // permet de définir si la case est marquée
        this.estMarquee = estMarquee;
    }

    public void setEstRelevee(boolean estRelevee) {
        // permet de définir si la case est revelée
        this.estRelevee = estRelevee;
    }
    
   // Fonction 

    public void addCaseVosine(Case c){
        // permet d'ajouter une case voisine à la liste des cases voisines
        this.LCaseVoisine.add(c);
    }
    
    public void marquer(){
        // permet de marquer la case
        this.estMarquee = true;
    }
      
    
    public int getNbbombeVoisne(){
        // retourne le nombre de bombes voisines
        
      int nbBombeproche = 0;
        for(Case c : this.LCaseVoisine){
            if (c.getEstBombe()){
                nbBombeproche +=1;
            }
        }
        return nbBombeproche;                        
    
    }

    public String getAffichage(){
        // retourne l'affichage de la case
        
        String RED = "\u001B[31m"; 
        String CYAN = "\u001B[36m";
        String BLUE = "\u001B[34m"; 
        String PURPLE = "\u001B[35m";
        String YELLOW = "\u001B[33m";
        String GREEN = "\u001B[32m";
        String RESET = "\u001B[0m";

        if(this.estRelevee){
            if (this.estBombe){
                return "@";
            }
            else{ // si elle est revele et ce n'est pas une bombe
                if(this.getNbbombeVoisne() == 0){
                    return GREEN +"0"+ RESET; // vert
                }

                if(this.getNbbombeVoisne() == 1){
                    return PURPLE +"1"+ RESET; // violet
                }

                if(this.getNbbombeVoisne() == 2){
                    return CYAN +"2"+ RESET; // Cyan
                }

                if(this.getNbbombeVoisne() == 3){
                    return BLUE +"3"+ RESET; // bleu
                }

                if(this.getNbbombeVoisne() == 4){
                    return YELLOW +"4" + RESET; // Jaune
                }

                // cas  rare 
                if(this.getNbbombeVoisne() == 5){
                    return YELLOW+"5"+RESET; // Jaune
                }
                
                if(this.getNbbombeVoisne() == 6){
                    return RED +"6" + RESET; // rouge
                }
                if(this.getNbbombeVoisne() == 7){
                    return RED+"7"+RESET;
                }
                if(this.getNbbombeVoisne() == 8){
                    return RED +"8"+RESET;
                }
            }
        }  

        else if (this.estMarquee){ // cas ou elle est marquee
            return "?";
        }

        
        return "."; // cas ou elle n'est pas reveler
    }

    // Affichage
    @Override
    public String toString(){
        // retourne une chaine de caractère qui affiche la case
    
        
        if (this.estMarquee && this.estBombe && !(this.estRelevee)){ // cas ou elle est marquee et une bombe et pas reveler
            return "La case (" + this.getLig() + ", "+this.getCol()+ ")" + " est marquee et possède une bombe";
        }
        else if (this.estMarquee && !(this.estBombe) && this.estRelevee) { // cas ou la case est marquée mais pas une bombe et que la case est revelée
            return "la case (" + this.getLig() + ", "+this.getCol()+ ")" + " est marquee, ne possède pas de bombe et n'est pas révélé";
        }

        else if (!(this.estMarquee) && this.estBombe && !(this.estRelevee)) { // cas ou la case est une bombe et n'est pas marquée et n'est pas révélé
            return "La case (" + this.getLig() + ", "+this.getCol()+ ")" + " n'est pas marqué, possède de bombe et n'est pas révélé";
        }

        else if (!(this.estMarquee) && !(this.estBombe) && this.estRelevee) { // cas ou elle est révélé mais pas marqué et n'a pas de bombe
            return "La case (" + this.getLig() + ", "+this.getCol()+ ")" + " n'est pas marqué, ne possède pas  de bombe est elle est révélé";
        }

        else { // cas ou elle n'est pas marqué et n'est pas bombe et n'est pas révélé
            return "La case (" + this.getLig() + ", "+this.getCol()+ ")" + " ,'n'est ni marqué, ne possède pas de bombe et n'est pas révélé";
        }
        
    }
    public void afficher() {
        // affiche la case pour le plateau
        System.out.print(this.getAffichage()+ " ");
    }
    @Override
    public boolean equals(Object o){
        // permet de comparer deux cases
        if (o instanceof Case){
            Case c = (Case) o;
            return (this.lig == c.getLig() && this.col == c.getCol());
        }
        else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return this.hashCode();
    }
}
