import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val tmdbKey = "604741659405a2182f8dbfad2aac1daf"
    private val scanner = AkwamScanner()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // مثال للبحث عند الضغط على زر
        GlobalScope.launch(Dispatchers.Main) {
            val searchResults = scanner.searchAkwam("Joker")
            // هنا تقوم بتحديث واجهة المستخدم (RecyclerView) بالنتائج
        }
    }
}
