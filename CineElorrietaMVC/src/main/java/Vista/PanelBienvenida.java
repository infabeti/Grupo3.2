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
		lblBienvenida.setFont(new Font("Arial", Font.PLAIN, 58));
		lblBienvenida.setBounds(73, 78, 367, 136);
		add(lblBienvenida);
		
		JLabel lblNewLabel = new JLabel("Cartelera del cine Elorrieta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(139, 228, 244, 44);
		add(lblNewLabel);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	}
}


