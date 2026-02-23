import org.jsoup.Jsoup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AkwamScanner {
    private val baseUrl = "https://ak.sv"

    suspend fun searchAkwam(query: String): List<MovieResult> = withContext(Dispatchers.IO) {
        val results = mutableListOf<MovieResult>()
        try {
            val url = "$baseUrl/search?q=${query.replace(" ", "+")}"
            val doc = Jsoup.connect(url).get()
            
            // استخراج العناصر (تعديل الـ Selector بناءً على تصميم الموقع)
            val elements = doc.select(".widget-v2-container .entry-box")
            for (el in elements) {
                val title = el.select(".entry-title").text()
                val link = el.select("a").attr("href")
                val poster = el.select("img").attr("src")
                results.add(MovieResult(title, link, poster))
            }
        } catch (e: Exception) { e.printStackTrace() }
        return@withContext results
    }
}

data class MovieResult(val title: String, val link: String, val poster: String)
