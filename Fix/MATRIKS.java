//package src;

import java.util.Scanner;

public class MATRIKS {
    /* DEKLARASI TIPE MATRIKS */
    protected double[][] matriks;
    protected int baris;
    protected int kolom;
    Scanner input = new Scanner(System.in);
    
    /* KONSTRUKTOR */
    public void MATRIKS(int i, int j){
        matriks = new double[i][j];
        baris = i;
        kolom = j;
    }
    
    /* SELEKTOR */
    public int getBrs(){
        return this.baris;
    }
    
    public int getKol(){
        return this.kolom;
    }
    
    public double getElmt(int i, int j){
        return this.matriks[i-1][j-1];
    }
    
    public double getDiagonal(int i){
        return this.matriks[i-1][i-1];
    }
    
    /* KELOMPOK BACA/TULIS MATRIKS */
    public void bacaMatriks(){
        /* Prosedur membaca matriks dari keyboard */
	System.out.print("Masukan jumlah baris matriks: ");
	this.baris = input.nextInt();
	System.out.print("Masukan jumlah kolom matriks: ");
	this.kolom = input.nextInt();
	this.matriks = new double[this.baris][this.kolom];
        for(int NB = 0; NB < baris; NB++){
            for(int NK = 0; NK < kolom; NK++){
                this.matriks[NB][NK] = input.nextDouble();     
            }
        }
    }
    
    public void bacaMatriks2(int i, int j){
        /* Prosedur membaca matriks dari keyboard */
        /* Matriks ini menerima baris dan kolom sbg parameter */
        this.matriks = new double[i][j];
        for(int NB = 0; NB < i; NB++){
            for(int NK = 0; NK < j; NK++){
                this.matriks[NB][NK] = input.nextDouble();
            }
        }
    }
    
    public void tulisMatriks(){
        /* Prosedur menuliskan matriks ke layar */
	int NB = this.getBrs();
	int NK = this.getKol();
        for(NB = 0; NB < baris; NB++){
            for(NK = 0; NK < kolom; NK++){
                if(this.matriks[NB][NK] == (-0.0)){
                    this.matriks[NB][NK] = 0.0;
                }
		System.out.printf("%.2f",this.matriks[NB][NK]);
		System.out.print(" ");
            }
            System.out.println();
	}
        System.out.println();
    }
    
