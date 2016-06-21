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

public class DrawActivity extends AppCompatActivity {

    // Next Button
    private ImageButton nextButton;

    // Players cards
    private String[] ia1Hand = new String[8];
    private String[] ia2Hand = new String[8];
    private String[] ia3Hand = new String[8];
    private String[] playerHand = new String[8];

    // Table cards
    private String[] tableCards;
    private ImageButton tableCard1,tableCard2,tableCard3,tableCard4,tableCard5,tableCard6;
    private int card1,card2,card3,card4;
    boolean card1Checked = false,card2Checked = false,card3Checked = false,card4Checked = false,card5Checked = false,card6Checked = false;

    // Players money
    private int ia1Money,ia2Money,ia3Money,playerMoney;

    // Deck
    private Deck deck;

    // Draw Cards
    private ImageButton faceUpCard1,faceUpCard2,faceUpCard3,faceUpCard4,faceDownCard1,faceDownCard2;

    // Selected Cards
    int selectedCard1=0, selectedCard2=0;
    int emptySpace=0;

    // Parameters
    private int selectedCards=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_draw);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Draw Phase");
        }

        nextButton = (ImageButton) findViewById(R.id.BtnNext);
        tableCard1 = (ImageButton) findViewById(R.id.TableCard1);
        tableCard2 = (ImageButton) findViewById(R.id.TableCard2);
        tableCard3 = (ImageButton) findViewById(R.id.TableCard3);
        tableCard4 = (ImageButton) findViewById(R.id.TableCard4);
        tableCard5 = (ImageButton) findViewById(R.id.DeckCard1);
        tableCard6 = (ImageButton) findViewById(R.id.DeckCard2);


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

        tableCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card1Checked) || (emptySpace>0 && (selectedCard1==0 || selectedCard2==0))) {

                    if (card1Checked == false) {
                        if (card1 == 1)
                            tableCard1.setImageResource(R.drawable.selected_legal_goods);
                        else if (card1 == 2)
                            tableCard1.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card1 == 3)
                            tableCard1.setImageResource(R.drawable.selected_lieutenant_card);
                        card1Checked = true;

                        if(selectedCard1==0) selectedCard1=1;
                        else selectedCard2 = 1;
                    } else {
                        if (card1 == 1)
                            tableCard1.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card1 == 2)
                            tableCard1.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card1 == 3)
                            tableCard1.setImageResource(R.drawable.lieutenant_card_reduced);
                        card1Checked = false;
                        if(selectedCard1==1) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });

        tableCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card2Checked) || (emptySpace>0 && (selectedCard1==0 || selectedCard2==0))) {

                    if (card2Checked == false) {
                        if (card2 == 1)
                            tableCard2.setImageResource(R.drawable.selected_legal_goods);
                        else if (card2 == 2)
                            tableCard2.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card2 == 3)
                            tableCard2.setImageResource(R.drawable.selected_lieutenant_card);
                        card2Checked = true;

                        if(selectedCard1==0) selectedCard1=2;
                        else selectedCard2 = 2;
                    } else {
                        if (card2 == 1)
                            tableCard2.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card2 == 2)
                            tableCard2.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card2 == 3)
                            tableCard2.setImageResource(R.drawable.lieutenant_card_reduced);
                        card2Checked = false;
                        if(selectedCard1==2) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });

        tableCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card3Checked) || (emptySpace>0 && (selectedCard1==0 || selectedCard2==0))) {

                    if (card3Checked == false) {
                        if (card3 == 1)
                            tableCard3.setImageResource(R.drawable.selected_legal_goods);
                        else if (card3 == 2)
                            tableCard3.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card3 == 3)
                            tableCard3.setImageResource(R.drawable.selected_lieutenant_card);
                        card3Checked = true;

                        if(selectedCard1==0) selectedCard1=3;
                        else selectedCard2 = 3;
                    } else {
                        if (card3 == 1)
                            tableCard3.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card3 == 2)
                            tableCard3.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card3 == 3)
                            tableCard3.setImageResource(R.drawable.lieutenant_card_reduced);
                        card3Checked = false;
                        if(selectedCard1==3) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });

        tableCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card4Checked) || (emptySpace>0 && (selectedCard1==0 || selectedCard2==0))) {

                    if (card4Checked == false) {
                        if (card4 == 1)
                            tableCard4.setImageResource(R.drawable.selected_legal_goods);
                        else if (card4 == 2)
                            tableCard4.setImageResource(R.drawable.selected_illegal_goods);
                        else if (card4 == 3)
                            tableCard4.setImageResource(R.drawable.selected_lieutenant_card);
                        card4Checked = true;

                        if(selectedCard1==0) selectedCard1=4;
                        else selectedCard2 = 4;
                    } else {
                        if (card4 == 1)
                            tableCard4.setImageResource(R.drawable.legal_goods_card_reduced);
                        else if (card4 == 2)
                            tableCard4.setImageResource(R.drawable.illegal_goods_card_reduced);
                        else if (card4 == 3)
                            tableCard4.setImageResource(R.drawable.lieutenant_card_reduced);
                        card4Checked = false;
                        if(selectedCard1==4) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });

        tableCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card5Checked) || (emptySpace>0 && ((selectedCard1==0 || selectedCard2==0) && selectedCard1<5 && selectedCard2<5 ))) {

                    if (card5Checked == false) {
                        tableCard5.setImageResource(R.drawable.selected_truck_card);
                        card5Checked = true;

                        if(selectedCard1==0) selectedCard1=5;
                        else selectedCard2 = 5;
                    } else {
                        tableCard5.setImageResource(R.drawable.truck_card_reduced);
                        card5Checked = false;
                        if(selectedCard1==5) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });

        tableCard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((card6Checked) || (emptySpace>0 && ((selectedCard1==0 || selectedCard2==0) && selectedCard1<5 && selectedCard2<5 ))) {

                    if (card6Checked == false) {
                        tableCard6.setImageResource(R.drawable.selected_truck_card);
                        card6Checked = true;

                        if(selectedCard1==0) selectedCard1=6;
                        else selectedCard2 = 6;
                    } else {
                        tableCard6.setImageResource(R.drawable.truck_card_reduced);
                        card6Checked = false;
                        if(selectedCard1==6) selectedCard1 = 0;
                        else selectedCard2 = 0;
                    }
                } else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "You cannot pick more cards", Toast.LENGTH_SHORT);

                    toast1.show();

                }
            }
        });



        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedCard1!=0){
                    for(int i=2 ; i<8 ; i++){
                        if(playerHand[i].equals("empty")){
                            if(selectedCard1<5) playerHand[i]=tableCards[selectedCard1-1];
                            else playerHand[i] = deck.getNextCard();
                            break;
                        }
                    }
                }

                if(selectedCard2!=0){
                    for(int i=2 ; i<8 ; i++){
                        if(playerHand[i].equals("empty")){
                            if(selectedCard2<5) playerHand[i]=tableCards[selectedCard2-1];
                            else playerHand[i] = deck.getNextCard();
                            break;
                        }
                    }
                }


                //We create the intent
                Intent intent =
                        new Intent(DrawActivity.this, CargoActivity.class);

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
                b.putSerializable("Deck",deck);


                //We add the bundle to the intent
                intent.putExtra("Bundle",b);

                //We start the activity
                startActivity(intent);

            }

        });
    }

    private void updateWindow() {

        if(tableCards[0].equals("legal_goods_card")){
            card1=1;
            tableCard1.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(tableCards[0].equals("illegal_goods_card")){
            card1=2;
            tableCard1.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(tableCards[0].equals("lieutenant_card")){
            card1=3;
            tableCard1.setImageResource(R.drawable.lieutenant_card_reduced);
        }
        else if(tableCards[0].equals("empty")){
            card1=0;
            tableCard1.setImageResource(R.drawable.empty_card);
            tableCard1.setEnabled(false);
        }

        if(tableCards[1].equals("legal_goods_card")){
            card2=1;
            tableCard2.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(tableCards[1].equals("illegal_goods_card")){
            card2=2;
            tableCard2.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(tableCards[1].equals("lieutenant_card")){
            card2=3;
            tableCard2.setImageResource(R.drawable.lieutenant_card_reduced);
        }

        if(tableCards[2].equals("legal_goods_card")){
            card3=1;
            tableCard3.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(tableCards[2].equals("illegal_goods_card")){
            card3=2;
            tableCard3.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(tableCards[2].equals("lieutenant_card")){
            card3=3;
            tableCard3.setImageResource(R.drawable.lieutenant_card_reduced);
        }

        if(tableCards[3].equals("legal_goods_card")){
            card4=1;
            tableCard4.setImageResource(R.drawable.legal_goods_card_reduced);
        }
        else if(tableCards[3].equals("illegal_goods_card")){
            card4=2;
            tableCard4.setImageResource(R.drawable.illegal_goods_card_reduced);
        }
        else if(tableCards[3].equals("lieutenant_card")){
            card4=3;
            tableCard4.setImageResource(R.drawable.lieutenant_card_reduced);
        }

        for(int i=2 ; i<8 ; i++){
            if(playerHand[i].equals("empty"))emptySpace++;
        }

    }

}
