package src;

import java.util.Scanner;
import java.io.*;

public class Menu extends MATRIKS{
        int pilihan,submenu;
        Scanner input = new Scanner(System.in);
        
    	public void Menu(){
		System.out.println("================================================");
		System.out.println("MENU");
		System.out.println("1. Sistem Persamaan Linier");
		System.out.println("2. Determinan");
		System.out.println("3. Matriks Balikan");
		System.out.println("4. Matriks Kofaktor");
		System.out.println("5. Matriks Adjoin");
		System.out.println("6. Interpolasi Polinom");
		System.out.println("7. Keluar");
		System.out.println("================================================");
		System.out.print("Pilih menu yang Anda inginkan: ");
	}
        
	public void Submenu1(){
		System.out.println("================================================");
		System.out.println("1. Metode Eliminasi Gauss");
		System.out.println("2. Metode Eliminasi Gauss-Jordan");
		System.out.println("3. Metode Matriks Balikan");
		System.out.println("4. Kaidah Cramer");
		System.out.print("Pilih sub-menu yang Anda inginkan: ");
	}
        
    public void Submenu2(){ 
        /* Submenu pilihan 2, determinan */
		System.out.println("================================================");
		System.out.println("1. Metode Eliminasi Gauss");
		System.out.println("2. Metode Ekspansi Kofaktor");
		System.out.print("Pilih sub-menu yang Anda inginkan: ");
        }
        
	public void Submenu3(){
        /* Submenu pilihan 3, matriks balikan */
		System.out.println("================================================");		
		System.out.println("1. Metode Adjoin");
		System.out.println("2. Metode Gauss");
		System.out.print("Pilih sub-menu yang Anda inginkan: ");
        }
        
