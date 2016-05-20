package guiLayer;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import org.freixas.jcalendar.*;


class ArrivalDate
    extends JFrame
{
	
public static void
main(
    String[] args)
{
    new ArrivalDate();
}


public
ArrivalDate()
{

    setTitle("ArrivalDate");
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Container contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(2, 2, 5, 5));


    MyDateListener listener = new MyDateListener();
    
        JCalendarCombo calendar1 =
    	new JCalendarCombo(
    	    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
    	    true);
        getContentPane().add(calendar1);
        calendar1.setEditable(true);
        calendar1.addDateListener(listener);


    JPanel panel1 = new JPanel(new BorderLayout());
    contentPane.add(panel1);
    
    JLabel lblPleaseSelectYour = new JLabel("Please select your arrival date above.");
    panel1.add(lblPleaseSelectYour, BorderLayout.CENTER);

    pack();
    setVisible(true);
}


private class MyDateListener
      implements DateListener
{

public void
dateChanged(
    DateEvent e)
{
    Calendar c = e.getSelectedDate();
    if (c != null) {
	System.out.println(c.getTime());
    }
    else {
	System.out.println("No time has been selected.");
    }
}

}
}
