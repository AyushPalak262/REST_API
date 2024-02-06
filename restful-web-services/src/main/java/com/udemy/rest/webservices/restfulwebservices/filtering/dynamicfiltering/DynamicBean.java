package com.udemy.rest.webservices.restfulwebservices.filtering.dynamicfiltering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("DynamicBeanFilter")
public class DynamicBean {
	
	private String area1;
	
	private String area2;
	
	private String area3;

	public DynamicBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DynamicBean(String area1, String area2, String area3) {
		super();
		this.area1 = area1;
		this.area2 = area2;
		this.area3 = area3;
	}

	public String getArea1() {
		return area1;
	}

	public String getArea2() {
		return area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}

	@Override
	public String toString() {
		return "DynamicBean [area1=" + area1 + ", area2=" + area2 + ", area3=" + area3 + "]";
	}

	
	

}
