package pomis.app.telenote.api

import io.reactivex.Observable
import org.json.JSONArray
import org.json.JSONObject
import pomis.app.telenote.models.Page

inline fun <reified T> Observable<String>.parse(): Observable<Page>? {
    val json = JSONObject(this.blockingFirst()).getJSONObject("result")
    when (T::class.java) {
        is Page -> {
            val list = ArrayList<Page>()
            val arr = json.getJSONArray("pages")
            (0..arr.length()).mapTo(list) {
                val obj = arr.getJSONObject(it)
                Page()
            }

            return Observable.fromIterable(list)

        }

        else -> return null
    }
}