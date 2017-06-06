package pomis.app.telenote.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by romanismagilov on 06.06.17.
 */

public class Node extends RealmObject {

    public String tag;

    public String attrs;

    public RealmList<Node> children;

}
