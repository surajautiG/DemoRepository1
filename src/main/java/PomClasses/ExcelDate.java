package PomClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDate{

	public void Excel() throws EncryptedDocumentException, IOException
	{
		String path = "C:\\Users\\ADMIN\\Desktop\\Testing.xlsx";
		
		for(int i=0 ; i<=4 ; i++) //for  row count
		{
			for(int j=0 ; j<2 ; j++) // for cell count
			{
				FileInputStream file = new FileInputStream(path);
				String value = WorkbookFactory.create(file).
						       getSheet("Surya").getRow(i).getCell(j).
						       getStringCellValue();
				System.out.print(" "+value+" "); 
				
			}
			System.out.println();
		}
		
		
	}
}
