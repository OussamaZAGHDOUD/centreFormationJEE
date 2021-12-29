package metier.entities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GenererFichier extends Thread{
	
	public GenererFichier( List<Etudiant> ls,int nbr,String nom)  {
		//1. Créer un Document vide
	       XSSFWorkbook wb = new XSSFWorkbook();
	       //2. Créer une Feuille de calcul vide
	       Sheet feuille = wb.createSheet("new sheet");
	 	  XSSFCellStyle csCouleur = wb.createCellStyle();
	 	  csCouleur.setFillPattern(csCouleur.SOLID_FOREGROUND);
	       Row ro = feuille.createRow((short)0);
		   ro.createCell(0).setCellValue("Nom de la matière : "+nom);

	       Row row = feuille.createRow((short)1);
	    		   row.createCell(0).setCellValue("Nom                      .");
	    		   row.createCell(1).setCellValue("Numéro de téléphone      .");
				 	  row.getCell(0).setCellStyle(csCouleur);
				 	  row.getCell(1).setCellStyle(csCouleur);
	       for (int i=2;i<nbr+2;i++)
	       {
		     row.createCell(i).setCellValue("Séance numéro "+(i-1)+"        .");
		 	  row.getCell(i).setCellStyle(csCouleur);
	       }
			/*
			 * for(int x=0;x<ls.size();x++) { Row row1 = feuille.createRow((short)(x+2));
			 * 
			 * Cell ceell = row1.createCell(0); String s= ls.get(x).getNom();
			 * ceell.setCellValue(s);
			 * 
			 * }
			 */
		       

	       
	       
	       
	       for(int i=0;i<ls.size();i++)
	       {
	    	   //3. Créer une ligne et mettre qlq chose dedans
		       Row row1 = feuille.createRow((short)(i+2));
		       
		        for (int j=0;j<(nbr+2);j++) {
		       Cell ceell = row1.createCell(j);
		       switch(j)
		       {
		       case 0:			       ceell.setCellValue(ls.get(i).getNom()+"        "); break;
		       case 1:			       ceell.setCellValue(ls.get(i).getNumTel()+"        "); break;
		       default: ceell.setCellValue("                     ");break;
		       
		       }
		       }
	       
		        
		        ro.getCell(0).setCellStyle(csCouleur);
    FileOutputStream fileOut;

	       
	       try {
	         fileOut = new FileOutputStream("/home/oussema/Desktop/nouveauFichier.xlsx");
	         wb.write(fileOut);
	         fileOut.close();
	       } catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e1) {
	           e1.printStackTrace();
	       } 
}
	}}
