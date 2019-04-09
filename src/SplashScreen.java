// SplashScreen.java
// A simple application to show a title screen in the center of the screen
// for the amount of time given in the constructor.  This class includes
// a sample main() method to test the splash screen, but it's meant for use
// with other applications.
//

import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
public class SplashScreen extends JWindow {
  public int duration;
  private static Person person;
  private UserPass user = new UserPass();
  public SplashScreen( ) {
  
  }
  public SplashScreen(int d) {
    duration = d;
  }

  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.green);

    // Set the window's bounds, centering the window
    int width = 450;
    int height =115;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    // Build the splash screen
    JLabel label = new JLabel(new ImageIcon("oreilly.gif"));
    JLabel copyrt = new JLabel
      ("Abd Elrazek & Al-Hussary", JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 30));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.CENTER);
 
    content.setBorder(BorderFactory.createLineBorder(new Color(0,110,0) , 3));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }

  public void showSplashAndExit() {
    showSplash();
    
  }

  public static void main(String[] args) {
   
    SplashScreen splash = new SplashScreen(2000);
    splash.showSplashAndExit();
	try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
                // UserPass u = new UserPass ();  // create user object
				person = new Person();
				if (person.getConnection()== null){
					JOptionPane.showMessageDialog (null , "The Host is not availble..");
					System.exit(0);
				}else{
					Person frame = new Person ();
				    frame.setTitle("THE PERSON");
				    frame.setVisible(true);
				    frame.setLocationRelativeTo(null);
				    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				    frame.setResizable(false);
				    frame.pack();
				    // us.dispose();
				    // setVisible(false); 
				}
              
                
                
  }
}
