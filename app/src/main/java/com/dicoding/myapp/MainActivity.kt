package com.dicoding.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    private val filmList = listOf(
        Film(
            "La La Land",
            "Berlatar di kota penuh kemegahan Los Angeles, film ini menceritakan kisah cinta antara seorang pianis jazz bernama Sebastian dan seorang aktris yang bercita-cita tinggi, Mia. Keduanya berjuang meraih mimpi mereka sambil berusaha mempertahankan hubungan mereka. Musik dan tarian indah menjadi bagian dari perjalanan emosional mereka, namun keduanya dihadapkan pada pilihan sulit: cinta atau karier?",
            R.drawable.poster_1
        ),
        Film(
            "Interstellar",
            "Film ini mengikuti perjalanan seorang tim penjelajah antariksa yang harus melewati lubang cacing untuk mencari planet layak huni demi menyelamatkan umat manusia. Dengan latar belakang kehancuran bumi akibat perubahan iklim, tokoh utama, Cooper, seorang mantan pilot NASA, memimpin ekspedisi penuh tantangan dan misteri. Kisah ini mengeksplorasi hubungan keluarga, waktu, dan cinta dalam konteks perjalanan luar angkasa yang epik.",
            R.drawable.poster_2
        ),
        Film(
            "Free Guy",
            "Free Guy bercerita tentang seorang pria biasa bernama Guy, yang sadar bahwa dirinya hanyalah NPC (Non-Player Character) dalam sebuah video game. Saat mulai memanipulasi peraturan permainan, Guy berusaha menyelamatkan dunia virtualnya dari kehancuran. Film ini penuh aksi, komedi, dan refleksi tentang kebebasan, identitas, dan kehidupan di dunia digital.",
            R.drawable.poster_3
        ),
        Film(
            "Dune",
            "Dune mengisahkan perjalanan Paul Atreides, seorang pemuda cerdas yang dipaksa memasuki intrik politik dan konflik kekuasaan di planet gurun Arrakis. Planet ini adalah sumber dari bahan paling berharga di alam semesta: Spice. Paul harus menghadapi musuh yang kuat dan takdirnya yang membawanya menjadi pemimpin besar. Film ini mengeksplorasi tema kepemimpinan, pengkhianatan, dan takdir dalam skala epik.",
            R.drawable.poster_4
        ),
        Film(
            "Cruella",
            "Berlatar di era 1970-an di London, film ini mengikuti kisah Estella, seorang perancang busana muda berbakat yang perlahan berubah menjadi penjahat terkenal, Cruella de Vil. Dengan suasana revolusi punk rock, film ini mengeksplorasi perjalanan Estella dari seorang gadis ambisius menjadi sosok yang kejam dan penuh manipulasi, sekaligus memberikan latar belakang mendalam pada karakter ikonik dari '101 Dalmatians'.",
            R.drawable.poster_5
        ),
        Film(
            "Fight Club",
            "Seorang pekerja kantoran yang merasa bosan dan terjebak dalam rutinitas hidupnya bertemu dengan seorang pria misterius bernama Tyler Durden. Bersama-sama, mereka mendirikan Fight Club, sebuah tempat rahasia di mana pria-pria bisa bertarung untuk melampiaskan frustrasi hidup. Film ini menyelami tema alienasi, kekerasan, dan kritik terhadap konsumerisme, dengan plot twist mengejutkan yang akan mengubah pandangan Anda terhadap karakter utamanya.",
            R.drawable.poster_6
        ),
        Film(
            "Longlegs",
            "Film ini menceritakan seorang pria misterius yang memiliki kemampuan unik dan digunakan oleh sebuah organisasi rahasia untuk melakukan tugas-tugas berbahaya. Namun, saat dia mulai mempertanyakan motif dan moralitas dari pekerjaannya, situasi berubah menjadi penuh konflik dan ketegangan. Film ini menyelami tema identitas dan kebebasan.",
            R.drawable.poster_7
        ),
        Film(
            "Warkop DKI Reborn",
            "Menghidupkan kembali komedi klasik Indonesia, 'Warkop DKI Reborn' menghadirkan trio legendaris Dono, Kasino, dan Indro dalam petualangan baru yang penuh tawa. Dengan humor khas Indonesia, film ini membawa nostalgia sekaligus memperkenalkan generasi baru pada salah satu waralaba komedi paling ikonik di Indonesia.",
            R.drawable.poster_8
        ),
        Film(
            "Deadpool & Wolverine",
            "Pertemuan dua karakter antihero Marvel yang sangat berbeda. Deadpool yang penuh lelucon dan Wolverine yang serius harus bekerjasama dalam menghadapi ancaman baru yang menargetkan keduanya. Film ini dipenuhi dengan aksi brutal, komedi gelap, dan chemistry unik antara dua karakter tersebut, membuatnya menjadi salah satu crossover Marvel yang ditunggu-tunggu.",
            R.drawable.poster_9
        ),
        Film(
            "Inside Out 2",
            "Lanjutan dari film animasi 'Inside Out', film ini kembali mengeksplorasi emosi dalam diri seorang anak bernama Riley yang kini telah remaja. Emosi lama seperti Joy, Sadness, Anger, dan Fear menghadapi tantangan baru ketika emosi remaja yang lebih kompleks mulai muncul. 'Inside Out 2' menghadirkan petualangan emosional yang mendalam dan mengharukan dengan visual yang memukau.",
            R.drawable.poster_10
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)

        val abtBtn: ImageButton = findViewById(R.id.abt_btn)

        abtBtn.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        movieAdapter = MovieAdapter(filmList) { film ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("title", film.title)
                putExtra("overview", film.overview)
                putExtra("image", film.imageResId)
            }
            startActivity(intent)
        }
        recyclerView.adapter = movieAdapter
    }
}
