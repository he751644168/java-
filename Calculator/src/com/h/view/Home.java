package com.h.view;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.h.service.Cacula;
import com.h.service.DefaultCacula;
public class Home {
	private JFrame frame = new JFrame();;
	private JTextField displayPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Home() {
		initialize();
	}
	//变量声明
	JButton btnNewButton, btnX, btnX_1, button_1, button_3, button_4, button_5, button_6, button_7, button_8, button_9,
			button_10, button_11, button_12, button_13, button_14, button_15, button_16, button_17;
	Boolean flagAsF = false, flagAsCC = false;
	private String optionList = "+-×÷%/*";
	// 存储运算表达式
	private List<String> list = new ArrayList<String>();
	private void initialize() {
		// 窗体基本属性设置
		frame.setBounds(100, 100, 335, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		displayPanel = new JTextField();
		displayPanel.setBounds(28, 25, 265, 62);
		displayPanel.setEditable(false);
		displayPanel.setBackground(Color.white);
		frame.getContentPane().add(displayPanel);
		displayPanel.setColumns(10);
		btnNewButton = new JButton("C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPanel.setText("");
				list.clear();
			}
		});
		btnNewButton.setBounds(28, 97, 59, 43);
		frame.getContentPane().add(btnNewButton);
		btnX = new JButton("AC");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除最后的字符并且做有效性判断
				if(displayPanel.getText().length()>=1) {
					displayPanel.setText(displayPanel.getText().substring(0, displayPanel.getText().length() - 1));
				}
				if(list.size()>=1) {
					list.remove(list.size() - 1);
					for(int i=list.size()-1;i>=0;i--) {
						if(list.get(i).equals("«")) {
							list.remove(i);
							flagAsCC = false;
							break;
						}}}}});		
		displayPanel.setFont(new Font("宋体", Font.PLAIN, 32));
		btnX.setBounds(97, 97, 59, 43);
		frame.getContentPane().add(btnX);
		button_1 = new JButton("\u00F7");
		button_1.setBounds(166, 97, 59, 43);
		frame.getContentPane().add(button_1);
		btnX_1 = new JButton("\u00D7");
		btnX_1.setBounds(235, 97, 59, 43);
		frame.getContentPane().add(btnX_1);
		button_3 = new JButton("7");
		button_3.setBounds(28, 150, 59, 43);
		frame.getContentPane().add(button_3);
		button_4 = new JButton("8");
		button_4.setBounds(97, 150, 59, 43);
		frame.getContentPane().add(button_4);
		button_5 = new JButton("9");
		button_5.setBounds(166, 150, 59, 43);
		frame.getContentPane().add(button_5);
		button_6 = new JButton("-");
		button_6.setBounds(235, 150, 59, 43);
		frame.getContentPane().add(button_6);
		button_7 = new JButton("4");
		button_7.setBounds(28, 203, 59, 43);
		frame.getContentPane().add(button_7);
		button_8 = new JButton("5");
		button_8.setBounds(97, 203, 59, 43);
		frame.getContentPane().add(button_8);
		button_9 = new JButton("6");
		button_9.setBounds(166, 203, 59, 43);
		frame.getContentPane().add(button_9);
		button_10 = new JButton("+");
		button_10.setBounds(235, 203, 59, 43);
		frame.getContentPane().add(button_10);
		button_11 = new JButton("1");
		button_11.setBounds(28, 256, 59, 43);
		frame.getContentPane().add(button_11);
		button_12 = new JButton("2");
		button_12.setBounds(97, 256, 59, 43);
		frame.getContentPane().add(button_12);
		button_13 = new JButton("3");
		button_13.setBounds(166, 256, 59, 43);
		frame.getContentPane().add(button_13);
	

		button_15 = new JButton("%");
		button_15.setBounds(28, 309, 59, 43);
		frame.getContentPane().add(button_15);
		button_16 = new JButton("0");
		button_16.setBounds(97, 309, 59, 43);
		frame.getContentPane().add(button_16);
		button_17 = new JButton(".");
		button_17.setBounds(166, 309, 59, 43);
		frame.getContentPane().add(button_17);
		button_14 = new JButton("=");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 计算核心
				try {
					Cacula cacula = new DefaultCacula();
					String s = null;
					if (flagAsF) {
						list.add(">");
						flagAsF = false;
					}
					if (flagAsCC) {
						list.add("»");
						flagAsCC = false;
					}
					if (list.size() != 0 && list != null)
						s = cacula.caculat(list, optionList) + "";
					list.clear();
					char[] c = s.toCharArray();
					if (c[0] == '-') {
						list.add("<");
					}
					for (int i = 0; i < c.length; i++)
						list.add(c[i] + "");
					if (c[0] == '-') {
						list.add(">");}
					
					displayPanel.setText(s);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					displayPanel.setText("数据输入错误");
				}
			}
		});
		button_14.setForeground(Color.BLACK);
		button_14.setBackground(new Color(255, 69, 0));
		button_14.setBounds(235, 256, 59, 96);
		frame.getContentPane().add(button_14);

		displayText(button_1, displayPanel);
		displayText(button_3, displayPanel);
		displayText(button_4, displayPanel);
		displayText(button_5, displayPanel);
		displayText(button_6, displayPanel);
		displayText(button_7, displayPanel);
		displayText(button_8, displayPanel);
		displayText(button_9, displayPanel);
		displayText(button_10, displayPanel);
		displayText(button_11, displayPanel);
		displayText(button_12, displayPanel);
		displayText(button_13, displayPanel);
		displayText(button_15, displayPanel);
		displayText(button_16, displayPanel);
		displayText(button_17, displayPanel);
		displayText(btnX_1, displayPanel);
	}

	/**
	 * 基础按钮点击事件触发
	 */
	public void displayText(JButton jButton, JTextField jTextField) {
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bText = jButton.getText();
				int size = list.size();
				
				//数据处理
				if (flagAsCC == true && "+-".matches(".*\\" + bText + ".*")&&!bText.equals(".")) {
					list.add("»");
					flagAsCC = false;
				}

				if (("×÷%/*".matches(".*\\" + bText + ".*")) && flagAsCC == false) {
					for (int i = list.size() - 1; i >= 0; i--) {
						if (i == 0) {
							list.add(i, "«");
							flagAsCC = true;
							break;
						}
						if ("+-".matches(".*" + list.get(i) + ".*")&&!list.get(i).equals(".")) {
							list.add(i + 1, "«");
							flagAsCC = true;
							break;
						}
					}
				}

				if (optionList.matches(".*\\" + bText + ".*") && flagAsF) {
					list.add(">");
					flagAsF = false;
				}
				if (list.size() == 0) {
					if (bText.equals("-")) {
						flagAsF = true;
						list.add("<");
					}
				} else {
					if (optionList.matches(".*\\" + bText + ".*")
							&& optionList.matches(".*" + list.get(size - 1) + ".*") && bText.equals("-")) {
						flagAsF = true;
						list.add("<");
					}
				}
				jTextField.setText(jTextField.getText() + jButton.getText());
				list.add(jButton.getText());
			}
		});
	}

}
