import java.util.Comparator;
public class Comp implements Comparator<Case> {
    public int compare(Case c1, Case c2) {
        // tri par colonne et par ligne
        if (c1.getCol() == c2.getCol()) {
            return c1.getLig() - c2.getLig();
        } else {
            return c1.getCol() - c2.getCol();
        }
    }
}
