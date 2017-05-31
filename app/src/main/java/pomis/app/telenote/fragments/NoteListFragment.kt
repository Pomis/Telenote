package pomis.app.telenote.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import io.reactivex.Observable

import pomis.app.telenote.R
import pomis.app.telenote.adapters.PagesAdapter
import pomis.app.telenote.api.Endpoints
import pomis.app.telenote.api.parse
import pomis.app.telenote.functions.doAsync
import pomis.app.telenote.models.Page
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class NoteListFragment : Fragment() {

    var notes: ListView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        initNotesList()
    }

    internal fun initNotesList() {
        notes = activity.findViewById(R.id.ll_notes) as ListView?

        refreshAdapter()
    }

    internal fun refreshAdapter() {
        val note1 = Page()
        note1.title = "kek123"
        note1.description = "dfsfsdfsd"

        val list = mutableListOf(note1, note1, note1, note1, note1, note1, note1, note1, note1)
        notes!!.adapter = PagesAdapter(context, 0, 0, list)

        loadNotes()
    }

    internal fun loadNotes() {
        val retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://telegra.ph/api")
                .build()

        val telegraphService: Endpoints = retrofit.create(Endpoints::class.java)

        telegraphService.getPageList(
                accessToken = "b968da509bb76866c35425099bc0989a5ec3b32997d55286c657e6994bbb",
                limit = 200
        )       .doAsync()
                .parse<Page>()
                ?.subscribe({ d("kek", it.title) })

    }

}


