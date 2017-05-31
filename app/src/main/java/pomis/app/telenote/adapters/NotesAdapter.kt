package pomis.app.telenote.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import pomis.app.telenote.models.Note

/**
 * Created by romanismagilov on 31.05.17.
 */
class NotesAdapter(context: Context?, resource: Int, textViewResourceId: Int, objects: MutableList<Note>?) : ArrayAdapter<Note>(context, resource, textViewResourceId, objects) {
    

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getView(position, convertView, parent)
    }
}