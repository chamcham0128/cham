package ddwu.mobile.final_project.ma02_20170938;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bDetailActivity extends Activity {
    TextView tvBtitle;
    TextView tvBlogger;
    TextView tvBdescription;
    TextView tvBloglink;

    NaverBlogDto blogDetail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdetail);

        tvBtitle = findViewById(R.id.tvBtitle);
        tvBlogger = findViewById(R.id.tvBlogger);
        tvBdescription = findViewById(R.id.tvBdescription);
        tvBloglink = findViewById(R.id.tvBloglink);

        blogDetail = (NaverBlogDto) getIntent().getSerializableExtra("name");

        tvBtitle.setText(blogDetail.getTitle());
        tvBlogger.setText(blogDetail.getBloggername());
        tvBdescription.setText(blogDetail.getDescription());
        tvBloglink.setText(blogDetail.getLink());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
                Intent intent = new Intent(bDetailActivity.this, MainActivity.class);
                startActivity(intent);
        }

    }
}
