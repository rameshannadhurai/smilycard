package smaily.seeni.dev;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cooltechworks.creditcarddesign.CardEditActivity;
import com.cooltechworks.creditcarddesign.CreditCardUtils;

public class MainActivity extends AppCompatActivity {
    final int GET_NEW_CARD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAddCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardEditActivity.class);
                startActivityForResult(intent, GET_NEW_CARD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {


            String cardHolderName = data.getStringExtra(CreditCardUtils.EXTRA_CARD_HOLDER_NAME);
            String expiry = data.getStringExtra(CreditCardUtils.EXTRA_CARD_EXPIRY);
            String cvv = data.getStringExtra(CreditCardUtils.EXTRA_CARD_CVV);

            Log.e("cardHolderName==>", "" + cardHolderName);
            Log.e("expiry==>", "" + expiry);
            Log.e("cvv==>", "" + cvv);


            // Your processing goes here.
            String temp[] = expiry.split("/");

            int month = Integer.parseInt(temp[0]);
            int year = Integer.parseInt(temp[1]);
            Log.e("month / year", "" + month + " / " + year);
        } else {

        }

    }

}
