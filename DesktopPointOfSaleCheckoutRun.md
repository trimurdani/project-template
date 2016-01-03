# Introduction #
Halaman ini berisi bagaimana caranya mendapatkan source code desktop-point-of-sale kemudian membukanya di netbeans, menyiapkan databasenya dan menjalankan aplikasi dari netbeans.


# Details #

Langkah-langkah yang harus dalakukan :
  * Menginstall subversion
> > Netbeans sudah dilengkapi dengan tools untuk bekerja dengan repository. Ada modul mercury, Subversion dan CVS. Google code menggunakan subversion sebagai source repository server, sehingga kita perlu mensetting environtment agar subversion berjalan normal. Ketika pertama kali menginstall NetBeans biasanya tidak ada subversion yang terinstall. Ada 2 cara menggunakan subversion cleint : dengan tools yang ada di netbeans atau dengan external tools. Mau pilih yang mana saja tidak masalah. Di lingkungan windows ada subversion client yang sangat terkenal, namanya tortoiseSVN, sangat bagus dan powerfull.
> > Saya menulis tutorial panjang lebar tentang tortoise svn, bisa didownload di sini : http://ifnubima.googlepages.com/subversion.pdf
> > atau kalau ingin lebih lengkap penjelasan tentang Subversion bisa pesan buku subversion dari artivisi.com

Kalau ingin menggunakan NetBeans langsung sebagai Subversion client, maka kita harus menginstall subversion client. Ada 2 cara :
  * Download subversion client dan menginstall secara terpisah.
    * Download subversion client dari http://www.collab.net/downloads/subversion/ untuk windows
    * Ubuntu : sudo apt-get install subversion
  * Install subversion client sebagai NetBeans plugin
    * Akses menu Team > Subversion > Checkout
> > Jika ada dialog untuk menginstall subversion client, pilih radio button untuk menginstall, kemudian tinggal ikuti wizardnya, gampang!.

  * Mengambil source code dari repository
Setelah berhasil menginstall Subversion client kita bisa menggunakanya untuk men-checkout repository dari googlecode.
Jika instalasinya berasal dari download (windows) atau apt-get (ubuntu), maka kita bisa menggunakan command line untuk men-checkout repository, caranya ketikkan perintah di bawah ini dari command line :

```
svn checkout http://project-template.googlecode.com/svn/trunk/desktop-point-of-sale desktop-point-of-sale
```

Jika instalasi subversion client dengan menggunakan netbeans plugin, maka proses checkout tidak bisa dari command line.
  * Pilih menu : Team > Subversion > Checkout
  * kemudian isikan url : http://project-template.googlecode.com/svn/trunk/desktop-point-of-sale
  * tekan tombol Next
  * Isi local folder dimana hasil checkout akan diletakkan
  * Centang pilihan : Scan NetBeans project after checkout

Setelah selesai proses checkout, di dalam folder desktop-point-of-sale ada 3 project : POS, POS-config dan POS-tools. Project POS berisi semua source code yang diperlukan untuk menjalankan POS. Di dalam project POS-config berisi hanya satu file yaitu database.properties yang berisi semua konfigurasi yang diperlukan untuk melakukan koneksi ke dalam database. POS-Config ini akan menghasilkan satu buah file jar terpisah dari project POS, kenapa dipisahkan? agar nanti secara runtime kita bisa mengubah konfigurasi database-nya, semisal url atau user dan passwordnya. POS-tools berisi beberapa tools kecil yang digunakan untuk mengedit isi dari konfigurasi yang ada dalam POS-config.

Setelah ketiga project diatas berhasil dibuka, sekarang siapkan database konfigurasi agar aplikasi POS ini bisa berjalan dengan baik.

  * Install Mysql 5.1, bisa didownload dari mysql.com atau : sudo apt-get install mysql-server untuk ubuntu.
  * Buat database baru dengan nama posdb
    * bisa dilakukan dengan mysql GUI tools
    * Atau dari NetBeans dengan mebuka tab Service, kemudian pilih node Mysql, klik kanan dan pilih menu Create Database
    * atau dari mysql console client :
      * Login dengan mengetik perintah
> > > > `$ mysql -u root -p `
      * Membuat database baru :
> > > > `mysql > create database posdb;`
    * Membuat user baru dengan grant database posdb

> > > ketikkan perintah ini dari console setalah login ke mysql


> `mysql > grant all on posdb.* to pos@localhost identified by 'pos';`

  * Memasukkan data sample dan schema ke dalam database posdb.
> > Setelah selesai membuat database dan user baru, kita akan memasukkan schema dan sample data dari posdb. Ketikkan perintah berikut ini dari console :

```
$ cd /home/ifnu/NetBeansProject/desktop-point-of-sale
$ mysql -u root -p posdb < POS/sql/posdb-schema.sql 
$ mysql -u root -p posdb < POS/sql/posdb-data.sql
```
  * folder `/home/ifnu/NetBeansProject` adalah folder dimana hasil ckeckout repository diletakkan. kalau di windows misalnya `c:\Document and Settings\ifnu\My Documents\NetBeansProject\desktop-point-of-sale`
  * Setelah semua siap, sekarang tinggal menjalankan aplikasinya. Project ini sudah dilengkapi dengan mode three tier. Untuk menjalankanya anda harus menjalankan server terlebih dahulu kemudian baru clientnya. Cara menjalankan server: klik kanan class com.artivisi.pos.server.Server kemudian pilih run. Berikutnya jalankan client dengan memilih com.artivisi.pos.ui.frame.FrameUtama klik kanan kemudian pilih run. Mekanisme three tier banyak saya jelaskan di blog ifnu.artivisi.com, silahkan dibuka arsipnya
  * Login ke aplikasi dengan user ADMIN dan password adminadmin

Selamat mencoba