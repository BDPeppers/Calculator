package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class Controller {
	@FXML
	private Label display;
	@FXML
	private Label result;
	String expression="";
	Object answer =null;
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine eng = mgr.getEngineByName("JavaScript");
	@FXML
	public void compute(ActionEvent event) {
		if((((Button)event.getSource())).getText().equals("CE")){//Clear Button
			expression = "";
			display.setText("0");
			result.setText("0");
		}else if((((Button)event.getSource())).getText().equals("=")){
			try {
				answer = eng.eval(expression);
				result.setText(answer.toString());
			} catch (ScriptException e) {
				result.setText("SYNTAX ERROR");
			} catch (NullPointerException e) {
				result.setText("SYNTAX ERROR");
			}finally{
				result.setText(answer.toString());
			}
		}else {
		expression += ((Button)event.getSource()).getText();
		display.setText(expression);
		}
	}

}
