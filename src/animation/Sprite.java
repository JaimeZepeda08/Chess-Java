package animation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.animation.ScaleTransition;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * This class extends ImageView and is used to create Images that can be
 * displayed using JavaFX
 * 
 * @author jaime
 */
public class Sprite extends ImageView {

	private Image image; // image object
	ScaleTransition scaleTransition;

	/**
	 * Constructor for an image
	 * 
	 * @param filepath String representing the path to the image file
	 * @param size     the size of the image
	 */
	public Sprite(String filepath, double size) {
		try {
			image = new Image(new FileInputStream(filepath));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		setImage(image);
		setFitWidth(size);
		setPreserveRatio(true);
		setSmooth(true);
		setCache(true);
	}

	/**
	 * Adds a shadow to show that it's been selected
	 */
	public void selectPiece() {
		// add shadow
		InnerShadow shadow = new InnerShadow();
		shadow.setColor(Color.DEEPSKYBLUE); 
        shadow.setRadius(15); 
        shadow.setOffsetX(0); 
        shadow.setOffsetY(0); 
		setEffect(shadow);
	}

	/**
	 * Resets the image to its original state
	 */
	public void deselectPiece() {
		setEffect(null);
	}

	/**
	 * Starts hover animation 
	 */
	public void startHoverAnimation(){
		// size animation
		scaleTransition = new ScaleTransition(Duration.millis(5), this);
		scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
		scaleTransition.play();
	}

	/**
	 * Stops hover animation
	 */
	public void stopHoverAnimation(){
		scaleTransition.stop();
        setScaleX(1.0);
       	setScaleY(1.0);
	}
}
