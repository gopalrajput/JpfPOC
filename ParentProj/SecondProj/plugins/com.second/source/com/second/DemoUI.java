package com.second;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.java.plugin.boot.Application;
import org.java.plugin.boot.ApplicationPlugin;
import org.java.plugin.registry.Extension;
import org.java.plugin.registry.ExtensionPoint;
import org.java.plugin.util.ExtendedProperties;
import com.first.FirstPlugin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemoUI  extends ApplicationPlugin implements Application  {

	private JPanel contentPane;
	private JFrame frame;
	  private static final Log logger = LogFactory.getLog(DemoUI.class);
	  static Logger log = Logger.getLogger(DemoUI.class);
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoUI frame = new DemoUI();		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public DemoUI() {
		System.out.println("Cons Call");
		frame =new JFrame();
		frame.setTitle("Hello JPF");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 330, 180);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseClickOn = new JLabel("Java Plug-in Framework");
		lblPleaseClickOn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseClickOn.setBounds(20, 11, 232, 29);
		contentPane.add(lblPleaseClickOn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 11, 248, 29);
		contentPane.add(panel);
		
		JButton btnClickMe = new JButton("Click Me to call 1st Plugin");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ExtensionPoint toolExtPoint =
		   getManager().getRegistry().getExtensionPoint(getDescriptor().getId(), "demo");
			
			if(toolExtPoint.isExtensionConnected("com.first@FirstPlugin")) {
				new FirstPlugin();
				}
			}
		});
		btnClickMe.setBounds(20, 69, 185, 23);
		contentPane.add(btnClickMe);
		
		frame.setVisible(true);
		
	}

	@Override
	protected void doStart() throws Exception {
		log.info("------ doStart === ");
		System.out.println("------ doStart === ");		
	}

	@Override
	protected Application initApplication(ExtendedProperties arg0, String[] arg1)
			throws Exception {
		log.debug("------ initApplication === ");
		System.out.println("------ initApplication === ");
		return this;
	}

	public void startApplication() throws Exception {
		log.warn("------ startApplication === ");
		System.out.println("------ startApplication === ");
	}

	@Override
	protected void doStop() throws Exception {
		log.error("------ doStop === ");
		System.out.println("------ doStop === ");		
	}
}
