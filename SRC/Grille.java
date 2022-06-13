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
    /**
     * @param nbLig : nombre de lignes de la grille
     * @param nbCol : nombre de colonnes de la grille
     * @param nbbombe : nombre de bombes dans la grille
     */
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
    /** @return la liste de toute les bombes présentes sur le terrain  */
    public ArrayList<Case> getlBombe() {
        return lBombe;
    }
    /** @return la liste de toute les bombes présentes sur le terrain */
    public ArrayList<Case> getlDrapeux() {
        return lDrapeux;
    }
    /** @return le nombre de ligne */
    public int getNbLig() {
        return this.nbLig;
    }

    /** @return nombre de drapeau que le joueur peut encore placer */
    public int getNbDrapeuxRestant() {
        return this.nbDrapeuxRestant;
    }
    /** @return nbCol : nombre de colonnes de la grille */
    public int getNbDrapeux() {
        return this.nbDrapeux;
    }

    /** @return le nombre de colonnes */
    public int getNbCol() {
        return this.nbCol;
    }

    /** @return nbbombe : nombre de bombes dans la grille */
    public int getNbbombe() {
        return this.nbbombe;
    }
    /**
     * @param nbLig : nombre de lignes de la grille
     * @param nbCol : nombre de colonnes de la grille   
     * @return Case : retourne la case de la grille
     */
    public Case getCase(int lig, int col) {
        //  à la ligne lig et à la colonne col
        return this.grille.get(lig).get(col);
    }

    /** @return le nombre de case déja révélée */
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
    /** @return le nombre de case déja marquée */
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

    /** @return si la partie est perdue */
    public boolean getPerdu() {
        return this.perdu;
    }
    /** affiche si la partie est perdu */
    public void estPerdu() {
        System.out.println("Vous avez perdu !");
    }
    /** 
     * affiche si la partie est gagné
     */ 
    public void estGagne() {
        System.out.println("Bravo vous avez gagné !");
    }

    
    /**
     * Permet de pouvoir faire l'affichage de la grille sur le terminal
     * @param difficulter le niveaux de difficulté
     * @return void
     */
    public void afficher( int difficulter) {
        // affiche la grille
        if(difficulter == 1){
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

        else if (difficulter == 2){
            System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
            System.out.println("║ / ║ 0 ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║ 6 ║ 7 ║");
            System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            for (int i = 0; this.nbLig > i; i++) {
                System.out.println("║ " +i+" ║ " +this.getCase(i, 0).getAffichage()+" ║ " +this.getCase(i, 1).getAffichage()+" ║ " +this.getCase(i, 2).getAffichage()+" ║ " +this.getCase(i, 3).getAffichage()+" ║ " +this.getCase(i, 4).getAffichage()+" ║ " +this.getCase(i, 5).getAffichage()+" ║ "+this.getCase(i, 6).getAffichage()+" ║"+this.getCase(i, 7).getAffichage()+"  ║ ");
                
                if(this.nbLig-i == 1){
                System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");}
                else{
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
                }
            }
        
        }

        else {
            System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
            System.out.println("║ / ║ 0 ║ 1 ║ 2 ║ 3 ║ 4 ║ 5 ║ 6 ║ 7 ║ 8 ║ 9 ║");
            System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            for (int i = 0; this.nbLig > i; i++) {
                System.out.println("║ " +i+" ║ " +this.getCase(i, 0).getAffichage()+" ║ " +this.getCase(i, 1).getAffichage()+" ║ " +this.getCase(i, 2).getAffichage()+" ║ " +this.getCase(i, 3).getAffichage()+" ║ " +this.getCase(i, 4).getAffichage()+" ║ " +this.getCase(i, 5).getAffichage()+" ║ "+this.getCase(i, 6).getAffichage()+" ║ "+this.getCase(i, 7).getAffichage()+" ║ "+this.getCase(i, 8).getAffichage()+" ║ "+this.getCase(i, 9).getAffichage()+" ║");
                
                if(this.nbLig-i == 1){
                System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");}
                else{
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
                }
            }
        
        }

    }

    /**
     * Permet de répliquer contains dans la classe Case 
     * @param Object o l'objet à comparer
     * @return boolean
     */
    
    public boolean isIn(Object o) {
        // cette fonction réplique contains cependant on prend une liste profonde
        // et on vérifie si l'objet est dans la liste

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
    /** 
     * @return ArrayList<Case> qui est la liste des bombe
     */
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
    /**
     * @param int x la ligne de la case
     * @param int y la colonne de la case
     * @return void 
     */
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
    /**
     * @param int x la ligne de la case
     * @param int y la colonne de la case
     * @return void 
     */
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
    /**
     * @param int  la ligne de la case
     * @param int  la colonne de la case
     * @return void 
     */
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
    /**
     * @param int prend en parametre une ligne de la grille
     * @param int prend en parametre une colonne de la grille
     */
    public void creuser(int lig, int col) {
        // permet de creuser la case à la ligne lig et à la colonne col
        if (this.getCase(lig, col).getEstRelevee() || this.getCase(lig, col).getEstMarquee()) {

        } 
        else {
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

    /**
     * Permet de pouvoir attribuer toute les cases voisines à chaque case
     * @return void 
     */
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

    /**
     * Permet de rejouer une partie sur l'ihm
     * @return void 
     */
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