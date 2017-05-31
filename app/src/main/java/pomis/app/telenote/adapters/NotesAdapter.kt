package pomis.app.telenote.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.jetbrains.anko.find
import pomis.app.telenote.R
import pomis.app.telenote.models.Page


class PagesAdapter(context: Context?, resource: Int, textViewResourceId: Int, var list: MutableList<Page>?)
    : ArrayAdapter<Page>(context, resource, textViewResourceId, list) {

    private var mInflator: LayoutInflater? = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ViewHolder
        if (convertView == null) {
            view = mInflator!!.inflate(R.layout.item_note, parent, false)
            vh = ViewHolder(
                    view.find(R.id.tv_row_title),
                    view.find(R.id.tv_row_description)
            )
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }


        vh.tvRowTitle.text = list!![position].title
        vh.tvRowDescription.text = list!![position].description
        return view
    }

    class ViewHolder(var tvRowTitle: TextView, var tvRowDescription: TextView)
}