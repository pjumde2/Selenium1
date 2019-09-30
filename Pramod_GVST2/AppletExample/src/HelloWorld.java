import java.applet.Applet;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class HelloWorld extends Applet {
	char[][] charValues = new char[10][10];
    DanTable aTable;
    boolean allowUserInput = false;

    public void init()	{
    	Button btnStart = new Button("Start");
    	this.add(btnStart);
    	aTable = new DanTable();
    	this.add( aTable );
    }
}
@SuppressWarnings("serial")
class DanTable extends JPanel {
    public DanTable() {
        Object[][] cellData = {
            {"row1-col1", "row1-col2"},
            {"row2-col1", "row2-col2"}};
        String[] columnNames = {"col1", "col2"};
        add(  new JTable(cellData, columnNames) ) ;
    }
}