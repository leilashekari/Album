package com.example.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.login.GalleryAdapter
import com.example.login.PictureUiModel
import com.example.login.R
import com.example.login.network.ImageListEndpoint
import com.example.login.network.NetworkClient.retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GalleryActivity : AppCompatActivity() {

    lateinit var galleryRecyclerView: RecyclerView
/*    val pictures = listOf(
        Picture(url = "https://picsum.photos/id/237/200/300", title = "Title 1"),
        Picture(url = "https://picsum.photos/id/238/200/300", title = "Title 2"),
        Picture(url = "https://picsum.photos/id/239/200/300", title = "Title 3"),
        Picture(url = "https://picsum.photos/id/240/200/300", title = "Title 4")
    )*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        galleryRecyclerView = findViewById(R.id.galleryRv)

        CoroutineScope(Dispatchers.Main).launch {
            // fetch data from internet
            val pictureDtoList = withContext(Dispatchers.IO) {
                retrofit.create(ImageListEndpoint::class.java).getImageList()
            }
            // map (convert) DTO to UI model
            val pictureUiModels = pictureDtoList.map { dto -> PictureUiModel(url = dto.url, author =dto.author) }

            // create adapter
            val galleryAdapter = GalleryAdapter(pictureUiModels)
            // set adapter to RV
            galleryRecyclerView.adapter = galleryAdapter
        }

    }
}