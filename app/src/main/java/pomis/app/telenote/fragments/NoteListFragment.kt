package pomis.app.telenote.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import org.jetbrains.anko.find

import pomis.app.telenote.R
import pomis.app.telenote.adapters.NotesAdapter
import pomis.app.telenote.models.Note


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
        val note1 = Note()
        note1.title = "kek123"
        note1.description = "dfsfsdfsd"

        val list = mutableListOf<Note>(note1, note1, note1, note1, note1, note1, note1, note1, note1)
        notes!!.adapter = NotesAdapter(context, 0, 0, list)
    }

}
