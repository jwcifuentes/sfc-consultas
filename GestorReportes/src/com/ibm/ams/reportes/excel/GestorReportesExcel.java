package com.ibm.ams.reportes.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

import com.ibm.ams.reportes.config.Reporte;

public class GestorReportesExcel {

	private List<Reporte> reportesExcel;

	public GestorReportesExcel(List<Reporte> reportesConfig){
		this.reportesExcel = reportesConfig;
	}
	
	public void getReporte(OutputStream flujoSalida ,String idReporte,Map<String,Object> parms)
				throws IOException,FileNotFoundException{
		if(idReporte == null || idReporte.isEmpty() || flujoSalida == null ){
			return;
		}
		Reporte reporteExport = null;
		for(Reporte r : reportesExcel){
			if(r.getIdReporte().equals(idReporte)){
				reporteExport = r;
				break;
			}
		}
		if(reporteExport == null){
			return;
		}
		
		try{
			XLSTransformer transformer = new XLSTransformer();
			FileInputStream fis = new FileInputStream(reporteExport.getRutaReporte());			
			//Transformar plantilla en documento POI
			Workbook workBook  =  transformer.transformXLS(fis, parms);
			workBook.write(flujoSalida);
			flujoSalida.flush();
			
		} catch (ParsePropertyException e) {		
			e.printStackTrace();
		} catch (InvalidFormatException e) {		
			e.printStackTrace();
		}finally{
			flujoSalida.close();
		}
			
	}
	
}
