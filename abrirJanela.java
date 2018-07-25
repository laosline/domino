import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
 
public class abrirJanela extends Application {
	private Mao jogador = new Mao();
    	public static void main(String [] args) {
        	launch(args);
    	}
    
    	@Override
    	public void start(Stage primaryStage) {
    		primaryStage.setTitle("Peças na mão");
		Scene mainScene = createMainScene(args);
		primaryStage.setScene(mainScene);
		
        	primaryStage.show();
    	}


	public Scene createMainScene() {
		
		Text text1 = new Text("Peças:"+args); //mudar no Mao
        	text1.setX(100); 
        	text1.setY(50);  
		
	        Group root = new Group();
        	root.getChildren().add(text1);
		
		return new Scene(root, 400, 300);
	}
	
}