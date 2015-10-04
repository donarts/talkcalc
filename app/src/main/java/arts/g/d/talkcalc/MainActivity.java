package arts.g.d.talkcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity{
    ListView m_ListView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    CustomAdapter m_Adapter;
    Control control;
    Button buttonSend;
    EditText editTextInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new Control();
        // 커스텀 어댑터 생성
        m_Adapter = new CustomAdapter();

        m_ListView = (ListView) findViewById(R.id.listView1);
        buttonSend = (Button) findViewById(R.id.button1);
        editTextInput = (EditText) findViewById(R.id.editText1);
        editTextInput.setPrivateImeOptions("defaultInputmode=english;");

        buttonSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = editTextInput.getText().toString();
                if( input.length() > 0 ) {
                    control.calcAll(m_Adapter, input);
                    editTextInput.setText("");
                    m_Adapter.notifyDataSetChanged();
                }
            }
        });

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        control.init(m_Adapter);
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
