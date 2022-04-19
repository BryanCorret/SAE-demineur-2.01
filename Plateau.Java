public abstract class Plateau {
    private Matrice plateau;
    public Plateau(Matrice m){
        this.plateau = m ;
    }

    // getteur

    public Matrice getPlateau() {
        return this.plateau;
    }

    public int getNbCol(){
        return this.plateau.getNbCol();
    }

    public int getNbLigne(){
        return this.plateau.getNbLigne();
    }

    public int getNbCase(){
        return this.getNbCol() * this.getNbLigne();
    }

    public char getValeur(int l, int c){
        return this.plateau.getValeur(l, c);
    }

    // setteur 

    public void setValeur(int L , int c, char valeur){
        this.plateau.setValeur(L, c, valeur);
    }   
    
    // affichage

    public void affichage(){
        this.plateau.affichage();
    }


    @Override
    public String toString(){
        return this.plateau.toString();
    }

    

     
    // int vers assci vers char
    public char intToChar(int nb){
        int base = 10; 
        char value_char = Character.forDigit(nb , base); 
        return value_char;
    }
}
