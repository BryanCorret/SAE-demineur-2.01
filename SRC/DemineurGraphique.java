import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

import javafx.scene.Node;
public class DemineurGraphique extends Application {

    private Grille jeu;
    private Pane infos;
    private GridPane grille;
    
    @Override
    public void init(){
        int nbParametres = this.getParameters().getRaw().size();
        try{
            int lignes = Integer.valueOf(this.getParameters().getRaw().get(0));
            int colonnes = Integer.valueOf(this.getParameters().getRaw().get(1));
            int nbBombes = Integer.valueOf(this.getParameters().getRaw().get(2)); 
            this.jeu = new Grille(lignes, colonnes, nbBombes);
        }
        catch(Exception e){
            this.jeu = new Grille(6, 6, 4);
        }
    }

    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.TOP_CENTER);
        this.grille = new GridPane();
        this.grille.setHgap(1);
        this.grille.setVgap(1);     
        for (int i = 0; i<this.jeu.getNbLig(); i++){
            for (int j=0; j<this.jeu.getNbCol(); j++){
                Case laCase = this.jeu.getCase(j, i);
                Bouton b = new Bouton(laCase);

                b.setOnMouseClicked(new ControleurBouton(b, laCase, this, this.jeu));
                grille.add(b, i, j);
            }
        }
        this.infos = new VBox(); 
        vbox.getChildren().addAll(grille, infos);
        this.jeu.toutLescasesVoisines();
        this.maj_de_la_grille();
        this.maj_des_infos();
        
        Scene scene = new Scene(vbox);
        stage.setTitle("Demineur");
        stage.setScene(scene);
        stage.show();
    }

    public void maj_de_la_grille(){
        for (Node b : this.grille.getChildren()){
            Bouton bb = (Bouton) b;
            bb.maj();
        }
    }

    public void desactiver(){
        for (Node b : this.grille.getChildren()){
            b.setDisable(true);
        }
    }
    
    public void maj_des_infos(){
        this.infos.getChildren().clear();
        Label label1 = new Label("Nombres de bombes : " + this.jeu.getNbbombe());
        Label label2 = new Label("Nombres de cases marquées : " + this.jeu.getCaseMarquee());
        Label label3 = new Label("Nombres de cases découvertes : " + this.jeu.getCaseRevelee());
        this.infos.getChildren().addAll(label1, label2, label3);
    }
    
    public static void main(String args[]){
        Application.launch(args);
    }
}
