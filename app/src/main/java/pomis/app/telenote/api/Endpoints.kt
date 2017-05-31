package pomis.app.telenote.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("getPageList?access_token={accessToken}&limit={limit}")
    fun getPageList(
            @Path("accessToken") accessToken: String,
            @Path("limit") limit: Int
    ): Observable<String>
}