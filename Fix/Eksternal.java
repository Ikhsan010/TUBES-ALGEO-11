//package src;

import java.util.Scanner;
import java.io.*;

public class Eksternal {
    public MATRIKS bacaFileMatriks(String namaFile) {
        File file;
        MATRIKS m = new MATRIKS();
        int Nbaris = 0;
        int Nkolom = 0;
        int NEL = 0;
        int i,j;
        try {
            file = new File(namaFile);
            Scanner bacaBaris = new Scanner(file);
            while(bacaBaris.hasNextLine()){
                Nbaris++;
                String line = bacaBaris.nextLine();
                Scanner bacaKolom = new Scanner(line);
                while (bacaKolom.hasNextDouble()) {
                    NEL++;
                    Double f = bacaKolom.nextDouble();
                }
            }

            Nkolom = NEL/Nbaris;
            Scanner bacaDouble = new Scanner(file);
            m.MATRIKS(Nbaris,Nkolom);
            for (i = 0 ; i < Nbaris; i++){
                for (j = 0 ; j < Nkolom; j++){
                    Double nilai = bacaDouble.nextDouble();
                    m.matriks[i][j] = nilai;
                }
            }
        } catch(Exception e){
            System.out.println("Error : " + e);
        }
        return m;
    }

    public void saveFile(MATRIKS m, String namafile){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(namafile);
            for (int i = 0; i<m.baris; i++){
                for(int j = 0; j<m.kolom; j++){
                    writer.print(m.matriks[i][j] + " ");
		} 
                writer.println();
            }
	}
	catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());			
	}
        finally {
            try{
                if (writer != null){
                    writer.close(); 
                }
            } 
            catch (Exception e){
                System.out.println("Could not close writer");
            }
	}
    }
    
}
