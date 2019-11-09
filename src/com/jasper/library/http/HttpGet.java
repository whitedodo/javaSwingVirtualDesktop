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
		        
	        // 문자열로 URL 표현
	        System.out.println("URL :" + getUrl.toExternalForm());
	        
	        // HTTP Connection 구하기 
	        HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();
	        
	        // 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
	        conn.setRequestMethod("GET"); 
	        
	        // 연결 타임아웃 설정 
	        conn.setConnectTimeout(3000); // 3초 
	        // 읽기 타임아웃 설정 
	        conn.setReadTimeout(3000); // 3초 
	        
	        // 요청 방식 구하기
	        System.out.println("getRequestMethod():" + conn.getRequestMethod());
	        // 응답 콘텐츠 유형 구하기
	        System.out.println("getContentType():" + conn.getContentType());
	        // 응답 코드 구하기
	        System.out.println("getResponseCode():"    + conn.getResponseCode());
	        // 응답 메시지 구하기
	        System.out.println("getResponseMessage():" + conn.getResponseMessage());
	        
	        
	        // 응답 헤더의 정보를 모두 출력
	        for (Map.Entry<String, List<String>> header : conn.getHeaderFields().entrySet()) {
	            for (String value : header.getValue()) {
	                System.out.println(header.getKey() + " : " + value);
	            }
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
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}