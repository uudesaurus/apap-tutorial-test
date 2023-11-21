# TUTORIAL 7 - WEB SERVICE
Mahmud Asrul - 2106655255 - APAP A

### Pertanyaan 1: Apa itu Dockerfile dan docker-compose.yaml? apa fungsinya?

Dockerfile itu mudahnya dibayangkan sebagai "to-do" untuk membangun sebuah Docker, bedanya dengan docker-compose-yaml itu sebagai konfigurasinya. Secara akar Dockerfile untuk bangun image sedangkan docker-compose.yaml untuk menjalankan apa bila terdapat 2 atau lebih container applications.

### Pertanyaan 2: Screenshot hasil perubahan anda. Setelah anda menyelesaikan tutorial ini, menurut anda, mengapa kita perlu mengganti port?

https://drive.google.com/file/d/1pqG3H9wJercmsQ6dhFyTeAnkIcnucY6v/view?usp=sharing

Tujuannya biar tidak terjadi konflik --> karena sebelumnya kita udah pernah buat service pada host. Port nya dipakai untuk proses mapping sehingga jika ada terjadi dua mapping kepada 1 port yang sama akan terjadi konflik, sehingga perlu untuk setiap mahasiswa mendapatkan urutannya sendiri, kebetulan saya sendiri dapat 75. Dengan mengubah memungkinkan aplikasi kita berjalan tanpa konflik.

### Pertanyaan 3: Apa yang terjadi pada langkah ini?

Saya mengganti port saya sesuai soal, 10075 dan 15075.

### Pertanyaan 4: Sertakan screenshot container yang sedang berjalan (versi gui atau cli, pilih salah satu). Apa itu docker images, docker container, dan docker volume?

Saya terdapat problem failed to build, permasalahan di env tapi saya coba sebisa saya. Docker Images adalah templlatenya untuk container (sistem file & konfigurasinya), Docker contianer adalah containernya itu sendiri sehingga dia punya environemtn yang berdiri secara independen (tidak terpengaruhi oleh luar) Sedangkan Docker Volume itu adalah prosedurnya untuk menyimpan data di dalam container.

### Pertanyaan 5: Apa perbedaan docker-compose down dan docker stop?

Bedanya dari fungsinya, kalau down untuk MENGHENTIKAN & MENGHAPUS, sedangkan stop untuk MENGHENTIKAN tanpa MENGHAPUS.


### Pertanyaan 6: Ceritakan pengalaman anda melakukan deployment ke Kirti. Kendala apa yang anda alami?


### Pertanyaan 7: Apa yang dimaksud load balancing?  Pada langkah keberapa kita mengatur konfigurasi untuk load balancing? Jelaskan blok baris yang mengatur hal tersebut.

Ini saya pernah bertanya kepada pak Denny, prosedur ini bisa kita refer ke sistem SIAK ketika misalnya terjadi SIAK WAR, istilahnya sempat ketika misalnya kita spamming terhadap server tersebut kita ga bisa masuk, tetapi teman kita yang hanya sekali pencet masuk kedalam website SIAK WAR, menurut ku ini salah satu contoh Load-balancing yang benar, intinya Load balancing adalah proses untuk melakukan distribusi ke server server yang ada. Sehingga tidak ada satu server yang bisa dibilang over-loaded. 


### Pertanyaan 8: Apa yang dimaksud reverse proxy?  Pada langkah keberapa kita mengatur konfigurasi untuk reverse proxy? Jelaskan baris yang mengatur hal tersebut dan jelaskan kegunaannya dalam pengerjaan tugas kelompok nanti.

Reverse proxy bisa dibilang sebagai bentuk tipe server yang melakukan proses funneling kepada klien kalau sesuai tutorial 7 ada di 9, ketika proses modifikasi file nginx.conf. Meskipun belum sampai situ tapi hal ini membantu ketika misal kita TK tidak ada microservices yang down karena over-loaded seperti pada pertanyaan 7.

### Pertanyaan 9: Apa fungsi dari SSH keys yang Anda buat dengan menggunakan ssh-keygen? Apa perbedaan antara file  ~/.ssh/deployer_apap.pub dan ~/.ssh/deployer_apap ?

### Pertanyaan 10: Apa perbedaan antara GitLab repository dan GitLab runner?

Gitlab Repository tujuannya untuk menyimpan proses dokumentasi sehingga semua bisa berbagi kode dan tersimpan dengan baik, berbeda dengan GitLab Runner yang tujuannya untuk menjalankan prosedur CI/CD.

### Pertanyaan 11: Apa perbedaan antara Continuous Integration, Continuous Delivery, dan Continuous Deployment?

Kita dapat bagi berdasarkan fungsinya, untuk Integration fokusnya adalah prosedur integrasi dari kumpulan developer kedalam 1 repositori yang berkelanjutan

Sedangkan Delivery berfokus kepada setiap PERUBAHAN yang terjadi dan lulus pada Integration akan di terapkan environment production.

Yang berakhir ke Deployment, artinya yang sudah lulus CI CD, lanjut ke Deploy sehingga secara otomatis tersimpan tanpa perlu ada prosedur verifikasi dari human decisions, hal ini memudahkan proses automasi.

### Pertanyaan 12: Apa yang dimaksud dengan "docker registry"? Apa fungsinya? 

Docker registery adalah penyimpanan dan distributor untuk IMAGE DOCKER yang bentukannya seperti template aplikasi & konfigurasi. sehingga bisa di lempar untuk pengguna docker lainnya.

### Pertanyaan 13: Dalam gitlab CI/CD, apa perbedaan antara: pipeline, stage, dan job?

Seperti pada pekerjaan Pipeline dapat dianggap sebagai kumpulan prosedur dari suatu eksekusi, sedangkan stage adalah TAHAP d pada pipleine yang mengelompokkan JOB, lalu JOB adalah subset dari STAGE. sehingga dapat dibayangkan sebagai Onion Cut, Job adalah subset dari Stage, Stage adalah Subset dari Pipeline

### Pertanyaan 14: Kapan proses CI/CD dijalankan di GitLab?

Proses CI/CD akan jalan secara otomatis ketika ada pemantik/event tertentu, misalnya ketika terjadi Push, Merge Request, Tagging, etc.

### Pertanyaan 15: Mengapa CI/CD ini penting? Apa manfaatnya?

Secara mudah CI/CD akan memudahkan para developer untuk tidak bergantung pada proses verifikasi manusia, dengan ada CI/CD akan memudahkan para developer untuk mengembangkan proses aplikasinya sehingga bisa rilis PROD.