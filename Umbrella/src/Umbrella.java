
import javax.swing.JOptionPane;
public class Umbrella {

	public static void main(String[] args) {
				
		int answer = JOptionPane.showConfirmDialog(null, "Is it raining?");
		boolean raining = (answer == JOptionPane.YES_OPTION);
		if (raining){
			JOptionPane.showMessageDialog(null, "Bring an umbrella and put it up ");
		}
		else if (answer == JOptionPane.CANCEL_OPTION){
			JOptionPane.showMessageDialog(null, "Canceled");
		}
		else {
		answer = JOptionPane.showConfirmDialog(null, "Does it look like it might rain?");	
		boolean mightRain = (answer == JOptionPane.YES_OPTION);
				if (mightRain) {
					JOptionPane.showMessageDialog(null, "Bring an umbrella"); 
					 answer = JOptionPane.showConfirmDialog(null, "Does it start to rain?");
					 boolean startRain = (answer == JOptionPane.YES_OPTION);
						if (startRain){
							JOptionPane.showMessageDialog(null, "put the umbrella up"); 
						}
						else if (answer == JOptionPane.CANCEL_OPTION) {
							JOptionPane.showMessageDialog(null, "Canceled");
						}
						else{
							JOptionPane.showMessageDialog(null, "Don't put the umbrella up");
						}
				}
				else if (answer == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Canceled");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Don't bring an umbrella");
				}
		}
	 }
}
			
			
			
			      
