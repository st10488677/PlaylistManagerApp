package vcmsa.ci.playlistmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import org.w3c.dom.Text

class PlaylistActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here

        val tvSongList = findViewById<TextView>(R.id.tvSongList)
        val tvAverage = findViewById<TextView>(R.id.tvAverage)
        val btnShowAll = findViewById<Button>(R.id.btnShowAll)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnBack)


        btnShowAll.setOnClickListener {
            val builder = StringBuilder()
            for (i in MainActivity.tvSongTitles.indices) {
                builder.append("Title: ${MainActivity.tvSongTitles[i]}\n")
                builder.append("Artist: ${MainActivity.tvArtistNames[i]}\n")
                builder.append("Rating: ${MainActivity.tvRatings[i]}\n")
                builder.append("Comment: ${MainActivity.tvComment[i]}\n\n")
            }
            tvSongList.text = builder.toString()
        }

        btnAverage.setOnClickListener {
            if (MainActivity.tvRatings.isEmpty()) {
                tvAverage.text = "No ratings available."
                return@setOnClickListener
            }
            val average = MainActivity.tvRatings.sum().toDouble() / MainActivity.tvRatings.size
            tvAverage.text = "Average Rating: %.2f".format(average)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}







