package main.Img;

import javafx.scene.image.Image;
import main.Model.Personaggio;
//La classe comprende sia il personaggio che un'immagine associata ad esso
public class Card {
    private Personaggio p;
    private Image image;
    public Card(Personaggio p) {
        this.p = p;
        String fileName = p.getNome()+".png";
        image = new Image("/main/Img/"+fileName,258,298,false,false);
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public Personaggio getP() {
        return p;
    }

    public void setP(Personaggio p) {
        this.p = p;
    }

}
