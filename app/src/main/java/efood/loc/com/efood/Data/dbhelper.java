package efood.loc.com.efood.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by loc on 26/02/2016.
 */
public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(Context context) {
        super(context, "data.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
