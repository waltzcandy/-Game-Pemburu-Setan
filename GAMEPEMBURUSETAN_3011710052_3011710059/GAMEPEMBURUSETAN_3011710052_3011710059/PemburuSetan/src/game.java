import java.util.Random;
import java.util.Scanner;

public class game {

	/**
	 * untuk membuat min dan max menyerang 30 sampai 50 musuh maupun player
	 * 
	 * @return
	 */
	public static int menyerang() {
		Random random = new Random();
		int hasil = random.nextInt(20) + 30;
		return hasil;
	}// menyerang()

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random random = new Random();

		// variabel musuh

		String[] musuh = { "Zombie", "Pocong", "Kunti", "Tuyul", "Genderuwo", "Buto Ijo", "KING JIN" };
		int nyawaMusuh = 100;
		String musuh1 = musuh[0];

		// variabel pemain
		int nyawaPlayer = 100;

		int obat = 0;
		int obatPenyembuh = 10;

		// variabel banyaknya musuh terbunuh
		int musuhTerbunuh = 0;

		// variabel menyerang
		int damagePlayer;
		int damageMusuh;

		// variabel soal
		String[] soal = { "Apa ibukota negara indonesia?", "Apa singkatan presiden ke-7?",
				"Apa nama gempa yang disebabkan oleh gunung api?",
				"Siapakah nama panggilan Presiden Republik Indonesia yang memiliki masa jabatan tersingkat?",
				"Binatang yang bisa hidup di air dan darat disebut?", "Pusat peredaran Tata Surya adalah...",
				"Danau terbesar di indonesia adalah...", "Penemu gunting adalah...",
				"Patung Liberty terletak dinegara...", "Burung tercepat di dunia adalah...",
				"Negara terkaya di dunia adalah....", "Besaran dari bunyi adalah...",
				"Primata yang paling cerdas ialah...", "Jumlah warna pelangi ada berapa?",
				"Ledakan bintang di galaksi disebut..", "jenis batuan terkeras adalah..", "Benua beku adalah benua...",
				"Seni menulis huruf arab disebut...", "Mamalia tertinggi adalah...", "Hewan terkecil adalah..",
				"Ibukota negara Rusia yaitu.." };
		String[] jawaban = { "jakarta", "jokowi", "vulkanik", "habibie", "amfibi", "matahari", "toba", "DaVinci",
				"prancis", "falcon", "qatar", "desibel", "simpanse", "tujuh", "supernova", "berlian", "antartika",
				"kaligrafi", "jerapah", "amoba", "moscow" };

		// intro game
		System.out.println("Selamat datang di game Pemburu Setan\n");
		System.out.println("Masukkan nama anda terlebih dahulu");
		System.out.print("Nama: ");
		String nama = in.next();

		System.out.println("------------------------------------\n");
		System.out.println("Baik " + nama + ", Apakah kamu siap memulai" + "\npetualangan yang menegangkan ini?");

		System.out.println(
				"\nPerkenalkan, saya Jacob. Orang yang mengarahkan anda\n" + "untuk bisa menyelesaikan game ini");
		in.nextLine();
		System.out.println("------------------------------------\n");

		System.out.println(
				"Jacob: kamu adalah seorang pahlawan,\n" + "\tkamu harus membunuh KING JIN yang mengganggu desamu\n"
						+ "\tkamu bisa membunuh KING JIN apabila kamu bisa membunuh anak buah\n"
						+ "\tKING JIN disetiap jalan yang kamu lewati");
		System.out.println("\n\t\t\tketik enter untuk melanjutkan");
		in.nextLine();

		System.out.println("Jacob: kamu mempunyai nyawa sebanyak " + nyawaPlayer
				+ "\n\tapabila kamu tidak dapat menjawab, maka nyawa kamu akan berkurang"
				+ "\n\tapabila kamu dapat menjawab, maka nyawa musuh berkurang");
		System.out.println("\n\t\t\tketik enter untuk melanjutkan");
		in.nextLine();
		System.out.println("------------------------------------\n");
		System.out.println("Okay, mari mulai!");
		System.out.println("-------------------------------------------");

