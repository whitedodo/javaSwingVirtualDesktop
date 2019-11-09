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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpPost {
    
	private String url;
	
	public HttpPost() {
		
	}

	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void response() {

		String usrUrl = this.getUrl();
		
        URL postUrl;
		try {
			postUrl = new URL(usrUrl);
			
	        // HTTP ���� ���ϱ�
	        HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
	        
	        // ������Ʈ �޼ҵ带 POST�� ����
	        conn.setRequestMethod("POST");
	        
	        // ����� connection ���� ��µ� �ϵ��� ���� 
	        conn.setDoOutput(true);
	    
	        // ��û �Ķ���� ���   
	        // - �Ķ���ʹ� ���� ���ڿ��� �������� ���� (ex) �̸�=��&�̸�=�� ����&...
	        // - �Ķ������ ������ �ѱ��� ���� �۽��ϴ� ���� URL ���ڵ��� �ؾ� ��.
	        try (OutputStream out = conn.getOutputStream()) {
	             out.write("id=java".getBytes());
	             out.write("&".getBytes());
	             out.write(("name=" + URLEncoder.encode("�ڹ�","UTF-8")).getBytes());
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
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
        
		
	}
	
}