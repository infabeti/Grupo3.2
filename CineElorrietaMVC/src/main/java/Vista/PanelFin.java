package Vista;

import javax.swing.JPanel;

import Controlador.ControladorPanelFin;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PanelFin extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelFin(ControladorPanelFin controladorPanelFin) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblFin = new JLabel("FIN");
		lblFin.setForeground(Color.WHITE);
		lblFin.setFont(new Font("Arial", Font.PLAIN, 34));
		lblFin.setBounds(195, 91, 70, 57);
		add(lblFin);

	}

}
