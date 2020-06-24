package com.rbm.gp.bo.pdf;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CompraData")
public class CompraData {

	public CompraData() {
	}
	private String imgDerecha;
	private String imgIzq;
	
	private List<Compra> compraList;

	@XmlElementWrapper(name = "compraList")
	@XmlElement(name = "compra")
	public List<Compra> getCompraList() {
		return compraList;
	}

	public void setCompraList(List<Compra> compraList) {
		this.compraList = compraList;
	}
	@XmlElement(name = "imgDerecha")
	public String getImgDerecha() {
		return imgDerecha;
	}
	
	public void setImgDerecha(String imgDerecha) {
		this.imgDerecha = imgDerecha;
	}
	@XmlElement(name = "imgIzq")
	public String getImgIzq() {
		return imgIzq;
	}

	public void setImgIzq(String imgIzq) {
		this.imgIzq = imgIzq;
	}
}