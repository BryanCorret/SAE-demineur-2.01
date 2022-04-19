public class PlateauJoueur extends Plateau {
    

    public PlateauJoueur(Matrice m) {
        super(m);
    }

    public void setDrapeau(int L , int c){
        this.setValeur(L, c, 'D');
    }
    
    public void creuser(int L , int c, Plateau pJeux){
        // rèvele le nombre de bombe sur une case et les cases avec des 0 adjacent
        if (pJeux.getValeur(L, c) == 'B'){
            System.out.println("Perdu");
        }

        else{
            this.setValeur(L, c, pJeux.getValeur(L, c));
        }
    }
}