package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import dominio.Reservas;
import dominio.alojamiento;
import dominio.bungalow;
import dominio.parcela;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class TabReservas extends JPanel {
	DefaultListModel modelo = new DefaultListModel();
	private JPanel pnlLista;
	private JPanel pnlAtributos;
	private JPanel pnlParcela;
	private JPanel pnlBungalow;
	private JLabel lblCategoria;
	private JLabel lblPrecionocheParcela;
	private JLabel lblTemporada;
	private JLabel lblMetrosCuadradosParcela;
	private JLabel lblCercanoa;
	private JCheckBox rdbtnAseos;
	private JCheckBox rdbtnPiscina;
	private JCheckBox rdbtnRestaurante;
	private JCheckBox rdbtnEntrada;
	private JLabel lblLuz;
	private JCheckBox cbLuz;
	private JComboBox cbCategoria;
	private JSpinner spPrecio;
	private JComboBox cbTemporada;
	private JSpinner spMetrosCuadradosParcela;
	private JPanel pnlDisponibilidad;
	private JLabel lblTamanio;
	private JLabel lblCapacidad;
	private JLabel lblPrecionocheBungalow;
	private JLabel lblMetrosCuadradosBungalow;
	private JLabel lblCaracteristicas;
	private JCheckBox chckbxMenaje;
	private JCheckBox chckbxMicroondas;
	private JCheckBox chckbxSabanas;
	private JCheckBox chckbxToallas;
	private JSpinner spCapacidad;
	private JComboBox cbTamanio;
	private JSpinner spPrecioNoche;
	private JSpinner spMetrosCuadradosBungalow;
	private JLabel lblDisponibilidad;
	private JComboBox cbDisponibilidad;
	private JLabel lblFechaDeEntrada;
	private JLabel lblFechaDeSalida;
	private JLabel lblCliente;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblNumeroDeOcupantes;
	private JLabel lblSolicitudes;
	private JCheckBox chckbxMenaje_1;
	private JCheckBox cbCuna;
	private JCheckBox chckbxMovEspecial;
	private JCheckBox chckbxMuebleBar;
	private JFormattedTextField ftxtFechaEntrada;
	private JFormattedTextField ftxtFechaSalida;
	private JTextField txtCliente;
	private JFormattedTextField ftxtTelefono;
	private JFormattedTextField ftxtEmail;
	private JSpinner spOcupantes;
	private JButton btnReservar;
	private JButton btnLimpiar;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblAviso;

	boolean[] arraybool = {false,true,true,true};
	boolean[] arraybool1 = {true,true,true,true};
	bungalow bun1 = new bungalow("bungalow 1", 70.0, 90,1,10,arraybool); //$NON-NLS-1$
	bungalow bun2 = new bungalow("bungalow 2", 120.0, 160,2,15,arraybool1); //$NON-NLS-1$
	bungalow bun3 = new bungalow("bungalow 3", 55.0, 70,0,6,arraybool1); //$NON-NLS-1$
	boolean[] arraybool2 = {false,true,true,true};
	boolean[] arraybool3 = {true,true,true,false};
	boolean[] arraybool4 = {false,true,false,true};
	parcela par1 = new parcela("parcela1",40.0,1, 1,60,arraybool2, true ); //$NON-NLS-1$
	parcela par2 = new parcela("parcela2",50.0,2, 1,80,arraybool3, true ); //$NON-NLS-1$
	parcela par3 = new parcela("parcela3",30.0,0, 0,40,arraybool4, true ); //$NON-NLS-1$

	private alojamiento[] listaAlojamientos = {bun1,bun2,bun3,par1,par2,par3};

	private ArrayList<Reservas> listaReservas = Reservas.iniciarReservas();
	private JButton btnHistorialReservas;


	/**
	 * Create the panel.
	 */
	public TabReservas() {
		setLayout(new BorderLayout(0, 0));

		pnlLista = new JPanel();
		pnlLista.setBackground(Color.LIGHT_GRAY);
		add(pnlLista, BorderLayout.WEST);
		GridBagLayout gbl_pnlLista = new GridBagLayout();
		gbl_pnlLista.columnWidths = new int[]{63, 224, 80, 0};
		gbl_pnlLista.rowHeights = new int[]{60, 381, 123, 0};
		gbl_pnlLista.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlLista.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlLista.setLayout(gbl_pnlLista);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		pnlLista.add(scrollPane, gbc_scrollPane);

		list = new JList();
		iniciarLista();
		list.addListSelectionListener(new ListAlojamientosListSelectionListener());

		/*
		list.setModel(new AbstractListModel() {
			String[] values = new String[6] ;
			for(int i=0;i<6;i++) {
				values[i]=listaAlojamiento[i].getNombre();
			}
			public int getSize() {
				return 6;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		scrollPane.setViewportView(list);
		pnlAtributos = new JPanel();
		add(pnlAtributos, BorderLayout.CENTER);
		pnlAtributos.setLayout(new CardLayout(0, 0));

		pnlParcela = new JPanel();
		pnlParcela.setBackground(Color.LIGHT_GRAY);
		pnlAtributos.add(pnlParcela, "name_377345674859300"); //$NON-NLS-1$
		GridBagLayout gbl_pnlParcela = new GridBagLayout();
		gbl_pnlParcela.columnWidths = new int[]{0, 0, 73, 127, 0};
		gbl_pnlParcela.rowHeights = new int[]{66, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlParcela.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlParcela.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlParcela.setLayout(gbl_pnlParcela);

		lblCategoria = new JLabel(MessagesTabReservas.getString("TabReservas.lblCategoria.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 1;
		pnlParcela.add(lblCategoria, gbc_lblCategoria);

		cbCategoria = new JComboBox();
		cbCategoria.setEnabled(false);
		cbCategoria.setModel(new DefaultComboBoxModel(new String[] {MessagesTabReservas.getString("TabReservas.Pequenia"), MessagesTabReservas.getString("TabReservas.Mediana"), "Deluxe"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridwidth = 2;
		gbc_cbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 1;
		pnlParcela.add(cbCategoria, gbc_cbCategoria);

		lblPrecionocheParcela = new JLabel(MessagesTabReservas.getString("TabReservas.lblPrecionocheParcela.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecionocheParcela = new GridBagConstraints();
		gbc_lblPrecionocheParcela.anchor = GridBagConstraints.EAST;
		gbc_lblPrecionocheParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecionocheParcela.gridx = 0;
		gbc_lblPrecionocheParcela.gridy = 2;
		pnlParcela.add(lblPrecionocheParcela, gbc_lblPrecionocheParcela);

		spPrecio = new JSpinner();
		spPrecio.setEnabled(false);
		spPrecio.setModel(new SpinnerNumberModel(30, 10, 100, 1));
		GridBagConstraints gbc_spPrecio = new GridBagConstraints();
		gbc_spPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_spPrecio.gridx = 1;
		gbc_spPrecio.gridy = 2;
		pnlParcela.add(spPrecio, gbc_spPrecio);

		lblTemporada = new JLabel(MessagesTabReservas.getString("TabReservas.lblTemporada.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTemporada = new GridBagConstraints();
		gbc_lblTemporada.anchor = GridBagConstraints.EAST;
		gbc_lblTemporada.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemporada.gridx = 0;
		gbc_lblTemporada.gridy = 3;
		pnlParcela.add(lblTemporada, gbc_lblTemporada);

		cbTemporada = new JComboBox();
		cbTemporada.setEnabled(false);
		cbTemporada.setModel(new DefaultComboBoxModel(new String[] {MessagesTabReservas.getString("TabReservas.Baja"), MessagesTabReservas.getString("TabReservas.Media"), MessagesTabReservas.getString("TabReservas.Alta")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_cbTemporada = new GridBagConstraints();
		gbc_cbTemporada.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTemporada.insets = new Insets(0, 0, 5, 5);
		gbc_cbTemporada.gridx = 1;
		gbc_cbTemporada.gridy = 3;
		pnlParcela.add(cbTemporada, gbc_cbTemporada);

		lblMetrosCuadradosParcela = new JLabel(MessagesTabReservas.getString("TabReservas.lblMetrosCuadradosParcela.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMetrosCuadradosParcela = new GridBagConstraints();
		gbc_lblMetrosCuadradosParcela.anchor = GridBagConstraints.EAST;
		gbc_lblMetrosCuadradosParcela.insets = new Insets(0, 0, 5, 5);
		gbc_lblMetrosCuadradosParcela.gridx = 0;
		gbc_lblMetrosCuadradosParcela.gridy = 4;
		pnlParcela.add(lblMetrosCuadradosParcela, gbc_lblMetrosCuadradosParcela);

		spMetrosCuadradosParcela = new JSpinner();
		spMetrosCuadradosParcela.setModel(new SpinnerNumberModel(20, 20, 100, 1));
		spMetrosCuadradosParcela.setEnabled(false);
		GridBagConstraints gbc_spMetrosCuadradosParcela = new GridBagConstraints();
		gbc_spMetrosCuadradosParcela.fill = GridBagConstraints.HORIZONTAL;
		gbc_spMetrosCuadradosParcela.insets = new Insets(0, 0, 5, 5);
		gbc_spMetrosCuadradosParcela.gridx = 1;
		gbc_spMetrosCuadradosParcela.gridy = 4;
		pnlParcela.add(spMetrosCuadradosParcela, gbc_spMetrosCuadradosParcela);

		lblCercanoa = new JLabel(MessagesTabReservas.getString("TabReservas.lblCercanoa.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCercanoa = new GridBagConstraints();
		gbc_lblCercanoa.anchor = GridBagConstraints.EAST;
		gbc_lblCercanoa.gridheight = 2;
		gbc_lblCercanoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblCercanoa.gridx = 0;
		gbc_lblCercanoa.gridy = 5;
		pnlParcela.add(lblCercanoa, gbc_lblCercanoa);

		rdbtnAseos = new JCheckBox(MessagesTabReservas.getString("TabReservas.rdbtnAseos.text")); //$NON-NLS-1$
		rdbtnAseos.setEnabled(false);
		GridBagConstraints gbc_rdbtnAseos = new GridBagConstraints();
		gbc_rdbtnAseos.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnAseos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAseos.gridx = 1;
		gbc_rdbtnAseos.gridy = 5;
		pnlParcela.add(rdbtnAseos, gbc_rdbtnAseos);

		rdbtnRestaurante = new JCheckBox(MessagesTabReservas.getString("TabReservas.rdbtnRestaurante.text")); //$NON-NLS-1$
		rdbtnRestaurante.setEnabled(false);
		GridBagConstraints gbc_rdbtnRestaurante = new GridBagConstraints();
		gbc_rdbtnRestaurante.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRestaurante.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRestaurante.gridx = 2;
		gbc_rdbtnRestaurante.gridy = 5;
		pnlParcela.add(rdbtnRestaurante, gbc_rdbtnRestaurante);

		rdbtnPiscina = new JCheckBox(MessagesTabReservas.getString("TabReservas.rdbtnPiscina.text")); //$NON-NLS-1$
		rdbtnPiscina.setEnabled(false);
		GridBagConstraints gbc_rdbtnPiscina = new GridBagConstraints();
		gbc_rdbtnPiscina.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnPiscina.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPiscina.gridx = 1;
		gbc_rdbtnPiscina.gridy = 6;
		pnlParcela.add(rdbtnPiscina, gbc_rdbtnPiscina);

		rdbtnEntrada = new JCheckBox(MessagesTabReservas.getString("TabReservas.rdbtnEntrada.text")); //$NON-NLS-1$
		rdbtnEntrada.setEnabled(false);
		GridBagConstraints gbc_rdbtnEntrada = new GridBagConstraints();
		gbc_rdbtnEntrada.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEntrada.gridx = 2;
		gbc_rdbtnEntrada.gridy = 6;
		pnlParcela.add(rdbtnEntrada, gbc_rdbtnEntrada);

		lblLuz = new JLabel(MessagesTabReservas.getString("TabReservas.lblLuz.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblLuz = new GridBagConstraints();
		gbc_lblLuz.anchor = GridBagConstraints.EAST;
		gbc_lblLuz.insets = new Insets(0, 0, 0, 5);
		gbc_lblLuz.gridx = 0;
		gbc_lblLuz.gridy = 7;
		pnlParcela.add(lblLuz, gbc_lblLuz);

		cbLuz = new JCheckBox(""); //$NON-NLS-1$
		cbLuz.setEnabled(false);
		GridBagConstraints gbc_cbLuz = new GridBagConstraints();
		gbc_cbLuz.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbLuz.insets = new Insets(0, 0, 0, 5);
		gbc_cbLuz.gridx = 1;
		gbc_cbLuz.gridy = 7;
		pnlParcela.add(cbLuz, gbc_cbLuz);

		pnlBungalow = new JPanel();
		pnlBungalow.setBackground(Color.LIGHT_GRAY);
		pnlAtributos.add(pnlBungalow, "name_377356522519300"); //$NON-NLS-1$
		GridBagLayout gbl_pnlBungalow = new GridBagLayout();
		gbl_pnlBungalow.columnWidths = new int[]{0, 0, 0, 80, 0};
		gbl_pnlBungalow.rowHeights = new int[]{66, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlBungalow.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlBungalow.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBungalow.setLayout(gbl_pnlBungalow);

		lblTamanio = new JLabel(MessagesTabReservas.getString("TabReservas.lblTamanio.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTamanio = new GridBagConstraints();
		gbc_lblTamanio.anchor = GridBagConstraints.EAST;
		gbc_lblTamanio.insets = new Insets(0, 0, 5, 5);
		gbc_lblTamanio.gridx = 0;
		gbc_lblTamanio.gridy = 1;
		pnlBungalow.add(lblTamanio, gbc_lblTamanio);

		cbTamanio = new JComboBox();
		cbTamanio.setEnabled(false);
		cbTamanio.setModel(new DefaultComboBoxModel(new String[] {MessagesTabReservas.getString("TabReservas.Pequenia"), MessagesTabReservas.getString("TabReservas.Mediana"), MessagesTabReservas.getString("TabReservas.Grande")})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		GridBagConstraints gbc_cbTamanio = new GridBagConstraints();
		gbc_cbTamanio.insets = new Insets(0, 0, 5, 5);
		gbc_cbTamanio.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbTamanio.gridx = 1;
		gbc_cbTamanio.gridy = 1;
		pnlBungalow.add(cbTamanio, gbc_cbTamanio);

		lblCapacidad = new JLabel(MessagesTabReservas.getString("TabReservas.lblCapacidad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCapacidad = new GridBagConstraints();
		gbc_lblCapacidad.anchor = GridBagConstraints.EAST;
		gbc_lblCapacidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacidad.gridx = 0;
		gbc_lblCapacidad.gridy = 2;
		pnlBungalow.add(lblCapacidad, gbc_lblCapacidad);

		spCapacidad = new JSpinner();
		spCapacidad.setEnabled(false);
		GridBagConstraints gbc_spCapacidad = new GridBagConstraints();
		gbc_spCapacidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_spCapacidad.insets = new Insets(0, 0, 5, 5);
		gbc_spCapacidad.gridx = 1;
		gbc_spCapacidad.gridy = 2;
		pnlBungalow.add(spCapacidad, gbc_spCapacidad);

		lblPrecionocheBungalow = new JLabel(MessagesTabReservas.getString("TabReservas.lblPrecionocheBungalow.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblPrecionocheBungalow = new GridBagConstraints();
		gbc_lblPrecionocheBungalow.anchor = GridBagConstraints.EAST;
		gbc_lblPrecionocheBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecionocheBungalow.gridx = 0;
		gbc_lblPrecionocheBungalow.gridy = 3;
		pnlBungalow.add(lblPrecionocheBungalow, gbc_lblPrecionocheBungalow);

		spPrecioNoche = new JSpinner();
		spPrecioNoche.setEnabled(false);
		GridBagConstraints gbc_spPrecioNoche = new GridBagConstraints();
		gbc_spPrecioNoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_spPrecioNoche.insets = new Insets(0, 0, 5, 5);
		gbc_spPrecioNoche.gridx = 1;
		gbc_spPrecioNoche.gridy = 3;
		pnlBungalow.add(spPrecioNoche, gbc_spPrecioNoche);

		lblMetrosCuadradosBungalow = new JLabel(MessagesTabReservas.getString("TabReservas.lblMetrosCuadradosBungalow.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblMetrosCuadradosBungalow = new GridBagConstraints();
		gbc_lblMetrosCuadradosBungalow.anchor = GridBagConstraints.EAST;
		gbc_lblMetrosCuadradosBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_lblMetrosCuadradosBungalow.gridx = 0;
		gbc_lblMetrosCuadradosBungalow.gridy = 4;
		pnlBungalow.add(lblMetrosCuadradosBungalow, gbc_lblMetrosCuadradosBungalow);

		spMetrosCuadradosBungalow = new JSpinner();
		spMetrosCuadradosBungalow.setEnabled(false);
		GridBagConstraints gbc_spMetrosCuadradosBungalow = new GridBagConstraints();
		gbc_spMetrosCuadradosBungalow.fill = GridBagConstraints.HORIZONTAL;
		gbc_spMetrosCuadradosBungalow.insets = new Insets(0, 0, 5, 5);
		gbc_spMetrosCuadradosBungalow.gridx = 1;
		gbc_spMetrosCuadradosBungalow.gridy = 4;
		pnlBungalow.add(spMetrosCuadradosBungalow, gbc_spMetrosCuadradosBungalow);

		lblCaracteristicas = new JLabel(MessagesTabReservas.getString("TabReservas.lblCaracteristicas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCaracteristicas = new GridBagConstraints();
		gbc_lblCaracteristicas.anchor = GridBagConstraints.EAST;
		gbc_lblCaracteristicas.gridheight = 2;
		gbc_lblCaracteristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblCaracteristicas.gridx = 0;
		gbc_lblCaracteristicas.gridy = 5;
		pnlBungalow.add(lblCaracteristicas, gbc_lblCaracteristicas);

		chckbxMenaje = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxMenaje.text")); //$NON-NLS-1$
		chckbxMenaje.setEnabled(false);
		GridBagConstraints gbc_chckbxMenaje = new GridBagConstraints();
		gbc_chckbxMenaje.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMenaje.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMenaje.gridx = 1;
		gbc_chckbxMenaje.gridy = 5;
		pnlBungalow.add(chckbxMenaje, gbc_chckbxMenaje);

		chckbxMicroondas = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxMicroondas.text")); //$NON-NLS-1$
		chckbxMicroondas.setEnabled(false);
		GridBagConstraints gbc_chckbxMicroondas = new GridBagConstraints();
		gbc_chckbxMicroondas.anchor = GridBagConstraints.WEST;
		gbc_chckbxMicroondas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMicroondas.gridx = 2;
		gbc_chckbxMicroondas.gridy = 5;
		pnlBungalow.add(chckbxMicroondas, gbc_chckbxMicroondas);

		chckbxToallas = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxToallas.text")); //$NON-NLS-1$
		chckbxToallas.setEnabled(false);
		GridBagConstraints gbc_chckbxToallas = new GridBagConstraints();
		gbc_chckbxToallas.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxToallas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxToallas.gridx = 1;
		gbc_chckbxToallas.gridy = 6;
		pnlBungalow.add(chckbxToallas, gbc_chckbxToallas);

		chckbxSabanas = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxSabanas.text")); //$NON-NLS-1$
		chckbxSabanas.setEnabled(false);
		GridBagConstraints gbc_chckbxSabanas = new GridBagConstraints();
		gbc_chckbxSabanas.anchor = GridBagConstraints.WEST;
		gbc_chckbxSabanas.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSabanas.gridx = 2;
		gbc_chckbxSabanas.gridy = 6;
		pnlBungalow.add(chckbxSabanas, gbc_chckbxSabanas);

		pnlDisponibilidad = new JPanel();
		pnlDisponibilidad.setBackground(Color.LIGHT_GRAY);
		add(pnlDisponibilidad, BorderLayout.EAST);
		GridBagLayout gbl_pnlDisponibilidad = new GridBagLayout();
		gbl_pnlDisponibilidad.columnWidths = new int[]{0, 115, 141, 169, 0};
		gbl_pnlDisponibilidad.rowHeights = new int[]{66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 68, 0, 40, 40, 0};
		gbl_pnlDisponibilidad.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlDisponibilidad.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDisponibilidad.setLayout(gbl_pnlDisponibilidad);

		lblFechaDeEntrada = new JLabel(MessagesTabReservas.getString("TabReservas.lblFechaDeEntrada.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeEntrada = new GridBagConstraints();
		gbc_lblFechaDeEntrada.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeEntrada.gridx = 0;
		gbc_lblFechaDeEntrada.gridy = 1;
		pnlDisponibilidad.add(lblFechaDeEntrada, gbc_lblFechaDeEntrada);

		//ftxtFechaEntrada = new JFormattedTextField();

		MaskFormatter formatoFecha;
		try {
			formatoFecha = new MaskFormatter("##'/##'/####"); //$NON-NLS-1$
			formatoFecha.setPlaceholderCharacter('_');
			ftxtFechaEntrada = new JFormattedTextField(formatoFecha);
			ftxtFechaSalida = new JFormattedTextField(formatoFecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_ftxtFechaEntrada = new GridBagConstraints();
		gbc_ftxtFechaEntrada.anchor = GridBagConstraints.NORTH;
		gbc_ftxtFechaEntrada.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaEntrada.gridx = 1;
		gbc_ftxtFechaEntrada.gridy = 1;
		pnlDisponibilidad.add(ftxtFechaEntrada, gbc_ftxtFechaEntrada);

		lblFechaDeSalida = new JLabel(MessagesTabReservas.getString("TabReservas.lblFechaDeSalida.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeSalida = new GridBagConstraints();
		gbc_lblFechaDeSalida.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeSalida.gridx = 0;
		gbc_lblFechaDeSalida.gridy = 2;
		pnlDisponibilidad.add(lblFechaDeSalida, gbc_lblFechaDeSalida);

		//ftxtFechaSalida = new JFormattedTextField();
		GridBagConstraints gbc_ftxtFechaSalida = new GridBagConstraints();
		gbc_ftxtFechaSalida.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtFechaSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtFechaSalida.gridx = 1;
		gbc_ftxtFechaSalida.gridy = 2;
		pnlDisponibilidad.add(ftxtFechaSalida, gbc_ftxtFechaSalida);

		lblCliente = new JLabel(MessagesTabReservas.getString("TabReservas.lblCliente.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 3;
		pnlDisponibilidad.add(lblCliente, gbc_lblCliente);

		txtCliente = new JTextField();
		GridBagConstraints gbc_txtCliente = new GridBagConstraints();
		gbc_txtCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCliente.gridx = 1;
		gbc_txtCliente.gridy = 3;
		pnlDisponibilidad.add(txtCliente, gbc_txtCliente);
		txtCliente.setColumns(10);

		lblTelefono = new JLabel(MessagesTabReservas.getString("TabReservas.lblTelefono.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 4;
		pnlDisponibilidad.add(lblTelefono, gbc_lblTelefono);

		//ftxtTelefono = new JFormattedTextField();

		MaskFormatter formatotlf;
		try {
			formatotlf = new MaskFormatter("'(###')' ###' ###' ###"); //$NON-NLS-1$
			formatotlf.setPlaceholderCharacter('*');
			ftxtTelefono = new JFormattedTextField(formatotlf);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_ftxtTelefono = new GridBagConstraints();
		gbc_ftxtTelefono.anchor = GridBagConstraints.NORTH;
		gbc_ftxtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtTelefono.gridx = 1;
		gbc_ftxtTelefono.gridy = 4;
		pnlDisponibilidad.add(ftxtTelefono, gbc_ftxtTelefono);

		lblEmail = new JLabel(MessagesTabReservas.getString("TabReservas.lblEmail.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		pnlDisponibilidad.add(lblEmail, gbc_lblEmail);

		//ftxtEmail = new JFormattedTextField();

		MaskFormatter formatoEmail;
		try {
			formatoEmail = new MaskFormatter("*********'@gmail.com"); //$NON-NLS-1$
			formatoEmail.setPlaceholderCharacter('_');
			ftxtEmail = new JFormattedTextField(formatoEmail);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		GridBagConstraints gbc_ftxtEmail = new GridBagConstraints();
		gbc_ftxtEmail.gridwidth = 2;
		gbc_ftxtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtEmail.gridx = 1;
		gbc_ftxtEmail.gridy = 5;
		pnlDisponibilidad.add(ftxtEmail, gbc_ftxtEmail);

		lblNumeroDeOcupantes = new JLabel(MessagesTabReservas.getString("TabReservas.lblNumeroDeOcupantes.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNumeroDeOcupantes = new GridBagConstraints();
		gbc_lblNumeroDeOcupantes.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDeOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeOcupantes.gridx = 0;
		gbc_lblNumeroDeOcupantes.gridy = 6;
		pnlDisponibilidad.add(lblNumeroDeOcupantes, gbc_lblNumeroDeOcupantes);

		spOcupantes = new JSpinner();
		spOcupantes.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		GridBagConstraints gbc_spOcupantes = new GridBagConstraints();
		gbc_spOcupantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_spOcupantes.insets = new Insets(0, 0, 5, 5);
		gbc_spOcupantes.gridx = 1;
		gbc_spOcupantes.gridy = 6;
		pnlDisponibilidad.add(spOcupantes, gbc_spOcupantes);

		lblSolicitudes = new JLabel(MessagesTabReservas.getString("TabReservas.lblSolicitudes.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblSolicitudes = new GridBagConstraints();
		gbc_lblSolicitudes.gridheight = 2;
		gbc_lblSolicitudes.anchor = GridBagConstraints.EAST;
		gbc_lblSolicitudes.insets = new Insets(0, 0, 5, 5);
		gbc_lblSolicitudes.gridx = 0;
		gbc_lblSolicitudes.gridy = 7;
		pnlDisponibilidad.add(lblSolicitudes, gbc_lblSolicitudes);

		chckbxMenaje_1 = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxMenaje_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxMenaje_1 = new GridBagConstraints();
		gbc_chckbxMenaje_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMenaje_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMenaje_1.gridx = 1;
		gbc_chckbxMenaje_1.gridy = 7;
		pnlDisponibilidad.add(chckbxMenaje_1, gbc_chckbxMenaje_1);

		chckbxMovEspecial = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxMovEspecial.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxMovEspecial = new GridBagConstraints();
		gbc_chckbxMovEspecial.anchor = GridBagConstraints.WEST;
		gbc_chckbxMovEspecial.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMovEspecial.gridx = 2;
		gbc_chckbxMovEspecial.gridy = 7;
		pnlDisponibilidad.add(chckbxMovEspecial, gbc_chckbxMovEspecial);

		cbCuna = new JCheckBox(MessagesTabReservas.getString("TabReservas.cbCuna.text")); //$NON-NLS-1$
		GridBagConstraints gbc_cbCuna = new GridBagConstraints();
		gbc_cbCuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCuna.insets = new Insets(0, 0, 5, 5);
		gbc_cbCuna.gridx = 1;
		gbc_cbCuna.gridy = 8;
		pnlDisponibilidad.add(cbCuna, gbc_cbCuna);

		chckbxMuebleBar = new JCheckBox(MessagesTabReservas.getString("TabReservas.chckbxMuebleBar.text")); //$NON-NLS-1$
		GridBagConstraints gbc_chckbxMuebleBar = new GridBagConstraints();
		gbc_chckbxMuebleBar.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMuebleBar.anchor = GridBagConstraints.WEST;
		gbc_chckbxMuebleBar.gridx = 2;
		gbc_chckbxMuebleBar.gridy = 8;
		pnlDisponibilidad.add(chckbxMuebleBar, gbc_chckbxMuebleBar);

		btnLimpiar = new JButton(MessagesTabReservas.getString("TabReservas.btnLimpiar.text")); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());


		lblDisponibilidad = new JLabel(MessagesTabReservas.getString("TabReservas.lblDisponibilidad.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDisponibilidad = new GridBagConstraints();
		gbc_lblDisponibilidad.anchor = GridBagConstraints.EAST;
		gbc_lblDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDisponibilidad.gridx = 0;
		gbc_lblDisponibilidad.gridy = 9;
		pnlDisponibilidad.add(lblDisponibilidad, gbc_lblDisponibilidad);

		cbDisponibilidad = new JComboBox();
		cbDisponibilidad.setEnabled(false);
		cbDisponibilidad.setModel(new DefaultComboBoxModel(new String[] {MessagesTabReservas.getString("TabReservas.Ocupada"), MessagesTabReservas.getString("TabReservas.Libre"), MessagesTabReservas.getString("TabReservas.reparacion"), MessagesTabReservas.getString("TabReservas.limpieza"), "--------------"})); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		GridBagConstraints gbc_cbDisponibilidad = new GridBagConstraints();
		gbc_cbDisponibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_cbDisponibilidad.gridx = 1;
		gbc_cbDisponibilidad.gridy = 9;
		pnlDisponibilidad.add(cbDisponibilidad, gbc_cbDisponibilidad);

		lblAviso = new JLabel(""); //$NON-NLS-1$
		lblAviso.setFont(new Font("Tahoma", Font.BOLD, 12)); //$NON-NLS-1$
		lblAviso.setBackground(Color.LIGHT_GRAY);
		lblAviso.setOpaque(true);
		lblAviso.setForeground(Color.red);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.gridwidth = 2;
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridx = 1;
		gbc_lblAviso.gridy = 10;
		pnlDisponibilidad.add(lblAviso, gbc_lblAviso);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.gridheight = 2;
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 0;
		gbc_btnLimpiar.gridy = 12;
		pnlDisponibilidad.add(btnLimpiar, gbc_btnLimpiar);

		btnReservar = new JButton(MessagesTabReservas.getString("TabReservas.btnReservar.text")); //$NON-NLS-1$
		btnReservar.addActionListener(new BtnReservarActionListener());

		btnHistorialReservas = new JButton(MessagesTabReservas.getString("TabReservas.btnHistorialReservas.text")); //$NON-NLS-1$
		btnHistorialReservas.addActionListener(new BtnHistorialReservasActionListener());
		GridBagConstraints gbc_btnHistorialReservas = new GridBagConstraints();
		gbc_btnHistorialReservas.gridheight = 2;
		gbc_btnHistorialReservas.fill = GridBagConstraints.BOTH;
		gbc_btnHistorialReservas.insets = new Insets(0, 0, 0, 5);
		gbc_btnHistorialReservas.gridx = 1;
		gbc_btnHistorialReservas.gridy = 12;
		pnlDisponibilidad.add(btnHistorialReservas, gbc_btnHistorialReservas);
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.gridheight = 2;
		gbc_btnReservar.fill = GridBagConstraints.BOTH;
		gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservar.gridx = 2;
		gbc_btnReservar.gridy = 12;
		pnlDisponibilidad.add(btnReservar, gbc_btnReservar);

	}
	public void iniciarLista() {
		for(int i=0;i<6;i++) {
			modelo.addElement(listaAlojamientos[i].getNombre());

		}
		list.setModel(modelo);
	}
	private class ListAlojamientosListSelectionListener implements ListSelectionListener {

		public void valueChanged(ListSelectionEvent e) {
			if(list.getSelectedIndex() !=-1) {
				if(listaAlojamientos[list.getSelectedIndex()].getClass().getSimpleName().equals("parcela")) { //$NON-NLS-1$
					pnlBungalow.setVisible(false);
					pnlParcela.setVisible(true);
					parcela aux = (parcela) listaAlojamientos[list.getSelectedIndex()];
					cbCategoria.setSelectedIndex(aux.getCategoria());
					spPrecio.setValue(aux.getPrecio_noche());
					cbTemporada.setSelectedIndex(aux.getTemporada());
					spMetrosCuadradosParcela.setValue(aux.getMetros_cuadrados());
					rdbtnAseos.setSelected(aux.getCerca0());
					rdbtnRestaurante.setSelected(aux.getCerca1());
					rdbtnPiscina.setSelected(aux.getCerca2());
					rdbtnEntrada.setSelected(aux.getCerca3());
					cbLuz.setSelected(aux.isLuz());
				}
				else {
					pnlParcela.setVisible(false);
					pnlBungalow.setVisible(true);
					bungalow aux = (bungalow) listaAlojamientos[list.getSelectedIndex()];
					cbTamanio.setSelectedIndex(aux.gettamanio());
					spCapacidad.setValue(aux.getCapacidad_maxima());
					spPrecioNoche.setValue(aux.getPrecio_noche());
					spMetrosCuadradosBungalow.setValue(aux.getMetros_cuadrados());
					chckbxMenaje.setSelected(aux.getCar0());
					chckbxMicroondas.setSelected(aux.getCar1());
					chckbxToallas.setSelected(aux.getCar2());
					chckbxSabanas.setSelected(aux.getCar3());

				}

			}
		}
	}
	public void limpiarCampos() {
		cbCategoria.setSelectedIndex(0);
		spPrecio.setValue(0);
		cbTemporada.setSelectedIndex(0);
		spMetrosCuadradosParcela.setValue(0);
		rdbtnAseos.setSelected(false);
		rdbtnRestaurante.setSelected(false);
		rdbtnPiscina.setSelected(false);
		rdbtnEntrada.setSelected(false);
		cbLuz.setSelected(false);

		cbTamanio.setSelectedIndex(0);
		spCapacidad.setValue(0);
		spPrecioNoche.setValue(0);
		spMetrosCuadradosBungalow.setValue(0);
		chckbxMenaje.setSelected(false);
		chckbxMicroondas.setSelected(false);
		chckbxToallas.setSelected(false);
		chckbxSabanas.setSelected(false);

		cbDisponibilidad.setSelectedIndex(4);
		ftxtFechaEntrada.setValue(null);
		ftxtFechaSalida.setValue(null);
		txtCliente.setText(""); //$NON-NLS-1$
		ftxtTelefono.setValue(null);
		ftxtEmail.setValue(null);
		spOcupantes.setValue(1);
		chckbxMenaje_1.setSelected(false);
		chckbxMovEspecial.setSelected(false);
		cbCuna.setSelected(false);
		chckbxMuebleBar.setSelected(false);

		list.clearSelection();
		lblAviso.setText(""); //$NON-NLS-1$
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			limpiarCampos();
		}
	}
	private class BtnReservarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex() !=-1) {
				/*if(Reservas.compararFormato(ftxtFechaEntrada.getText())) {
					if(Reservas.compararFormato(ftxtFechaSalida.getText())) {*/
				boolean[] solicitudes= {chckbxMenaje_1.isSelected(), chckbxMovEspecial.isSelected(), cbCuna.isSelected(), chckbxMuebleBar.isSelected()};
				Reservas miRes = new Reservas(listaAlojamientos[list.getSelectedIndex()], ftxtFechaEntrada.getText(), ftxtFechaSalida.getText(), txtCliente.getText(), ftxtTelefono.getText(), ftxtEmail.getText(), (Integer) spOcupantes.getValue(), solicitudes);
				if(miRes.getCliente().equals("") ||miRes.getTelefono().equals("") || miRes.getEmailString().equals("") ) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					lblAviso.setText(MessagesTabReservas.getString("TabReservas.rellenarcampos")); //$NON-NLS-1$
				}else if(comprobarDisponibilidad()) {
					listaReservas.add(miRes);
					lblAviso.setText(MessagesTabReservas.getString("TabReservas.reservafinalizada")); //$NON-NLS-1$
				}

			}

		}/*
					else {
						lblAviso.setText("Formato fecha salida no valido");
					}
				}
				else {
					lblAviso.setText("Formato fecha entrada no valido");
				}
			}
		}*/
	}
	public boolean comprobarDisponibilidad() {
		for(int i=0; i < listaReservas.size(); i++) {
			if(Reservas.changeFormat(ftxtFechaEntrada.getText()).after(Reservas.changeFormat(ftxtFechaSalida.getText()))) {
				lblAviso.setText(MessagesTabReservas.getString("TabReservas.fechasincorrectas")); //$NON-NLS-1$
				cbDisponibilidad.setSelectedIndex(0);
				return false; // Fecha final antes de fecha inicial
			}
			if(listaAlojamientos[list.getSelectedIndex()].getNombre().equals(listaReservas.get(i).getMiAlojamiento().getNombre()) ) {
				lblAviso.setText(MessagesTabReservas.getString("TabReservas.reservafinalizada1")); //$NON-NLS-1$
				cbDisponibilidad.setSelectedIndex(1);
				return true; // Si no hay ninguna reserva del alojamiento X -> correcto
			}
			if((Reservas.changeFormat(ftxtFechaEntrada.getText()).before(listaReservas.get(i).getSalida()) || (Reservas.changeFormat(ftxtFechaEntrada.getText()).compareTo(listaReservas.get(i).getSalida()) == 0))
					&& (Reservas.changeFormat(ftxtFechaSalida.getText()).after(listaReservas.get(i).getEntrada()) || Reservas.changeFormat(ftxtFechaSalida.getText()).compareTo(listaReservas.get(i).getEntrada()) == 0)){
				lblAviso.setText(MessagesTabReservas.getString("TabReservas.fechasocupadas")); //$NON-NLS-1$
				cbDisponibilidad.setSelectedIndex(0);
				return false; // Si ocurre un solapamiento de fechas
			}
			else {
				cbDisponibilidad.setSelectedIndex(1);
				lblAviso.setText(MessagesTabReservas.getString("TabReservas.reservafinalizada2")); //$NON-NLS-1$
				return true; //Si no ocurre solapamiento

			}
		}
		lblAviso.setText(MessagesTabReservas.getString("TabReservas.errordesconocido")); //$NON-NLS-1$
		cbDisponibilidad.setSelectedIndex(0);
		return false; 

	}
	
	private class BtnHistorialReservasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object[] opciones = {MessagesTabReservas.getString("TabReservas.0")}; //$NON-NLS-1$
			int contador=1;
			String mensaje = ""; //$NON-NLS-1$
			for(int i=0; i<listaReservas.size();i++) {
				mensaje+= MessagesTabReservas.getString("TabReservas.2")+ contador + "\n" +listaReservas.get(i); //$NON-NLS-1$ //$NON-NLS-2$
				contador++;
			}
			JOptionPane.showOptionDialog(pnlDisponibilidad,mensaje,MessagesTabReservas.getString("TabReservas.4"),JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null,opciones, 0); //$NON-NLS-1$
		}
	}
}
