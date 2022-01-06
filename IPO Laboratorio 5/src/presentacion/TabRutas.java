package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dominio.Ruta;

import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.ArrayList;

public class TabRutas extends JPanel {
	private static ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private TextArea textArea;
	private JPanel panel_1;
	private JLabel lblFoto;

	/**
	 * Create the panel.
	 */
	public TabRutas() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{Messages.getString("TabRutas.2"), "15/12/2020", "17:00", "18:00", "Juanto", Messages.getString("TabRutas.0"), new Integer(15)}, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
					{Messages.getString("TabRutas.1"), "17/12/2020", "11:00", "13:00", "Angel", Messages.getString("TabRutas.3"), new Integer(40)}, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				},
				new String[] {
						"Ruta", "D\u00EDa", "Hora de inicio", "Hora de fin", "Monitor", "Punto de encuentro", "Personas m\u00E1ximas" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getSelectionModel().addListSelectionListener(new TableListSelectionListener());


		//Inicialización de rutas

		scrollPane.setViewportView(table);
		String descripcion1 = Messages.getString("TabRutas.19"); //$NON-NLS-1$
		String descripcion2 = Messages.getString("TabRutas.20"); //$NON-NLS-1$

		Ruta r1 = new Ruta("Ruta por el campo", "15/12/2020", "17:00", "18:00", "Juanto", "Entrada del camping",10,descripcion1,"/presentacion/mapa1.png"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		Ruta r2 = new Ruta("Ruta hasta el lago", "17/12/2020", "11:00", "13:00", "Angel", "Plaza del camping",40,descripcion2,"/presentacion/mapa2.png"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
		listaRutas.add(r1);
		listaRutas.add(r2);



		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{188, 229, 37, 0};
		gbl_panel.rowHeights = new int[]{150, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		textArea = new TextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.anchor = GridBagConstraints.NORTHWEST;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 0;
		panel.add(textArea, gbc_textArea);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);

		lblFoto = new JLabel(""); //$NON-NLS-1$
	      lblFoto.setPreferredSize(new Dimension(780, 380));

		panel_1.add(lblFoto);

	}
	private class TableListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			textArea.setText(listaRutas.get(table.getSelectedRow()).getDescripcion());

			Image imagenOriginal;
			try {
				imagenOriginal = ImageIO.read(TabRutas.class.getResource(listaRutas.get(table.getSelectedRow()).getMapa()));
				Image imagenEscalada = imagenOriginal.getScaledInstance(lblFoto.getWidth(),
						lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
				ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
				lblFoto.setIcon(iconoLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
