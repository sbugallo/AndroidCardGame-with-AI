package es.uvigo.teleco.prohis;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class CargoActivity extends AppCompatActivity {

    // Next Button
    private ImageButton nextButton, passButton;

    // Players cards
    private String[] ia1Hand;
    private String[] ia2Hand;
    private String[] ia3Hand;
    private String[] playerHand;

    // Table cards
    private String[] tableCards;

    // Players money
    private int ia1Money,ia2Money,ia3Money,playerMoney;

    // Deck
    private Deck deck;

    //Player cards
    private ImageButton playerCard1,playerCard2,playerCard3,playerCard4,playerCard5,playerCard6,playerCard7,playerCard8;
    private int card1,card2,card3,card4,card5,card6,card7,card8;
    private boolean card1Checked, card2Checked,card3Checked, card4Checked,card5Checked, card6Checked,card7Checked, card8Checked;
    private int selectedCard1=0,selectedCard2=0,selectedCard3=0,selectedCard4=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_cargo);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Make Your Cargo");
        }

        nextButton = (ImageButton) findViewById(R.id.BtnNext);
        passButton = (ImageButton) findViewById(R.id.BtnPass);
        playerCard1 = (ImageButton) findViewById(R.id.CargoCard1);
        playerCard2 = (ImageButton) findViewById(R.id.CargoCard2);
        playerCard3 = (ImageButton) findViewById(R.id.CargoCard3);
        playerCard4 = (ImageButton) findViewById(R.id.CargoCard4);
        playerCard5 = (ImageButton) findViewById(R.id.CargoCard5);
        playerCard6 = (ImageButton) findViewById(R.id.CargoCard6);
        playerCard7 = (ImageButton) findViewById(R.id.CargoCard7);
        playerCard8 = (ImageButton) findViewById(R.id.CargoCard8);

        Bundle extras= this.getIntent().getBundleExtra("Bundle");

        ia1Hand = extras.getStringArray("IA1Hand");
        ia2Hand = extras.getStringArray("IA2Hand");
        ia3Hand = extras.getStringArray("IA3Hand");
        playerHand = extras.getStringArray("PlayerHand");

        ia1Money = extras.getInt("IA1Money");
        ia2Money = extras.getInt("IA2Money");
        ia3Money = extras.getInt("IA3Money");
        playerMoney = extras.getInt("PlayerMoney");

        tableCards = extras.getStringArray("TableCards");
        deck = (Deck) extras.getSerializable("Deck");

        updateWindow();

        /*
         * WE DEFINE THE BUTTONS
         */

        playerCard1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(card1Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card1Checked == false){

                        if (card1 == 1)
                            playerCard1.setImageResource(R.drawable.selected_legal_goods);
                        else if (card1 == 2)
                            playerCard1.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card1 == 3)
                            playerCard1.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card1 == 4)
                            playerCard1.setImageResource(R.drawable.selected_captain_card);
                        else if (card1 == 5)
                            playerCard1.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=1;
                        else if(selectedCard2==0) selectedCard2=1;
                        else if(selectedCard3==0) selectedCard3=1;
                        else selectedCard4=1;

                        card1Checked=true;
                    }else{

                        if (card1 == 1)
                            playerCard1.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card1 == 2)
                            playerCard1.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card1 == 3)
                            playerCard1.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card1 == 4)
                            playerCard1.setImageResource(R.drawable.captain_card_reduced);
                        else if (card1 == 5)
                            playerCard1.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==1) selectedCard1=0;
                        else if(selectedCard2==1) selectedCard2=0;
                        else if(selectedCard3==1) selectedCard3=0;
                        else selectedCard4=0;

                        card1Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card2Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card2Checked == false){

                        if (card2 == 1)
                            playerCard2.setImageResource(R.drawable.selected_legal_goods);
                        else if (card2 == 2)
                            playerCard2.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card2 == 3)
                            playerCard2.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card2 == 4)
                            playerCard2.setImageResource(R.drawable.selected_captain_card);
                        else if (card2 == 5)
                            playerCard2.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=2;
                        else if(selectedCard2==0) selectedCard2=2;
                        else if(selectedCard3==0) selectedCard3=2;
                        else selectedCard4=2;

                        card1Checked=true;
                    }else{

                        if (card2 == 1)
                            playerCard2.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card2 == 2)
                            playerCard2.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card2 == 3)
                            playerCard2.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card2 == 4)
                            playerCard2.setImageResource(R.drawable.captain_card_reduced);
                        else if (card2 == 5)
                            playerCard2.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==2) selectedCard1=0;
                        else if(selectedCard2==2) selectedCard2=0;
                        else if(selectedCard3==2) selectedCard3=0;
                        else selectedCard4=0;

                        card2Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card3Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card3Checked == false){

                        if (card3 == 1)
                            playerCard3.setImageResource(R.drawable.selected_legal_goods);
                        else if (card3 == 2)
                            playerCard3.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card3 == 3)
                            playerCard3.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card3 == 4)
                            playerCard3.setImageResource(R.drawable.selected_captain_card);
                        else if (card3 == 5)
                            playerCard3.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=3;
                        else if(selectedCard2==0) selectedCard2=3;
                        else if(selectedCard3==0) selectedCard3=3;
                        else selectedCard4=3;

                        card3Checked=true;
                    }else{

                        if (card3 == 1)
                            playerCard3.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card3 == 2)
                            playerCard3.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card3 == 3)
                            playerCard3.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card3 == 4)
                            playerCard3.setImageResource(R.drawable.captain_card_reduced);
                        else if (card3 == 5)
                            playerCard3.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==3) selectedCard1=0;
                        else if(selectedCard2==3) selectedCard2=0;
                        else if(selectedCard3==3) selectedCard3=0;
                        else selectedCard4=0;

                        card3Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card4Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card4Checked == false){

                        if (card4 == 1)
                            playerCard4.setImageResource(R.drawable.selected_legal_goods);
                        else if (card4 == 2)
                            playerCard4.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card4 == 3)
                            playerCard4.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card4 == 4)
                            playerCard4.setImageResource(R.drawable.selected_captain_card);
                        else if (card4 == 5)
                            playerCard4.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=4;
                        else if(selectedCard2==0) selectedCard2=4;
                        else if(selectedCard3==0) selectedCard3=4;
                        else selectedCard4=4;

                        card4Checked=true;
                    }else{

                        if (card4 == 1)
                            playerCard4.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card4 == 2)
                            playerCard4.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card4 == 3)
                            playerCard4.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card4 == 4)
                            playerCard4.setImageResource(R.drawable.captain_card_reduced);
                        else if (card4 == 5)
                            playerCard4.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==4) selectedCard1=0;
                        else if(selectedCard2==4) selectedCard2=0;
                        else if(selectedCard3==4) selectedCard3=0;
                        else selectedCard4=0;

                        card4Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card5Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card5Checked == false){

                        if (card5 == 1)
                            playerCard5.setImageResource(R.drawable.selected_legal_goods);
                        else if (card5 == 2)
                            playerCard5.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card5 == 3)
                            playerCard5.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card5 == 4)
                            playerCard5.setImageResource(R.drawable.selected_captain_card);
                        else if (card5 == 5)
                            playerCard5.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=5;
                        else if(selectedCard2==0) selectedCard2=5;
                        else if(selectedCard3==0) selectedCard3=5;
                        else selectedCard4=5;

                        card5Checked=true;
                    }else{

                        if (card5 == 1)
                            playerCard5.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card5 == 2)
                            playerCard5.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card5 == 3)
                            playerCard5.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card5 == 4)
                            playerCard5.setImageResource(R.drawable.captain_card_reduced);
                        else if (card5 == 5)
                            playerCard5.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==5) selectedCard1=0;
                        else if(selectedCard2==5) selectedCard2=0;
                        else if(selectedCard3==5) selectedCard3=0;
                        else selectedCard4=0;

                        card5Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card6Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card6Checked == false){

                        if (card6 == 1)
                            playerCard6.setImageResource(R.drawable.selected_legal_goods);
                        else if (card6 == 2)
                            playerCard6.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card6 == 3)
                            playerCard6.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card6 == 4)
                            playerCard6.setImageResource(R.drawable.selected_captain_card);
                        else if (card6 == 5)
                            playerCard6.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=6;
                        else if(selectedCard2==0) selectedCard2=6;
                        else if(selectedCard3==0) selectedCard3=6;
                        else selectedCard4=6;

                        card6Checked=true;
                    }else{

                        if (card6 == 1)
                            playerCard6.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card6 == 2)
                            playerCard6.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card6 == 3)
                            playerCard6.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card6 == 4)
                            playerCard6.setImageResource(R.drawable.captain_card_reduced);
                        else if (card6 == 5)
                            playerCard6.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==6) selectedCard1=0;
                        else if(selectedCard2==6) selectedCard2=0;
                        else if(selectedCard3==6) selectedCard3=0;
                        else selectedCard4=0;

                        card6Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card7Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card7Checked == false){

                        if (card7 == 1)
                            playerCard7.setImageResource(R.drawable.selected_legal_goods);
                        else if (card7 == 2)
                            playerCard7.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card7 == 3)
                            playerCard7.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card7 == 4)
                            playerCard7.setImageResource(R.drawable.selected_captain_card);
                        else if (card7 == 5)
                            playerCard7.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=7;
                        else if(selectedCard2==0) selectedCard2=7;
                        else if(selectedCard3==0) selectedCard3=7;
                        else selectedCard4=7;

                        card7Checked=true;
                    }else{

                        if (card7 == 1)
                            playerCard7.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card7 == 2)
                            playerCard7.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card7 == 3)
                            playerCard7.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card7 == 4)
                            playerCard7.setImageResource(R.drawable.captain_card_reduced);
                        else if (card7 == 5)
                            playerCard7.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==7) selectedCard1=0;
                        else if(selectedCard2==7) selectedCard2=0;
                        else if(selectedCard3==7) selectedCard3=0;
                        else selectedCard4=0;

                        card7Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        playerCard8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(card8Checked || (selectedCard1==0 || selectedCard2==0 || selectedCard3==0 || selectedCard4==0)){

                    if(card8Checked == false){

                        if (card8 == 1)
                            playerCard8.setImageResource(R.drawable.selected_legal_goods);
                        else if (card8 == 2)
                            playerCard8.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card8 == 3)
                            playerCard8.setImageResource(R.drawable.selected_lieutenant_card);
                        else if (card8 == 4)
                            playerCard8.setImageResource(R.drawable.selected_captain_card);
                        else if (card8 == 5)
                            playerCard8.setImageResource(R.drawable.selected_inspector_card);

                        if(selectedCard1==0) selectedCard1=8;
                        else if(selectedCard2==0) selectedCard2=8;
                        else if(selectedCard3==0) selectedCard3=8;
                        else selectedCard4=8;

                        card8Checked=true;
                    }else{

                        if (card8 == 1)
                            playerCard8.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card8 == 2)
                            playerCard8.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card8 == 3)
                            playerCard8.setImageResource(R.drawable.lieutenant_card_reduced);
                        else if (card8 == 4)
                            playerCard8.setImageResource(R.drawable.captain_card_reduced);
                        else if (card8 == 5)
                            playerCard8.setImageResource(R.drawable.inspector_card_reduced);

                        if(selectedCard1==8) selectedCard1=0;
                        else if(selectedCard2==8) selectedCard2=0;
                        else if(selectedCard3==8) selectedCard3=0;
                        else selectedCard4=0;

                        card8Checked=false;
                    }
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int count = 0;
                if(selectedCard1!=0) count++;
                if(selectedCard2!=0) count++;
                if(selectedCard3!=0) count++;
                if(selectedCard4!=0) count++;

                if(count>1) {

                    String[] cargo = new String[4];
                    int nextPosition = 0;

                    if (card1Checked) {
                        cargo[nextPosition] = playerHand[0];
                        playerHand[0] = "empty";
                        nextPosition++;
                    }

                    if (card2Checked) {
                        cargo[nextPosition] = playerHand[1];
                        playerHand[1] = "empty";
                        nextPosition++;
                    }

                    if (card3Checked) {
                        cargo[nextPosition] = playerHand[2];
                        playerHand[2] = "empty";
                        nextPosition++;
                    }

                    if (card4Checked) {
                        cargo[nextPosition] = playerHand[3];
                        playerHand[3] = "empty";
                        nextPosition++;
                    }

                    if (card5Checked) {
                        cargo[nextPosition] = playerHand[4];
                        playerHand[4] = "empty";
                        nextPosition++;
                    }

                    if (card6Checked) {
                        cargo[nextPosition] = playerHand[5];
                        playerHand[6] = "empty";
                        nextPosition++;
                    }

                    if (card7Checked) {
                        cargo[nextPosition] = playerHand[6];
                        playerHand[6] = "empty";
                        nextPosition++;
                    }

                    if (card8Checked) {
                        cargo[nextPosition] = playerHand[7];
                        playerHand[7] = "empty";
                        nextPosition++;
                    }


                    //Creamos el Intent
                    Intent intent =
                            new Intent(CargoActivity.this, IAInspectionActivity.class);

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
                    b.putStringArray("Cargo", cargo);


                    //We add the bundle to the intent
                    intent.putExtra("Bundle",b);

                    //We start the activity
                    startActivity(intent);
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Select, at least, 2 cards", Toast.LENGTH_SHORT);

                    toast1.show();
                }
