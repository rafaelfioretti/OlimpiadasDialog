package br.com.fiap.olimpiadasdialog;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView nome;
    private TextView idade;
    private RadioGroup periodo;
    private Spinner modalidade;
    RadioButton rbselecionado;
    private  TextView txtnome, txtidad, txtperiodo, txtmodalidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (TextView) findViewById(R.id.edtNome);
        idade = (TextView) findViewById(R.id.edtIdade);
        periodo = (RadioGroup) findViewById(R.id.rgModalidade);
        modalidade = (Spinner) findViewById(R.id.spnModalidade);
        nome.setCursorVisible(true);
    }

    public void reservar (View v){

        Ingresso ing = new Ingresso();
        int per;

        ing.setNome(nome.getText().toString());
        ing.setIdade(Integer.parseInt(idade.getText().toString()));
        ing.setModalidade(modalidade.getSelectedItem().toString());
        per = periodo.getCheckedRadioButtonId();
        rbselecionado = (RadioButton) findViewById(per);
        ing.setPeriodo((String)rbselecionado.getText());

        confirmar(ing, v);
    }

    public void confirmar (Ingresso ing, View v){
        //Toast.makeText(MainActivity.this, ing.toString(), Toast.LENGTH_SHORT).show();

        final Dialog confDialog = new Dialog(this);
        //confDialog.setTitle(getString(R.string.confirmar));
        confDialog.setContentView(R.layout.confirma_layout);
        txtnome = (TextView) confDialog.findViewById(R.id.txtNome);
        txtidad = (TextView) confDialog.findViewById(R.id.txtIdades);
        txtperiodo = (TextView) confDialog.findViewById(R.id.txtPeriodo);
        txtmodalidade = (TextView) confDialog.findViewById(R.id.txtModalidade);

        txtnome.setText(ing.getNome());
        txtidad.setText(Integer.toString(ing.getIdade()));
        txtperiodo.setText(ing.getPeriodo());
        txtmodalidade.setText(ing.getModalidade());

        Button confirmar = (Button) confDialog.findViewById(R.id.btnConfirmar);
        confirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                AlertDialog.Builder builder = new AlertDialog.Builder(confDialog.getContext());
                builder.setTitle(getString(R.string.confirmação));
                builder.setNeutralButton("OK", null);
                builder.show();
                confDialog.dismiss();
                limpar(v);



            }

        });


        confDialog.show();





    }

    public void limpar (View v){

        nome.setText("");
        idade.setText("");
        modalidade.setSelection(0);
        nome.setCursorVisible(true);
        periodo.clearCheck();
        RadioButton rbnovo = (RadioButton) findViewById(R.id.rbManha);
        rbnovo.setChecked(true);
    }
}
