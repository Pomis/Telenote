package pomis.app.telenote.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import io.realm.Realm;
import pomis.app.telenote.networking.Endpoints;

import static pomis.app.telenote.App.getRealmInstance;
import static pomis.app.telenote.App.getTelegraphService;

/**
 * Created by romanismagilov on 06.06.17.
 */

public class BaseFragment extends Fragment {

    protected Realm realm;
    protected Endpoints api;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = getRealmInstance(getContext());
        api = getTelegraphService(getContext());
    }
}
