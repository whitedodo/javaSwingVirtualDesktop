/*
 * Created Date: 2019-11-09
 * Subject: HTTP ���(Http Communication)
 * Filename: HttpPost.java
 * Author: 
 * Description:
 * 
 * 
 * Reference:
 * 
 */

package com.jasper.library.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpGet {
	
	private String url;
	private String txtMsg;
	/// http://localhost/rss
	/// http://localhost/rss?id=3333.....
	
	public HttpGet() {
		this.url = null;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTxtmsg() {
		return this.txtMsg;
	}
	
	public void setTxtMsg(String txtMsg) {
		this.txtMsg = txtMsg;
	}
	
	public void response() {
		
		try {
			String usrUrl = this.getUrl();
			URL getUrl = new URL(usrUrl);
		        
	        // ���ڿ��� URL ǥ��
	        System.out.println("URL :" + getUrl.toExternalForm());
	        
	        // HTTP Connection ���ϱ� 
	        HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();
	        
	        // ��û ��� ���� ( GET or POST or .. ������ �������������� GET ��� )
	        conn.setRequestMethod("GET"); 
	        
	        // ���� Ÿ�Ӿƿ� ���� 
	        conn.setConnectTimeout(3000); // 3�� 
	        // �б� Ÿ�Ӿƿ� ���� 
	        conn.setReadTimeout(3000); // 3�� 
	        
	        // ��û ��� ���ϱ�
	        System.out.println("getRequestMethod():" + conn.getRequestMethod());
	        // ���� ������ ���� ���ϱ�
	        System.out.println("getContentType():" + conn.getContentType());
	        // ���� �ڵ� ���ϱ�
	        System.out.println("getResponseCode():"    + conn.getResponseCode());
	        // ���� �޽��� ���ϱ�
	        System.out.println("getResponseMessage():" + conn.getResponseMessage());
	        
	        
	        // ���� ����� ������ ��� ���
	        for (Map.Entry<String, List<String>> header : conn.getHeaderFields().entrySet()) {
	            for (String value : header.getValue()) {
	                System.out.println(header.getKey() + " : " + value);
	            }
	        }
	        
	        // ���� ����(BODY) ���ϱ�        
	        try (InputStream in = conn.getInputStream();
	                ByteArrayOutputStream out = new ByteArrayOutputStream()) {
	            
	            byte[] buf = new byte[1024 * 8];
	            int length = 0;
	            
	            while ((length = in.read(buf)) != -1) {
	                out.write(buf, 0, length);
	            }
	            
	            String txtMsg = new String(out.toByteArray(), "UTF-8");
	            txtMsg = txtMsg + "\n";
	            System.out.print(txtMsg);            
	        }
	        
	        // ���� ����
	        conn.disconnect();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}