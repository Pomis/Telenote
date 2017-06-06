package pomis.app.telenote.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by romanismagilov on 06.06.17.
 */

public class Page extends RealmObject {

    @PrimaryKey
    public String name;

    public String url;

    public String title;

    public String description;

    public String author_name;

    public RealmList<Node> content;

}
