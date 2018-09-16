package com.h.service;

import java.util.ArrayList;
import java.util.List;
public class DefaultCacula implements Cacula {
	/**
	 * 计算准备，为列表填充
	 */
	@Override
	public Double caculat(List<String> list,String optionList) {
		list.add(" ");
		String numberStr1 = "";
		String numberStr2 = "";
		Double sum = null;
		Double optionNumber = null;
		String option = null;
		int count = 0;
		boolean flagAsF = false;
		
		int index = list.indexOf("«");
		if(index!=-1) {
			List<String> list2=new ArrayList<>();
			for(int i=index+1;i<list.size();) {
				if(list.get(i).equals("»")) {
					list.remove(i);
					break;
				}
				list2.add(list.get(i));
				list.remove(i);
			}
			String s2=caculat(list2, optionList)+"";
			list.remove(index);
			
			if(list.size()==1)return Double.valueOf(s2);
			
			char [] c=s2.toCharArray();
			for(int i=0;i<c.length;i++) {
				list.add(index+i,c[i]+"");
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(0);
			if(s.equals("<")) {
				flagAsF = true;
				list.remove(0);
				continue;
			}
			if(s.equals(">")) {
				flagAsF = false;
				list.remove(0);
				break;
			}
			if(flagAsF==true) {
				numberStr1 += s;
				list.remove(0);
				continue;
			}
			
			if (s.matches("[0-9]+") || s.equals(".")) {
				numberStr1 += s;
			} else {
				break;
			}
			list.remove(0);
		}

		sum = Double.parseDouble(numberStr1);
		
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			
			if(s.equals("<")) {
				flagAsF = true;
				continue;
			}
			if(s.equals(">")) {
				flagAsF = false;
				continue;
			}
			if(flagAsF==true) {
				numberStr2 += s;
				continue;
			}
			
			if (((count == 1) &&(optionList.matches(".*"+s+".*")))&&!s.equals(".") || (i == list.size() - 1)) {
				optionNumber = Double.valueOf(numberStr2);
				sum = caculatFormal(sum, optionNumber, option);
				option = null;
				numberStr2 = "";
				count = 0;
			}
			
			if (s.matches("[0-9]+") || s.equals(".")) {
				numberStr2 += s;
			} else {
				option = s;
				count++;
			}
		}
		return sum;
	}

	/**
	 * 正式计算
	 */
	private Double caculatFormal(Double sum, Double optionNumber, String option) {
		// TODO Auto-generated method stub
		switch (option) {
		case "+":
			sum += optionNumber;
			break;
		case "-":
			sum -= optionNumber;
			break;
		case "×":
			sum *= optionNumber;
			break;
		case "÷":
			sum /= optionNumber;
			break;
		case "%":
			sum %= optionNumber;
			break;
		default:
			break;
		}
		return sum;
	}
}
