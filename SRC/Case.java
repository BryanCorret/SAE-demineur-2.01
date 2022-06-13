import java.util.ArrayList;


public class Case {
   
   private boolean estBombe;
   private boolean estRelevee;
   private boolean estMarquee;
   private int lig; // permet de savoir sur quelle ligne est la grille
   private int col; // permet de savoir sur quelle colonne est la grille 
   private ArrayList<Case> LCaseVoisine ;
    /**
     * Constructeur de la classe Case
     * @param lig : la ligne de la case
     * @param col : La colonne de la case
     */
    public Case(int lig, int col){
        this.estBombe = false;
        this.estRelevee = false;
        this.estMarquee = false;
        this.lig = lig;
        this.col = col;
        this.LCaseVoisine = new ArrayList<>();

    }

    // Getter
    /**
     * Getter de la variable estBombe
     * @return int colonne de la case 
     */
    public int getCol() {
        // retourne la colonne de la case
        return this.col;
    }
    /**
     * Getter de la variable estBombe
     * @return int : la ligne de la case
     */
    public int getLig() {
        // retourne la ligne de la case
        return this.lig;
    }
    /**
     * retourne si la case est une bombe
     * @return boolean 
     */
    public boolean getEstBombe(){
        //  retourne vrai si la case est une bombe
        return this.estBombe;
    }

    /**
     * retourne si la case est marquée
     * @return boolean 
     */
    public boolean getEstMarquee(){
        //  retourne vrai si la case est marquée
        return this.estMarquee;
    }

    /**
     * retourne si la case est relevée
     * @return boolean 
     */
    public boolean getEstRelevee(){
        //  retourne vrai si la case est revelée
        return this.estRelevee;
    }
    /**
     * retourne la liste des cases voisines
     * @return ArrayList<> 
     */
    public ArrayList<Case> getLCaseVoisine() {
        // retourne la liste des cases voisines
        return LCaseVoisine;
    }

    // Setter
    /**
     * Setter de la variable estBombe
     * @param boolean : true si la case est une bombe sinon false
     */
    public void setEstBombe(boolean estBombe) {
        // permet de définir si la case est une bombe
        this.estBombe = estBombe;
    }
    /**
     * Setter de la variable estRelevee
     * @param boolean : true si la case est relevée sinon false
     */
    public void setEstMarquee(boolean estMarquee) {
        // permet de définir si la case est marquée
        this.estMarquee = estMarquee;
    }
    /**
     * Setter de la variable estRelevee
     * @param boolean : true si la case est relevée sinon false
     */
    public void setEstRelevee(boolean estRelevee) {
        // permet de définir si la case est revelée
        this.estRelevee = estRelevee;
    }
    /**
     * Setter de la variable estRelevee
     * @param ArrayList<Case> : la liste des cases voisines
     */
    public void setLCaseVoisine(ArrayList<Case> lCaseVoisine) {
        this.LCaseVoisine = lCaseVoisine;
    }
   // Fonction 
    /**
     * Permet d'ajouter une case voisine à la liste des cases voisines
     * @param Case : la case voisine à ajouter
     */
    public void addCaseVosine(Case c){
        this.LCaseVoisine.add(c);
    }
     
    /**
     * Permet de retourner le nombre de bombe voisin à la case
     * @return int : le nombre de bombes autour de la case
     */
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
    /**
     * Gere l'affiche du terminal
     * @return String : le caractère à afficher
     */
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
            return "M";
        }

        
        return " "; // cas ou elle n'est pas reveler
    }
    /**
     * Gere l'affiche du terminal
     * @return String : le caractère à afficher
     */
    public String getAffichageIHM(){
        // retourne l'affichage de la case
        
        if(this.estRelevee){
            if (this.estBombe){
                return "💣";
            }
            else{ // si elle est revele et ce n'est pas une bombe
                if(this.getNbbombeVoisne() == 0){
                    return "0"; // vert
                }

                if(this.getNbbombeVoisne() == 1){
                    return "1"; // violet
                }

                if(this.getNbbombeVoisne() == 2){
                    return "2"; // Cyan
                }

                if(this.getNbbombeVoisne() == 3){
                    return "3"; // bleu
                }

                if(this.getNbbombeVoisne() == 4){
                    return "4"; // Jaune
                }

                // cas  rare 
                if(this.getNbbombeVoisne() == 5){
                    return "5"; // Jaune
                }
                
                if(this.getNbbombeVoisne() == 6){
                    return "6" ; // rouge
                }
                if(this.getNbbombeVoisne() == 7){
                    return "7";
                }
                if(this.getNbbombeVoisne() == 8){
                    return "8";
                }
            }
        }  

        else if (this.estMarquee){ // cas ou elle est marquee
            return "⚐";
        }

        
        return " "; // cas ou elle n'est pas reveler
    }

    // Affichage
    /**
     * L'affichage de la case
     * @return String : le caractère à afficher
     */
    @Override
    public String toString(){
        // retourne une chaine de caractère qui affiche la case
    
        return "(" + this.lig +", "+ this.col + ")";
        /*
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
        */
    }
    /**
     * Gere l'affiche du nombre de bombe proche de la case
     */
    public void afficher() {
        // affiche la case pour le plateau
        System.out.print(this.getAffichage()+ " ");
    }
    /**
     * Gere l'égalité des case
     * @param c : la case à comparer
     * @return boolean : true si les deux cases sont égales sinon false
     */
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
    /**
     * Gere le hashcode des cases
     * @return int : le hashcode de la case
     */
    @Override
    public int hashCode(){
        return System.identityHashCode(this);
    }
}
