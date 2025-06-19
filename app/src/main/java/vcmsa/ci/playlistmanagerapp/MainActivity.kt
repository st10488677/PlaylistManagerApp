package vcmsa.ci.playlistmanagerapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class MainActivity : AppCompatActivity() {
    

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val titleInput = findViewById<EditText>(R.id.edtSongTitle)
        val artistInput = findViewById<EditText>(R.id.edtArtistName)
        val ratingInput = findViewById<EditText>(R.id.edtRating)
        val commentInput = findViewById<EditText>(R.id.edtComments)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnViewDetails = findViewById<Button>(R.id.btnViewDetails)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnAdd.setOnClickListener {
            val title = titleInput.text.toString()
            val artist = artistInput.text.toString()
            val ratingText = ratingInput.text.toString()
            val comment = commentInput.text.toString()

            if (title.isBlank() || artist.isBlank() || ratingText.isBlank() || comment.isBlank()) {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating = ratingText.toIntOrNull()
            if (rating == null || rating !in 1..5) {
                Toast.makeText(this, "Rating must be a number between 1 and 5", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            Int.Companion; object {
            val tvSongTitles = ArrayList<String>()
            val tvArtistNames = ArrayList<String>()
            val tvRatings = ArrayList<Int>()
            val tvComments = ArrayList<String>()
        }
             val data = arrayOf(
            arrayOf("Let Down, Lovers Rock, Forget Her, Bad Habit"),
                    arrayOf("Radio head, TV girl, Jeff Buckley, Steve Lacy"),
            arrayOf("4, 1, 2, 3"),
            arrayOf("Great, Horrible, Bad, Average")
            )
            Toast.makeText(this, "Song added to playlist!", Toast.LENGTH_SHORT).show()

            titleInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentInput.text.clear()
        }

        btnViewDetails.setOnClickListener {
            startActivity(Intent(this, PlaylistActivity::class.java))
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    companion object {
        val tvComment: ArrayList<String> = TODO()
        val tvRatings: ArrayList<Int> = TODO()
        val tvArtistNames: ArrayList<String> = TODO()
        val tvSongTitles: ArrayList<String> = TODO()

    }


}