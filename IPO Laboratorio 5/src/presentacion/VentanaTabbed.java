package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dominio.usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;

public class VentanaTabbed {

	public JFrame frmTab;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private JPanel pnlReservas;
	private JPanel pnlEmpleados;
	private JPanel pnlActividades;
	private JPanel pnlRutas;
	private JPanel pnlDiseniarRutas;
	private JPanel panel;
	private JLabel lblInicio;
	private JLabel lblltimaConexin;
	private JLabel lblFoto;
	private JRadioButton rdbtnEnglish;
	private JRadioButton rdbtnEspaol;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton ayuda;
	public JLabel lblConexion;
	private JButton btnCerrarSesion;
	
	private boolean inglesSeleccionado;
	private boolean espaniolSeleccionado;
	private usuario uOriginal;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaTabbed window = new VentanaTabbed();
//					window.frmTab.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public VentanaTabbed(boolean ingles,boolean espaniol,usuario u) {
		initialize();
		this.inglesSeleccionado = ingles;
		this.espaniolSeleccionado = espaniol;
		this.uOriginal = u;
		lblConexion.setText("5/1/2021 20:00"); //$NON-NLS-1$
		this.setFoto(uOriginal);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTab = new JFrame();
		frmTab.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTabbed.class.getResource("/presentacion/route.png"))); //$NON-NLS-1$
		frmTab.setTitle(MessagesVentanaTabbed.getString("VentanaTabbed.frmTab.title")); //$NON-NLS-1$
		frmTab.setBounds(100, 100, 1424, 658);
		frmTab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel_1 = new JPanel();
		frmTab.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setToolTipText(""); //$NON-NLS-1$
		panel_1.add(tabbedPane, BorderLayout.CENTER);

		pnlReservas = new TabReservas();
		tabbedPane.addTab(MessagesVentanaTabbed.getString("VentanaTabbed.2"), new ImageIcon(VentanaTabbed.class.getResource("/presentacion/reception.png")), pnlReservas, null); //$NON-NLS-1$ //$NON-NLS-2$

		pnlEmpleados = new TabEmpleados();
		tabbedPane.addTab(MessagesVentanaTabbed.getString("VentanaTabbed.4"), new ImageIcon(VentanaTabbed.class.getResource("/presentacion/employee-card.png")), pnlEmpleados, null); //$NON-NLS-1$ //$NON-NLS-2$

		pnlActividades = new TabActividades();
		tabbedPane.addTab(MessagesVentanaTabbed.getString("VentanaTabbed.6"), new ImageIcon(VentanaTabbed.class.getResource("/presentacion/ball.png")), pnlActividades, null); //$NON-NLS-1$ //$NON-NLS-2$

		pnlRutas = new TabRutas();
		tabbedPane.addTab(MessagesVentanaTabbed.getString("VentanaTabbed.8"), new ImageIcon(VentanaTabbed.class.getResource("/presentacion/location.png")), pnlRutas, null); //$NON-NLS-1$ //$NON-NLS-2$

		pnlDiseniarRutas = new EditorGrafico();
		tabbedPane.addTab(MessagesVentanaTabbed.getString("VentanaTabbed.10"), new ImageIcon(VentanaTabbed.class.getResource("/presentacion/pencil.png")), pnlDiseniarRutas, null); //$NON-NLS-1$ //$NON-NLS-2$

		panel = new JPanel();
		frmTab.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 18, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		rdbtnEnglish = new JRadioButton(MessagesVentanaTabbed.getString("VentanaTabbed.rdbtnEnglish.text")); //$NON-NLS-1$
		buttonGroup.add(rdbtnEnglish);
		rdbtnEnglish.addActionListener(new RdbtnEnglishActionListener());
		rdbtnEnglish.setSelected(inglesSeleccionado);
		rdbtnEnglish.setBorderPainted(true);
		rdbtnEnglish.setIcon(new ImageIcon(VentanaTabbed.class.getResource("/presentacion/banderaIng.gif"))); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnEnglish = new GridBagConstraints();
		gbc_rdbtnEnglish.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEnglish.gridx = 3;
		gbc_rdbtnEnglish.gridy = 0;
		panel.add(rdbtnEnglish, gbc_rdbtnEnglish);

		rdbtnEspaol = new JRadioButton(MessagesVentanaTabbed.getString("VentanaTabbed.rdbtnEspaol.text")); //$NON-NLS-1$
		buttonGroup.add(rdbtnEspaol);
		rdbtnEspaol.addActionListener(new RdbtnEspaolActionListener());
		rdbtnEspaol.setIcon(new ImageIcon(VentanaTabbed.class.getResource("/presentacion/banderaEsp.gif"))); //$NON-NLS-1$
		rdbtnEspaol.setSelected(espaniolSeleccionado);
		rdbtnEspaol.setBorderPainted(true);
		GridBagConstraints gbc_rdbtnEspaol = new GridBagConstraints();
		gbc_rdbtnEspaol.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnEspaol.gridx = 4;
		gbc_rdbtnEspaol.gridy = 0;
		panel.add(rdbtnEspaol, gbc_rdbtnEspaol);
		
		ayuda = new JButton("");	//$NON-NLS-1$
		ayuda.addActionListener(new AyudaActionListener());	
		ayuda.setIcon(new ImageIcon(VentanaTabbed.class.getResource("/presentacion/ayuda.png")));	//$NON-NLS-1$
		ayuda.setHorizontalAlignment(SwingConstants.LEFT);	
		GridBagConstraints gbc_ayuda = new GridBagConstraints();	
		gbc_ayuda.insets = new Insets(0, 0, 5, 0);	
		gbc_ayuda.gridx = 6;	
		gbc_ayuda.gridy = 0;	
		Border emptyBorder = BorderFactory.createEmptyBorder();	
		ayuda.setBorder(emptyBorder);	
		panel.add(ayuda, gbc_ayuda);	

		lblInicio = new JLabel(MessagesVentanaTabbed.getString("VentanaTabbed.lblInicio.text")); //$NON-NLS-1$
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 30)); //$NON-NLS-1$
		GridBagConstraints gbc_lblInicio = new GridBagConstraints();
		gbc_lblInicio.gridheight = 3;
		gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblInicio.gridx = 1;
		gbc_lblInicio.gridy = 1;
		panel.add(lblInicio, gbc_lblInicio);

		lblFoto = new JLabel(""); //$NON-NLS-1$
		lblFoto.setIcon(new ImageIcon(VentanaTabbed.class.getResource("/presentacion/user2.png"))); //$NON-NLS-1$
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.gridx = 2;
		gbc_lblFoto.gridy = 1;
		panel.add(lblFoto, gbc_lblFoto);
		
		
		
		lblltimaConexin = new JLabel(MessagesVentanaTabbed.getString("VentanaTabbed.lblltimaConexin.text")); //$NON-NLS-1$
		lblltimaConexin.setEnabled(false);
		GridBagConstraints gbc_lblltimaConexin = new GridBagConstraints();
		gbc_lblltimaConexin.insets = new Insets(0, 0, 5, 5);
		gbc_lblltimaConexin.gridx = 2;
		gbc_lblltimaConexin.gridy = 3;
		panel.add(lblltimaConexin, gbc_lblltimaConexin);

		lblConexion = new JLabel(""); //$NON-NLS-1$
		GridBagConstraints gbc_lblConexion = new GridBagConstraints();
		gbc_lblConexion.insets = new Insets(0, 0, 5, 5);
		gbc_lblConexion.gridx = 3;
		gbc_lblConexion.gridy = 3;
		panel.add(lblConexion, gbc_lblConexion);

		btnCerrarSesion = new JButton(MessagesVentanaTabbed.getString("VentanaTabbed.btnCerrarSesion.text")); //$NON-NLS-1$
		btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
		GridBagConstraints gbc_btnCerrarSesion = new GridBagConstraints();
		gbc_btnCerrarSesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrarSesion.gridwidth = 2;
		gbc_btnCerrarSesion.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrarSesion.gridx = 3;
		gbc_btnCerrarSesion.gridy = 4;
		panel.add(btnCerrarSesion, gbc_btnCerrarSesion);

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
				VentanaTabbed v = new VentanaTabbed(false,true,uOriginal);
				frmTab.dispose();
				v.frmTab.setVisible(true);

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

				VentanaTabbed v = new VentanaTabbed(true,false,uOriginal);
				frmTab.dispose();
				v.frmTab.setVisible(true);
			}
			else {
				rdbtnEnglish.setBorderPainted(false);

			}
		}
	}
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaLogin v = new VentanaLogin(inglesSeleccionado,espaniolSeleccionado);
			Object[] opciones = {MessagesVentanaTabbed.getString("VentanaTabbed.32"),MessagesVentanaTabbed.getString("VentanaTabbed.33")}; //$NON-NLS-1$ //$NON-NLS-2$
			int i= JOptionPane.showOptionDialog(frmTab,MessagesVentanaTabbed.getString("VentanaTabbed.34"),MessagesVentanaTabbed.getString("VentanaTabbed.35"),JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null,opciones, 0); //$NON-NLS-1$ //$NON-NLS-2$
			
			if(i==1) {
				v.getFrame().setVisible(true);
				frmTab.dispose();
			}
		}
	}
	
	public void setFoto(usuario user) {
		lblFoto.setIcon(new ImageIcon(VentanaTabbed.class.getResource(user.getFoto())));
	}
	
	private class AyudaActionListener implements ActionListener {	
	public void actionPerformed(ActionEvent e) {	
		Object[] opciones = {MessagesVentanaTabbed.getString("VentanaTabbed.0")};	 //$NON-NLS-1$
		JOptionPane.showOptionDialog(panel,MessagesVentanaTabbed.getString("VentanaTabbed.1"),MessagesVentanaTabbed.getString("VentanaTabbed.3"),JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE, null,opciones, 0);	 //$NON-NLS-1$ //$NON-NLS-2$
	}	
}
}