	public void SubSubMenu(){
        System.out.println("================================================");		
		System.out.println("1. Membaca dari keyboard");
		System.out.println("2. Membaca dari file");
		System.out.print("Pilih metode input yang Anda inginkan: ");
        }
        public void bacaMenu(){
            pilihan = 0;
            while(pilihan != 7){
                Menu();
                pilihan = input.nextInt();
                switch(pilihan){
                    case 1: //SPL
                            Submenu1();
                            MATRIKS M1 = new MATRIKS();
                            MATRIKS Koef = new MATRIKS();
                            MATRIKS Hasil = new MATRIKS();
                            submenu = input.nextInt();
                            
                            switch(submenu){
                                case 1: //Eliminasi gauss
									SubSubMenu();
									int subsubmenu = input.nextInt();
									if (subsubmenu==1)
									{											
										System.out.println("Masukkan matriks koefisien: ");
			   
										Koef.bacaMatriks();
										Hasil.MATRIKS(Koef.baris,1);
										System.out.println("Masukkan matriks hasil: ");
										Hasil.bacaMatriks2(Koef.baris,1);
										Hasil = Hasil.SPLGaussJordan(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
									}
									else if (subsubmenu==2)
									{
										Eksternal ex = new Eksternal();
										Koef = ex.bacaFileMatriks("../test/Matriks.txt");
										Hasil = ex.bacaFileMatriks("../test/HasilSPL.txt");
										Hasil = Hasil.SPLGaussJordan(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
									}
                                    break;              
                                case 2: //Eliminasi gauss jordan
									SubSubMenu();
                                    int subsubmenu2 = input.nextInt();
									if (subsubmenu2==1)
									{
										System.out.println("Masukkan matriks koefisien: ");
										Koef.bacaMatriks();
										Hasil.MATRIKS(Koef.baris,1);
										System.out.println("Masukkan matriks hasil: ");
										Hasil.bacaMatriks2(Koef.baris,1);
										Hasil = Hasil.SPLGaussJordan(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
                                    } 
                                    else if (subsubmenu2==2)
									{
										Eksternal ex = new Eksternal();
										Koef = ex.bacaFileMatriks("../test/Matriks.txt");
										Hasil = ex.bacaFileMatriks("../test/HasilSPL.txt");
										Hasil = Hasil.SPLGaussJordan(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
									}
                                    break;
                                    
                                case 3: //Matriks balikan
                                    SubSubMenu();
                                    int subsubmenu3 = input.nextInt();
									if (subsubmenu3==1)
									{
										System.out.println("Masukkan matriks koefisien: ");
										Koef.bacaMatriks();
										Hasil.MATRIKS(Koef.baris,1);
										System.out.println("Masukkan matriks hasil: ");
										Hasil.bacaMatriks2(Koef.baris,1);
										Hasil = Hasil.SPLInvers(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
									}
									else if (subsubmenu3==2)
									{
										Eksternal ex = new Eksternal();
										Koef = ex.bacaFileMatriks("../test/Matriks.txt");
										Hasil = ex.bacaFileMatriks("../test/HasilSPL.txt");
										Hasil = Hasil.SPLGaussJordan(Koef,Hasil);
										System.out.println("Solusi SPL yang diberikan adalah ");
										Hasil.tulisMatriks();
									}
									break;
                                    
                                case 4: //Kaidah cramer
                                    SPLCrammer();
                                    break;
                            }
                            break;
                            
                    case 2: //Determinan
                            Submenu2();
                            submenu = input.nextInt();
                            MATRIKS M2 = new MATRIKS(); 
                            switch(submenu){
                                case 1: //Gauss
                                    SubSubMenu();
                                    int subsubmenu21 = input.nextInt();
									if (subsubmenu21==1)
									{
										M2.bacaMatriks();
										//M2.determinanGauss(M2);
										System.out.println("Determinan matriks menggunakan metode gauss adalah "+ M2.determinanGauss(M2));
									}
									else if (subsubmenu21==2)
									{
										Eksternal ex = new Eksternal();
										M2 = ex.bacaFileMatriks("../test/Matriks.txt");
										System.out.println("Determinan matriks menggunakan metode gauss adalah "+ M2.determinanGauss(M2));
									}
									break;
                                    //Sudah dicek, SALAH
                                    
                                case 2: //Ekspansi kofaktor
                                    SubSubMenu();
                                    int subsubmenu22 = input.nextInt();
									if (subsubmenu22==1)
									{
										M2.bacaMatriks();
										System.out.println("Determinan matriks menggunakan kofaktor adalah "+M2.determinan(M2));
                                    }
									else if (subsubmenu22==2)
									{
										Eksternal ex = new Eksternal();
										M2 = ex.bacaFileMatriks("../test/Matriks.txt");
										System.out.println("Determinan matriks menggunakan kofaktor adalah "+M2.determinan(M2));
                                    }
                                    break;
                                    //Sudah dicek, BENAR
                            }
                            break;
                    
                    case 3: //Matriks balikan / inverse
                            Submenu3();
                            MATRIKS M3 = new MATRIKS();
                            submenu = input.nextInt();
                            switch (submenu){
                                case 1: //Metode adjoin
                                    SubSubMenu();
                                    int subsubmenu31 = input.nextInt();
									if (subsubmenu31==1)
									{
										M3.bacaMatriks();
										M3 = M3.InverseAdDet(M3);
										System.out.println("Matriks balikan menggunakan metode Adjoin adalah ");
										M3.tulisMatriks();
									}
									else if (subsubmenu31==2)
									{
										Eksternal ex = new Eksternal();
										M3 = ex.bacaFileMatriks("../test/Matriks.txt");
										M3 = M3.InverseAdDet(M3);
										System.out.println("Matriks balikan menggunakan metode Adjoin adalah ");
										M3.tulisMatriks();
									}
                                    break;
                                    //Sudah dicek, BENAR
                                case 2: //Metode Gauss
                                    SubSubMenu();
                                    int subsubmenu32 = input.nextInt();
									if (subsubmenu32==1)
									{
										M3.bacaMatriks(); 
										M3 = M3.matriksInversGaussJordan(M3);
										System.out.println("Matriks balikan menggunakan metode Gauss adalah ");
										M3.tulisMatriks();
									}
									else if (subsubmenu32==2)
									{
										Eksternal ex = new Eksternal();
										M3 = ex.bacaFileMatriks("../test/Matriks.txt");
										M3 = M3.matriksInversGaussJordan(M3);
										System.out.println("Matriks balikan menggunakan metode Gauss adalah ");
										M3.tulisMatriks();
									}
                                    break;
                                    //Belum selesai, SALAH!
                            }
                            break;
                    
                    case 4: //Matriks kofaktor
                            SubSubMenu();
                            int subsubmenu4 = input.nextInt();
							if (subsubmenu4==1)
							{
								MATRIKS M4 = new MATRIKS();
								M4.bacaMatriks();
								M4 = M4.matriksKofaktor(M4);
								M4.tulisMatriks();
							}
							else if (subsubmenu4==2)
							{
								MATRIKS M4 = new MATRIKS();
								Eksternal ex = new Eksternal();
								M4 = ex.bacaFileMatriks("../test/Matriks.txt");
								M4 = M4.matriksKofaktor(M4);
								System.out.println("Matriks Kofaktor:");
								M4.tulisMatriks();
							}

							break;
                            //Sudah dicek, BENAR
                   
                    case 5: //Matriks adjoin
                            SubSubMenu();
                            int subsubmenu5 = input.nextInt();
							if (subsubmenu5==1)
							{
								MATRIKS M5 = new MATRIKS();
								M5.bacaMatriks();
								M5 = matriksAdjoin(M5);
								M5.tulisMatriks();
							}
							else if (subsubmenu5==2)
							{
								MATRIKS M5 = new MATRIKS();
								Eksternal ex = new Eksternal();
								M5 = ex.bacaFileMatriks("../test/Matriks.txt");
								M5 = M5.matriksAdjoin(M5);
								System.out.println("Matriks Adjoin:");
								M5.tulisMatriks();
							}
							break;
                            //Sudah dicek, BENAR
                            
                    case 6: //Interpolasi polinom
							InterPoli();
                            break;
                    case 7:
                            System.out.println("Semangat DECRYPT 2018");
                            break;
                }
                
                System.out.println("================================================");
                System.out.println("================================================");
                System.out.println("================================================");
            }
            
        }
}
