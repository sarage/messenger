package com.example.aizhan.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] oper1 = {"Мээрим Бектурова"};
    String[] oper2 = {"Нурайым Жанузакова"};
    String[] oper3 = {"Айгерим Конушбаева"};
    String[] oper4 = {"Адил Эрмеков"};
    String[] oper5 = {"Арген Эдилбеков"};
    String[] oper6 = {"Айзирек Жолдошбекова"};
    String[] oper7 = {"Улан Базаркулов"};
    String[] oper8 = {"Памирбек Каразаков"};

    ArrayList<Oper> operators = new ArrayList<>();
    OperAdap operatorAdapter;

    GridView grvOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Сообщения");

        grvOperator = (GridView) findViewById(R.id.gvOperator);
        grvOperator.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), EnterActivity.class);
                startActivity(intent);
            }
        });
        operatorAdapter = new OperAdap(this, operators);

        show();
    }
    private void show() {
        fillData(oper1[0]);
        fillData(oper2[0]);
        fillData(oper3[0]);
        fillData(oper4[0]);
        fillData(oper5[0]);
        fillData(oper6[0]);
        fillData(oper7[0]);
        fillData(oper8[0]);
        select();
    }
    private void select() {
        grvOperator.setAdapter(operatorAdapter);
        adjustGridView();
    }
    private void adjustGridView() {
        grvOperator.setVerticalSpacing(15);
    }
    void fillData(String operName) {
        operators.add(new Oper(R.drawable.cwac_cam2_ic_action_settings,operName));
    }
}
