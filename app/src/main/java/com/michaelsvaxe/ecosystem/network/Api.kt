import com.michaelsvaxe.ecosystem.model.CardInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    fun getData(@Url url: String): Call<CardInfo>
}