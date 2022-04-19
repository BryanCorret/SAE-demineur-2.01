public class excutableMatrice {
    public static void main(String[] args) {
        Matrice m1 = new Matrice(5,5);

       m1.affichage();

       System.out.println(m1.getNbCol());; //affiche 5
       System.out.println(m1.getNbLigne()); //affiche 5

       m1.setValeur(3, 4, '1');
       m1.setValeur(3, 3, 'b');
       m1.setValeur(4, 2, 'd');


       m1.affichage();


    }
}
 