package mason.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView displayTurn;

    private String currentSymbol = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Game board buttons
        Button topLeft = findViewById(R.id.topLeft);
        Button topMiddle = findViewById(R.id.topMiddle);
        Button topRight = findViewById(R.id.topRight);
        Button middleLeft = findViewById(R.id.middleLeft);
        Button middleMiddle = findViewById(R.id.middleMiddle);
        Button middleRight = findViewById(R.id.middleRight);
        Button bottomLeft = findViewById(R.id.bottomLeft);
        Button bottomMiddle = findViewById(R.id.bottomMiddle);
        Button bottomRight = findViewById(R.id.bottomRight);

        //Reset button
        Button reset = findViewById(R.id.reset);

        //The turn indicator
        displayTurn = findViewById(R.id.displayTurn);
        displayTurn.setText("Turn: " + currentSymbol);

        View.OnClickListener playListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Button b = (Button) view;
                //Perform the play
                currentSymbol = setSymbol(currentSymbol, b);
                //Update the displayTurn
                displayTurn.setText("Turn: " + currentSymbol);
            }
        };

        View.OnClickListener resetListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                recreate();
            }
        };

        //Attach the click listeners to the buttons
        topLeft.setOnClickListener(playListener);
        topMiddle.setOnClickListener(playListener);
        topRight.setOnClickListener(playListener);
        middleLeft.setOnClickListener(playListener);
        middleMiddle.setOnClickListener(playListener);
        middleRight.setOnClickListener(playListener);
        bottomLeft.setOnClickListener(playListener);
        bottomMiddle.setOnClickListener(playListener);
        bottomRight.setOnClickListener(playListener);

        //Attach reset button
        reset.setOnClickListener(resetListener);
    }

    //Set the symbol for the play
    private String setSymbol(String symbol, Button button) {
        //If and only if the button text hasn't already been set
        if(button.getText().toString().equals("")) {
            //Set the text in the
            button.setText(symbol);
            if(symbol.equals("X")){
                return "O";
            }else{
                return "X";
            }
        }else{
            return symbol;
        }
    }
}