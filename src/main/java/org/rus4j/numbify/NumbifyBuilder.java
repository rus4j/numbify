package org.rus4j.numbify;

import org.rus4j.numbify.lang.en.English;
import org.rus4j.numbify.lang.ru.RuDeclension;
import org.rus4j.numbify.lang.ru.Russian;

public class NumbifyBuilder {
    private Language language;

    public NumbifyBuilder english() {
        this.language = new English();
        return this;
    }

    public NumbifyBuilder russian() {
        this.language = new Russian();
        return this;
    }

    public NumbifyBuilder russian(RuDeclension declension, Gender gender) {
        this.language = new Russian(declension, gender);
        return this;
    }

//    public NumbifyBuilder customLanguage(Language language) {
//        this.language = language;
//        return this;
//    }

    public Numbify build() {
        return new Numbify(language);
    }
}
