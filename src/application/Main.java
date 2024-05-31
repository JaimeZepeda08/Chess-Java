package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import animation.Sprite;
import controller.GameController;
import controller.GameState;
import model.Board;

public class Main extends Application {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	public static final int SQUARE_SIZE = HEIGHT / Board.SIZE;

	private static Stage stage; 
	private static Group pieceGrid; 

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage defaultStage) {
		// set up stage
		stage = defaultStage;
		stage.setTitle("Chess - White");
		stage.setResizable(false);

		Board.init(); // initialize board

		Group gameObjects = new Group();
		// create grid
		gameObjects.getChildren().add(createGrid());
		// add pieces
		gameObjects.getChildren().add(drawPieces());

		Scene gameScene = new Scene(gameObjects, WIDTH, HEIGHT);
		stage.setScene(gameScene);

		// display stage
		stage.show();
	}

	private Group createGrid() {
		Group grid = new Group();
		boolean white = true;
		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				Rectangle rect = new Rectangle(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				rect.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
					GameController.selectPiece((int) rect.getY() / SQUARE_SIZE, (int) rect.getX() / SQUARE_SIZE);
					GameController.move();
				});
				if (white) {
					rect.setFill(Color.CORNSILK);
				} else {
					rect.setFill(Color.TAN);
				}
				grid.getChildren().add(rect);
				white = !white;
			}
			white = !white;
		}
		return grid;
	}

	private Group drawPieces() {
		pieceGrid = new Group();

		for (int i = 0; i < Board.SIZE; i++) {
			for (int j = 0; j < Board.SIZE; j++) {
				if (!Board.getBoard()[i][j].isEmpty()) {
					Sprite sprite = Board.getBoard()[i][j].getPiece().getSprite();
					pieceGrid.getChildren().add(sprite);
					sprite.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> {
						GameController.selectPiece((int) sprite.getY() / SQUARE_SIZE, (int) sprite.getX() / SQUARE_SIZE);
						GameController.move();
					});
					sprite.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, (event) -> {
						sprite.startHoverAnimation();
					});
					sprite.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, (event) -> {
						sprite.stopHoverAnimation();
					});
				}
			}
		}

		return pieceGrid;
	}

	public static void changeTitle(GameState gameState){
		if (gameState == GameState.BLACKTURN){
			stage.setTitle("Chess - Black");
		} else if (gameState == GameState.WHITETURN){
			stage.setTitle("Chess - White");
		}
	}

	public static Group getPieceGrid(){
		return pieceGrid;
	}
}