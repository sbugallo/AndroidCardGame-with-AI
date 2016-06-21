package es.uvigo.teleco.prohis;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Deck implements Serializable {
	/* Statics for each card */
	public static final String LEGAL_GOODS = "legal_goods_card";
	public static final String ILLEGAL_GOODS = "illegal_goods_card";
	public static final String LIEUTENANT = "lieutenant_card";
	private static final int TOTAL_CARDS = 66;
	private ArrayList<String> deck = new ArrayList<String>(TOTAL_CARDS);
	private final Random rand = new Random();
	/** Legal goods cards left in the deck */
	private int legalGoods = 40;
	/** Illegal goods cards left in the deck */
	private int illegalGoods = 20;
	/** Lieutenant cards left in the deck */
	private int lieutenant = 6;

	/**
	 * Returns a newly initialized deck.
	 */
	public Deck() {
		initializeDeck();
	}

	/**
	 * Gets the current cards in the deck
	 * 
	 * @return
	 */
	public int getDeckSize() {
		return deck.size();
	}

	/**
	 * Generates a deck full of cards. The deck is always the same, but we
	 * access it randomly (Instead of generating it randomly and accessing it
	 * fixed.
	 */
	private void initializeDeck() {
		for (int i = 0; i < legalGoods; i++) {
			deck.add(LEGAL_GOODS);
		}
		for (int i = 0; i < illegalGoods; i++) {
			deck.add(ILLEGAL_GOODS);
		}
		for (int i = 0; i < lieutenant; i++) {
			deck.add(LIEUTENANT);
		}

	}

	/**
	 * Gets the probability of getting a legal goods card if we use
	 * {@link Deck#getNextCard()}. Value is normalized from 0 to 1.
	 * 
	 * @return the probability of getting a legal goods card.
	 */
	public float getLegalGoodsProb() {
		return (float) legalGoods / (float) (getDeckSize());
	}

	/**
	 * Gets the probability of getting a illegal goods card if we use
	 * {@link Deck#getNextCard()}. Value is normalized from 0 to 1.
	 * 
	 * @return the probability of getting an illegal goods card.
	 */
	public float getIllegalGoodsProb() {
		return (float) illegalGoods / (float) (getDeckSize());
	}

	/**
	 * Gets the probability of getting a lieutenant card if we use
	 * {@link Deck#getNextCard()}. Value is normalized from 0 to 1.
	 * 
	 * @return the probability of getting a lieutenant goods card.
	 */
	public float getLieutenantProb() {
		return (float) lieutenant / (float) (getDeckSize());
	}

	/*
	 * Randomly gets (and removes) a card from the deck.
	 */
	public String getNextCard() {
		String card = deck.remove(rand.nextInt(deck.size()));
		if (card.equals(ILLEGAL_GOODS)) {
			illegalGoods--;
		} else if (card.equals(LEGAL_GOODS)) {
			legalGoods--;
		} else if (card.equals(LIEUTENANT)) {
			lieutenant--;
		}
		return card;
	}

}