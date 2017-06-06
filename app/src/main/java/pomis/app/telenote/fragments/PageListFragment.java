package pomis.app.telenote.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pomis.app.telenote.R;
import pomis.app.telenote.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageListFragment extends BaseFragment {

    String DEFAULT_TOKEN = "b968da509bb76866c35425099bc0989a5ec3b32997d55286c657e6994bbb";

    public PageListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_list, container, false);
    }


    private void loadPages() {
        api.getPageList(DEFAULT_TOKEN, 10)
                .subscribeOn(Schedulers.newThread())
                .subscribe(s -> System.out.println(s.toString()));
    }

}
