package pomis.app.telenote.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;
import pomis.app.telenote.networking.Endpoints;

import static pomis.app.telenote.App.getRealmInstance;
import static pomis.app.telenote.App.getTelegraphService;

/**
 * Created by romanismagilov on 06.06.17.
 */

public class BaseActivity extends AppCompatActivity {

    protected Realm realm;
    protected Endpoints api;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        realm = getRealmInstance(this);
        api = getTelegraphService(this);
    }
}
