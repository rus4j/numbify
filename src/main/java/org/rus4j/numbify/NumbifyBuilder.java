package org.rus4j.numbify;


import org.rus4j.numbify.lang.Declension;
import org.rus4j.numbify.lang.Gender;

public class NumbifyBuilder {
    private Declension declension;
    private Gender gender;
    private Currency currency = Currency.NO_CURRENCY;

    public NumbifyBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public NumbifyBuilder declension(Declension declension) {
        this.declension = declension;
        return this;
    }

    public NumbifyBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Numbify build() {
        return new Numbify(declension, gender);
    }
}
