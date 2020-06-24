package com.ibm.ams.reportes.pdf;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.ibm.ams.excepcion.ExcepcionFOP;
import com.ibm.ams.excepcion.ExcepcionRutasArchivos;
import com.ibm.ams.excepcion.ExcepcionTransformacion;
import com.ibm.ams.reportes.config.Reporte;
import com.ibm.ams.utils.GeneradorPDFs;

public class GestorReportesPDF {

	List<Reporte> reportesPDF;
	
	public GestorReportesPDF(List<Reporte> reportesConfig) {
		reportesPDF = reportesConfig;
	}
	
	public byte[] getReporte(String idReporte,Object parms) {
		
		if(idReporte == null || idReporte.isEmpty()){
			return null;
		}
		Reporte reporteExport = null;
		for(Reporte r : reportesPDF){
			if(r.getIdReporte().equals(idReporte)){
				reporteExport = r;
				break;
			}
		}
		if(reporteExport == null){
			return null;
		}
		
		GeneradorPDFs handler = new GeneradorPDFs();
		
		String rutaArchivoPlantilla = reporteExport.getRutaReporte();
		
		try {
			ByteArrayOutputStream streamSource = handler.crearOutputStreamPDF(parms, rutaArchivoPlantilla);
			return streamSource.toByteArray();
			
		} catch (ExcepcionFOP e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionTransformacion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionRutasArchivos e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}
