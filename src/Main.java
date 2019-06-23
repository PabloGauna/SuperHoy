import java.awt.EventQueue;

import controllers.MainController;
import models.MainModel;
import views.MainView;

public class Main {

public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView view = new MainView();					
					
					MainController controller = new MainController(view, new MainModel());					
					view.setControlador(controller);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}