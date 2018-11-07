package pkg.json.json_only;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pkg.json.json_only.R;

//.gitignore
public class MainActivity extends AppCompatActivity {
    TextView textView;
    String json;
    String display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = "";
        json = "[ { \"name\":\"wada\", \"age\":22 }, { \"name\":\"yokoya\", \"age\":22 } ]";

        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                display += jsonObject.getString("name");
                display += ":"+jsonObject.getString("age");
            }

            textView = (TextView) findViewById(R.id.display);
            textView.setText(display);

        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
