package presentacion;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JList;

import dominio.Empleado;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class TabEmpleados extends JPanel {
	private static ArrayList<Empleado> listaEmpleados = Empleado.iniciarLista();
	DefaultListModel modelo = new DefaultListModel();
	private JList list;
	private JButton btnAadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblDni;
	private JLabel lblFormacin;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JFormattedTextField txtTelefono;
	private JFormattedTextField txtEmail;
	private JFormattedTextField ftxtDNI;
	private JTextField txtFormacion;
	private JLabel lblFoto;
	private JButton btnCargarFoto;
	private JButton btnLimpiar;
	private JLabel lblAviso;
	private JFrame frame;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public TabEmpleados() {
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{37, 73, 73, 73, 76, 0, 75, 50, 65, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 36, 0, 0, 0, 0, 0, 0, 49, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		btnCargarFoto = new JButton(MessagestTabEmpleados.getString("TabEmpleados.btnCargarFoto.text")); //$NON-NLS-1$
		btnCargarFoto.addActionListener(new BtnCargarFotoActionListener());

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);

		lblFoto = new JLabel(""); //$NON-NLS-1$
		panel.add(lblFoto);
		lblFoto.setIcon(new ImageIcon(TabEmpleados.class.getResource("/presentacion/user2.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_btnCargarFoto = new GridBagConstraints();
		gbc_btnCargarFoto.anchor = GridBagConstraints.WEST;
		gbc_btnCargarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarFoto.gridx = 6;
		gbc_btnCargarFoto.gridy = 1;
		add(btnCargarFoto, gbc_btnCargarFoto);


		list = new JList();

		iniciarLista();
		list.addListSelectionListener(new ListEmpleadosListSelectionListener());

		/*
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Jorge"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 8;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridwidth = 3;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		add(list, gbc_list);

		lblNombre = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 5;
		gbc_lblNombre.gridy = 3;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.txtNombre.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 6;
		gbc_txtNombre.gridy = 3;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		lblApellidos = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblApellidos.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 5;
		gbc_lblApellidos.gridy = 4;
		add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.txtApellidos.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 2;
		gbc_txtApellidos.anchor = GridBagConstraints.NORTH;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 6;
		gbc_txtApellidos.gridy = 4;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);

		lblTelefono = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblTelefono.text")); //$NON-NLS-1$
		lblTelefono.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 5;
		gbc_lblTelefono.gridy = 5;
		add(lblTelefono, gbc_lblTelefono);

		//txtTelefono = new JFormattedTextField();
		
		MaskFormatter formatotlf;
		try {
			formatotlf = new MaskFormatter("'(###')' ###' ###' ###"); //$NON-NLS-1$
			formatotlf.setPlaceholderCharacter('*');
			txtTelefono = new JFormattedTextField(formatotlf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTelefono.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.txtTelefono.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtTelefono = new GridBagConstraints();
		gbc_txtTelefono.anchor = GridBagConstraints.NORTH;
		gbc_txtTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefono.gridx = 6;
		gbc_txtTelefono.gridy = 5;
		add(txtTelefono, gbc_txtTelefono);
		txtTelefono.setColumns(10);

		lblCorreo = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblCorreo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 5;
		gbc_lblCorreo.gridy = 6;
		add(lblCorreo, gbc_lblCorreo);

		//txtEmail = new JFormattedTextField();
		
		MaskFormatter formatoEmail;
		try {
			formatoEmail = new MaskFormatter("*********'@gmail.com"); //$NON-NLS-1$
			formatoEmail.setPlaceholderCharacter('_');
			txtEmail = new JFormattedTextField(formatoEmail);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtEmail.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.txtEmail.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 6;
		gbc_txtEmail.gridy = 6;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblDni = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblDni.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 5;
		gbc_lblDni.gridy = 7;
		add(lblDni, gbc_lblDni);

		//ftxtDNI = new JFormattedTextField();
		
		MaskFormatter formatoDNI;
		try {
		formatoDNI = new MaskFormatter("########'-U"); //$NON-NLS-1$
		formatoDNI.setPlaceholderCharacter('X');
		ftxtDNI = new JFormattedTextField(formatoDNI);
		} catch (ParseException e) {
		e.printStackTrace();
		}
		
		ftxtDNI.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.ftxtDNI.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_ftxtDNI = new GridBagConstraints();
		gbc_ftxtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtDNI.gridx = 6;
		gbc_ftxtDNI.gridy = 7;
		add(ftxtDNI, gbc_ftxtDNI);

		lblFormacin = new JLabel(MessagestTabEmpleados.getString("TabEmpleados.lblFormacin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFormacin = new GridBagConstraints();
		gbc_lblFormacin.anchor = GridBagConstraints.EAST;
		gbc_lblFormacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormacin.gridx = 5;
		gbc_lblFormacin.gridy = 8;
		add(lblFormacin, gbc_lblFormacin);

		txtFormacion = new JTextField();
		txtFormacion.setToolTipText(MessagestTabEmpleados.getString("TabEmpleados.txtFormacion.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_txtFormacion = new GridBagConstraints();
		gbc_txtFormacion.gridwidth = 2;
		gbc_txtFormacion.insets = new Insets(0, 0, 5, 5);
		gbc_txtFormacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFormacion.gridx = 6;
		gbc_txtFormacion.gridy = 8;
		add(txtFormacion, gbc_txtFormacion);
		txtFormacion.setColumns(10);


		lblAviso = new JLabel(""); //$NON-NLS-1$
		lblAviso.setOpaque(true);
		lblAviso.setForeground(Color.red);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridx = 6;
		gbc_lblAviso.gridy = 9;
		add(lblAviso, gbc_lblAviso);

		btnAadir = new JButton(MessagestTabEmpleados.getString("TabEmpleados.btnAadir.text")); //$NON-NLS-1$
		btnAadir.addActionListener(new BtnAadirActionListener());
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.fill = GridBagConstraints.BOTH;
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 1;
		gbc_btnAadir.gridy = 10;
		add(btnAadir, gbc_btnAadir);

		btnModificar = new JButton(MessagestTabEmpleados.getString("TabEmpleados.btnModificar.text")); //$NON-NLS-1$
		btnModificar.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.BOTH;
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 10;
		add(btnModificar, gbc_btnModificar);

		btnEliminar = new JButton(MessagestTabEmpleados.getString("TabEmpleados.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.BOTH;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 10;
		add(btnEliminar, gbc_btnEliminar);

		btnLimpiar = new JButton(MessagestTabEmpleados.getString("TabEmpleados.btnLimpiar.text")); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 6;
		gbc_btnLimpiar.gridy = 10;
		add(btnLimpiar, gbc_btnLimpiar);

	}

	public void limpiarCampos() {
		txtNombre.setText(""); //$NON-NLS-1$
		txtApellidos.setText(""); //$NON-NLS-1$
		txtTelefono.setText(""); //$NON-NLS-1$
		ftxtDNI.setText(""); //$NON-NLS-1$
		txtFormacion.setText(""); //$NON-NLS-1$
		txtEmail.setText(""); //$NON-NLS-1$
		lblFoto.setIcon(new ImageIcon(TabEmpleados.class.getResource("/presentacion/user2.png"))); //$NON-NLS-1$
		list.clearSelection();
		lblAviso.setText(""); //$NON-NLS-1$
	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			limpiarCampos();
		}
	}

	public void anadirEmpleado(Empleado e) {
		DefaultListModel modelo2 = new DefaultListModel();
		listaEmpleados.add(e);
		for (int i = 0; i <= listaEmpleados.size() - 1; i++) {
			modelo2.addElement(listaEmpleados.get(i).getNombre());
		}
		list.setModel(modelo2);
		list.setSelectedIndex(listaEmpleados.size()-1);
		list.ensureIndexIsVisible(listaEmpleados.size()-1);
	}
	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Empleado em= new Empleado(txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),ftxtDNI.getText(),txtEmail.getText(),txtFormacion.getText(),lblFoto.getIcon());
			if(em.getNombre().equals("")||em.getApellidos().equals("")||em.getTelefono().equals("")||em.getDni().equals("")||em.getEmail().equals("")||em.getFormacion().equals("")||em.getImagen().equals("")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
				lblAviso.setText(MessagestTabEmpleados.getString("TabEmpleados.0")); //$NON-NLS-1$
			}
			else {
				anadirEmpleado(em);
			}

		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex()!=-1) {
				Empleado em = listaEmpleados.get(list.getSelectedIndex());
				em.setApellidos(txtApellidos.getText());
				em.setDni(ftxtDNI.getText());
				em.setEmail(txtEmail.getText());
				em.setFormacion(txtFormacion.getText());
				em.setImagen(lblFoto.getIcon());
				em.setNombre(txtNombre.getText());
				em.setTelefono(txtTelefono.getText());
			}else{
				lblAviso.setText(MessagestTabEmpleados.getString("TabEmpleados.22")); //$NON-NLS-1$
			}

		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(list.getSelectedIndex()!=-1) {
				listaEmpleados.remove(list.getSelectedIndex());
				DefaultListModel modelo2 = new DefaultListModel();

				for (int i = 0; i <= listaEmpleados.size() - 1; i++) {
					modelo2.addElement(listaEmpleados.get(i).getNombre());
				}

				limpiarCampos();
				list.setModel(modelo2);

			}else {
				lblAviso.setText(MessagestTabEmpleados.getString("TabEmpleados.23")); //$NON-NLS-1$

			}
		}
	}
	public void iniciarLista() {

		for (int i = 0; i <= listaEmpleados.size() - 1; i++) {
			modelo.addElement(listaEmpleados.get(i).getNombre());
		}
		list.setModel(modelo);
	}
	private class ListEmpleadosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if(list.getSelectedIndex()!=-1) {
				txtNombre.setText(listaEmpleados.get(list.getSelectedIndex()).getNombre());
				txtApellidos.setText(listaEmpleados.get(list.getSelectedIndex()).getApellidos());
				txtTelefono.setText(listaEmpleados.get(list.getSelectedIndex()).getTelefono());
				ftxtDNI.setText(listaEmpleados.get(list.getSelectedIndex()).getDni());
				txtFormacion.setText(listaEmpleados.get(list.getSelectedIndex()).getFormacion());
				txtEmail.setText(listaEmpleados.get(list.getSelectedIndex()).getEmail());
				lblFoto.setIcon(listaEmpleados.get(list.getSelectedIndex()).getImagen());
			}
		}
	}
	private class BtnCargarFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				Image imagenOriginal;
				try {
					imagenOriginal = ImageIO.read(file);
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

}
