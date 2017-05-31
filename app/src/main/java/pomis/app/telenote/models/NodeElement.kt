package pomis.app.telenote.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class NodeElement : RealmObject(){

    open var tag: String? = null

    open var attrs: Map<String, String>? = null

    open var childen: RealmList<NodeElement>? = null

}