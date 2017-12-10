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

        //Array to hold filled squares
        final String board[] = new String[9];
        for(int i = 0; i < 9; ++i){
            board[i] = "";
        }

        View.OnClickListener playListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Button b = (Button) view;
                switch(view.getId()){
                    case R.id.topLeft:
                        board[0] = currentSymbol;
                        break;
                    case R.id.topMiddle:
                        board[1] = currentSymbol;
                        break;
                    case R.id.topRight:
                        board[2] = currentSymbol;
                        break;
                    case R.id.middleLeft:
                        board[3] = currentSymbol;
                        break;
                    case R.id.middleMiddle:
                        board[4] = currentSymbol;
                        break;
                    case R.id.middleRight:
                        board[5] = currentSymbol;
                        break;
                    case R.id.bottomLeft:
                        board[6] = currentSymbol;
                        break;
                    case R.id.bottomMiddle:
                        board[7] = currentSymbol;
                        break;
                    case R.id.bottomRight:
                        board[8] = currentSymbol;
                        break;
                    default:
                        break;
                }


                //Check if the game is won
                if(checkWin(board)){
                    displayTurn.setText("Player " + currentSymbol + " wins!\nClick reset to start over.");
                    //Perform the play
                    currentSymbol = setSymbol(currentSymbol, b);
                }else {
                    //Perform the play
                    currentSymbol = setSymbol(currentSymbol, b);
                    //Update the displayTurn
                    displayTurn.setText("Turn: " + currentSymbol);
                }
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

    //Check if the game is won
    private boolean checkWin(String [] board){
        //Top layer win state
        if(!board[0].equals("") && board[0].equals(board[1]) && board[1].equals(board[2])){
            return true;
        }

        //Middle layer win state
        if(!board[3].equals("") && board[3].equals(board[4]) && board[4].equals(board[5])){
            return true;
        }

        //Bottom layer win state
        if(!board[6].equals("") && board[6].equals(board[7]) && board[7].equals(board[8])){
            return true;
        }

        //Left vert layer win state
        if(!board[0].equals("") && board[0].equals(board[3]) && board[3].equals(board[6])){
            return true;
        }

        //Middle vert layer win state
        if(!board[1].equals("") && board[1].equals(board[4]) && board[4].equals(board[7])){
            return true;
        }

        //Right vert layer win state
        if(!board[2].equals("") && board[2].equals(board[5]) && board[5].equals(board[8])){
            return true;
        }

        //Bot to Top diag layer win state
        if(!board[2].equals("") && board[2].equals(board[4]) && board[4].equals(board[6])){
            return true;
        }

        //Top to Bot diag layer win state
        if(!board[0].equals("") && board[0].equals(board[4]) && board[4].equals(board[8])){
            return true;
        }

        return false;
    }
}