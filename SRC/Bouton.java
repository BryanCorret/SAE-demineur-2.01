import javafx.scene.control.Button; 
import javafx.scene.image.ImageView;
 import javafx.scene.image.Image;;

public class Bouton extends Button{
    
    private Case laCase;

    public Bouton(Case laCase){
        super();
        this.setPrefWidth(30);
        this.setPrefHeight(30);
        this.laCase = laCase;
        if (laCase.getEstRelevee() && laCase.getEstBombe())
            ajouteImage("bombe.jpeg");
        else if (laCase.getEstRelevee() && laCase.getEstBombe())
            ajouteImage("bombe.jpeg");
        
    }
    
    private void ajouteImage(String fichierImage){
        try{
                Image image = new Image(fichierImage);
                ImageView iv = new ImageView();
                iv.setImage(image);
                iv.setFitWidth(20);
                iv.setPreserveRatio(true);
                this.setGraphic(iv);
            }
        catch(Exception e){
            this.setText(laCase.getAffichage());
        }
    }
    
    public void maj(){
        this.setText(this.laCase.getAffichage());
        if (this.laCase.getEstRelevee())

            this.setDisable(true);

        else
            this.setDisable(false);
        this.setText(this.laCase.getAffichage());
    }
}
