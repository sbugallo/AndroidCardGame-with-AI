package es.uvigo.teleco.prohis;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends AppCompatActivity {

    /* Turn values:
     * 1 = Player
     * 2 = IA1
     * 3 = IA2
     * 4 = IA3*/
    private int turn,initialTurn;

    // Players cards
    private String[] ia1Hand={"empty","empty","empty","empty","empty","empty","empty","empty"};
    private String[] ia2Hand={"empty","empty","empty","empty","empty","empty","empty","empty"};
    private String[] ia3Hand={"empty","empty","empty","empty","empty","empty","empty","empty"};
    private String[] playerHand={"empty","empty","empty","empty","empty","empty","empty","empty"};

    // Table cards
    private String[] tableCards={"empty","empty","empty","empty"};

    // Players money
    private int ia1Money,ia2Money,ia3Money,playerMoney;



    /* Cards in the deck:
     * 40 Legal Goods cards
     * 20 Illegal Goods cards
     * 4 Inspector cards
     * 4 Captain cards
     * 6 Lieutenant cards
     */
    private Deck deck = new Deck();

    // Activity Elements
    private ImageButton nextButton;
    private TextView ia1MoneyText,ia2MoneyText,ia3MoneyText,playerMoneyText;
    private EditText turnText;
    private ImageView ia1HandImage,ia1InspectorImage,ia1CaptainImage;
    private ImageView ia2HandImage,ia2InspectorImage,ia2CaptainImage;
    private ImageView ia3HandImage,ia3InspectorImage,ia3CaptainImage;
    private ImageView playerInspectorImage,playerCaptainImage,playerCard1,playerCard2,playerCard3,playerCard4,playerCard5,playerCard6;
    private ImageView tableCard1,tableCard2,tableCard3,tableCard4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         *  WE HIDE THE STATUS BAR
         */

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }

        /*
         * WE DEFINE THE BUTTONS
         */

        nextButton = (ImageButton) findViewById(R.id.BtnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(turn!=1) {
                    //We create the Intent
                    Intent intent =
                            new Intent(GameActivity.this, UserInspectionActivity.class);

                    Bundle b = new Bundle();
                    b.putStringArray("PlayerHand", playerHand);
                    b.putInt("PlayerMoney", playerMoney);
                    b.putStringArray("IA1Hand", ia1Hand);
                    b.putInt("IA1Money", ia1Money);
                    b.putStringArray("IA2Hand", ia2Hand);
                    b.putInt("IA2Money", ia2Money);
                    b.putStringArray("IA3Hand", ia3Hand);
                    b.putInt("IA3Money", ia3Money);
                    b.putStringArray("TableCards", tableCards);
                    b.putSerializable("Deck", deck);


                    //We add the bundle to the intent
                    intent.putExtra("Bundle",b);

                    //We start the activity
                    startActivity(intent);
                }else{
                    //We create the Intent
                    Intent intent =
                            new Intent(GameActivity.this, DrawActivity.class);

                    Bundle b = new Bundle();
                    b.putStringArray("PlayerHand", playerHand);
                    b.putInt("PlayerMoney", playerMoney);
                    b.putStringArray("IA1Hand", ia1Hand);
                    b.putInt("IA1Money", ia1Money);
                    b.putStringArray("IA2Hand", ia2Hand);
                    b.putInt("IA2Money", ia2Money);
                    b.putStringArray("IA3Hand", ia3Hand);
                    b.putInt("IA3Money", ia3Money);
                    b.putStringArray("TableCards", tableCards);
                    b.putSerializable("Deck", deck);


                    //We add the bundle to the intent
                    intent.putExtra("Bundle", b);

                    //We start the activity
                    startActivity(intent);
                }
            }

        });

        /*
         * WE DEFINE THE ELEMENTS
         */

        ia1MoneyText = (TextView) findViewById(R.id.IA1MoneyTxt);
        ia2MoneyText = (TextView) findViewById(R.id.IA2MoneyTxt);
        ia3MoneyText = (TextView) findViewById(R.id.IA3MoneyTxt);
        playerMoneyText = (TextView) findViewById(R.id.PlayerMoneyTxt);

        ia1HandImage = (ImageView) findViewById(R.id.IA1Hand);
        ia1InspectorImage = (ImageView) findViewById(R.id.IA1Inspector);
        ia1CaptainImage = (ImageView) findViewById(R.id.IA1Captain);

        ia2HandImage = (ImageView) findViewById(R.id.IA2Hand);
        ia2InspectorImage = (ImageView) findViewById(R.id.IA2Inspector);
        ia2CaptainImage = (ImageView) findViewById(R.id.IA2Captain);

        ia3HandImage = (ImageView) findViewById(R.id.IA3Hand);
        ia3InspectorImage = (ImageView) findViewById(R.id.IA3Inspector);
        ia3CaptainImage = (ImageView) findViewById(R.id.IA3Captain);

        playerCard1 = (ImageView) findViewById(R.id.PlayerCard1);
        playerCard2 = (ImageView) findViewById(R.id.PlayerCard2);
        playerCard3 = (ImageView) findViewById(R.id.PlayerCard3);
        playerCard4 = (ImageView) findViewById(R.id.PlayerCard4);
        playerCard5 = (ImageView) findViewById(R.id.PlayerCard5);
        playerCard6 = (ImageView) findViewById(R.id.PlayerCard6);;
        playerInspectorImage = (ImageView) findViewById(R.id.PlayerInspectorCard);
        playerCaptainImage = (ImageView) findViewById(R.id.PlayerCaptainCard);

        tableCard1 = (ImageView) findViewById(R.id.TableCard1);
        tableCard2 = (ImageView) findViewById(R.id.TableCard2);
        tableCard3 = (ImageView) findViewById(R.id.TableCard3);
        tableCard4 = (ImageView) findViewById(R.id.TableCard4);

        turnText = (EditText) findViewById(R.id.TurnText);
        turnText.setEnabled(false);

        /*
         * WE DEFINE THE FUNCTIONALITY
         */

        initializeGame();
        updateWindow();

    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        updateGame(intent.getBundleExtra("Bundle"));
        updateWindow();
    }

    //############## AUXILIARY FUNCTIONS ##############

    private void initializeGame(){

        generateTable();
        generateTurn();
        ia1Money=0;
        ia2Money=0;
        ia3Money=0;
        playerMoney=0;
        generatePlayerHand();
        generateIA1Hand();
        generateIA2Hand();
        generateIA3Hand();
    }

    private void generatePlayerHand(){
        playerHand[0]="inspector_card";
        playerHand[1]="captain_card";

        for(int i=2;i<6;i++) {
            playerHand[i]=deck.getNextCard();
        }
    }

    private void generateIA1Hand(){
        ia1Hand[0]="inspector_card";
        ia1Hand[1]="captain_card";

        for(int i=2;i<6;i++) {
            ia1Hand[i]=deck.getNextCard();
        }
    }

    private void generateIA2Hand(){
        ia2Hand[0]="inspector_card";
        ia2Hand[1]="captain_card";

        for(int i=2;i<6;i++) {
            ia2Hand[i]=deck.getNextCard();
        }
    }

    private void generateIA3Hand(){
        ia3Hand[0]="inspector_card";
        ia3Hand[1]="captain_card";

        for(int i=2 ; i<6 ; i++){
            ia3Hand[i]=deck.getNextCard();
            System.out.println(ia3Hand[i]);
        }
    }

    private void generateTurn(){
        Random random = new Random();
        initialTurn = random.nextInt(4)+1;
        turn = initialTurn;

        switch (turn){
            case 1: turnText.setText("It's your turn");
                    break;
            case 2: turnText.setText("It's IA1's turn");
                break;
            case 3: turnText.setText("It's IA2's turn");
                break;
            case 4: turnText.setText("It's IA3's turn");
                break;
            default: turnText.setText("An error occurred");
                break;
        }
    }

    private void generateTable() {
        for (int i=0 ; i<4; i++) {
            tableCards[i] = deck.getNextCard();
        }
    }

    private void updateWindow(){

        // We update the money of the players
        ia1MoneyText.setText(String.valueOf(ia1Money));
        ia2MoneyText.setText(String.valueOf(ia2Money));
        ia3MoneyText.setText(String.valueOf(ia3Money));
        playerMoneyText.setText(String.valueOf(playerMoney));

        //We update the IA1 cards

        int ia1Count=0;

        if(ia1Hand[0].equals("empty")) ia1InspectorImage.setImageResource(R.drawable.empty_card);
        else ia1InspectorImage.setImageResource(R.drawable.inspector_card);

        if(ia1Hand[1].equals("empty")) ia1CaptainImage.setImageResource(R.drawable.empty_card);
        else ia1CaptainImage.setImageResource(R.drawable.captain_card);

        if(!(ia1Hand[2].equals("empty"))) ia1Count++;
        if(!(ia1Hand[3].equals("empty"))) ia1Count++;
        if(!(ia1Hand[4].equals("empty"))) ia1Count++;
        if(!(ia1Hand[5].equals("empty"))) ia1Count++;
        if(!(ia1Hand[6].equals("empty"))) ia1Count++;
        if(!(ia1Hand[7].equals("empty"))) ia1Count++;

        switch (ia1Count){

            case 0: ia1HandImage.setImageResource(R.drawable.cards_hand_0);
                break;

            case 1: ia1HandImage.setImageResource(R.drawable.cards_hand_1);
                break;

            case 2: ia1HandImage.setImageResource(R.drawable.cards_hand_2);
                break;

            case 3: ia1HandImage.setImageResource(R.drawable.cards_hand_3);
                break;

            case 4: ia1HandImage.setImageResource(R.drawable.cards_hand_4);
                break;

            case 5: ia1HandImage.setImageResource(R.drawable.cards_hand_5);
                break;

            case 6: ia1HandImage.setImageResource(R.drawable.cards_hand_6);
                break;
        }

        //We update the IA2 cards

        int ia2Count=0;

        if(ia2Hand[0].equals("empty")) ia2InspectorImage.setImageResource(R.drawable.empty_card);
        else ia2InspectorImage.setImageResource(R.drawable.inspector_card);

        if(ia2Hand[1].equals("empty")) ia2CaptainImage.setImageResource(R.drawable.empty_card);
        else ia2CaptainImage.setImageResource(R.drawable.captain_card);

        if(!(ia2Hand[2].equals("empty"))) ia2Count++;
        if(!(ia2Hand[3].equals("empty"))) ia2Count++;
        if(!(ia2Hand[4].equals("empty"))) ia2Count++;
        if(!(ia2Hand[5].equals("empty"))) ia2Count++;
        if(!(ia2Hand[6].equals("empty"))) ia2Count++;
        if(!(ia2Hand[7].equals("empty"))) ia2Count++;

        switch (ia2Count){

            case 0: ia2HandImage.setImageResource(R.drawable.cards_hand_0);
                break;

            case 1: ia2HandImage.setImageResource(R.drawable.cards_hand_1);
                break;

            case 2: ia2HandImage.setImageResource(R.drawable.cards_hand_2);
                break;

            case 3: ia2HandImage.setImageResource(R.drawable.cards_hand_3);
                break;

            case 4: ia2HandImage.setImageResource(R.drawable.cards_hand_4);
                break;

            case 5: ia2HandImage.setImageResource(R.drawable.cards_hand_5);
                break;

            case 6: ia2HandImage.setImageResource(R.drawable.cards_hand_6);
                break;
        }

        //We update the IA 3 cards

        int ia3Count=0;

        if(ia3Hand[0].equals("empty")) ia3InspectorImage.setImageResource(R.drawable.empty_card);
        else ia3InspectorImage.setImageResource(R.drawable.inspector_card);

        if(ia3Hand[1].equals("empty")) ia3CaptainImage.setImageResource(R.drawable.empty_card);
        else ia3CaptainImage.setImageResource(R.drawable.captain_card);

        if(!(ia3Hand[2].equals("empty"))) ia3Count++;
        if(!(ia3Hand[3].equals("empty"))) ia3Count++;
        if(!(ia3Hand[4].equals("empty"))) ia3Count++;
        if(!(ia3Hand[5].equals("empty"))) ia3Count++;
        if(!(ia3Hand[6].equals("empty"))) ia3Count++;
        if(!(ia3Hand[7].equals("empty"))) ia3Count++;

        switch (ia3Count){

            case 0: ia3HandImage.setImageResource(R.drawable.cards_hand_0);
                break;

            case 1: ia3HandImage.setImageResource(R.drawable.cards_hand_1);
                break;

            case 2: ia3HandImage.setImageResource(R.drawable.cards_hand_2);
                break;

            case 3: ia3HandImage.setImageResource(R.drawable.cards_hand_3);
                break;

            case 4: ia3HandImage.setImageResource(R.drawable.cards_hand_4);
                break;

            case 5: ia3HandImage.setImageResource(R.drawable.cards_hand_5);
                break;

            case 6: ia3HandImage.setImageResource(R.drawable.cards_hand_6);
                break;
        }

        //We update the Player cards

        if(playerHand[0].equals("empty")) playerInspectorImage.setImageResource(R.drawable.empty_card);
        else playerInspectorImage.setImageResource(R.drawable.inspector_card);

        if(playerHand[1].equals("empty")) playerCaptainImage.setImageResource(R.drawable.empty_card);
        else playerCaptainImage.setImageResource(R.drawable.captain_card);

        if(playerHand[2].equals("empty")) playerCard1.setImageResource(R.drawable.empty_card);
        else if(playerHand[2].equals("legal_goods_card")) playerCard1.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[2].equals("illegal_goods_card")) playerCard1.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[2].equals("lieutenant_card")) playerCard1.setImageResource(R.drawable.lieutenant_card);

        if(playerHand[3].equals("empty")) playerCard2.setImageResource(R.drawable.empty_card);
        else if(playerHand[3].equals("legal_goods_card")) playerCard2.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[3].equals("illegal_goods_card")) playerCard2.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[3].equals("lieutenant_card")) playerCard2.setImageResource(R.drawable.lieutenant_card);

        if(playerHand[4].equals("empty")) playerCard3.setImageResource(R.drawable.empty_card);
        else if(playerHand[4].equals("legal_goods_card")) playerCard3.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[4].equals("illegal_goods_card")) playerCard3.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[4].equals("lieutenant_card")) playerCard3.setImageResource(R.drawable.lieutenant_card);

        if(playerHand[5].equals("empty")) playerCard4.setImageResource(R.drawable.empty_card);
        else if(playerHand[5].equals("legal_goods_card")) playerCard4.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[5].equals("illegal_goods_card")) playerCard4.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[5].equals("lieutenant_card")) playerCard4.setImageResource(R.drawable.lieutenant_card);

        if(playerHand[6].equals("empty")) playerCard5.setImageResource(R.drawable.empty_card);
        else if(playerHand[6].equals("legal_goods_card")) playerCard5.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[6].equals("illegal_goods_card")) playerCard5.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[6].equals("lieutenant_card")) playerCard5.setImageResource(R.drawable.lieutenant_card);

        if(playerHand[7].equals("empty")) playerCard6.setImageResource(R.drawable.empty_card);
        else if(playerHand[7].equals("legal_goods_card")) playerCard6.setImageResource(R.drawable.legal_goods_card);
        else if(playerHand[7].equals("illegal_goods_card")) playerCard6.setImageResource(R.drawable.illegal_goods_card);
        else if(playerHand[7].equals("lieutenant_card")) playerCard6.setImageResource(R.drawable.lieutenant_card);

        // We update the table cards

        if(tableCards[0].equals("legal_goods_card")) tableCard1.setImageResource(R.drawable.legal_goods_card);
        else if(tableCards[0].equals("illegal_goods_card")) tableCard1.setImageResource(R.drawable.illegal_goods_card);
        else if(tableCards[0].equals("lieutenant_card")) tableCard1.setImageResource(R.drawable.lieutenant_card);

        if(tableCards[1].equals("legal_goods_card")) tableCard2.setImageResource(R.drawable.legal_goods_card);
        else if(tableCards[1].equals("illegal_goods_card")) tableCard2.setImageResource(R.drawable.illegal_goods_card);
        else if(tableCards[1].equals("lieutenant_card")) tableCard2.setImageResource(R.drawable.lieutenant_card);

        if(tableCards[2].equals("legal_goods_card")) tableCard3.setImageResource(R.drawable.legal_goods_card);
        else if(tableCards[2].equals("illegal_goods_card")) tableCard3.setImageResource(R.drawable.illegal_goods_card);
        else if(tableCards[2].equals("lieutenant_card")) tableCard3.setImageResource(R.drawable.lieutenant_card);

        if(tableCards[3].equals("legal_goods_card")) tableCard4.setImageResource(R.drawable.legal_goods_card);
        else if(tableCards[3].equals("illegal_goods_card")) tableCard4.setImageResource(R.drawable.illegal_goods_card);
        else if(tableCards[3].equals("lieutenant_card")) tableCard4.setImageResource(R.drawable.lieutenant_card);

        // We Update the turn label

        switch (turn){
            case 1: turnText.setText("It's your turn");
                break;
            case 2: turnText.setText("It's IA1's turn");
                break;
            case 3: turnText.setText("It's IA2's turn");
                break;
            case 4: turnText.setText("It's IA3's turn");
                break;
            default: turnText.setText("An error occurred");
                break;
        }

    }

    private void updateGame(Bundle bundle){

        playerHand = bundle.getStringArray("PlayerHand");
        ia1Hand =  bundle.getStringArray("IA1Hand");
        ia2Hand = bundle.getStringArray("IA2Hand");
        ia3Hand =  bundle.getStringArray("IA3Hand");

        playerMoney = bundle.getInt("PlayerMoney");
        ia1Money = bundle.getInt("IA1Money");
        ia2Money = bundle.getInt("IA2Money");
        ia3Money = bundle.getInt("IA3Money");

        tableCards = bundle.getStringArray("TableCards");
        deck = (Deck) bundle.getSerializable("Deck");

        updateWindow();

        if(turn==4) turn=1;
        else turn++;

    }

}
