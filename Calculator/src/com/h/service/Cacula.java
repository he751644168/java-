package com.h.service;

import java.util.List;

public interface Cacula {
	/**
	 * @author 前进的书生
	 * @param List<String> list  表达式组成的列表,String optionList 可以进行的操作列表
	 * @return Double 表达式计算结果
	 */
	public Double caculat(List<String> list,String optionList); 
}
