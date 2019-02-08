

import java.util.Scanner;

import javax.swing.JOptionPane;
public class Pounds_Shillings_Pennies {
	

  public static final int NEW_PENNIES_PER_OLD_PENNY = 67 ;
  public static final int OLD_PENNIES_PER_OLD_SHILLING = 12;
  public static final int NEW_SHILLINGS_PER_OLD_POUND = 20;
  public static final int NEW_PENNIES_PER_NEW_POUND = 100;
  public static final double ROUNDING_ADJUSTMENT = 0.01;

  public static void main(String[] args) {
   
				String input = JOptionPane.showInputDialog
("Enter the old amounts of money separated\nby spaces (pounds shillings pennies):");
                Scanner inputScanner = new Scanner( input );
                double oldpounds = inputScanner.nextDouble();
                double oldshillings =inputScanner.nextDouble();
                double oldpennies =inputScanner.nextDouble();
                inputScanner.close();
                
                double totalpounds = 
		                (((oldpounds*NEW_SHILLINGS_PER_OLD_POUND)
		                *OLD_PENNIES_PER_OLD_SHILLING)
		                *(NEW_PENNIES_PER_OLD_PENNY)
		                /NEW_PENNIES_PER_NEW_POUND);
                double totalshillings =								
                		((oldshillings*OLD_PENNIES_PER_OLD_SHILLING)
                		*NEW_PENNIES_PER_OLD_PENNY)
                		/NEW_PENNIES_PER_NEW_POUND;
                double totalpennies =
                		(oldpennies*NEW_PENNIES_PER_OLD_PENNY)
                		/(NEW_PENNIES_PER_NEW_POUND);
               double totalmoney=totalpounds +totalshillings +totalpennies;
               
                JOptionPane.showMessageDialog(null, "your modern amount is £" + totalmoney);
  }

}