    /* KELOMPOK PENGUJIAN MATRIKS */
    public boolean isBrsZero(int i){
        /*Fungsi mengembalikan true jika satu baris 
          semuanya 0 */
        /* KAMUS */
        int j;
        
        /* ALGORITMA */
        j = 0;
        while((this.matriks[i][j]==0) && j<this.kolom-1){
            j++;
        }
        if(this.matriks[i][j]==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isSimetris(MATRIKS m){
        /* Fungsi menghasilkan true bila matriks 
        simetris */
	boolean Simetris = true;
	if(isSquare(m)){
	for (int i = 0; i < baris; i++){
            for (int j = 0; j < kolom; j++){
		if (this.matriks[i][j] != this.matriks[j][i]){
                    Simetris = false;
		}
            }
	}
	}
        else{
            Simetris = false;
	}
	return Simetris;
    }

    public boolean isSquare(MATRIKS m){
        /* Fungsi menghasilkan true bila matriks persegi */
	return(kolom == baris);
    }
    
    /* KELOMPOK OPERASI MATRIKS */
    public int getLead(int i){
        /*Fungsi mengembalikan indeks ditemukannya lead, yakni angka pertama
          selain 0  pada baris i */
        /* KAMUS */    
        int j;
        boolean cek;
        
        /* ALGORITMA */
        cek = false;
        j = 0;
        while(j<kolom && !cek){
            cek = (this.matriks[i][j]!=0);
            if(this.matriks[i][j]==0){
                j++;
            }
        }
         return j;
    }
    
        public void swap(int i1, int i2){
        //Prosedur men-swap antara baris i1 dengan i2
        /* KAMUS */
        int j;
        
        /* ALGORITMA */
        for(j=0; j<kolom; j++){
            double temp = this.matriks[i1][j];
            this.matriks[i1][j] = this.matriks[i2][j];
            this.matriks[i2][j] = temp;
        }
    }
    
    public void kaliKoef(int i, double x){
        //prosedur mengalikan baris dengan koefisien x
        /* KAMUS */
        int j;
        
        /* ALGORITMA */
        if(i<0 || i>=baris){
            System.out.println("Baris tidak valid");
        }
        else{
            for(j=0; j<kolom; j++){
                this.matriks[i][j] *= x;
            }
        }
    }
    
    MATRIKS kaliMATRIKS(MATRIKS M1,MATRIKS M2){
        /* Fungsi mengalikan matriks M1 dengan matriks M2 */
        int i,j,k;
	MATRIKS MH = new MATRIKS();
        MH.MATRIKS(M1.baris,M2.kolom);
        for (i=0;i<M1.baris;i++){
            for (j=0;j<M2.kolom;j++){
                for (k=0;k<M1.kolom;k++){
                    MH.matriks[i][j]+=(M1.matriks[i][k]*M2.matriks[k][j]);
                }
            }
	}
        return MH;
    }
    
    public void plusBaris(int i1, int i2, double x){
        //prosedur membuat i1 = i1 + x*i2
        /* KAMUS */
        int j;
        
        /* ALGORITMA */
        
        for(j=0; j<kolom; j++){
            this.matriks[i1][j] += this.matriks[i2][j]*x;
        }
    }
    
    public void sortMatriks(){
        /*prosedur mengurutkan element matriks terurut
          membesar */
        /*prosedur akan swap baris bila getLead(i)>getLead(i+1)
        /* KAMUS */
        int i,j, maxBrs;   //note: maxBrs->awal sebagai inisiasi
        int temp;        // utk pembanding antar baris  
        
        /* ALGORITMA */
        if(baris>1){
            for(i=0; i<baris; i++){
                maxBrs = i;     //inisiasi maxBrs dg indeks i
                for(j=i+1; j<baris; j++){
                    temp = this.getLead(j);
                    if(temp < this.getLead(maxBrs)){
                        maxBrs = j;     //idx maxBrs digantikan j bila kondisi
                                        //memenuhi
                    }  
                }   
                this.swap(i,maxBrs);    //lakukan swap baris
            }
        }   
    }
    
    public void makeIdentitas(int n){
        /* Prosedur membuat matriks menjadi matriks identitas */
        /* Matriks identitas yaitu elemen diagonal utamanya 1 sedangkan
        yang lainnya 0 */
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n ; j++){
                if (i == j){
                    this.matriks[i][j] = 1;
                }
                else{
                    this.matriks[i][j] = 0;
                }
            }
	}
    }
    
    public MATRIKS matriksSegitigaBawah(MATRIKS m){
        /* Matriks membuat segitiga bawah pada matriks bernilai nol */
        double kali;
      
        MATRIKS temp = new MATRIKS();
        temp.MATRIKS(m.baris, m.kolom);
        for (int i = 0; i < temp.baris; i++){
            for (int j = 0; j < temp.kolom; j++){ 
                temp.matriks[i][j] = m.matriks[i][j];
            }
        }
        temp.tulisMatriks();
        m.tulisMatriks();
        m.gaussOp();
        m.tulisMatriks();
        for (int k = 0; k < temp.baris; k++){
            for (int l = 0; l < temp.kolom; l++){
                kali = temp.matriks[k][k];
                m.matriks[k][l] *= kali;
            }
        }
        return m;
    }
    
    
    public MATRIKS concatMatriks(MATRIKS M1, MATRIKS M2){
        /* Fungsi menggabungkan antara 2 matriks, M1 dan M2 */
        MATRIKS res = new MATRIKS();
        res.MATRIKS(M1.baris , M1.kolom + M2.kolom);
        if (M1.baris == M2.baris){
            for (int i = 0; i < M1.baris; i++){
                for (int j = 0; j < M1.kolom; j++){
                    res.matriks[i][j] = M1.matriks[i][j];
		}
            }
            for (int i = 0; i < M1.baris; i++){
                for (int j = M1.kolom; j < M1.kolom + M2.kolom; j++){
                    res.matriks[i][j] = M2.matriks[i][j-M1.kolom];
                }
            }
            return res;
        }
        else{
            System.out.println("Gagal, Baris kedua matriks tidak sama!");
            return this;
        }
    }
        