;
            }

        });

        passButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {



                    //We create the Intent
                    Intent intent =
                            new Intent(CargoActivity.this, GameActivity.class);

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);

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

        });
    }

    private void updateWindow() {

        if(playerHand[0].equals("legal_goods_card")){
            card1=1;
            playerCard1.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[0].equals("illegal_goods_card")){
            card1=2;
            playerCard1.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[0].equals("lieutenant_card")){
            card1=3;
            playerCard1.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[0].equals("captain_card")){
            card1=4;
            playerCard1.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[0].equals("inspector_card")){
            card1=5;
            playerCard1.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[0].equals("empty")) {
            card1 = 0;
            playerCard1.setImageResource(R.drawable.empty_card_reduced);
            playerCard1.setEnabled(false);
        }

        if(playerHand[1].equals("legal_goods_card")){
            card2=1;
            playerCard2.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[1].equals("illegal_goods_card")){
            card2=2;
            playerCard2.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[1].equals("lieutenant_card")){
            card2=3;
            playerCard2.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[1].equals("captain_card")){
            card2=4;
            playerCard2.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[1].equals("inspector_card")){
            card2=5;
            playerCard2.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[1].equals("empty")) {
            card2 = 0;
            playerCard2.setImageResource(R.drawable.empty_card_reduced);
            playerCard2.setEnabled(false);
        }

        if(playerHand[2].equals("legal_goods_card")){
            card3=1;
            playerCard3.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[2].equals("illegal_goods_card")){
            card3=2;
            playerCard3.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[2].equals("lieutenant_card")){
            card3=3;
            playerCard3.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[2].equals("captain_card")){
            card3=4;
            playerCard3.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[2].equals("inspector_card")){
            card3=5;
            playerCard3.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[2].equals("empty")) {
            card3 = 0;
            playerCard3.setImageResource(R.drawable.empty_card_reduced);
            playerCard3.setEnabled(false);
        }

        if(playerHand[3].equals("legal_goods_card")){
            card4=1;
            playerCard4.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[3].equals("illegal_goods_card")){
            card4=2;
            playerCard4.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[3].equals("lieutenant_card")){
            card4=3;
            playerCard4.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[3].equals("captain_card")){
            card4=4;
            playerCard4.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[3].equals("inspector_card")){
            card4=5;
            playerCard4.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[3].equals("empty")) {
            card4 = 0;
            playerCard4.setImageResource(R.drawable.empty_card_reduced);
            playerCard4.setEnabled(false);
        }

        if(playerHand[4].equals("legal_goods_card")){
            card5=1;
            playerCard5.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[4].equals("illegal_goods_card")){
            card5=2;
            playerCard5.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[4].equals("lieutenant_card")){
            card5=3;
            playerCard5.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[4].equals("captain_card")){
            card5=4;
            playerCard5.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[4].equals("inspector_card")){
            card5=5;
            playerCard5.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[4].equals("empty")) {
            card1 = 5;
            playerCard5.setImageResource(R.drawable.empty_card_reduced);
            playerCard5.setEnabled(false);
        }

        if(playerHand[5].equals("legal_goods_card")){
            card6=1;
            playerCard6.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[5].equals("illegal_goods_card")){
            card6=2;
            playerCard6.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[5].equals("lieutenant_card")){
            card6=3;
            playerCard6.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[5].equals("captain_card")){
            card6=4;
            playerCard6.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[5].equals("inspector_card")){
            card6=5;
            playerCard6.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[5].equals("empty")) {
            card6 = 0;
            playerCard6.setImageResource(R.drawable.empty_card_reduced);
            playerCard6.setEnabled(false);
        }

        if(playerHand[6].equals("legal_goods_card")){
            card7=1;
            playerCard7.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[6].equals("illegal_goods_card")){
            card7=2;
            playerCard7.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[6].equals("lieutenant_card")){
            card7=3;
            playerCard7.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[6].equals("captain_card")){
            card7=4;
            playerCard7.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[6].equals("inspector_card")){
            card7=5;
            playerCard7.setImageResource(R.drawable.inspector_card_reduced);
        }
        else if(playerHand[6].equals("empty")) {
            card7 = 0;
            playerCard7.setImageResource(R.drawable.empty_card_reduced);
            playerCard7.setEnabled(false);
        }

        if(playerHand[7].equals("legal_goods_card")){
            card8=1;
            playerCard8.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(playerHand[7].equals("illegal_goods_card")){
            card8=2;
            playerCard8.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(playerHand[7].equals("lieutenant_card")){
            card8=3;
            playerCard8.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(playerHand[7].equals("captain_card")){
            card8=4;
            playerCard8.setImageResource(R.drawable.captain_card_reduced);
        }
        else if(playerHand[7].equals("inspector_card")){
            card8=5;
            playerCard8.setImageResource(R.drawable.inspector_card_reduced);
        } else if (playerHand[7].equals("empty")) {
            card8 = 0;
            playerCard8.setImageResource(R.drawable.empty_card_reduced);
            playerCard8.setEnabled(false);
        }
    }

}
