package com.semanticpartners.checkout;

import com.semanticpartners.checkout.SupermarketCheckout.Transaction;
import org.junit.Test;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertEquals;

public class SupermarketCheckoutTest {

    private static final Item A = new Item("A");
    private static final Item B = new Item("B");
    private static final Item C = new Item("C");
    private static final Item D = new Item("D");

    private SupermarketCheckout checkout = new SupermarketCheckout();

    private Set<PricingRule> thisWeeksPrices = newHashSet(
        PricingRule.pricingRuleFor(A).atPrice(50),
        PricingRule.pricingRuleFor(B).atPrice(30),
        PricingRule.pricingRuleFor(C).atPrice(20),
        PricingRule.pricingRuleFor(D).atPrice(15)
    ); 

    @Test
    public void calculateTotalPriceOfIndividuallyPricedItems() {
        Transaction transaction = checkout.startTransaction(thisWeeksPrices)
                .scan(A)
                .scan(D);

        assertEquals(65, checkout.calculateTotalPrice(transaction));
    }
}
