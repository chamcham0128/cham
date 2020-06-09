package ddwu.mobile.final_project.ma02_20170938;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    EditText etStore;
    String query;
    MyReviewAdapter adapter3;
    MyBlogAdapter adapter2;
    MyStoreAdapter adapter;
    ArrayList<NaverBlogDto> resultList2;
    ArrayList<NaverStoreDto> resultList;
    ArrayList<MyReviewDto> resultList3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etStore = findViewById(R.id.etStore);
        resultList = new ArrayList();

        adapter3 = new MyReviewAdapter(this, R.layout.listview_myreview, resultList3);
        adapter2 = new MyBlogAdapter(this, R.layout.listview_blog, resultList2);
        adapter = new MyStoreAdapter(this, R.layout.listview_store, resultList);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_storeslist:
                query = etStore.getText().toString();
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                intent.putExtra("query", query);
                startActivity(intent);
                break;

            case R.id.btn_mymap:
                query = etStore.getText().toString();
                Intent intent1 = new Intent(MainActivity.this, PlaceActivity.class);
                intent1.putExtra("query", query);
                startActivity(intent1);
                break;
            case R.id.btnMyReview:
                Intent intent2 = new Intent(MainActivity.this, ShowMyReviewActivity.class);
                startActivity(intent2);
                break;
        }
    }

}
