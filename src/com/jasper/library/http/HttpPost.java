/*
 * Created Date: 2019-11-09
 * Subject: HTTP 통신(Http Communication)
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
			
	        // HTTP 접속 구하기
	        HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
	        
	        // 리퀘스트 메소드를 POST로 설정
	        conn.setRequestMethod("POST");
	        
	        // 연결된 connection 에서 출력도 하도록 설정 
	        conn.setDoOutput(true);
	    
	        // 요청 파라미터 출력   
	        // - 파라미터는 쿼리 문자열의 형식으로 지정 (ex) 이름=값&이름=값 형식&...
	        // - 파라미터의 값으로 한국어 등을 송신하는 경우는 URL 인코딩을 해야 함.
	        try (OutputStream out = conn.getOutputStream()) {
	             out.write("id=java".getBytes());
	             out.write("&".getBytes());
	             out.write(("name=" + URLEncoder.encode("자바","UTF-8")).getBytes());
	        }
	                
	        // 응답 내용(BODY) 구하기
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
	        // 접속 해제
	        conn.disconnect();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
        
		
	}
	
}