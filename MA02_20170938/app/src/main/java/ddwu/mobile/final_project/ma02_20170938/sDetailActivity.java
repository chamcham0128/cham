package ddwu.mobile.final_project.ma02_20170938;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class sDetailActivity extends Activity {

    TextView etName;
    TextView etPhone;
    TextView etAddress;
    NaverStoreDto storeDetail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdetail);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

        storeDetail = (NaverStoreDto) getIntent().getSerializableExtra("name");

        etName.setText(storeDetail.getTitle());
        etAddress.setText(storeDetail.getAddress());
        etPhone.setText(storeDetail.getTelephone());


    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowReview:

                Intent intent = new Intent(sDetailActivity.this, BlogActivity.class);
                String name = storeDetail.getTitle();
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.btnWriteReview:

                Intent intent1 = new Intent(sDetailActivity.this, wReviewActivity.class);
                String title = storeDetail.getTitle();
                intent1.putExtra("title", title);
                startActivity(intent1);

                break;

            case R.id.btnClose:
                Intent intent2 = new Intent(sDetailActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}