    public MATRIKS cropMatriks(int first, int last){
        /* Fungsi mengkopi matriks lama ke matriks yang baru */
        if ((first >= 0 && first < this.kolom) && (last >= 0 && last < this.kolom) && (first <= last)){
            MATRIKS crop = new MATRIKS();
            crop.MATRIKS(this.baris ,last-first+1);
            for (int i = 0; i < this.baris; i++){
                int Kolom = 0;
		for (int j = first; j <= last; j++){
                    crop.matriks[i][Kolom] = this.matriks[i][j];
                    Kolom++;
		}
            }
            return crop;
	}
        else{
            System.out.println("Gagal, indeks tidak valid!");
            return this;
	}
    }
    
    /* KELOMPOK MAIN OPERATION */
    public void gaussOp(){
        //prosedur melakukan operasi gauss pada matriks
        /* KAMUS */
        int i,j;
        int tempIdxLead;
        double leadKoef,pengali;
        
        /* ALGORITMA */
        this.sortMatriks();
        for(i=0; i<baris-1; i++){
            //Lakukan validasi baris, apakah seluruh elemennya 0 semua
            if(!this.isBrsZero(i)){
                leadKoef = this.matriks[i][this.getLead(i)];
                //Lakukan operasi gauss pada baris dibawahnya
                for(j=i+1; j<baris; j++){
                    if(!this.isBrsZero(j)){
                        pengali = (-1)*this.matriks[j][this.getLead(i)] / leadKoef;
                        this.plusBaris(j, i, pengali);
                    }
                    this.matriks[j][this.getLead(i)] = 0;
                }
            }
        }
        
        for(i=0; i<baris; i++){
            if(!this.isBrsZero(i)){
               leadKoef = this.matriks[i][this.getLead(i)];
               double temp = 1/leadKoef;
               this.kaliKoef(i, temp);
            }
        }
        
    }
    
    public double determinanGauss(MATRIKS m){
        /* Fungsi menentukan determinan menggunakan metode gauss */
        double det = 0;
        if (isSquare(m)){
            m = m.matriksSegitigaBawah(m);
            m.tulisMatriks();
            for (int i = 0; i < m.baris; i++){
                det *= m.matriks[i][i];
            }
        }
        else{
            System.out.println("Ukuran Matriks tidak sesuai");
        }
        return det;
    }
    
    public void gaussJordan(){
        /* Prosedur membuat matriks menggunakan metode gauss jordan */
        /* KAMUS */
        int i,j;
        
        /* ALGORITMA */
        gaussOp();
        for(i=baris-1; i>0; i--){
            if(!this.isBrsZero(i)){
                for(j=i-1; j>=0; j--){
                    if(!this.isBrsZero(j)){
                        double pengali = (-1)*this.matriks[j][this.getLead(i)];
                        this.plusBaris(j,i,pengali);
                    }
                }
            }
        }
    }
    
    public MATRIKS matriksMinor(MATRIKS m, int b, int k){
        /* Fungsi menentukan minor pada matriks */
	MATRIKS res = new MATRIKS();
 	res.MATRIKS(this.baris-1,this.kolom-1);
	int idxBar = 0;
	if (isSquare(m)){
            for (int i = 0; i < baris; i++){
		int idxKol = 0;
		for (int j =  0; j < kolom; j++){
                    if ((i != b) && (j != k)){
			res.matriks[idxBar][idxKol] = this.matriks[i][j];
			++idxKol;
                    }
                }
		if (idxKol == this.kolom-1){
                    ++idxBar;
		}
            }
	} 
        else {
            System.out.println("Ukuran Matriks tidak sesuai");
            res = m;
	}
	return res;
    }
    
