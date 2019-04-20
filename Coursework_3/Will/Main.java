package application;


    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Pos;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.Pane;
	import javafx.scene.layout.StackPane;
	import javafx.scene.paint.Color;
    import javafx.scene.shape.Rectangle;
	import javafx.scene.Parent;


	public class Main extends Application implements EventHandler<ActionEvent>{
		private Parent createContent() {
			Pane root = new Pane();
			root.setPrefSize(1000,1000);
		
			 for(int i =1 ; i < 9; ++i) {
				for(int j=1 ; j< 9 ; ++j) {
					Tile tile = new Tile();
					tile.setTranslateX(j*100);
					tile.setTranslateY(i*100);
					 root.getChildren().addAll(tile);
					 }
				 }
			
			root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			    @Override
			        public void handle(MouseEvent event) {
			    	int x_coord = (int)(Math.rint((event.getSceneX())/100));
			    	int y_coord = (int)(Math.rint((event.getSceneY())/100));
			        System.out.println(x_coord+ " + " + y_coord);
			        
			    }
			});
			return root;
		}
		@Override
		public void start(Stage primaryStage) {
				primaryStage.setScene(new Scene(createContent()));
				primaryStage.show();
		}
		
		private class Tile extends StackPane{
			public Tile() {
				Rectangle boarder = new Rectangle(100,100);
				boarder.setFill(Color.BEIGE);
				boarder.setStroke(Color.BLACK);
				setAlignment(Pos.CENTER);
				getChildren().addAll(boarder);
			}
		}
	

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}	
}