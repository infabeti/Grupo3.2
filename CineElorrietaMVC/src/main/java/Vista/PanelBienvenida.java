package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		setBackground(Color.DARK_GRAY);
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		
		setLayout(null);
		
		lblBienvenida = new JLabel("\u00A1Bienvenid@! ");
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setFont(new Font("Shocking Headline", Font.PLAIN, 61));
		lblBienvenida.setBounds(145, 99, 198, 136);
		add(lblBienvenida);
		
		JLabel lblNewLabel = new JLabel("Cartelera del cine Elorrieta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Shocking Headline", Font.PLAIN, 32));
		lblNewLabel.setBounds(127, 245, 234, 44);
		add(lblNewLabel);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	}
}