		boolean running = true;
		/**
		 * while(running) - apabila running maka game akan dimulai nyawaPlayer > 0 -
		 * pemain memilih keluar atau lanjut nyawaPlayer < 1 - pemain akan keluar
		 * karenya nyawa pemain lemah
		 */

		GAME: while (running) {
			if (musuhTerbunuh > 6) {
				System.out.println("SELAMAT KAMU TELAH MEMBUNUH KING JIN");
				System.out.println("KAMU TELAH MENYELESAIKAN GAME INI");
				System.out.println("NYAWA KAMU SAAT INI " + nyawaPlayer);
				System.out.println("DESA KAMU SEKARANG SUDAH AMAN");
				break GAME;
			} // menang melawan king jin
			if (nyawaPlayer > 0) {
				System.out.println("\nApa yang ingin kamu lakukan sekarang?");
				System.out.println("1. Lanjutkan Perjalanan");
				System.out.println("2. Keluar permainan");
				String pilih = in.next();

				if (pilih.equals("1")) {
					System.out.println("\nKamu melanjutkan perjalanan!");

					while (nyawaMusuh > 0) {
						System.out.println("\tNyawamu Tinggal " + nyawaPlayer);
						System.out.println("\tNyawa " + musuh1 + " : " + nyawaMusuh);
						System.out.println("\n\tApa yang akan kamu lakukan, " + nama + "? ");
						System.out.println("\t1. Menyerang");
						System.out.println("\t2. Menambah nyawa");
						System.out.println("\t3. Lari!");
						int menyerang = in.nextInt();

						/**
						 * 1 - pemain akan menjawab. jika benar nyawa musuh berkurang. dan sebaliknya 2
						 * - pemain mendapat obat. obat akan berkurang 3 - pemain akan lari dan bertemu
						 * musuh lainnya
						 */
						if (menyerang == 1) {
							String jawab = null;
							int n = random.nextInt(soal.length);
							System.out.println("jawab soal dibawah ini: ");
							System.out.println(soal[n]);
							jawab = in.next();
							if (jawab.equalsIgnoreCase(jawaban[n])) {
								damageMusuh = menyerang();
								nyawaMusuh = nyawaMusuh - damageMusuh;

								System.out.println("kamu benar");
								System.out.println("\t> Kamu memukul " + musuh1 + " dan " + musuh1
										+ " telah kekurangan " + damageMusuh + " HP.");
								if (nyawaMusuh > 0) {
									continue;
								} else {
									musuhTerbunuh++;
									System.out.println("---------------------------------------------------");
									System.out.println(" # " + musuh1 + " Telah mati!");
									System.out.println(" # Kamu memiliki " + nyawaPlayer + " HP tersisa.");
									System.out.println(" # Kamu telah membunuh " + musuhTerbunuh + " musuh");
									System.out.println("--------------------------------------------------");

									if (musuhTerbunuh == 1) {
										nyawaMusuh = 100;
										musuh1 = musuh[1];
										nyawaMusuh = nyawaMusuh + 10;
										continue GAME;
									} else if (musuhTerbunuh == 2) {
										nyawaMusuh = 100;
										musuh1 = musuh[2];
										nyawaMusuh = nyawaMusuh + 20;
										continue GAME;
									} else if (musuhTerbunuh == 3) {
										nyawaMusuh = 100;
										musuh1 = musuh[3];
										nyawaMusuh = nyawaMusuh + 30;
										continue GAME;
									} else if (musuhTerbunuh == 4) {
										nyawaMusuh = 100;
										musuh1 = musuh[4];
										nyawaMusuh = nyawaMusuh + 50;
										continue GAME;
									} else if (musuhTerbunuh == 5) {
										nyawaMusuh = 100;
										musuh1 = musuh[5];
										nyawaMusuh = nyawaMusuh + 70;
										continue GAME;
									} else if (musuhTerbunuh == 6) {
										nyawaMusuh = 100;
										musuh1 = musuh[6];
										nyawaMusuh = nyawaMusuh + 100;
										continue GAME;
									}
								} // tambah level

							} else {
								damagePlayer = menyerang();
								nyawaPlayer = nyawaPlayer - damagePlayer;

								System.out.println("kamu salah");
								System.out.println("\t> Kamu terkena pukulan " + musuh1 + " dan kamu telah kekurangan "
										+ damagePlayer + " HP.");
								continue;
							} // musuh menyerang

						} // memilih minum obat
						else if (menyerang == 2) {
							System.out.println("obat kamu saat ini " + obat);
							System.out.println("jika kamu ingin mendapatkan obat kamu harus menjawab pertanyaan");
							System.out.println("\n\tApa yang akan kamu lakukan, " + nama + "? ");
							System.out.println("\t1. menjawab pertanyaan");
							System.out.println("\t2. meminum obat");
							System.out.println("\t3. lanjutkan perjalanan");
							int jawabx = in.nextInt();
							if (jawabx == 1) {
								if (obat > 2) {
									System.out.println("kamu memiliki obat yang cukup untuk melanjutkan perjalanan"
											+ "\n obat kamu saat ini " + obat);
									continue;
								} // maksimal obat
								String jawab = null;
								int n = random.nextInt(soal.length);
								System.out.println("jawab soal dibawah ini: ");
								System.out.println(soal[n]);
								jawab = in.next();
								if (jawab.equalsIgnoreCase(jawaban[n])) {
									System.out.println("kamu mendapatkan satu obat yang berisi 10 HP");
									obat++;
									continue;
								} else {
									System.out.println("kamu salah, kamu tidak mendapatkan apa-apa");
									continue;
								} // jawaban
							} // memilih menjawab
							else if (jawabx == 2) {
								if (obat > 0) {
									nyawaPlayer = nyawaPlayer + obatPenyembuh;
									obat--;
									System.out.println(
											"\t> Kamu meminum obat Penambah Nyawa. Nyawa kamu bertambah sebanyak "
													+ obatPenyembuh + "." + "\n\t>  Nyawa kamu saat ini " + nyawaPlayer
													+ "\n\t> kamu memiliki " + obat + " Penambah nyawa.\n");
									continue GAME;
								} else {
									System.out.println("\t> Kamu tidak memiliki obat Penambah Nyawa lagi!"
											+ "\nsilahkan main dengan nyawa yang tersisa!\n" + "nyawa kamu "
											+ nyawaPlayer);
									continue GAME;
								} // meminum obat

							} // memilih minum obat
							else if (jawabx == 3) {
								continue GAME;
							} // memilih mealanjutkan permainan
							else {
								System.out.println("input tidak terdeteksi");
								continue;
							}

						} else if (menyerang == 3) {
							System.out.println("\t Kamu lari dari " + musuh1 + "!");
							System.out.println("kamu keluar permainan karena terlalu penakut");
							break GAME;

						} // memilih lari
						else {
							System.out.println("input tidak terdeteksi");
							continue;
						}
					}

				} else if (pilih.equals("2")) {
					System.out.println("Kamu keluar dari game");
					System.out.println("##################");
					System.out.println("##Terima Kasih####");
					System.out.println("##Telah Bermain##");
					System.out.println("##################");
					break GAME;

				} else {
					System.out.println("input tidak terdeteksi");
					continue;
				} // nyawa musuh > 0

			} // nyawa player > 0

			else {
				System.out.println("nyawa anda lemah\n" + "anda tidak dapat melanjutkan game ini");
				System.out.println("\n##################");
				System.out.println("##Terima Kasih####");
				System.out.println("##Telah Bermain##");
				System.out.println("##################");
				System.out.println("#kamu telah membunuh musuh sebanyak(" + musuhTerbunuh + ")#");
				break GAME;
			} // nyawa player < 1
		} // running

	}// main
}// class