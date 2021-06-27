package test.game.of.life;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control {
    Control() {
    	JFrame jframe = new JFrame();
    	jframe.setSize(425,460);
    	JPanel jpanel = new JPanel();
    	jpanel.setBounds(0,0,400,400);
    	int count = 0;
    	Cell [][]map = new Cell[16][16];
    	map = Map.initial();
    	Map.getliving(map);
    	jframe.setTitle("第"+ count +"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
    	jframe.setVisible(true);
    	Graphics g = jpanel.getGraphics();
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0;j < 16; j++) {
    			g.drawRect(i*25, j*25, 25, 25);
    		}
    	}
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0;j < 16; j++) {
    			if(map[i][j].getStatus() == 1) {
    				// 填充矩形
    				g.fillRect(i*25, j*25, 25, 25);
    			}
    			else {
    				// 绘制边框
    				g.drawRect(i*25, j*25, 25, 25);
    			}
    		}
    	}
    	long d1 = System.currentTimeMillis();
    	while(true) {
    		long d2 = System.currentTimeMillis();
    		if(d2 - d1 > 500) {
    			int change;
    			d1 = d2;
    			jframe.repaint();
    			change = Map.UpdateMap(map);
    			Map.getliving(map);
    			for(int i = 0; i < 16; i++) {
    	    		for(int j = 0;j < 16; j++) {
    	    			g.drawRect(i*25, j*25, 25, 25);
    	    		}
    	    	}
    			for(int i = 0; i < 16; i++) {
    				for(int j = 0;j < 16; j++) {
    					if(map[i][j].getStatus() == 1) {
    	    				g.fillRect(i*25, j*25, 25, 25);
    	    			}
    	    			else {
    	    				g.drawRect(i*25, j*25, 25, 25);
    				    }
    				}
    			}
    		    count++;
    		    jframe.setTitle("第"+ count +"次演化");
    			if(change == 16*16) break;
    			if(count > 1000) break;
    	    }	    	
    	}
    	JOptionPane.showMessageDialog(jframe, "在第"+ count +"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
    }
}