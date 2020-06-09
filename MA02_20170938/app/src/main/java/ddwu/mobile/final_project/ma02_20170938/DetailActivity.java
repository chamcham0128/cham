package ddwu.mobile.final_project.ma02_20170938;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvPhone;
    TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvAddress = findViewById(R.id.tvAddress);

        String name = getIntent().getStringExtra("name");
        String tel = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");

        tvName.setText(name);
        tvPhone.setText(tel);
        tvAddress.setText(address);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClose:
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
