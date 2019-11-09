/*
 * Created Date: 2019-10-17
 * Subject: AES256, 자바 가상 데스크톱 환경(Java virtual desktop environment), 
 * 			HTTP 통신(Http Communication)
 * Filename: MainFrm.java
 * Author: Dodo (rabbit.white@daum.net)
 * Description:
 * 
 * 
 * Reference:
 * 
 */

package com.jasper.view;

import javax.crypto.BadPaddingException; 
import javax.crypto.IllegalBlockSizeException; 
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException; 
import java.security.InvalidKeyException; 
import java.security.NoSuchAlgorithmException; 
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jasper.library.http.HttpGet;
import com.jasper.library.security.AES256;
import java.awt.Font;

public class MainFrm extends JInternalFrame  {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	//Variables
	public int nrOfLeds;
	public byte rValue;
	public byte gValue;
	public byte bValue;
	public byte intensityValue;
	public byte[] rgbMap = new byte[10];
	private JLabel lblTitle;


	/**
	 * Create the frame.
	 */
	public MainFrm() {
		
		initComponents(); 
		createObject(); 
		
	}

	private void initComponents() { 

		setTitle("화면1");
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 384);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 772, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblTitle = new JLabel("화면입력");
		lblTitle.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblTitle.setBounds(12, 8, 391, 15);
		panel.add(lblTitle);
		
		
	}
	
	private void createObject() {
		
		/* AES256 */
		
		final String secret_key = "rabbit2me1234567"; 
		String plain_text = "123412341";
		 
		try { 
		 
			String encrypt_text = AES256.aes_encode(plain_text, secret_key); 
			String decrypt_text = AES256.aes_decode(encrypt_text, secret_key); 
			System.out.println(encrypt_text); 
			System.out.println(decrypt_text); 
		
		} catch (NoSuchAlgorithmException |
				NoSuchPaddingException | 
				InvalidKeyException | 
				InvalidAlgorithmParameterException | 
				IllegalBlockSizeException | 
				BadPaddingException e) { 
			e.printStackTrace(); 
		} 
		
		/* HTTP POST, GET전송 */
		
		HttpGet httpGet = new HttpGet();
		httpGet.setUrl("http://localhost/myhomepage/index.php/board/notice/rss");
		httpGet.response();
		
	}

}
