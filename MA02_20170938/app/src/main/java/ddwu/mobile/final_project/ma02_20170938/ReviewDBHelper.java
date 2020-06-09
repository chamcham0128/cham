package ddwu.mobile.final_project.ma02_20170938;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ReviewDBHelper extends SQLiteOpenHelper {

	private final static String DB_NAME = "review_db";
	public final static String TABLE_NAME = "review_table";
	public final static String COL_ID = "_id";
    public final static String COL_NAME = "name";
    public final static String COL_REVIEW = "review";
    public final static String COL_IMAGE = "image";


	public ReviewDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_NAME + " ( " + COL_ID + " integer primary key autoincrement,"
				+ COL_NAME + " TEXT, "+COL_IMAGE+" TEXT, " + COL_REVIEW + " TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + TABLE_NAME);
        onCreate(db);
	}

}
