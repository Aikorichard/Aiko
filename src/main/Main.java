package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	ArrayList<String> kodeList = new ArrayList<>();
	ArrayList<String> namaList = new ArrayList<>();
	ArrayList<String> jenisList = new ArrayList<>();
	ArrayList<String> jabatanList = new ArrayList<>();
	ArrayList<Integer> gajiList = new ArrayList<>();

	
	public Main() {
		int menu = 0;
		do {
		System.out.println("PT ChipiChapa");
		System.out.println("1. Insert data");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.println("5. Exit");
		System.out.print(">> ");
		
		menu = scan.nextInt();
		scan.nextLine();
		
		switch (menu) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			update();
			break;
		case 4:
			delete();
			break;
		default:
			break;
	}
		}while (menu != 5);
		System.out.println("Thank you");
			}
	private void insert() {
		String nama = "";
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		String jenis = "";
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenis = scan.nextLine();
		} while (!(jenis.equals("Laki-laki") || jenis.equals("Perempuan")));
		String jabatan = "";
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		char randomhuruf1, randomhuruf2;
		randomhuruf1 = (char) (rand.nextInt(26) + 'A');
		randomhuruf2 = (char) (rand.nextInt(26) + 'A');
		int randomangka = rand.nextInt(10000);
		String kode = "" + randomhuruf1 + randomhuruf2 + "-" + randomangka;
		
		int gaji = 0;
		int manager = 0, supervisor = 0, admin = 0;
		
		switch (jabatan) {
		case "Manager":
			gaji = 8000000;
			break;
		case "Supervisor":
			gaji = 6000000;
			break;
		case "Admin":
			gaji = 4000000;
			break;
		default:
			break;
			
		}

		jabatanList.add(jabatan);
		jenisList.add(jenis);
		namaList.add(nama);
		kodeList.add(kode);
		gajiList.add(gaji);
		
		if (jabatan.equals("Manager")) {	
		        manager++;
		    } else if (jabatan.equals("Supervisor")) {
		        supervisor++;
		    } else if (jabatan.equals("Admin")) {
		        admin++;
		    }
		
		if (manager %3 == 0 && manager != 0) {
			for (int i = 0; i < jabatanList.size(); i++) {
				if (jabatanList.get(i).equals("Manager")) {
					int bonus = (int) (gajiList.get(i)* 0.10);
					gajiList.set(i, gajiList.get(i) + bonus);
						System.out.print("Bonus sebesar 10% diberikan kepada karyawan dengan ID " + kodeList.get(i) + ", ");
				}
			}
		} else if (supervisor %3 == 0 && supervisor != 0) {
			for (int j = 0; j < jabatanList.size(); j++) {
				if (jabatanList.get(j).equals("Supervisor")) {
					int bonus = (int) (gajiList.get(j) * 0.075);
					gajiList.set(j, gajiList.get(j) + bonus);
						System.out.print("Bonus sebesar 7.5% diberikan kepada karyawan dengan ID " + kodeList.get(j) + ", ");
				}
			}
		} else if (admin %3 == 0 && admin != 0) {
			for (int k = 0; k < jabatanList.size(); k++) {
				if (jabatanList.get(k).equals("Admin")) {
					int bonus = (int) (gajiList.get(k) * 0.05);
					gajiList.set(k, gajiList.get(k) + bonus);
						System.out.print("Bonus sebesar 5% diberikan kepada karyawan dengan ID " + kodeList.get(k) + ", ");
				}
			}
		}
		
		System.out.println("Berhasil menambahkan karyawan dengan ID :  " + kode);
		System.out.println("ENTER to return");
		scan.nextLine();	
	}
	
	private void view() {
		if (namaList.isEmpty()) {
			System.out.println("There's no list");
		} else {
			sortAsc();
			System.out.println("|----|--------------|------------------------------|------------------|----------------|----------------|");
			System.out.println("|No  |Kode Karyawan |Nama Karyawan                 |Jenis Kelamin     |Jabatan         |Gaji Karyawan   |");
			System.out.println("|----|--------------|------------------------------|------------------|----------------|----------------|");
			for (int i = 0; i < namaList.size(); i++) {
				System.out.printf("|%d|%14s|%30s|%18s|%16s|%16d|\n", i + 1, kodeList.get(i), namaList.get(i), jenisList.get(i), jabatanList.get(i), gajiList.get(i));
			}
			System.out.println("|----|--------------|------------------------------|------------------|----------------|----------------|");
		}
	}
	private void update() {
		view();
		System.out.print("Input nomor karyawan yang ingin diupdate: ");
		int no = scan.nextInt(); 
		scan.nextLine();
		
		String nama = "";
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while ( nama.length() <3);
		String jenis = "";
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenis = scan.nextLine();
		} while (!(jenis.equals("Laki-laki") || jenis.equals("Perempuan")));
		String jabatan = "";
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		int gaji = 0;
		if (kodeList.equals("0") && nama.equals("0") && jenis.equals("0") && jabatan.equals("0") && gaji == 0) {
			System.out.println("Data karyawan tidak berubah.");
			return;
			
		namaList.set(no, nama);
		jenisList.set(no, jenis);
		jabatanList.set(no, jabatan);
		
        }
		System.out.println("Berhasil mengupdate karyawan dengan ID " + kodeList.get(no));
		System.out.println("ENTER to return");
	}
	private void delete() {
		System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
		int i = scan.nextInt();scan.nextLine();
		System.out.println("Karyawan dengan kode " + kodeList.get(i-1) + " berhasil dihapus");
		namaList.remove(i - 1);
		System.out.println("ENTER to return");
	}
	private void sortAsc() {
		for (int i = 0; i < namaList.size(); i++) {
			for (int j = 0; j < namaList.size()- 1; j++) {
				if (namaList.get(i).compareToIgnoreCase(namaList.get(j)) < 0) {
					String nama = namaList.get(i);
					namaList.set(i, namaList.get(j));
					namaList.set(j, nama);
					
					String jenis = jenisList.get(i);
					jenisList.set(i, jenisList.get(j));
					jenisList.set(j, jenis);
					
					String jabatan = jabatanList.get(i);
					jabatanList.set(i, jabatanList.get(j));
					jabatanList.set(j, jabatan);
					
					String kode = kodeList.get(i);
					kodeList.set(i, kodeList.get(j));
					kodeList.set(j, kode);
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
