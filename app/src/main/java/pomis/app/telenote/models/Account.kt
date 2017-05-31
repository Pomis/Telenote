package pomis.app.telenote.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@RealmClass
open class Account() : RealmObject() {

    open var short_name: String? = null

    open var author_name: String? = null

    open var access_token: String? = null

    open var page_count: String? = null

}