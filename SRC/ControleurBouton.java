import javafx.event.EventHandler; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.input.MouseButton;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.Optional;

public class ControleurBouton implements EventHandler<MouseEvent> {

    private Bouton bouton;
    private Case laCase;
    private DemineurGraphique demineur;
    private Grille lePlateau;

    public ControleurBouton(Bouton bouton, Case laCase, DemineurGraphique demineur, Grille lePlateau) {
        this.bouton = bouton;
        this.laCase = laCase;
        this.demineur = demineur;
        this.lePlateau = lePlateau;
    }

    @Override
    public void handle(MouseEvent e) {
        if (!this.laCase.getEstRelevee()) {
            if (e.getButton() == MouseButton.PRIMARY) {
                System.out.println("clic gauche ( "+this.laCase.getLig()+", "+this.laCase.getCol()+" )");
                this.lePlateau.creuser(this.laCase.getLig(), this.laCase.getCol());
                System.out.println(this.lePlateau.getlBombe());
                this.bouton.maj();
                this.demineur.maj_de_la_grille();
                this.bouton.setDisable(true);
            }

            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("clic droit");
                if (!this.laCase.getEstRelevee()) {
                    this.laCase.marquer();
                    this.demineur.maj_de_la_grille();
                    this.bouton.maj();
                }
            }
        }

        this.demineur.maj_des_infos();

        System.out.println("Le jeu est-il perdu ? : " + this.lePlateau.getPerdu());
        if (this.lePlateau.getPerdu()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vous avez perdu !\nVoulez-vous rejouer ?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Attention");
            Optional<ButtonType> rep = alert.showAndWait();

            if (rep.isPresent() && rep.get() == ButtonType.YES) {
                this.lePlateau.init();
                this.demineur.maj_des_infos();
                this.demineur.maj_de_la_grille();

            } else {
                this.demineur.desactiver();
            }
        }
        else if (this.lePlateau.getCaseRevelee()+this.lePlateau.getNbbombe() == this.lePlateau.getNbLig()*this.lePlateau.getNbCol()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bravo Vous avez gagné !\nVoulez-vous rejouer ?", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Bravo");
            Optional<ButtonType> rep = alert.showAndWait();

            if (rep.isPresent() && rep.get() == ButtonType.YES) {
                this.lePlateau.init();
                this.demineur.maj_des_infos();
                this.demineur.maj_de_la_grille();
            } else {
                this.demineur.desactiver();
            }
        }

    }

}