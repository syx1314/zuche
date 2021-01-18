package com.zql.app.lib.entity;

/**
 * 数据传输Bean（继承DTO）
 * 
 * @author 曾繁添
 * @version 1.0
 * @param <V>
 * @param <K>
 * 
 */
public class BaseDTB<K, V> extends BaseDTO<K, V>{

	private String name;

	private String nameCN;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}
}
