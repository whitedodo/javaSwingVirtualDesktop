package com.jasper.application;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameLayout {

	private Point point;
	
	public JFrameLayout() {
		this.point = new Point();
	}
	
	public JFrame centerLayout(JFrame frame) {

		int x, y;
		Point p = this.getPoint();
		
	    /// ������ â ��� ����ϱ�
		Dimension frameSize = frame.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
	
		System.out.println(frameSize + "" + windowSize);
		
		x = (windowSize.width - frameSize.width) / 2;
		y = (windowSize.height - frameSize.height) / 2;
		
		p.setLocation(x, y);
		frame.setLocation(point);
		
		return frame;
		
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		this.point = point;
	}
	
}
