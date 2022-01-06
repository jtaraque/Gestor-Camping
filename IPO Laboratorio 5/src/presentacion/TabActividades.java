package presentacion;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Actividades;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class TabActividades extends JPanel {
	private static ArrayList<Actividades> listaActividades = Actividades.iniciarLista(); 
	DefaultListModel modelo = new DefaultListModel();
	private JList list;
	private JButton btnAadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblHorario;
	private JLabel lblPrecio;
	private JButton btnLimpiar;
	private JComboBox cbHorario;
	private JLabel lblCupoMinimo;
	private JLabel lblCupoMaximo;
	private JSpinner spCupoMinimo;
	private JSpinner spCupoMaximo;
	private JLabel lblMonitor;
	private JComboBox cbMonitor;
	private JLabel lblDestinatario;
	private JComboBox cbDestinatario;
	private JSpinner spPrecio;
	private JLabel lblDescripcin;
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private JLabel lblAviso;
	private JLabel lblNombre;
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public TabActividades() {
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{112, 73, 73, 73, 76, 0, 62, 58, 0, 109, 0};
		gridBagLayout.rowHeights = new int[]{76, 29, 25, 0, 0, 0, 0, 0, 25, 49, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		list = new JList();
		iniciarLista();
		list.addListSelectionListener(new ListActividadesListSelectionListener());
		/*
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		
		lblNombre = new JLabel(MessagesTabActividades.getString("TabActividades.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 5;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 6;
		gbc_txtNombre.gridy = 1;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 8;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 3;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		add(list, gbc_list);

		lblHorario = new JLabel(MessagesTabActividades.getString("TabActividades.lblHorario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.anchor = GridBagConstraints.EAST;
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridx = 5;
		gbc_lblHorario.gridy = 2;
		add(lblHorario, gbc_lblHorario);

		cbHorario = new JComboBox();
		cbHorario.setModel(new DefaultComboBoxModel(new String[] {"11:00", "12:00", "16:00", "17:00", "18:00", "19:00"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
		GridBagConstraints gbc_cbHorario = new GridBagConstraints();
		gbc_cbHorario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbHorario.insets = new Insets(0, 0, 5, 5);
		gbc_cbHorario.gridx = 6;
		gbc_cbHorario.gridy = 2;
		add(cbHorario, gbc_cbHorario);

		lblCupoMinimo = new JLabel(MessagesTabActividades.getString("TabActividades.lblCupoMinimo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCupoMinimo = new GridBagConstraints();
		gbc_lblCupoMinimo.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMinimo.gridx = 5;
		gbc_lblCupoMinimo.gridy = 3;
		add(lblCupoMinimo, gbc_lblCupoMinimo);

		spCupoMinimo = new JSpinner();
		spCupoMinimo.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		GridBagConstraints gbc_spCupoMinimo = new GridBagConstraints();
		gbc_spCupoMinimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_spCupoMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_spCupoMinimo.gridx = 6;
		gbc_spCupoMinimo.gridy = 3;
		add(spCupoMinimo, gbc_spCupoMinimo);

		lblCupoMaximo = new JLabel(MessagesTabActividades.getString("TabActividades.lblCupoMaximo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCupoMaximo = new GridBagConstraints();
		gbc_lblCupoMaximo.anchor = GridBagConstraints.EAST;
		gbc_lblCupoMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupoMaximo.gridx = 5;
		gbc_lblCupoMaximo.gridy = 4;
		add(lblCupoMaximo, gbc_lblCupoMaximo);

		spCupoMaximo = new JSpinner();
		spCupoMaximo.setModel(new SpinnerNumberModel(11, 11, 40, 1));
		GridBagConstraints gbc_spCupoMaximo = new GridBagConstraints();
		gbc_spCupoMaximo.fill = GridBagConstraints.HORIZONTAL;
		gbc_spCupoMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_spCupoMaximo.gridx = 6;
		gbc_spCupoMaximo.gridy = 4;
		add(spCupoMaximo, gbc_spCupoMaximo);

		lblMonitor = new JLabel(MessagesTabActividades.getString("TabActividades.lblMonitor.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMonitor = new GridBagConstraints();
		gbc_lblMonitor.anchor = GridBagConstraints.EAST;
		gbc_lblMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitor.gridx = 5;
		gbc_lblMonitor.gridy = 5;
		add(lblMonitor, gbc_lblMonitor);

		cbMonitor = new JComboBox();
		cbMonitor.setModel(new DefaultComboBoxModel(new String[] {"Juanto", "Angel"})); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_cbMonitor = new GridBagConstraints();
		gbc_cbMonitor.gridwidth = 2;
		gbc_cbMonitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbMonitor.insets = new Insets(0, 0, 5, 5);
		gbc_cbMonitor.gridx = 6;
		gbc_cbMonitor.gridy = 5;
		add(cbMonitor, gbc_cbMonitor);

		lblDestinatario = new JLabel(MessagesTabActividades.getString("TabActividades.lblDestinatario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDestinatario = new GridBagConstraints();
		gbc_lblDestinatario.anchor = GridBagConstraints.EAST;
		gbc_lblDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatario.gridx = 5;
		gbc_lblDestinatario.gridy = 6;
		add(lblDestinatario, gbc_lblDestinatario);

		cbDestinatario = new JComboBox();
		cbDestinatario.setModel(new DefaultComboBoxModel(new String[] {MessagesTabActividades.getString("TabActividades.8"), MessagesTabActividades.getString("TabActividades.9"), MessagesTabActividades.getString("TabActividades.10")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_cbDestinatario = new GridBagConstraints();
		gbc_cbDestinatario.gridwidth = 2;
		gbc_cbDestinatario.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_cbDestinatario.gridx = 6;
		gbc_cbDestinatario.gridy = 6;
		add(cbDestinatario, gbc_cbDestinatario);

		lblPrecio = new JLabel(MessagesTabActividades.getString("TabActividades.lblPrecio.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 5;
		gbc_lblPrecio.gridy = 7;
		add(lblPrecio, gbc_lblPrecio);

		spPrecio = new JSpinner();
		spPrecio.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		GridBagConstraints gbc_spPrecio = new GridBagConstraints();
		gbc_spPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_spPrecio.gridx = 6;
		gbc_spPrecio.gridy = 7;
		add(spPrecio, gbc_spPrecio);

		lblDescripcin = new JLabel(MessagesTabActividades.getString("TabActividades.lblDescripcin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 5;
		gbc_lblDescripcin.gridy = 8;
		add(lblDescripcin, gbc_lblDescripcin);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		btnAadir = new JButton(MessagesTabActividades.getString("TabActividades.btnAadir.text")); //$NON-NLS-1$
		btnAadir.addActionListener(new BtnAadirActionListener());

		lblAviso = new JLabel(""); //$NON-NLS-1$
		lblAviso.setOpaque(true);
		lblAviso.setForeground(Color.red);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridx = 6;
		gbc_lblAviso.gridy = 9;
		add(lblAviso, gbc_lblAviso);
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.fill = GridBagConstraints.BOTH;
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 1;
		gbc_btnAadir.gridy = 10;
		add(btnAadir, gbc_btnAadir);

		btnModificar = new JButton(MessagesTabActividades.getString("TabActividades.btnModificar.text")); //$NON-NLS-1$
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 10;
		add(btnModificar, gbc_btnModificar);

		btnEliminar = new JButton(MessagesTabActividades.getString("TabActividades.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 10;
		add(btnEliminar, gbc_btnEliminar);

		btnLimpiar = new JButton(MessagesTabActividades.getString("TabActividades.btnLimpiar.text")); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.VERTICAL;
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 6;
		gbc_btnLimpiar.gridy = 10;
		add(btnLimpiar, gbc_btnLimpiar);

	}
	public void iniciarLista() {
		for (int i = 0; i <= listaActividades.size() - 1; i++) {
			modelo.addElement(listaActividades.get(i).getNombre());
		}
		list.setModel(modelo);
	}
	private class ListActividadesListSelectionListener implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {
			if(list.getSelectedIndex() !=-1) {
				txtNombre.setText(listaActividades.get(list.getSelectedIndex()).getNombre());
				cbHorario.setSelectedIndex(listaActividades.get(list.getSelectedIndex()).getHora());
				spCupoMinimo.setValue(listaActividades.get(list.getSelectedIndex()).getCupo_minimo());
				spCupoMaximo.setValue(listaActividades.get(list.getSelectedIndex()).getCupo_maximo());
				cbMonitor.setSelectedIndex(listaActividades.get(list.getSelectedIndex()).getMonitor());
				cbDestinatario.setSelectedIndex(listaActividades.get(list.getSelectedIndex()).getDestinatario());
				spPrecio.setValue(listaActividades.get(list.getSelectedIndex()).getPrecio());
				textPane.setText(listaActividades.get(list.getSelectedIndex()).getDescripcion());
			}
		}
	}

	public void limpiarCampos() {
		txtNombre.setText(""); //$NON-NLS-1$
		cbHorario.setSelectedIndex(0);
		spCupoMinimo.setValue(1);
		spCupoMaximo.setValue(11);
		cbMonitor.setSelectedIndex(0);
		cbDestinatario.setSelectedIndex(0);
		spPrecio.setValue(0);
		list.clearSelection();
		textPane.setText(""); //$NON-NLS-1$
		lblAviso.setText(""); //$NON-NLS-1$
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			limpiarCampos();
		}
	}

	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex()!=-1) {
				listaActividades.remove(list.getSelectedIndex());
				DefaultListModel modelo2 = new DefaultListModel();

				for (int i = 0; i <= listaActividades.size() - 1; i++) {
					modelo2.addElement(listaActividades.get(i).getNombre());
				}

				limpiarCampos();
				list.setModel(modelo2);

			}else {
				lblAviso.setText(MessagesTabActividades.getString("TabActividades.15")); //$NON-NLS-1$

			}
		}
	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex()!=-1) {
				Actividades a = listaActividades.get(list.getSelectedIndex());
				a.setNombre(txtNombre.getText());
				a.setHora(cbHorario.getSelectedIndex());
				a.setCupo_minimo((Integer)spCupoMinimo.getValue());
				a.setCupo_maximo((Integer)spCupoMaximo.getValue());
				a.setMonitor(cbMonitor.getSelectedIndex());
				a.setDestinatario(cbDestinatario.getSelectedIndex());
				a.setPrecio((Integer)spPrecio.getValue());
				a.setDescripcion(textPane.getText());
			}else{
				lblAviso.setText(MessagesTabActividades.getString("TabActividades.16")); //$NON-NLS-1$
			}
		}
	}
	public void anadirActividad(Actividades a) {
		DefaultListModel modelo2 = new DefaultListModel();
		listaActividades.add(a);
		for (int i = 0; i <= listaActividades.size() - 1; i++) {
			modelo2.addElement(listaActividades.get(i).getNombre());
		}
		list.setModel(modelo2);
		list.setSelectedIndex(listaActividades.size()-1);
		list.ensureIndexIsVisible(listaActividades.size()-1);
	}
	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				Actividades a= new Actividades(txtNombre.getText(), cbHorario.getSelectedIndex(), (Integer)spCupoMinimo.getValue(), (Integer)spCupoMaximo.getValue(), cbMonitor.getSelectedIndex(), cbDestinatario.getSelectedIndex(), (Integer)spPrecio.getValue(), textPane.getText());
				if(a.getNombre().equals("")||a.getDescripcion().equals("")) { //$NON-NLS-1$ //$NON-NLS-2$
					lblAviso.setText(MessagesTabActividades.getString("TabActividades.19")); //$NON-NLS-1$
				}
				else {
					anadirActividad(a);
				}		
			
		}
	}
}