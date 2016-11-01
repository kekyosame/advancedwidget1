package id.sch.smktelkom_mlg.learn.advancedwidget1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout llmain = (LinearLayout) findViewById(R.id.linearLayoutMain);
        addEditText(llmain);
        Button bProses = new Button(this);



        bProses.setText("Proses");
        llmain.addView(bProses);
        final TextView tvHasil = new TextView(this);
        llmain.addView(tvHasil);


        bProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProses(llmain);
            }


        });
    }

    private void doProses(LinearLayout llmain) {
        String hasil = "";
        for (int i = 0; i < 5; i++) {
            EditText etNama = (EditText) llmain.getChildAt(i * 2);
            EditText etUmur = (EditText) llmain.getChildAt((i * 2) + 1);

            String nama = etNama.getText().toString().trim();
            String umur = etUmur.getText().toString();

            if (umur.isEmpty())
                umur = "0";
            if (!nama.isEmpty())
                hasil += "Anak ke-" + (i + 1) + ": " + nama + " umur" + umur + " tahun\n";
        }
        TextView tvHasil = (TextView) llmain.getChildAt(11);
        tvHasil.setText(hasil);

}


    private void addEditText(LinearLayout llmain) {
        for (int i = 1; i <= 5; i++) {
            final EditText etNama = new EditText(this);
            llmain.addView(etNama);
            etNama.setHint("isikan nama anak");

            final EditText etUmur = new EditText(this);
            llmain.addView(etUmur);
            etUmur.setHint("isikan umur anak");
            etUmur.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }
}
