import java.lang.Math;
public class PlateauJeux extends Plateau{
    
    public PlateauJeux(Matrice m) {
        super(m);
    }
    
    public void setallBombe(){
        // 25% du cases sont des bombes
        long nbBombe = Math.round(Math.ceil(this.getNbCase() * 0.25)) ; // ici on arrondie avec ceil et nous convertison notre double en long
        for(int i = 0; i < nbBombe; i++ ){
            int pos1 = 1 + (int) (Math.random()*4); // nombre aléatoire entre 1 et 4
            int pos2 = 1 + (int) (Math.random()*4);
            
            if (getValeur(pos1 , pos2) == 'B'){ // En cas de doublon de valeur on refait un essaie 
                i -= 1;
            }
            
            this.setbombe(pos1, pos2);
        }
    }
    
    public void setbombe(int L , int c){
        this.setValeur(L, c, 'B');
    }

    // savoir le nombre de bombe sur la case

    public void setNbALLBombeAdj(){
        /*
        Droite = +1
        Gauche = -1
        Haut = -1
        Bas = +1
        BAS droit = +1 +1
        BAS gauche = +1 -1
        Haut Droit = -1 +1
        Haut gauche = -1 -1
        */
        for(int i = 0; i < this.getNbLigne(); i++ ){
            for(int j = 0; j < this.getNbCol(); j++ ){
                int nbBombeproche = 0;
                if (getValeur(i, j) != 'B' ){
                    // Selection de toute les lignes du HAUT adjacent =(BAS / DROITE / GAUCHE/ BAS DROITE / BAS GAUCHE)
                    if (i == 0){
                        // Selection de la premier case de la ligne du HAUT adjacent = (BAS / DROITE / BAS DROITE )
                            if (j == 0 ){
                            // Droit
                            if (this.getValeur(i, j+1) == 'B')
                                nbBombeproche +=1;

                            // BAS
                            if (this.getValeur(i+1, j) == 'B')
                                nbBombeproche +=1;

                            // BAS DROIT
                            if (this.getValeur(i+1, j+1) == 'B')
                                nbBombeproche +=1;
                            
                            this.setValeur(i, j, intToChar(nbBombeproche));
                            }
                            // Selection de toute les lignes du HAUT adjacent = (BAS / GAUCHE / BAS GAUCHE)
                            else if (j == this.getNbCol()-1 ){

                                // BAS
                                if (this.getValeur(i+1, j) == 'B')
                                    nbBombeproche +=1;

                                // Gauche 
                                if (this.getValeur(i, j-1) == 'B')
                                    nbBombeproche +=1;

                                // BAS GAUCHE
                                if (this.getValeur(i+1, j-1) == 'B')
                                    nbBombeproche +=1;
                                this.setValeur(i, j, intToChar(nbBombeproche));
                            }
                            // Selection de toute les lignes du HAUT adjacent = (BAS / GAUCHE/ DROITE / BAS GAUCHE/ BAS DROITE)
                            else{
                            
                                // BAS
                                if (this.getValeur(i+1, j) == 'B')
                                    nbBombeproche +=1;

                                // Gauche 
                                if (this.getValeur(i, j+1) == 'B')
                                    nbBombeproche +=1;

                                // Droit
                                if (this.getValeur(i, j+1) == 'B')
                                    nbBombeproche +=1;
                                
                                // BAS GAUCHE
                                if (this.getValeur(i+1, j-1) == 'B')
                                    nbBombeproche +=1;
                                
                                // BAS DROIT
                                if (this.getValeur(i+1, j+1) == 'B')
                                    nbBombeproche +=1;
                                this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                    }   
                    // Selection de toute les lignes du BAS adjacent =(HAUT / DROIT / GAUCHE / HAUT DROIT/ HAUT GAUCHE)
                    else if (i == this.getNbLigne()-1){
                        // Selection de la premier case de la ligne du BAS adjacent = (HAUT / DROIT/ HAUT DROIT)
                        if (j == 0 ){

                            // HAUT
                            if (this.getValeur(i-1, j) == 'B')
                                nbBombeproche +=1;

                            // DROIT
                            if (this.getValeur(i, j+1) == 'B')
                                nbBombeproche +=1;

                            // HAUT DROIT
                            if (this.getValeur(i-1, j+1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                        // Selection de toute les lignes du BAS adjacent = (HAUT / GAUCHE / HAUT GAUCHE)
                        else if (j == this.getNbCol()-1 ){
                            // HAUT
                            if (this.getValeur(i-1, j) == 'B')
                                nbBombeproche +=1;

                            // GAUCHE
                            if (this.getValeur(i, j-1) == 'B')
                            nbBombeproche +=1;

                        // HAUT GAUCHE
                            if (this.getValeur(i-1, j-1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                        
                        // Selection de toute les lignes du BAS adjacent = (HAUT / GAUCHE / DROIT / HAUT GAUCHE / HAUT DROIT)
                        else{
                            // HAUT
                            if (this.getValeur(i-1, j) == 'B')
                                nbBombeproche +=1;

                            // GAUCHE
                            if (this.getValeur(i, j-1) == 'B')
                            nbBombeproche +=1;

                            // DROIT
                            if (this.getValeur(i, j+1) == 'B')
                                nbBombeproche +=1;

                            // HAUT GAUCHE
                            if (this.getValeur(i-1, j-1) == 'B')
                                nbBombeproche +=1;
                            
                            // HAUT DROIT
                            if (this.getValeur(i-1, j+1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                    }
                    // Selection de toute les autres lignes non-speciales adjacent = (H / B / D / G / HD / HG / BD / BG  )
                    else{

                        if (j == 0 ){
                             // HAUT
                             if (this.getValeur(i-1, j) == 'B')
                             nbBombeproche +=1;

                            // DROIT
                            if (this.getValeur(i, j+1) == 'B')
                                nbBombeproche +=1;

                            // HAUT DROIT
                            if (this.getValeur(i-1, j+1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }

                        else if (j == this.getNbCol()-1 ){
                            // HAUT
                            if (this.getValeur(i-1, j) == 'B')
                                nbBombeproche +=1;

                            // GAUCHE
                            if (this.getValeur(i, j-1) == 'B')
                            nbBombeproche +=1;

                            // HAUT GAUCHE
                            if (this.getValeur(i-1, j-1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                        else{
                            // HAUT
                            if (this.getValeur(i-1, j) == 'B')
                                nbBombeproche +=1;
                            // BAS
                            if (this.getValeur(i+1, j) == 'B')
                            nbBombeproche +=1;

                            // GAUCHE
                            if (this.getValeur(i, j-1) == 'B')
                                nbBombeproche +=1;

                            // DROIT
                            if (this.getValeur(i, j+1) == 'B')
                                nbBombeproche +=1;

                            // HAUT GAUCHE
                            if (this.getValeur(i-1, j-1) == 'B')
                                nbBombeproche +=1;
                            
                            // HAUT DROIT
                            if (this.getValeur(i-1, j+1) == 'B')
                                nbBombeproche +=1;

                            // BAS GAUCHE
                            if (this.getValeur(i+1, j-1) == 'B')
                            nbBombeproche +=1;
                            
                            // BAS DROIT
                            if (this.getValeur(i+1, j+1) == 'B')
                                nbBombeproche +=1;
                            this.setValeur(i, j, intToChar(nbBombeproche));

                        }
                    }
                }
            }
        }
    }

}
