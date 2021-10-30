package seedu.awe.model.payment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.awe.testutil.Assert.assertThrows;
import static seedu.awe.testutil.TypicalPayments.ALICE_BOB_COST;
import static seedu.awe.testutil.TypicalPayments.ALICE_BOB_PAYMENT;
import static seedu.awe.testutil.TypicalPayments.CARL_DANIEL_COST;
import static seedu.awe.testutil.TypicalPayments.CARL_DANIEL_PAYMENT;
import static seedu.awe.testutil.TypicalPersons.ALICE;
import static seedu.awe.testutil.TypicalPersons.BOB;
import static seedu.awe.testutil.TypicalPersons.CARL;
import static seedu.awe.testutil.TypicalPersons.DANIEL;

import org.junit.jupiter.api.Test;

import seedu.awe.model.expense.Cost;


public class PaymentTest {

    @Test
    public void getPayer_success() {
        assertEquals(ALICE, ALICE_BOB_PAYMENT.getPayer());
        assertEquals(CARL, CARL_DANIEL_PAYMENT.getPayer());
    }

    @Test
    public void nullPayer_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Payment(null, BOB, ALICE_BOB_COST));
    }

    @Test
    public void getPayee_success() {
        assertEquals(BOB, ALICE_BOB_PAYMENT.getPayee());
        assertEquals(DANIEL, CARL_DANIEL_PAYMENT.getPayee());
    }

    @Test
    public void nullPayee_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Payment(ALICE, null, ALICE_BOB_COST));
    }

    @Test
    public void getCost_success() {
        assertEquals(ALICE_BOB_COST, ALICE_BOB_PAYMENT.getCost());
        assertEquals(CARL_DANIEL_COST, CARL_DANIEL_PAYMENT.getCost());
    }

    @Test
    public void nullCost_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Payment(ALICE, BOB, null));
    }

    @Test
    public void toString_test() {
        assertEquals(new Payment(ALICE, BOB, new Cost(10.0)).toString(),
                "Bob Choo pays $10.00 to Alice Pauline.");
    }

    @Test
    public void equals() {
        Payment aliceBobPayment = new Payment(ALICE, BOB, new Cost(10.0));
        assertTrue(aliceBobPayment.equals(new Payment(ALICE, BOB, new Cost(10.0))));
        assertTrue(aliceBobPayment.equals(aliceBobPayment));
        assertFalse(aliceBobPayment.equals(10.0));
        assertFalse(aliceBobPayment.equals(new Payment(BOB, ALICE, new Cost(10.0))));
    }

}
