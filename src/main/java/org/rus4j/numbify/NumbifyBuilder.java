package org.rus4j.numbify;


import org.rus4j.numbify.lang.ru.RuDeclension;

public class NumbifyBuilder {
    private Declension declension = RuDeclension.NOMINATIVE;
    private Gender gender = Gender.MALE;
    private Language<?> language;
//    private Currency currency = Currency.NO_CURRENCY;

//    public NumbifyBuilder currency(Currency currency) {
//        this.currency = currency;
//        return this;
//    }

    public NumbifyBuilder declension(Declension declension) {
        this.declension = declension;
        return this;
    }

    public NumbifyBuilder gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public NumbifyBuilder language(Language<?> language) {
        this.language = language;
        return this;
    }

    public Numbify build() {
        return new Numbify(declension, gender, language);
    }
}
