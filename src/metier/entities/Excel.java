package metier.entities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
    public static void main(String[] args) {
   
       //1. Créer un Document vide
       XSSFWorkbook wb = new XSSFWorkbook();
       //2. Créer une Feuille de calcul vide
       Sheet feuille = wb.createSheet("new sheet");
       //3. Créer une ligne et mettre qlq chose dedans
       Row row = feuille.createRow((short)0);
       //4. Créer une Nouvelle cellule
       Cell cell = row.createCell(0);
       //5. Donner la valeur
       cell.setCellValue(1.2);
   
       //Ajouter d'autre cellule avec différents type
       /*int*/row.createCell(1).setCellValue(3);
       /*char*/row.createCell(2).setCellValue('c');
       /*String*/row.createCell(3).setCellValue("chaine");
       /*boolean*/row.createCell(4).setCellValue(false);

       FileOutputStream fileOut;
       try {
         fileOut = new FileOutputStream("/home/oussema/Desktop/nouveauFichier.xlsx");
         wb.write(fileOut);
         fileOut.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}