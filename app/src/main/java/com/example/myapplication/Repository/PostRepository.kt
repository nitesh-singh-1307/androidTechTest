
import com.example.myapplication.apiService.ApiService
import com.example.myapplication.domain.RemoteDataSource
import com.example.myapplication.models.Post




class PostRepository(private val apiService: ApiService)  {
    suspend fun getPosts(endPoint:String): Post {
        return apiService.getPosts(endPoint)
    }
}