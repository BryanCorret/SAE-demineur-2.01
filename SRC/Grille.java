import java.util.ArrayList;
import java.util.Collections;


public class Grille {
    private int nbLig;
    private int nbCol;
    private int nbbombe;
    private int nbDrapeux;
    private int nbDrapeuxRestant;
    private ArrayList<ArrayList<Case>> grille;
    private ArrayList<Case> lDrapeux;
    private ArrayList<Case> lBombe;
    private boolean perdu ;

    public Grille(int nbLig, int nbCol, int nbbombe) {
        this.nbLig = nbLig;
        this.nbCol = nbCol;
        this.nbbombe = nbbombe;
        this.nbDrapeux = nbbombe;
        this.nbDrapeuxRestant = nbbombe;
        this.perdu = false;
        lDrapeux = new ArrayList<>();
        lBombe = new ArrayList<>();
        ArrayList<Case> Ltmp = new ArrayList<>();
        this.grille = new ArrayList<>();

        // Atribuer des cases
        for (int i = 0; nbLig > i; i++) {
            for (int j = 0; nbCol > j; j++) {
                Case c = new Case(i, j);
                Ltmp.add(c);
            }
            this.grille.add(Ltmp);
            Ltmp = new ArrayList<>();
        }
    }

    // Les getters

    public ArrayList<Case> getlBombe() {
        // retourne la liste des cases des bombes
        return lBombe;
    }

    public ArrayList<Case> getlDrapeux() {
        // retourne la liste des cases des drapeaux
        return lDrapeux;
    }

    public int getNbLig() {
        // retourne le nombre de lignes
        return this.nbLig;
    }

    public int getNbDrapeuxRestant() {
        // retourne le nombre de drapeaux restant
        return this.nbDrapeuxRestant;
    }

    public int getNbDrapeux() {
        // retourne le nombre de drapeaux
        return this.nbDrapeux;
    }

    public int getNbCol() {
        // retourne le nombre de colonnes
        return this.nbCol;
    }

    public int getNbbombe() {
        // retourne le nombre de bombes
        return this.nbbombe;
    }

    public Case getCase(int lig, int col) {
        // retourne la case de la grille à la ligne lig et à la colonne col
        return this.grille.get(lig).get(col);
    }

