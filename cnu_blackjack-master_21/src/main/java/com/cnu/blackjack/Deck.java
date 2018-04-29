package com.cnu.blackjack;

import com.cnu.blackjack.exceptions.NoMoreCardException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final int number;
    private final List<Card> cardList;

    public Deck(int number) { // number만큼 덱에 카드를 생성한다.
        this.number = number;
        this.cardList = new ArrayList<Card>();
        createCards(number);
        Collections.shuffle(cardList);
    }

    private void createCards(int number) { // 카드 생성 함수
        // create card for single deck
        for (int j = 0; j < number; j++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1 ; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
    }

    public int getTotalCard() {
        return cardList.size();
    } // 덱에 남아있는 카드 크기 리턴.

    public Card drawCard() { // 덱 비우기.
        if (cardList.size() == 0) {
            throw new NoMoreCardException();
        }
        return cardList.remove(0);
    }
}