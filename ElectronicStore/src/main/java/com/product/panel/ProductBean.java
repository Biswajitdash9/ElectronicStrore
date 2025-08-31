package com.product.panel;

import java.io.Serializable;

public class ProductBean  implements Serializable
{

	private String pCode,pName,pCompany,pPrice,pQtn;
	
	public ProductBean()
	{
		
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCompany() {
		return pCompany;
	}

	public void setpCompany(String pCompany) {
		this.pCompany = pCompany;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpQtn() {
		return pQtn;
	}

	public void setpQtn(String pQtn) {
		this.pQtn = pQtn;
	}
	
	
}
