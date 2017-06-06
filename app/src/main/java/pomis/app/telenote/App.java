package pomis.app.telenote;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pomis.app.telenote.networking.Endpoints;
import pomis.app.telenote.networking.JSONConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by romanismagilov on 06.06.17.
 */

public class App extends Application {

    static private Realm realm;
    static private Endpoints telegraphService;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm(this);
        initRetrofit(this);
    }

    private static void initRetrofit(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new JSONConverterFactory())
                .baseUrl("https://api.telegra.ph/")
                .client(httpClient.build())
                .build();

        telegraphService = retrofit.create(Endpoints.class);
    }

    private static void initRealm(Context context) {
        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("telenote.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
    }

    static public Realm getRealmInstance(Context context) {
        if (realm == null) initRealm(context);
        return realm;
    }

    static public Endpoints getTelegraphService(Context context) {
        if (telegraphService == null) initRetrofit(context);
        return telegraphService;
    }

}
