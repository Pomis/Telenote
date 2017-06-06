package pomis.app.telenote.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmList;
import io.realm.RealmResults;
import pomis.app.telenote.R;
import pomis.app.telenote.base.BaseFragment;
import pomis.app.telenote.models.Page;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageListFragment extends BaseFragment {

    String DEFAULT_TOKEN = "b968da509bb76866c35425099bc0989a5ec3b32997d55286c657e6994bbb";
    int DEFAULT_OFFSET = 10;
    List<Page> pages;

    @BindView(R.id.lv_pages)
    ListView lvPages;

    public PageListFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_list, container, false);
        ButterKnife.bind(this, v);
        return v;
    }


    private void loadPages() {
        api.getPageList(DEFAULT_TOKEN, DEFAULT_OFFSET)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe(json -> {
                    realm.createOrUpdateAllFromJson(Page.class, json.getJSONArray("pages"));
                    pages = realm.where(Page.class).findAll();
                });
    }

}
