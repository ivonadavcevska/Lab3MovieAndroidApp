package mk.ukim.finki.lab3movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import mk.ukim.finki.lab3movieapp.ui.movies.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState==null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container_view_tag, FirstFragment())
                setReorderingAllowed(true)
            }
        }
    }
}