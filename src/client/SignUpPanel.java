/* DESIGNED AND CODED BY JEREMY AFTEM */
package client;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customui.HubButton;
import customui.HubPassField;
import customui.HubTextField;
import customui.ThemeColors;
import library.ImageLibrary;
import utilities.scalableLabel;

public class SignUpPanel extends JPanel {
	private static final long serialVersionUID = -6157734000544090104L;
	
	private Image bg;
	private JLabel bgLabel;
	private HubTextField usernameTextField, fnameTextField, lnameTextField;
	private HubPassField passwordTextField, confirmPasswordTextField;
	private HubButton signupButton;
	private JPanel centerPanel, buttonBox;
	public SignUpPanel() {
		setLayout(new BorderLayout());
		setSize(1100,699);
		instantiateComponents();
		createGUI();
	}
	
	private void instantiateComponents() {	
		bg = ImageLibrary.getImage(Constants.SPLASH_IMAGE);
		/* scalableLabel is a JLabel */
		bgLabel = new scalableLabel(new ImageIcon(bg));
		usernameTextField = new HubTextField("Email");
		passwordTextField = new HubPassField(Constants.PASSWORD_TEXT);
		confirmPasswordTextField = new HubPassField("Confirm Password");
		fnameTextField = new HubTextField("First Name");
		lnameTextField = new HubTextField("Last Name");
		signupButton = new HubButton(Constants.SIGNUP_TEXT, ThemeColors.SIGNUP_COLOR, ThemeColors.SIGNUP_HIGHLIGHT_COLOR);
		centerPanel = new JPanel();		
		buttonBox = new JPanel();
	}
	
	private void createGUI() {
		bgLabel.setLayout(new GridBagLayout());
		/* Center Panel is a panel located vertically and horizontally in the center of the frame */
		centerPanel.setPreferredSize(new Dimension(310,460));
		centerPanel.setLayout(null);
		/* The components inside the center panel are placed by pixels,
		 * OK because user can't resize smaller than 1100x699 */
		fnameTextField.setBounds(0, 115, 150, 50);
		lnameTextField.setBounds(160, 115, 150, 50);
		usernameTextField.setBounds(0, 173, 310, 50);
		passwordTextField.setBounds(0, 231, 310, 50);
		confirmPasswordTextField.setBounds(0, 289, 310, 50);
		Image img = ImageLibrary.getScaledImage(ImageLibrary.getImage(Constants.SPLASH_LOGO), 310, 85);
		JLabel logoLabel = new JLabel(new ImageIcon(img));
		logoLabel.setBounds(0, 0, 310, 85);
		/* buttonBox: Container for buttons login and sign out */
		buttonBox.setLayout(new FlowLayout());
		buttonBox.setBounds(0, 350, 310, 60);
		signupButton.setPreferredSize(new Dimension(310, 50));
		//signupButton.setBounds(163,0,147,50);
		buttonBox.add(signupButton);
		/* Add all the components to the center panel */
		centerPanel.add(logoLabel);
		centerPanel.add(fnameTextField);
		centerPanel.add(lnameTextField);
		centerPanel.add(usernameTextField);
		centerPanel.add(passwordTextField);
		centerPanel.add(confirmPasswordTextField);
		centerPanel.add(buttonBox);
		/* Transparent panel */
		centerPanel.setOpaque(false);
		buttonBox.setOpaque(false);
		/* Add the centerPanel to the center (vertically and horizontally) of the JLabel */
		bgLabel.add(centerPanel, new GridBagConstraints());
		add(bgLabel);
	}
	
	public HubButton getButtonSignUp() {
		return signupButton;
	}
}