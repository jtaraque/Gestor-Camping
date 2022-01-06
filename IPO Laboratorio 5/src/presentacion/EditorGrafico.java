package presentacion;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class EditorGrafico extends JPanel {
	private JMenuBar menuHerramientas;
	private JButton btnInicio;
	private JButton btnFin;
	private JButton btnHito;
	private JButton btnDescanso;
	private JButton btnCamino;
	private JButton btnComentario;
	private JRadioButton rdbtnDificultadFacil;
	private JRadioButton rdbtnDificultadNormal;
	private JRadioButton rdbtnDificultadDificil;
	private JScrollPane scrollPane;
	private MiAreaDibujo miAreaDibujo;
	private Icon imagen;	
	private JTextField txtTexto = new JTextField();


	private final ButtonGroup buttonGroup = new ButtonGroup();

	//Variable que almacena el modo de dibujado seleccionado por el usuario
	int modo = -1;
	private final int INICIO = 1;
	private final int FIN = 2;
	private final int HITO = 3;
	private final int DESCANSO = 4;
	private final int CAMINO = 5;
	private final int COMENTARIO = 6;

	//Cursores e imagenes
	private Toolkit toolkit;
	private Image imagInicio;
	private Image imagFin;
	private Image imagHito;
	private Image imagDescanso;
	private Image imagCamino;
	private Image imagComentario;
	private Cursor cursorInicio;
	private Cursor cursorFin;
	private Cursor cursorHito;
	private Cursor cursorDescanso;
	private Cursor cursorCamino;
	private Cursor cursorComentario;
	private int x,y;
	private JLabel lblAviso;

	private boolean inicio,fin;
	private Color dificultad;
	private int fixX=0;
	private int fixY=26;
	
	/**
	 * Create the panel.
	 */
	public EditorGrafico() {
		setLayout(new BorderLayout(0, 0));

		menuHerramientas = new JMenuBar();
		add(menuHerramientas, BorderLayout.NORTH);

		btnInicio = new JButton(""); //$NON-NLS-1$
		btnInicio.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnInicio.toolTipText")); //$NON-NLS-1$
		btnInicio.addActionListener(new BtnInicioActionListener());
		btnInicio.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/location.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnInicio);

		btnFin = new JButton(""); //$NON-NLS-1$
		btnFin.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnFin.toolTipText")); //$NON-NLS-1$
		btnFin.addActionListener(new BtnFinActionListener());
		btnFin.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/racing-flag.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnFin);

		btnHito = new JButton(""); //$NON-NLS-1$
		btnHito.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnHito.toolTipText")); //$NON-NLS-1$
		btnHito.addActionListener(new BtnHitoActionListener());
		btnHito.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/office-push-pin.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnHito);

		btnDescanso = new JButton(""); //$NON-NLS-1$
		btnDescanso.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnDescanso.toolTipText")); //$NON-NLS-1$
		btnDescanso.addActionListener(new BtnDescansoActionListener());
		btnDescanso.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/bench3.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnDescanso);

		btnCamino = new JButton(""); //$NON-NLS-1$
		btnCamino.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnCamino.toolTipText")); //$NON-NLS-1$
		btnCamino.addActionListener(new BtnCaminoActionListener());
		btnCamino.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/pencil.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnCamino);

		rdbtnDificultadFacil = new JRadioButton(MessagesEditorGrafico.getString("EditorGrafico.Dificultad")); //$NON-NLS-1$
		rdbtnDificultadFacil.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.rdbtnDificultadFacil.toolTipText")); //$NON-NLS-1$
		rdbtnDificultadFacil.addActionListener(new RdbtnCustomActionListener());

		btnComentario = new JButton(""); //$NON-NLS-1$
		btnComentario.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.btnComentario.toolTipText")); //$NON-NLS-1$
		btnComentario.addActionListener(new BtnComentarioActionListener());
		btnComentario.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/speech-bubble.png"))); //$NON-NLS-1$
		menuHerramientas.add(btnComentario);
		rdbtnDificultadFacil.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/DificultadFacil2.png"))); //$NON-NLS-1$
		rdbtnDificultadFacil.setHorizontalTextPosition(SwingConstants.LEFT);
		buttonGroup.add(rdbtnDificultadFacil);
		menuHerramientas.add(rdbtnDificultadFacil);

		rdbtnDificultadNormal = new JRadioButton(""); //$NON-NLS-1$
		rdbtnDificultadNormal.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.rdbtnDificultadNormal.toolTipText")); //$NON-NLS-1$
		rdbtnDificultadNormal.addActionListener(new RdbtnCustomActionListener());
		rdbtnDificultadNormal.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/DificultadNormal.png"))); //$NON-NLS-1$
		rdbtnDificultadNormal.setHorizontalTextPosition(SwingConstants.RIGHT);
		buttonGroup.add(rdbtnDificultadNormal);
		menuHerramientas.add(rdbtnDificultadNormal);

		rdbtnDificultadDificil = new JRadioButton(""); //$NON-NLS-1$
		rdbtnDificultadDificil.setToolTipText(MessagesEditorGrafico.getString("EditorGrafico.rdbtnDificultadDificil.toolTipText")); //$NON-NLS-1$
		rdbtnDificultadDificil.addActionListener(new RdbtnCustomActionListener());
		rdbtnDificultadDificil.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/DificultadDificil.png"))); //$NON-NLS-1$
		buttonGroup.add(rdbtnDificultadDificil);
		menuHerramientas.add(rdbtnDificultadDificil);

		lblAviso = new JLabel(""); //$NON-NLS-1$
		lblAviso.setForeground(Color.RED);
		menuHerramientas.add(lblAviso);
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(new ImageIcon(EditorGrafico.class.getResource("/presentacion/mapa.png"))); //$NON-NLS-1$
		scrollPane.setViewportView(miAreaDibujo);

		imagen = new ImageIcon(EditorGrafico.class.getResource("/presentacion/mapa.png")); //$NON-NLS-1$

		//Creación de imágenes y cursores
		toolkit = Toolkit.getDefaultToolkit();
		imagInicio =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/location.png")); //$NON-NLS-1$
		imagFin =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/racing-flag.png")); //$NON-NLS-1$
		imagHito =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/office-push-pin.png")); //$NON-NLS-1$
		imagCamino =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/pencil.png")); //$NON-NLS-1$
		imagDescanso =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/bench4.png")); //$NON-NLS-1$
		imagComentario =toolkit.getImage(getClass().getClassLoader().getResource("presentacion/speech-bubble.png")); //$NON-NLS-1$

		//Creación de los cursores
		cursorInicio = toolkit.createCustomCursor(imagInicio,new Point(0,0),"CURSOR_INICIO"); //$NON-NLS-1$
		cursorFin= toolkit.createCustomCursor(imagFin,new Point(0,0),"CURSOR_FINAL"); //$NON-NLS-1$
		cursorHito = toolkit.createCustomCursor(imagHito,new Point(0,0),"CURSOR_HITO"); //$NON-NLS-1$
		cursorCamino = toolkit.createCustomCursor(imagCamino,new Point(0,0),"CURSOR_CAMINO"); //$NON-NLS-1$
		cursorDescanso= toolkit.createCustomCursor(imagDescanso,new Point(0,0),"CURSOR_DESCANSO"); //$NON-NLS-1$
		cursorComentario = toolkit.createCustomCursor(imagComentario,new Point(0,0),"CURSOR_COMENTARIO"); //$NON-NLS-1$

		//Variables para el correcto funcionamiento del editor
		inicio = false;
		fin = false;
		dificultad = new Color(25,127,24);

	}

	private class BtnInicioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = INICIO;
			setCursor(cursorInicio);
		}
	}
	private class BtnFinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = FIN;
			setCursor(cursorFin);
		}
	}
	private class BtnHitoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = HITO;
			setCursor(cursorHito);
		}
	}
	private class BtnDescansoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = DESCANSO;
			setCursor(cursorDescanso);
		}
	}
	private class BtnCaminoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = CAMINO;
			setCursor(cursorCamino);
		}
	}
	private class BtnComentarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = COMENTARIO;
			setCursor(cursorComentario);
		}
	}

	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			lblAviso.setText(""); //$NON-NLS-1$
			x = e.getX();
			y = e.getY();
			toolkit = Toolkit.getDefaultToolkit();
			if (imagen != null){
				switch (modo){

				case INICIO:
					if(inicio == false) {
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagInicio));
						miAreaDibujo.repaint();
						inicio =true;
					}else {
						lblAviso.setText(MessagesEditorGrafico.getString("EditorGrafico.SoloUnInicioRuta")); //$NON-NLS-1$
					}
					break;

				case FIN:
					if(fin == false) {
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagFin));
						miAreaDibujo.repaint();
						fin = true;
					}else {
						lblAviso.setText(MessagesEditorGrafico.getString("EditorGrafico.SoloUnFinalRuta")); //$NON-NLS-1$
					}
					break;

				case HITO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagHito));
					miAreaDibujo.repaint();
					break;

				case DESCANSO:
					miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagDescanso));
					miAreaDibujo.repaint();
					break;
					
				case CAMINO:
					miAreaDibujo.addObjetoGrafico(new PuntoGrafico(x+fixX,y+fixY,x+fixX,y+fixY,dificultad));
					miAreaDibujo.repaint();
					break;

				case COMENTARIO:
					txtTexto.setBounds(x, y, 200,30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg) {
							if(!txtTexto.getText().equals("")) //$NON-NLS-1$
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText()));
							txtTexto.setText(""); //$NON-NLS-1$
							txtTexto.setVisible(false);
							miAreaDibujo.repaint();
						}
					});
					miAreaDibujo.add(txtTexto);
				}
			}

		}
	}


	private class RdbtnCustomActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(((JRadioButton) e.getSource()).isSelected()) {
				((JRadioButton) e.getSource()).setBorderPainted(true);
			}
			if (rdbtnDificultadFacil.getIcon().toString().equals(((JRadioButton) e.getSource()).getIcon().toString())) {
				dificultad = new Color(25,127,24);
			}
			else if (rdbtnDificultadNormal.getIcon().toString().equals(((JRadioButton) e.getSource()).getIcon().toString())) {
				dificultad = new Color(148,0,211);
			}
			else if (rdbtnDificultadDificil.getIcon().toString().equals(((JRadioButton) e.getSource()).getIcon().toString())) {
				dificultad = Color.red;
			}
			
		}
	}
	
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == CAMINO && imagen!=null) {
				((PuntoGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX()+fixX);
				((PuntoGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY()+fixY);
				miAreaDibujo.repaint();
			}
		}
	}
}
