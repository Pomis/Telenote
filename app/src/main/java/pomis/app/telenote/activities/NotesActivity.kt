package pomis.app.telenote.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pomis.app.telenote.R
import pomis.app.telenote.base.BaseActivity

class NotesActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
    }
}
