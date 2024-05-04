package ui


import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode

import java.io.IOException
import java.net.HttpURLConnection
import java.net.InetSocketAddress
import java.net.Socket
import java.net.URL

class EntryScreenViewModel : ViewModel() {

    private val client = HttpClient()

    private val apiKey = "sk-proj-7uRYYbBekvLy9fKn8Dq3T3BlbkFJlSkzPVgrIXf6zOh529KL"

    val _uiState : MutableLiveData<Boolean> = MutableLiveData(false)

    suspend fun isInternetAvailable(apiKey: String): Boolean {
        return try {
            val response: HttpResponse = client.get("https://api.openai.com/v1/engines") {
                headers {
                    append(HttpHeaders.Authorization, "Bearer $apiKey")
                }
            }
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            false
        }
    }

    suspend fun getUiState():Boolean{
        if(isInternetAvailable(apiKey)){
            return true
        }else{
            return false
        }
    }


}