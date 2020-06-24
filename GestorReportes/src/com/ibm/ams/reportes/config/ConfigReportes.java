package com.ibm.ams.reportes.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ReportesConfig")
public class ConfigReportes {

	
	private List<Reporte> reportesExcel;
	private List<Reporte> reportesPDF;
	
	public ConfigReportes() {
		// TODO Auto-generated constructor stub
	}

	@XmlElementWrapper(name = "ReportesExcel")	
	@XmlElement(name = "Reporte")
	public List<Reporte> getReportesExcel() {
		return reportesExcel;
	}

	public void setReportesExcel(List<Reporte> reportes) {
		this.reportesExcel = reportes;
	}

	@XmlElementWrapper(name = "ReportesPDF")	
	@XmlElement(name = "Reporte")
	public List<Reporte> getReportesPDF() {
		return reportesPDF;
	}

	public void setReportesPDF(List<Reporte> reportesPDF) {
		this.reportesPDF = reportesPDF;
	}

}