    public MATRIKS matriksKofaktor(MATRIKS m){	
        /* Fungsi membuat matriks kofaktor dengan memanfaatkan
        minor pada matriks 
        */
	MATRIKS minor = new MATRIKS();
	MATRIKS kofaktor = new MATRIKS();
	kofaktor.MATRIKS(this.baris, this.kolom);
	double determinan;
	if (isSquare(m)){
            for (int i = 0; i < baris; i++){
		for (int j =  0; j < kolom; j++){								
                    minor = m.matriksMinor(m,i,j);
                    determinan = Math.pow(-1,i+j)*minor.determinan(minor);
                    kofaktor.matriks[i][j] = determinan;
		}
            }
	}
        else{
            System.out.println("Ukuran Matriks tidak sesuai");
            kofaktor = m;
	}
        return kofaktor;
    }
    
    public double determinan(MATRIKS m){
        /* Fungsi menentukan determinan menggunakan
        metode ekspansi kofaktor */
        double det = 0;
        MATRIKS minor = new MATRIKS();
        if(isSquare(m)){
            if ((baris == 1) && (kolom == 1)){
                return m.matriks[0][0];
            }
            else {
                for (int i = 0; i < baris; i++){
                    minor = m.matriksMinor(m,i,0);
                    det += (Math.pow(-1, i))*(m.matriks[i][0])*(minor.determinan(minor));									
                }
            }

	} 
        else{
            System.out.println("Ukuran Matriks tidak sesuai");
        }
        return det;
    }
    
    public MATRIKS transpose (MATRIKS m){
        /* Fungsi men-transpose matriks */
	int j,i;
	MATRIKS MT = new MATRIKS();
	MT.MATRIKS(m.baris, m.kolom);
	for (i=0;i<m.baris;i++){
            for (j=0;j<m.kolom;j++){
		MT.matriks[i][j]=m.matriks[j][i];
            }
	}
	return MT;
    }
    
    public MATRIKS matriksAdjoin(MATRIKS m){
        /* Fungsi men-transpose matriks kofaktor */
	MATRIKS MT = new MATRIKS();
	MT.MATRIKS(m.baris, m.kolom);
	MT = m.transpose(m.matriksKofaktor(m));
	return MT;
    }
    
    public MATRIKS InverseAdDet(MATRIKS m){
        /* Fungsi menentukan inverse suatu matriks menggunakan
        metode adjoin
        */
        int i;
        if (m.determinan(m)==0){
            System.out.println("Matriks Singular");
            return m;
        }
        else{
            MATRIKS MAdj = m.matriksAdjoin(m);
            for (i=0;i<m.baris;i++){
                MAdj.kaliKoef(i,1/m.determinan(m));
            }
            return MAdj;
        }
    }
    
    public MATRIKS matriksInversGaussJordan(MATRIKS m){
        /* Fungsi menentukan inverse matriks menggunakan metode 
        Gauss Jordan
        */
        MATRIKS i = new MATRIKS();
        i.MATRIKS(m.baris, m.baris);
        i.makeIdentitas(m.baris);
	MATRIKS temp = new MATRIKS();
        temp.MATRIKS(m.baris, (m.kolom)+(i.kolom));
        temp = temp.concatMatriks(m,i);
        temp.gaussJordan();
        m = temp.cropMatriks((m.kolom), (m.kolom) + (i.kolom)-1);
        return m;
    }
    
