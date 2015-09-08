package umkc.student.tuhvu.umpirebuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {


    private View mStrikeButton;
    private Button mBallButton;
    private int mStrikeCount;
    private int mBallCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStrikeButton = findViewById(R.id.Strike_button);
        mBallButton = (Button)findViewById(R.id.Ball_button);

        mStrikeButton.setOnClickListener(this);
        mBallButton.setOnClickListener(this);
    }

    private void updateCount(int id) {

        TextView mStrikeCount_tv = (TextView)findViewById(R.id.Strike_count);
        TextView mBallCount_tv = (TextView)findViewById(R.id.Ball_count);

        switch (id) {
            case R.id.Strike_count:
                mStrikeCount_tv.setText(Integer.toString(mStrikeCount));
                if (mStrikeCount == 0) {
                    mBallCount_tv.setText(Integer.toString(0));
                }
                break;
            case R.id.Ball_count:
                mBallCount_tv.setText(Integer.toString(mBallCount));
                if (mBallCount == 0) {
                    mStrikeCount_tv.setText(Integer.toString(0));
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Strike_button:
                mStrikeCount++;
                if (mStrikeCount == 3) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Out!");
                    dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mStrikeCount = 0;
                        }
                    });
                    dlgAlert.show();
                }
                updateCount(R.id.Strike_count);
                break;
            case R.id.Ball_button:
                mBallCount++;
                if (mBallCount == 4)
                {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Walk!");
                    dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            mBallCount = 0;
                        }
                    });
                    dlgAlert.show();
                }
                updateCount(R.id.Ball_count);
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
