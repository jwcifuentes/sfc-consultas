package com.ibm.rbm.generador.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import com.ibm.rbm.generador.entidades.ContentZIP;
import com.ibm.rbm.generador.excepcion.ExcepcionZIP;

/**
 * @author dprojas - IBM Colombia
 * @version Proyecto GeneradorZIP-v1.0_Agosto, 2013
 *
 */
public class GeneradorZIP {
	
	/**
	 * Comprime un archivo en otro en formato ZIP. Soporta directorios recursivamente.
	 * @param fileSource File
	 * @param fileZip File
	 */
	public static boolean zipFile(File fileSource, File fileZip) {
		return zipFile(fileSource, fileZip, null);
	}
	/**
	 * Comprime un archivo en otro en formato ZIP. Soporta directorios recursivamente.
	 * @param fileSource File
	 * @param fileZip File
	 * @param name Nombre del archivo en el zip, si es null se toma el nombre del archivo
	 * 	recibido.
	 */
	public static boolean zipFile(File fileSource, File fileZip, String name) {
		return zipFile(new File[]{fileSource},fileZip,name);
	}
	/**
	 * Comprime varios archivos en otro en formato ZIP. Soporta directorios recursivamente.
	 * @param fileSource File[]
	 * @param fileZip File
	 * @param name Nombre del archivo en el zip, si es null se toma el nombre del archivo
	 * 	recibido.
	 */
	public static boolean zipFile(File[] fileSource, File fileZip, String name) {
		byte[] buf = new byte[1024 * 4];
		if (fileSource==null || fileSource.length==0 || fileZip==null)
			return false;
		
		String path=null;
		try {
			// Create the ZIP file
			FileOutputStream out1=new FileOutputStream(fileZip);
			ZipOutputStream out = new ZipOutputStream(out1);

			// Compress the file	
			int files=0;		
			for (int i=0;i<fileSource.length;i++){
				if (fileSource[i]==null || !fileSource[i].exists())
					continue;
				files++;
				path=fileSource[i].getAbsolutePath();
				
				addZip(fileSource[i],fileSource[i],out,i==0?name:null,buf);
				
			}
			// Complete the ZIP file
			if (files>0){
				out.close();//lanza exception si no contiene ningun archivo
				return true;
			}else{		
				out1.close();
				return false;
			}
		} catch (Exception e) {
//			log.error("Error empaquetando archivo: "+path+" ex: "+e);
			System.out.println("Error empaquetando archivo: "+path+" ex: "+e);
			return false;
		}
	}
	/**
	 * Adiciona un archivo o directorio a un ZipOutputStream recursivamente.
	 * @param path archivo a adicionar
	 * @param root directorio raiz relativo.
	 * @param out salida ZIP
	 * @param name nombre para el archivo a adicionar, si es null toma el de File.
	 * @param buf Buffer compartido para el proceso.
	 * @throws Exception
	 */
	private static void addZip(File path, File root, ZipOutputStream out,String name,byte[] buf) throws Exception {
		if (name==null)
			name = path.getName();
		
		if (path.isDirectory()){
			String[] files=path.list();
			for (int i = 0; i < files.length; i++) {
				String fname = files[i];
				File n=new File(path,fname);
				addZip(n, root, out, n.getAbsolutePath().substring(root.getAbsolutePath().length()), buf);
			}
		}else{
			if (name.charAt(0)=='\\' || name.charAt(0)=='/')
				name=name.substring(1);
			FileInputStream in = new FileInputStream(path);
			// Add ZIP entry to output stream.
			out.putNextEntry(new ZipEntry(name));
	
			// Transfer bytes from the file to the ZIP file
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
	
			// Complete the entry
			out.closeEntry();
			in.close();
		}
		
		
	}
	/**
	 * Descomprime un archivo zip, crea los subdirectorios si es necesario y borra los archivos
	 * reemplazados.
	 * @param srczip archivo zip a descomprimir.
	 * @param target directorio donde se descomprime.
	 * @return
	 */
	public static boolean unZipFile(File srczip, File target) {
		ZipInputStream in=null;
		FileOutputStream out=null;
		try {
			in = new ZipInputStream(new FileInputStream(srczip));
			ZipEntry entry=in.getNextEntry();
			target.mkdirs();
			while(entry!=null){
				if(entry.isDirectory()){
					new File(target.getAbsoluteFile()+"/"+entry.getName()).mkdirs();
				}else{
					String file=target.getAbsoluteFile()+"/"+entry.getName();
					new File(file).delete();
					out = new FileOutputStream(file);
					byte[] buf=new byte[2048];
					int read=in.read(buf);
					while(read>0){
						out.write(buf,0,read);
						read=in.read(buf);
					}
					out.close();
					new File(file).setLastModified(entry.getTime());
				}
				entry=in.getNextEntry();
			}
			in.close();
			return true;
		} catch (Exception e) {
			try{in.close();out.close();}catch(Exception e1){}
//			log.error("Error haciendo unzip de archivo "+srczip.getAbsolutePath()+" de tamanno "+srczip.length(),e);
			System.out.println("Error haciendo unzip de archivo "+srczip.getAbsolutePath()+" de tamaño "+srczip.length());
			return false;
		} 
	}
	
	/**
	 * Crea un archivo zip, comprime todos los archivos que llegan como parametro.
	 * 	
	 * 	@param path 
	 * 		Ruta absoluta donde se crea el archivo .zip
	 * 	
	 * 	@param List<ContentZIP> 
	 * 		Lista de archivos que contendra el comprimido. 
	 * 
	 * @return	ZipOutputStream
	 * 		Archivo .zip generado con el contenido correspondiente.
	 * @throws Exception 
	 * 		
	 */	
	public byte[] zipFiles(String nombreArchivo, List<ContentZIP> contentZIP) throws ExcepcionZIP{		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ZipOutputStream out = null;

		try{			
			out = new ZipOutputStream(outStream);

			for(ContentZIP content : contentZIP){
				ZipEntry e = new ZipEntry(content.getNombre());
				out.putNextEntry(e);

				byte[] data = content.getArchivo();
				out.write(data, 0, data.length);
				out.closeEntry();				
			}
			out.close();			

		}catch (IOException e) {
			throw new ExcepcionZIP("El archivo no pudo ser creado", e);
			// log.error("Error creando el archivo: "+e);
		}catch (Exception e) {
			throw new ExcepcionZIP("Ocurrió un error generando el archivo .zip", e);
			// log.error("Error empaquetando archivo: "+nombreArchivo+" ex: "+e);
		}
		return outStream.toByteArray(); 
	}	
}
