package pomis.app.telenote.networking;

import org.json.JSONObject;

import io.reactivex.Observable;
import pomis.app.telenote.models.Page;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by romanismagilov on 06.06.17.
 */

public interface Endpoints {

    @GET("/getPageList")
    Observable<JSONObject> getPageList(
            @Query("access_token") String accessToken,
            @Query("limit") int limit
    );
}