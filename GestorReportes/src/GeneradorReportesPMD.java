

public class GeneradorReportesPMD {

	public GeneradorReportesPMD() {
		
	}
	
//	public static void main(String... args) throws ParsePropertyException, InvalidFormatException, IOException, XmlToDtoException{
//		
//        //imprimirReportePMD();
//		imprimirReporte5();
//		//imprimirReporte4();
//		//imprimirReportePDFPDM();
//		//imprimirReportePDFAdquirienteEmisor();
//		//imprimirReportePDFAdquirienteEmisorTran();
//	}
//	
//	private static void imprimirReportePDFAdquirienteEmisorTran() throws XmlToDtoException, IOException{
//		
//		List<ComisionesXBanco> comisiones = getComisionesEntidadTransaccionTest();
//		
//		ReporteAdquirienteEmisorDTO reporte = new ReporteAdquirienteEmisorDTO();
//		
//		reporte.setLogoRedeban("C:/$user/Documentos/RedeBan/Compensaciones/RedeBan.png");
//		reporte.setFechaCompensacion("08/Ago/2013");
//		reporte.setFechaGeneracion("08/Ago/2013");
//		reporte.setFranquicia("RBM");
//		reporte.setUsuario("oaballesteros");
//		reporte.setEntidad("Todos");
//		reporte.setItemsAdquirientesEmisor(comisiones);
//		
//		String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//        
//	    com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//	    byte[] reporteByte = reportes.getReportePDF("ReporteEntidadesTransaccionTipoComision", reporte);
//	    
//	    FileOutputStream fos = new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/ResumenComisionesTipoTransaccion.pdf");
//	    fos.write(reporteByte);
//	    fos.flush();
//	    fos.close();
//	    
//	}
//	
//	private static void imprimirReportePDFAdquirienteEmisor() throws XmlToDtoException, IOException{
//		
//		List<ComisionesXBanco> comisiones = getComisionesEntidadFinancieraTest();
//		
//		ReporteAdquirienteEmisorDTO reporte = new ReporteAdquirienteEmisorDTO();
//		
//		reporte.setLogoRedeban("C:/$user/Documentos/RedeBan/Compensaciones/RedeBan.png");
//		reporte.setFechaCompensacion("08/Ago/2013");
//		reporte.setFechaGeneracion("08/Ago/2013");
//		reporte.setFranquicia("RBM");
//		reporte.setUsuario("oaballesteros");
//		reporte.setItemsAdquirientesEmisor(comisiones);
//		
//		String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//        
//	    com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//	    byte[] reporteByte = reportes.getReportePDF("ReporteComisionesEntidadAdquirienteEmisor", reporte);
//	    
//	    FileOutputStream fos = new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/ResumenComisionTipoComision.pdf");
//	    fos.write(reporteByte);
//	    fos.flush();
//	    fos.close();
//	}
//	
//	private static void imprimirReportePDFPDM() throws XmlToDtoException, IOException{
//		List<ItemPMD> itemsN = getPMDsFechaTest();
//		List<ItemPMD> items = formarEstructuraPMD(itemsN);
//		
//		System.out.println(items); 
//		
//		ReportePMDDTO reporte = new ReportePMDDTO();
//		reporte.setLogoRedeban("C:/$user/Documentos/RedeBan/Compensaciones/RedeBan.png");
//		reporte.setFechaCompensacion("08/Ago/2013");
//		reporte.setEntidad("Bancolombia");
//		reporte.setFechaGeneracion("08/Ago/2013");
//		reporte.setFranquicia("RBM");
//		reporte.setGeneradoPor("oaballesteros");
//		reporte.setPosicionNeta(new BigDecimal(1000600007.0));
//		reporte.setItemsPMD(items);
//		
//		 String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//	           
//	     com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//	     byte[] reporteByte = reportes.getReportePDF("ReportePMD", reporte);
//	     
//	     FileOutputStream fos = new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/ReportePMD.pdf");
//		 fos.write(reporteByte);
//		 fos.flush();
//		 fos.close();
//		
//		
//	}
//	
//	private static void imprimirReporte4()throws ParsePropertyException, InvalidFormatException, IOException, XmlToDtoException{
//		List<ComisionesXBanco> comisiones = getComisionesEntidadTransaccionTest();
//		System.out.println("Numero Resultados "+comisiones.size());
//		ItemDescripcion itemF = new ItemDescripcion();
//		itemF.setCodigo(1);
//		itemF.setNombre("RBM");
//		ItemDescripcion itemE = new ItemDescripcion();
//		itemE.setCodigo(7);
//		itemE.setNombre("Bancolombia");
//		
//		// initilize list of departments in some way
//        Map<String,Object> beans = new HashMap<String,Object>();
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        beans.put("reporte", comisiones);
//        beans.put("franquicia", itemF);
//        beans.put("fechaCompensacion", df.format(new Date()));
//        beans.put("entidad", itemE);
//        beans.put("usuario", "oaballesteros");
//        beans.put("fechaReporte", df.format(new Date()));
//        
//        
//        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/ReporteEntidadesTransaccionesComision.xls"));
//        
//        String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//        
//        
//        com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//        reportes.getReporte(os, "ReporteEntidadesTransaccionesComision", beans);
//        os.close();
//
//	}
//	
//	
//	private static void imprimirReporte5()throws ParsePropertyException, InvalidFormatException, IOException, XmlToDtoException{
//		List<ComisionesXBanco> comisiones = getComisionesEntidadFinancieraTest();
//		System.out.println("Numero Resultados "+comisiones.size());
//		ItemDescripcion itemF = new ItemDescripcion();
//		itemF.setCodigo(1);
//		itemF.setNombre("RBM");
//		ItemDescripcion itemE = new ItemDescripcion();
//		itemE.setCodigo(7);
//		itemE.setNombre("Bancolombia");
//		
//		
//		// initilize list of departments in some way
//        Map<String,Object> beans = new HashMap<String,Object>();
//        beans.put("reporte", comisiones);
//        beans.put("franquicia", itemF);
//        beans.put("fechaCompensacion", new Date());
//        beans.put("entidad", itemF);
//        beans.put("usuario", "oaballesteros");
//        beans.put("fechaReporte", new Date());
//        
//        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/ReporteComisionesEntidadAdquirienteEmisor.xls"));
//        
//        String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//        
//        
//        com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//        reportes.getReporte(os, "ReporteComisionesEntidadAdquirienteEmisor", beans);
//        os.close();
//
//	}
//	
//	private static void imprimirReportePMD()throws ParsePropertyException, InvalidFormatException, IOException, XmlToDtoException{
//		List<ItemPMD> itemsN = getPMDsFechaTest();
//		List<ItemPMD> items = formarEstructuraPMD(itemsN);
//		System.out.println(items); 
//		
//		BigDecimal posicion = getPosicionNeta(13, new Date("2013/06/26"));
//		
//		ItemDescripcion itemF = new ItemDescripcion();
//		itemF.setCodigo(1);
//		itemF.setNombre("RBM");
//		ItemDescripcion itemE = new ItemDescripcion();
//		itemE.setCodigo(7);
//		itemE.setNombre("Bancolombia");
//		
//		
//		// initilize list of departments in some way
//        Map<String,Object> beans = new HashMap<String,Object>();
//        beans.put("registros", items);
//        beans.put("franquicia", itemF);
//        beans.put("fechaCompensacion", new Date());
//        beans.put("entidad", itemF);
//        beans.put("usuario", "oaballesteros");
//        beans.put("fechaReporte", new Date());
//        beans.put("posicionNeta", posicion);
//        
//        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:/$user/Documentos/RedeBan/Compensaciones/Reportes/reporte_excel.xls"));
//        
//        String configFile = "C:/$user/Documentos/RedeBan/Compensaciones/Configuraciones/ReportesConfig.xml";
//        
//        
//        com.ibm.ams.reportes.GestorReportes reportes = new com.ibm.ams.reportes.GestorReportes(configFile);
//        reportes.getReporte(os, "ReportePMD", beans);
//        os.close();
//        
//	}
//	
//	private static List<ItemPMD> formarEstructuraPMD(List<ItemPMD> items){
//		System.out.println("Items "+items.size());
//		List<ItemPMD> itemsP = new ArrayList<ItemPMD>();
//		if(items != null && !items.isEmpty()){
//			for(ItemPMD i : items){
//				itemsP.add(i);
//				itemsP.addAll(formarEstructuraPMD(i.getItemsPMD()));
//			}
//		}
//		return itemsP;
//	}
//
//	
//	private static List<ItemPMD> getPMDsFechaTest(){
//		GestorReportes gestor = new GestorReportes();
//		try {
//			List<ItemPMD> items = gestor.getPMDsFecha("RBM", 13, new Date("2013/06/26"), new Date("2013/06/26"));
//			System.out.println(gestor.getPosicionNeta("RBM",13, new Date("2013/06/26")));
//			System.out.println(items);
//			return items;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (XmlToDtoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	private static BigDecimal getPosicionNeta(int entidad,Date fecha){
//		GestorReportes gestor = new GestorReportes();
//		try {
//			return gestor.getPosicionNeta("RBM",entidad, fecha);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XmlToDtoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	private static List<ComisionesXBanco> getComisionesEntidadTransaccionTest(){
//		GestorReportes gestorReportes = new GestorReportes();
//		List<ComisionesXBanco> comisionesBanco = null;
//		try {
//			comisionesBanco = gestorReportes.getComisionesPorEntidadTransaccion("RBM", null, new Date("2013/06/26"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XmlToDtoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(comisionesBanco.size());
//		
//		
//		for(ComisionesXBanco comi : comisionesBanco){
//			System.out.println("Comision X Banco "+comi.getCodigoBanco() );
//			for(ComisionesXTransaccion ct : comi.getComisionesTransaccion()){
//				System.out.println("Transaccion "+ct.getTipoTransaccion());
//				for(ItemResumenComision irt : ct.getComisiones()){
//					System.out.println("Resumen "+irt.getTipoComision()+" "+irt.getCodigo());
//					System.out.println("Emisor "+irt.getResumentEmisor().getCantidad()+" "+irt.getResumentEmisor().getValor());
//					
//				}
//			}
//		}
//		
//		return comisionesBanco;
//	}
//	
//	private static List<ComisionesXBanco> getComisionesEntidadFinancieraTest(){
//		GestorReportes gestorReportes = new GestorReportes();
//		List<Integer> codigos = new ArrayList<Integer>();
//		codigos.add(7);
//		List<ComisionesXBanco> comisionesBanco = null;
//		try {
//			comisionesBanco = gestorReportes.getComisionesEntidad("RBM",null, new Date("2013/06/26"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XmlToDtoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(comisionesBanco.size());
//		return comisionesBanco;
//	}
}