    public void	SPLCrammer(){	
        /* Fungsi menentukan nilai variabel pada SPL
        dengan memanfaatkan determinan dari matriks */
        int i,j,n,a;
        double DetUtama;
        n = 0;
        Scanner input = new Scanner(System.in);
        MATRIKS M = new MATRIKS();
        MATRIKS hasil = new MATRIKS();
        System.out.println("Masukkan matriks koefisien: ");
        M.bacaMatriks();
        double [] det = new double[M.baris];
        System.out.println("Masukkan matriks hasil: ");
        hasil.bacaMatriks2(M.baris,1);
            for (j=0;j<M.kolom;j++){
                MATRIKS M3 = new MATRIKS();
                M3.MATRIKS(M.baris,M.kolom);
                for (n=0;n<M.baris;n++){
                    for (i=0;i<M.baris;i++){
                        for (j=0;j<M.kolom;j++){
                            M3.matriks[i][j]=M.matriks[i][j];
			}
                    }
                    for (i=0;i<M.baris;i++){
			for (j=0;j<M.kolom;j++){
                            if (j==n){
				M3.matriks[i][j]=hasil.matriks[i][0];
    				det[i] = M3.determinan(M3);
                            }
			}
                    }
		}	
            }
            System.out.println("Solusi SPL yang diberikan adalah ");
            for (i=0;i<M.baris;i++){
		System.out.println(det[i]/M.determinan(M));
            }
    }
    
    public MATRIKS SPLInvers(MATRIKS Koef, MATRIKS Hasil){
        /* Prosedur meng-inverse matriks bentukan SPL */
        int i,j;
        MATRIKS MI = new MATRIKS();
        MATRIKS MH = new MATRIKS();
		MI = MI.InverseAdDet(Koef);
		MH = MI.kaliMATRIKS(MI,Hasil);
	return MH;
    }
    
    public MATRIKS SPLGaussJordan(MATRIKS Koef, MATRIKS Hasil){
        /* Fungsi menentukan nilai variabel dari SPL menggunakan metode
        Gauss Jordan*/
        MATRIKS temp = new MATRIKS();
        temp.MATRIKS(Koef.baris, (Koef.kolom)+1);
	temp = temp.concatMatriks(Koef,Hasil);
        temp.gaussJordan();
        MATRIKS res = new MATRIKS();
        res.MATRIKS((Hasil.baris),1);
	res = temp.cropMatriks((Koef.kolom),(Koef.kolom));
        return res;
    }
    
    public void InterPoli()
    {
		int i,j, ntitik;
		double res;
		double xtaksir;
		MATRIKS M = new MATRIKS();
		System.out.print("Jumlah titik yang ingin dibuat: ");
		ntitik = input.nextInt();
		M.MATRIKS(ntitik,ntitik);
		double[] x = new double[ntitik];
		double[] y = new double[ntitik];
		for(i=0;i<ntitik;i++)
		{
			System.out.print("x["+(i+1)+"]: ");
			x[i] = input.nextDouble();
			System.out.print("y["+(i+1)+"]: ");
			y[i] = input.nextDouble();
		}
		System.out.println();
		System.out.println("Titik yang terbentuk adalah");
		for (i=0;i<ntitik;i++)
		{
			System.out.println("("+x[i]+","+y[i]+")");
		}
		for (i=0;i<ntitik;i++)
		{
			M.matriks[i][0]=1;
			for (j=0;j<ntitik-1;j++)
			{
				M.matriks[i][j+1]=Math.pow(x[i],j+1);
			}
		}
		MATRIKS hasil = new MATRIKS();
		hasil.MATRIKS(ntitik,1);
		for (i=0;i<ntitik;i++)
		{
			hasil.matriks[i][0]=y[i];
		}
		hasil = hasil.SPLInvers(M,hasil);
		System.out.print("Masukkan x yang ingin ditakskir: ");
		xtaksir = input.nextDouble();
		res = 0;
		for (i=0;i<ntitik;i++)
		{
			res+=hasil.matriks[i][0]*Math.pow(xtaksir,i);
		}
		System.out.print("Hasil interpolasi adalah ");
		System.out.printf("%.2f",res);
		System.out.println();
	}
}
