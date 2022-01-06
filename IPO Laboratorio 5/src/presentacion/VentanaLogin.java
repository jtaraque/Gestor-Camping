package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import dominio.datosUsuario;
import dominio.usuario;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaLogin {

	private JFrame frmAcceso;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnLimpiar;
	private JButton btnAcceder;
	private JRadioButton rdbtnEnglish;
	private JRadioButton rdbtnEspaol;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton ayuda;
	private JLabel lblLogin;
	private JMenuBar menuBar;
	private JMenu mnAyuda;
	private JMenu mnOpciones;
	private JMenu mntmFuente;
	private JMenu mntmTamaoDeLa;
	private JMenuItem mntmAcercaDe;
	private JRadioButtonMenuItem rdbtnmntmTahoma;
	private JRadioButtonMenuItem rdbtnmntmTimesNewRoman;
	private JRadioButtonMenuItem rdbtnmntmArial;
	private JRadioButtonMenuItem rdbtnmntmPequea;
	private JRadioButtonMenuItem rdbtnmntmMediana;
	private JRadioButtonMenuItem rdbtnmntmGrande;
	private JLabel lblAviso;

	private int escalaLetras = 12;
	private String tipoLetra = "Tahoma"; //$NON-NLS-1$
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JLabel lblFoto;
	
	private boolean inglesSeleccionado;
	private boolean espaniolSeleccionado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin v = new VentanaLogin(false,true);
					v.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin(boolean ingles,boolean espaniol) {
		initialize();
		this.inglesSeleccionado = ingles;
		this.espaniolSeleccionado = espaniol;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcceso = new JFrame();
		frmAcceso.addWindowListener(new FrmAccesoWindowListener());
		frmAcceso.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/presentacion/route.png"))); //$NON-NLS-1$
		frmAcceso.setTitle(MessagesVentanaLogin.getString("VentanaLogin.frmAcceso.title")); //$NON-NLS-1$
		frmAcceso.setMinimumSize(new Dimension(600, 400));
		frmAcceso.setMaximumSize(new Dimension(600, 400));
		frmAcceso.setResizable(false);
		frmAcceso.setBounds(100, 100, 500, 400);
		frmAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {84, 93, 87, 96, 85, 74, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frmAcceso.getContentPane().setLayout(gridBagLayout);

		rdbtnEnglish = new JRadioButton(MessagesVentanaLogin.getString("VentanaLogin.rdbtnEnglish.text")); //$NON-NLS-1$
		rdbtnEnglish.addActionListener(new RdbtnEnglishActionListener());
		rdbtnEnglish.setSelected(inglesSeleccionado);
		rdbtnEnglish.setBorderPainted(true);
		rdbtnEnglish.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/banderaIng.gif"))); //$NON-NLS-1$
		buttonGroup.add(rdbtnEnglish);
		GridBagConstraints gbc_rdbtnEnglish = new GridBagConstraints();
		gbc_rdbtnEnglish.anchor = GridBagConstraints.EAST;
		gbc_rdbtnEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEnglish.gridx = 3;
		gbc_rdbtnEnglish.gridy = 1;
		frmAcceso.getContentPane().add(rdbtnEnglish, gbc_rdbtnEnglish);

		rdbtnEspaol = new JRadioButton(MessagesVentanaLogin.getString("VentanaLogin.rdbtnEspaol.text")); //$NON-NLS-1$
		rdbtnEspaol.addActionListener(new RdbtnEspaolActionListener());
		rdbtnEspaol.setSelected(espaniolSeleccionado);
		rdbtnEspaol.setBorderPainted(true);
		rdbtnEspaol.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/banderaEsp.gif"))); //$NON-NLS-1$
		buttonGroup.add(rdbtnEspaol);
		GridBagConstraints gbc_rdbtnEspaol = new GridBagConstraints();
		gbc_rdbtnEspaol.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEspaol.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEspaol.gridx = 4;
		gbc_rdbtnEspaol.gridy = 1;
		frmAcceso.getContentPane().add(rdbtnEspaol, gbc_rdbtnEspaol);

		ayuda = new JButton(""); //$NON-NLS-1$
		ayuda.addActionListener(new AyudaActionListener());
		ayuda.setHorizontalAlignment(SwingConstants.LEFT);
		ayuda.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/ayuda.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_ayuda = new GridBagConstraints();
		gbc_ayuda.anchor = GridBagConstraints.SOUTHWEST;
		gbc_ayuda.insets = new Insets(0, 0, 5, 5);
		gbc_ayuda.gridx = 5;
		gbc_ayuda.gridy = 1;
		Border emptyBorder = BorderFactory.createEmptyBorder();
		ayuda.setBorder(emptyBorder);
		frmAcceso.getContentPane().add(ayuda, gbc_ayuda);

		lblLogin = new JLabel("LOGIN CAMPING"); //$NON-NLS-1$
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22)); //$NON-NLS-1$
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.gridwidth = 3;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 0;
		gbc_lblLogin.gridy = 2;
		frmAcceso.getContentPane().add(lblLogin, gbc_lblLogin);

		lblUsuario = new JLabel(MessagesVentanaLogin.getString("VentanaLogin.lblUsuario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 3;
		frmAcceso.getContentPane().add(lblUsuario, gbc_lblUsuario);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 2;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 3;
		frmAcceso.getContentPane().add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		lblFoto = new JLabel(""); //$NON-NLS-1$
		lblFoto.setIcon(new ImageIcon(VentanaLogin.class.getResource("/presentacion/portada.png"))); //$NON-NLS-1$
		lblFoto.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridheight = 5;
		gbc_lblFoto.gridwidth = 3;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 3;
		gbc_lblFoto.gridy = 2;
		frmAcceso.getContentPane().add(lblFoto, gbc_lblFoto);

		lblContrasenia = new JLabel(MessagesVentanaLogin.getString("VentanaLogin.lblContrasenia.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
		gbc_lblContrasenia.anchor = GridBagConstraints.EAST;
		gbc_lblContrasenia.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasenia.gridx = 0;
		gbc_lblContrasenia.gridy = 5;
		frmAcceso.getContentPane().add(lblContrasenia, gbc_lblContrasenia);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.gridwidth = 2;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 5;
		frmAcceso.getContentPane().add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);

		btnLimpiar = new JButton(MessagesVentanaLogin.getString("VentanaLogin.btnLimpiar.text")); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 1;
		gbc_btnLimpiar.gridy = 6;
		frmAcceso.getContentPane().add(btnLimpiar, gbc_btnLimpiar);

		btnAcceder = new JButton(MessagesVentanaLogin.getString("VentanaLogin.btnAcceder.text")); //$NON-NLS-1$
		btnAcceder.addActionListener(new BtnAccederActionListener());
		GridBagConstraints gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridx = 2;
		gbc_btnAcceder.gridy = 6;
		frmAcceso.getContentPane().add(btnAcceder, gbc_btnAcceder);

		lblAviso = new JLabel(""); //$NON-NLS-1$
		lblAviso.setOpaque(true);
		GridBagConstraints gbc_lblAviso = new GridBagConstraints();
		gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAviso.gridwidth = 2;
		gbc_lblAviso.gridx = 1;
		gbc_lblAviso.gridy = 7;
		frmAcceso.getContentPane().add(lblAviso, gbc_lblAviso);

		menuBar = new JMenuBar();
		frmAcceso.setJMenuBar(menuBar);

		mnOpciones = new JMenu(MessagesVentanaLogin.getString("VentanaLogin.mnOpciones.text")); //$NON-NLS-1$
		menuBar.add(mnOpciones);

		mntmFuente = new JMenu(MessagesVentanaLogin.getString("VentanaLogin.mntmFuente.text")); //$NON-NLS-1$
		mnOpciones.add(mntmFuente);

		rdbtnmntmTahoma = new JRadioButtonMenuItem("Tahoma"); //$NON-NLS-1$
		rdbtnmntmTahoma.addActionListener(new RdbtnmntmTahomaActionListener());
		buttonGroup_2.add(rdbtnmntmTahoma);
		mntmFuente.add(rdbtnmntmTahoma);

		rdbtnmntmTimesNewRoman = new JRadioButtonMenuItem("Times New Roman"); //$NON-NLS-1$
		rdbtnmntmTimesNewRoman.addActionListener(new RdbtnmntmTimesNewRomanActionListener());
		buttonGroup_2.add(rdbtnmntmTimesNewRoman);
		mntmFuente.add(rdbtnmntmTimesNewRoman);

		rdbtnmntmArial = new JRadioButtonMenuItem("Arial"); //$NON-NLS-1$
		rdbtnmntmArial.addActionListener(new RdbtnmntmArialActionListener());
		buttonGroup_2.add(rdbtnmntmArial);
		mntmFuente.add(rdbtnmntmArial);

		mntmTamaoDeLa = new JMenu(MessagesVentanaLogin.getString("VentanaLogin.mntmTamaoDeLa.text")); //$NON-NLS-1$
		mnOpciones.add(mntmTamaoDeLa);

		rdbtnmntmPequea = new JRadioButtonMenuItem(MessagesVentanaLogin.getString("VentanaLogin.rdbtnmntmPequea.text")); //$NON-NLS-1$
		buttonGroup_1.add(rdbtnmntmPequea);
		rdbtnmntmPequea.addActionListener(new RdbtnmntmPequeaActionListener());
		mntmTamaoDeLa.add(rdbtnmntmPequea);

		rdbtnmntmMediana = new JRadioButtonMenuItem(MessagesVentanaLogin.getString("VentanaLogin.rdbtnmntmMediana.text")); //$NON-NLS-1$
		rdbtnmntmMediana.addActionListener(new RdbtnmntmMedianaActionListener());
		buttonGroup_1.add(rdbtnmntmMediana);
		mntmTamaoDeLa.add(rdbtnmntmMediana);

		rdbtnmntmGrande = new JRadioButtonMenuItem(MessagesVentanaLogin.getString("VentanaLogin.rdbtnmntmGrande.text")); //$NON-NLS-1$
		rdbtnmntmGrande.addActionListener(new RdbtnmntmGrandeActionListener_1());
		buttonGroup_1.add(rdbtnmntmGrande);
		mntmTamaoDeLa.add(rdbtnmntmGrande);

		mnAyuda = new JMenu(MessagesVentanaLogin.getString("VentanaLogin.mnAyuda.text")); //$NON-NLS-1$
		menuBar.add(mnAyuda);

		mntmAcercaDe = new JMenuItem(MessagesVentanaLogin.getString("VentanaLogin.mntmAcercaDe.text")); //$NON-NLS-1$
		mntmAcercaDe.addActionListener(new BtnAcercaDeActionListener());
		mnAyuda.add(mntmAcercaDe);

	}

	public JFrame getFrame() {
		return this.frmAcceso;
	}

	private class RdbtnEspaolActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnEspaol.isSelected()) {
				rdbtnEspaol.setBorderPainted(true);
				MessagesVentanaLogin.setIdioma("espaniol"); //$NON-NLS-1$
				MessagesVentanaTabbed.setIdioma("espaniol"); //$NON-NLS-1$
				MessagesTabActividades.setIdioma("espaniol"); //$NON-NLS-1$
				MessagesTabReservas.setIdioma("espaniol"); //$NON-NLS-1$
				MessagestTabEmpleados.setIdioma("espaniol"); //$NON-NLS-1$
				MessagesEditorGrafico.setIdioma("espaniol"); //$NON-NLS-1$
				Messages.setIdioma("espaniol");//$NON-NLS-1$

				VentanaLogin v = new VentanaLogin(false,true);
				frmAcceso.dispose();
				v.frmAcceso.setVisible(true);
			}
			else {
				rdbtnEspaol.setBorderPainted(false);

			}
		}
	}
	private class RdbtnEnglishActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnEnglish.isSelected()) {
				rdbtnEnglish.setBorderPainted(true);
				MessagesVentanaLogin.setIdioma("inglés"); //$NON-NLS-1$
				MessagesVentanaTabbed.setIdioma("inglés"); //$NON-NLS-1$
				MessagesTabActividades.setIdioma("inglés"); //$NON-NLS-1$
				MessagesTabReservas.setIdioma("inglés"); //$NON-NLS-1$
				MessagestTabEmpleados.setIdioma("inglés"); //$NON-NLS-1$
				MessagesEditorGrafico.setIdioma("inglés"); //$NON-NLS-1$
				Messages.setIdioma("inglés");//$NON-NLS-1$
				VentanaLogin v = new VentanaLogin(true,false);
				frmAcceso.dispose();
				v.frmAcceso.setVisible(true);
			}
			else {
				rdbtnEnglish.setBorderPainted(false);

			}
		}
	}
	private class BtnAccederActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			datosUsuario miUser = new datosUsuario();

			if (miUser.esValido(txtUsuario.getText().toLowerCase(), txtPassword.getText())==0){

				miUser.setNombre(txtUsuario.getText().toLowerCase());


				usuario u = new usuario();
				if(miUser.getNombre().equals("angel")) { //$NON-NLS-1$
					u.setNombre("Angel  Gamero"); //$NON-NLS-1$
					u.setFoto("/presentacion/custo.png"); //$NON-NLS-1$
				}else {
					u.setNombre("Juan Tomas Araque"); //$NON-NLS-1$
					u.setFoto("/presentacion/juanto.png"); //$NON-NLS-1$
				}

				VentanaTabbed v= new VentanaTabbed(inglesSeleccionado,espaniolSeleccionado,u);

				v.frmTab.setVisible(true);
				frmAcceso.dispose();
			}
			else if(miUser.esValido(txtUsuario.getText().toLowerCase(), txtPassword.getText())==1) {
				lblAviso.setText(MessagesVentanaLogin.getString("VentanaLogin.32")); //$NON-NLS-1$
				lblAviso.setForeground(Color.red);
			}
			else {
				lblAviso.setText(MessagesVentanaLogin.getString("VentanaLogin.33")); //$NON-NLS-1$
				lblAviso.setForeground(Color.red);
			}

		}
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtUsuario.setText(""); //$NON-NLS-1$
			txtPassword.setText(""); //$NON-NLS-1$
		}
	}

	private class BtnAcercaDeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object[] opciones = {MessagesVentanaLogin.getString("VentanaLogin.36")}; //$NON-NLS-1$
			JOptionPane.showOptionDialog(frmAcceso,MessagesVentanaLogin.getString("VentanaLogin.37"),MessagesVentanaLogin.getString("VentanaLogin.38"),JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null,opciones, 0); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	private class AyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object[] opciones = {MessagesVentanaLogin.getString("VentanaLogin.39")}; //$NON-NLS-1$
			JOptionPane.showOptionDialog(frmAcceso,MessagesVentanaLogin.getString("VentanaLogin.40"),MessagesVentanaLogin.getString("VentanaLogin.41"),JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null,opciones, 0); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	private class RdbtnmntmPequeaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			escalaLetras= 10;
			lblAviso.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(null,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(null, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(null, Font.PLAIN, escalaLetras));

		}
	}

	private class RdbtnmntmMedianaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			escalaLetras= 12;
			lblAviso.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(null,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(null, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(null, Font.PLAIN, escalaLetras));
		}
	}
	private class RdbtnmntmGrandeActionListener_1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			escalaLetras= 14;
			lblAviso.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(null,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(null,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(null, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(null, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(null, Font.PLAIN, escalaLetras));
		}
	}
	private class RdbtnmntmTahomaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tipoLetra = "Tahoma"; //$NON-NLS-1$

			lblAviso.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(tipoLetra,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
		}
	}
	private class RdbtnmntmArialActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tipoLetra = "Arial"; //$NON-NLS-1$

			lblAviso.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(tipoLetra,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
		}
	}
	private class RdbtnmntmTimesNewRomanActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tipoLetra = "Times New Roman"; //$NON-NLS-1$

			lblAviso.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblUsuario.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblContrasenia.setFont(new Font(tipoLetra,Font.PLAIN,escalaLetras));
			lblLogin.setFont(new Font(tipoLetra,Font.BOLD,escalaLetras+4));
			btnAcceder.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			btnLimpiar.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEnglish.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
			rdbtnEspaol.setFont(new Font(tipoLetra, Font.PLAIN, escalaLetras));
		}
	}
	private class FrmAccesoWindowListener extends WindowAdapter {
		@Override
		public void windowOpened(WindowEvent e) {
			Image imagenOriginal;
			try {
				imagenOriginal = ImageIO.read(TabRutas.class.getResource("/presentacion/portada.png")); //$NON-NLS-1$
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
