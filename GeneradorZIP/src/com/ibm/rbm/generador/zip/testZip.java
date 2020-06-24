package com.ibm.rbm.generador.zip;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.ibm.rbm.generador.entidades.ContentZIP;
import com.ibm.rbm.generador.excepcion.ExcepcionZIP;

public class testZip {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ExcepcionZIP, IOException {		

		GeneradorZIP generadorZ = new GeneradorZIP();

		try {
			File f = new File("c:\\testHoy.zip");
			FileOutputStream file = new FileOutputStream(f);
			ZipOutputStream out = new ZipOutputStream(file);
			byte[] zip = generadorZ.zipFiles("Test_GeneradorZIP", getLista());			
			
			
		}  catch (FileNotFoundException e1) {
			System.out.println("Error:" + e1.getMessage());
			e1.printStackTrace();
		}		catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static List<ContentZIP> getLista() throws IOException{
		List<ContentZIP> contenidos = new ArrayList<ContentZIP>();		

		try{
			ContentZIP contenido = null;

			contenido = new ContentZIP();
			contenido.setNombre("Hola1.txt");
			contenido.setArchivo(getByte("C:\\archivos\\uno.txt"));
			contenidos.add(contenido);

			contenido = new ContentZIP();
			contenido.setNombre("Hola2.txt");
			contenido.setArchivo(getByte("C:\\archivos\\dos.txt"));
			contenidos.add(contenido);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
		return contenidos;
	}

	public static byte[] getByte(String a) throws IOException{
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		try{
			InputStream inputStream = new FileInputStream (a);
			int nRead;
			byte[] data = new byte[16384];

			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();
			System.out.println("Arreglo de bytes generado: " + buffer.toByteArray());
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
		return buffer.toByteArray();
	}


}