    public int getCaseRevelee() {
        int nb = 0;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (this.grille.get(i).get(j).getEstRelevee()) {
                    nb++;
                }
            }
        }
        return nb;
    }

    public int getCaseMarquee() {
        int nb = 0;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (this.grille.get(i).get(j).getEstMarquee()) {
                    nb++;
                }
            }
        }
        return nb;
    }


    public boolean getPerdu() {
        // retourne vrai si la partie est perdue
        return this.perdu;
    }

    public void estPerdu() {
        System.out.println("Vous avez perdu !");
    }

    public void estGagne() {
        System.out.println("Bravo vous avez gagné !");
    }

    public int nbCaseRevele() {
        // retourne le nombre de cases révélées
        int nbCaseRevele = 0;
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (this.getCase(i, j).getEstRelevee()) {
                    nbCaseRevele++;
                }
            }
        }
        return nbCaseRevele;
    }

    public int NbcaseMarque() {
        // retourne le nombre de cases marquées
        int nbCaseMarque;
        nbCaseMarque = this.nbDrapeuxRestant - this.nbDrapeux;
        return nbCaseMarque;
    }

    // afficher Terminal
    public void afficher() {
        // affiche la grille
        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        System.out.println("║ / ║ 0 ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║");
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
        for (int i = 0; this.nbLig > i; i++) {
            System.out.println("║ " +i+" ║ " +this.getCase(i, 0).getAffichage()+" ║ " +this.getCase(i, 1).getAffichage()+" ║ " +this.getCase(i, 2).getAffichage()+" ║ " +this.getCase(i, 3).getAffichage()+" ║ " +this.getCase(i, 4).getAffichage()+" ║ " +this.getCase(i, 5).getAffichage()+" ║");
            
            if(this.nbLig-i == 1){
            System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝");}
            else{
            System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }
        }
        
    

    }

    public boolean isIn(Object o) {
        // cette fonction réplique isIn cependant on prend une liste profonde
        // et on vérifie si l'objet est dans la liste

        boolean in = false;
        for (ArrayList<Case> l : this.grille) {
            for (Case c : l) {
                if (c.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    // trouver les bombes sur le plateaux
    public ArrayList<Case> trouverBombe() {
        // trouve les cases des bombes
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                if (this.getCase(i, j).getEstBombe()) {
                    this.lBombe.add(this.getCase(i, j));
                }
            }
        }
        return this.lBombe;
    }
    // action Joueur

    // placer bombe
    public void placerBombes(int lig, int col) {
        // place une bombe à la ligne lig et à la colonne col
        while (this.lBombe.size() < this.nbbombe) {
            // case aléatoire
            int ligAlea = (int) (Math.random() * this.nbLig);
            int colAlea = (int) (Math.random() * this.nbCol);

            Case c = this.getCase(ligAlea, colAlea);
            while (c.getCol() == col && c.getLig() == lig) {
                ligAlea = (int) (Math.random() * this.nbLig);
                colAlea = (int) (Math.random() * this.nbCol);
            }
            if (!c.getEstBombe()) {
                c.setEstBombe(true);
                this.lBombe.add(c);
            }
        }

        Collections.sort(this.lBombe, new Comp());
    }

    // placer les drapeaux
    public void placerDrapeaux(int lig, int col) {
        // place un drapeau à la ligne lig et à la colonne col
        if (this.nbDrapeuxRestant > 0) {
            if (this.getCase(lig, col).getEstRelevee()) {
                System.out.println("Vous ne pouvez pas placer un drapeau sur une case déjà révélée.");
            } else if (this.getCase(lig, col).getEstMarquee()) {
                System.out.println("Vous ne pouvez pas place un drapeau sur une case qui possède déjà un drapeaux.");
            } else {
                this.getCase(lig, col).setEstMarquee(true);
                this.lDrapeux.add(this.getCase(lig, col));
                this.nbDrapeuxRestant--;
                Collections.sort(lDrapeux, new Comp());
            }
        } else {
            System.out.println("Vous ne pouvez pas placer plus de drapeaux.");
        }
    }

    // enlever les drapeaux
    public void enleverDrapeaux(int lig, int col) {
        // permets d'enlever un drapeau à la ligne lig et à la colonne col
        if (this.nbDrapeuxRestant < this.nbDrapeux) {
            if (this.getCase(lig, col).getEstRelevee()) {
                System.out.println("Vous ne pouvez pas enlever un drapeau sur une case déjà révélée.");
            } else if (!(this.getCase(lig, col).getEstMarquee())) {
                System.out.println("Vous ne pouvez pas enlever un drapeau qui n'est pas placé.");
            } else {
                this.getCase(lig, col).setEstMarquee(false);
                this.lDrapeux.add(this.getCase(lig, col));
                this.nbDrapeuxRestant++;
            }
        } else {
            System.out.println("Aucun Drapeau n'est placé.");
        }
    }

    public void creuser(int lig, int col) {
        // permet de creuser la case à la ligne lig et à la colonne col
        if (this.getCase(lig, col).getEstRelevee()) {

        } else {
            this.getCase(lig, col).setEstRelevee(true);
            if (this.lBombe.size() == 0) {
                this.placerBombes(lig, col);
            }

            if (this.getCase(lig, col).getEstBombe()) {
                this.perdu = true;
            }
            else{
                if (this.getCase(lig, col).getNbbombeVoisne() == 0) {
                    for (Case c : this.getCase(lig, col).getLCaseVoisine()) {
                        if (!c.getEstMarquee()) {
                            this.creuser(c.getLig(), c.getCol());
                        }
                    }
                
            }
            }
        }
    }


    public void toutLescasesVoisines() {
        //permet de definier toute les cases voisines
        for (int i = 0; this.nbLig > i; i++) {
            for (int j = 0; this.nbCol > j; j++) {
                // Selection de toute les lignes du HAUT adjacent =(BAS / DROITE / GAUCHE/ BAS DROITE / BAS GAUCHE)
                if (i == 0) {
                    // Selection de la premier case de la ligne du HAUT adjacent = (BAS / DROITE / BAS DROITE )
                    if (j == 0) {
                        // Droit
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }

                        // BAS
                        if (isIn(this.getCase(i + 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j));
                        }

                        // BAS DROIT
                        if ((isIn(this.getCase(i + 1, j + 1)))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j + 1));

                        }
                    }
                    // Selection de la derniere case de la ligne du HAUT adjacent = (BAS / GAUCHE / BAS GAUCHE )
                    else if (j == this.nbCol - 1) {
                        // GAUCHE
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // BAS
                        if (isIn(this.getCase(i + 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j));
                        }

                        // BAS GAUCHE
                        if ((isIn(this.getCase(i + 1, j - 1)))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j - 1));

                        }
                    } else {// Selection milieu des case sur la ligne du HAUT adjacent = (BAS / GAUCHE / BAS GAUCHE / DROITE / BAS DROITE / HAUT / HAUT DROITE)
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // BAS
                        if (isIn(this.getCase(i + 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j));
                        }

                        // BAS GAUCHE
                        if (isIn(this.getCase(i + 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j - 1));
                        }

                        // DROITE
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }
                        // BAS DROIT
                        if (isIn(this.getCase(i + 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j + 1));
                        }

                    }

                } else if (i == this.nbLig - 1) {
                    // Selection sur la ligne du BAS adjacent = (HAUT / GAUCHE / HAUT GAUCHE / DROITE / HAUT DROITE)
                    if (j == 0) { // Selection de la derniere case de la ligne du HAUT adjacent = (HAUT / DROITE / HAUT DROITE)
                        // DROITE
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }

                        // HAUT
                        if (isIn(this.getCase(i - 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j));
                        }

                        // HAUT DROITE
                        if (isIn(this.getCase(i - 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j + 1));
                        }


                    } else if (j == this.nbCol - 1) {
                        // selection de la derniere case de la ligne du HAUT adjacent = (HAUT / GAUCHE / HAUT GAUCHE)
                        // GAUCHE
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // HAUT
                        if (isIn(this.getCase(i - 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j));
                        }

                        // HAUT DROITE
                        if (isIn(this.getCase(i - 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j - 1));
                        }

                    } else {
                        // Selection milieu des case sur la ligne du HAUT adjacent = (HAUT / GAUCHE / HAUT GAUCHE / DROITE / HAUT DROITE)
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // HAUT
                        if (isIn(this.getCase(i - 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j));
                        }

                        // HAUT GAUCHE
                        if (isIn(this.getCase(i - 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j - 1));
                        }

                        // DROITE
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }

                        // HAUT DROITE
                        if (isIn(this.getCase(i - 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j + 1));
                        }

                    }
                } else { // Selection des lignes du millieu adjacent = (HAUT / GAUCHE / HAUT GAUCHE / DROITE / HAUT DROITE / BAS DROITE / BAS GAUCHE )
                    if (j == 0) { // Selection de la derniere case de la ligne quelqueconque adjacent = (BAS / DROITE / BAS DROITE)
                        // DROITE
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }

                        // BAS
                        if (isIn(this.getCase(i + 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j));
                        }

                        // BAS DROITE
                        if (isIn(this.getCase(i + 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j + 1));
                        }


                    } else if (j == this.nbCol - 1) {
                        // selection de la derniere case de la ligne quelqueconque adjacent = (HAUT / GAUCHE / HAUT GAUCHE)
                        // GAUCHE
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // HAUT
                        if (isIn(this.getCase(i - 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j));
                        }

                        // HAUT GAUCHE
                        if (isIn(this.getCase(i - 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j - 1));
                        }

                    } else {
                        // Selection milieu des case quelqueconque adjacent = (HAUT / GAUCHE / HAUT GAUCHE / DROITE / HAUT DROITE / BAS DROITE / BAS GAUCHE )
                        // GAUCHE
                        if (isIn(this.getCase(i, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j - 1));
                        }

                        // BAS GAUCHE
                        if (isIn(this.getCase(i + 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j - 1));
                        }

                        // HAUT GAUCHE
                        if (isIn(this.getCase(i - 1, j - 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j - 1));
                        }

                        // DROITE
                        if (isIn(this.getCase(i, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i).get(j + 1));
                        }

                        // HAUT DROITE
                        if (isIn(this.getCase(i - 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j + 1));
                        }

                        // BAS DROITE
                        if (isIn(this.getCase(i + 1, j + 1))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j + 1));
                        }

                        // HAUT
                        if (isIn(this.getCase(i - 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i - 1).get(j));
                        }

                        // BAS
                        if (isIn(this.getCase(i + 1, j))) {
                            this.grille.get(i).get(j).addCaseVosine(this.grille.get(i + 1).get(j));
                        }


                    }
                }

            }

        }
    }

    public void init() {
        
        this.nbDrapeux = nbbombe;
        this.nbDrapeuxRestant = nbbombe;
        this.perdu = false;
        lDrapeux = new ArrayList<>();
        lBombe = new ArrayList<>();
        ArrayList<Case> Ltmp = new ArrayList<>();
        this.grille = new ArrayList<>();

        // Atribuer des cases
        for (int i = 0; nbLig > i; i++) {
            for (int j = 0; nbCol > j; j++) {
                Case c = new Case(i, j);
                Ltmp.add(c);
            }
            this.grille.add(Ltmp);
            Ltmp = new ArrayList<>();
        }
        
    }
}