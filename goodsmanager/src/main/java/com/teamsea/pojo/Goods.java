package com.teamsea.pojo;

public class Goods {

	private Integer id;
	private String name;
	private Integer num;

	public Goods() {
		
	}
	
	public Goods(Integer id, String name, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", num=" + num + "]";
	}
	
	

}
