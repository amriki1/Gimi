import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class PlayerActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer

    fun startVideo(videoUrl: String) {
        player = ExoPlayer.Builder(this).build()
        val playerView = findViewById<com.google.android.exoplayer2.ui.StyledPlayerView>(R.id.player_view)
        playerView.player = player

        val mediaItem = MediaItem.fromUri(videoUrl)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }
}
