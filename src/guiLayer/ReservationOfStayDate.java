package guiLayer;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import org.freixas.jcalendar.*;


class ReservationOfStayDate  extends JFrame {
	
	private ReservationMenu menu;
	private int arrDep;
	
	public static void main( String[] args) {
		new ReservationOfStayDate(new ReservationMenu(), 1);
	}


	public ReservationOfStayDate(ReservationMenu menu, int arrDep) {

		this.menu = menu;
		this.arrDep = arrDep;
		
    setTitle("Reservation of Stay Date");
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
    
    JLabel lblPleaseSelectYour = new JLabel("Please select the date above.");
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
	if(arrDep == 1){
		menu.setArrivalDate(getDate(c.getTime().toString()));
		ReservationOfStayDate.this.dispose();
	}else {
		menu.setDepartureDate(getDate(c.getTime().toString()));
		ReservationOfStayDate.this.dispose();
	}
    }
    else {
	System.out.println("No time has been selected.");
    }
}
private String getDate(String date){
	String export = "";
	
	export = export + date.substring(8, 10);
	switch(date.substring(4, 7)){
		case "Jan":
			export = export + "-01";
			break;
		case "Feb":
			export = export + "-02";
			break;
		case "Mar":
			export = export + "-03";
			break;
		case "Apr":
			export = export + "-04";
			break;
		case "May":
			export = export + "-05";
			break;
		case "Jun":
			export = export + "-06";
			break;
		case "Jul":
			export = export + "-07";
			break;
		case "Aug":
			export = export + "-08";
			break;
		case "Sep":
			export = export + "-09";
			break;
		case "Oct":
			export = export + "-10";
			break;
		case "Nov":
			export = export + "-11";
			break;
		case "Dec":
			export = export + "-12";
			break;
	}
	
	export = export + "-" + date.substring(25);
	
	return export;
}
}

}
