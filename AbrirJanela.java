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
 
public abstract class abrirJanela extends Application{
	private String [] pedras;
	private Stage primaryStage = new Stage();
    	public void abrir(String [] pedras) {
		this.pedras = pedras;
        	mostrar();
    	}
    
    	public void mostrar() {
    		primaryStage.setTitle("Pecas na mão");
		Scene mainScene = createMainScene();
		primaryStage.setScene(mainScene);
		
        	primaryStage.show();
    	}


	public Scene createMainScene() {
		
		Text text1 = new Text("Peças:"+this.pedras); //mudar no Mao
        	text1.setX(100); 
        	text1.setY(50);  
		
	        Group root = new Group();
        	root.getChildren().add(text1);
		
		return new Scene(root, 400, 300);
	}
	
}
