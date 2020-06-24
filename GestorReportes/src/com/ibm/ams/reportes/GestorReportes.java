package com.ibm.ams.reportes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.ibm.ams.excepcion.XmlToDtoException;
import com.ibm.ams.reportes.config.ConfigReportes;
import com.ibm.ams.reportes.excel.GestorReportesExcel;
import com.ibm.ams.reportes.pdf.GestorReportesPDF;
import com.ibm.ams.utils.XmlToDto;

public class GestorReportes {

	private ConfigReportes configReportes;
	
	private GestorReportesExcel reportesExcel;
	private GestorReportesPDF reportesPDF;
	
	public GestorReportes(String rutaConfig) throws XmlToDtoException {
		XmlToDto<ConfigReportes> parser = new XmlToDto<ConfigReportes>();
		
		File fileConfigReports = new File(rutaConfig);
		configReportes = new ConfigReportes();
		configReportes = parser.getDto(configReportes, fileConfigReports);
		
		if(configReportes != null && configReportes.getReportesExcel() != null){
			reportesExcel = new GestorReportesExcel(configReportes.getReportesExcel());
		}
		if(configReportes != null && configReportes.getReportesPDF() != null){
			reportesPDF = new GestorReportesPDF(configReportes.getReportesPDF());
		}
	}
	
	public void getReporte(OutputStream flujoSalida ,String idReporte,Map<String,Object> parms)
													throws IOException,FileNotFoundException{
		reportesExcel.getReporte(flujoSalida, idReporte, parms);
	}
	
	public byte[] getReportePDF(String idReporte,Object parametros){
		return reportesPDF.getReporte(idReporte, parametros);
	}

}
