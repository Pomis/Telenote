package pomis.app.telenote.models


import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Note : RealmObject(){

    open var path: String? = null

    open var url: String? = null

    open var title: String? = null

    open var description: String? = null

    open var author_name: String? = null

//    open var content: Content? = null
//
//    @RealmClass
//    open class Content : RealmObject(){
//
//        open var children: ArrayList<String>? = null
//
//    }
}