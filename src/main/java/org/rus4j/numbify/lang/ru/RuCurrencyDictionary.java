package org.rus4j.numbify.lang.ru;

import java.util.Map;

import org.rus4j.numbify.lang.Currency;

import static org.rus4j.numbify.lang.ru.RuDeclension.ACCUSATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.DATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.GENITIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.INSTRUMENTAL;
import static org.rus4j.numbify.lang.ru.RuDeclension.NOMINATIVE;
import static org.rus4j.numbify.lang.ru.RuDeclension.PREPOSITIONAL;

public class RuCurrencyDictionary {

    final String currency(Currency currency, RuDeclension declension, int form) {
        return switch (currency) {
            case RUB -> ruble.get(declension)[form];
            case USD -> usd.get(declension)[form];
            case EUR -> euro.get(declension)[form];
            case NUMBER -> number.get(declension)[form];
        };
    }

    final String decimalCurrency(Currency currency, RuDeclension declension, int decimalLength, int form) {
        return switch (currency) {
            case RUB -> decimalRub.get(declension)[form];
            case USD, EUR -> cent.get(declension)[form];
            case NUMBER -> decimal[decimalLength] + decimalEndings.get(declension)[form];
        };
    }

    final Map<RuDeclension, String[]> ruble = Map.of(
            NOMINATIVE, new String[]{"рубль", "рубля", "рублей"},
            GENITIVE, new String[]{"рубля", "рублей", "рублей"},
            DATIVE, new String[]{"рублю", "рублям", "рублям"},
            ACCUSATIVE, new String[]{"рубль", "рубля", "рублей"},
            INSTRUMENTAL, new String[]{"рублём", "рублями", "рублями"},
            PREPOSITIONAL, new String[]{"рубле", "рублях", "рублях"}
    );

    final Map<RuDeclension, String[]> usd = Map.of(
            NOMINATIVE, new String[]{"доллар", "доллара", "долларов"},
            GENITIVE, new String[]{"доллара", "долларов", "долларов"},
            DATIVE, new String[]{"доллару", "долларам", "долларам"},
            ACCUSATIVE, new String[]{"доллар", "доллара", "долларов"},
            INSTRUMENTAL, new String[]{"долларом", "долларами", "долларами"},
            PREPOSITIONAL, new String[]{"долларе", "долларах", "долларах"}
    );

    final Map<RuDeclension, String[]> euro = Map.of(
            NOMINATIVE, new String[]{"евро", "евро", "евро"},
            GENITIVE, new String[]{"евро", "евро", "евро"},
            DATIVE, new String[]{"евро", "евро", "евро"},
            ACCUSATIVE, new String[]{"евро", "евро", "евро"},
            INSTRUMENTAL, new String[]{"евро", "евро", "евро"},
            PREPOSITIONAL, new String[]{"евро", "евро", "евро"}
    );

    final Map<RuDeclension, String[]> number = Map.of(
            NOMINATIVE, new String[]{"целая", "целых", "целых"},
            GENITIVE, new String[]{"целой", "целых", "целых"},
            DATIVE, new String[]{"целой", "целым", "целым"},
            ACCUSATIVE, new String[]{"целую", "целых", "целых"},
            INSTRUMENTAL, new String[]{"целой", "целыми", "целыми"},
            PREPOSITIONAL, new String[]{"целой", "целых", "целых"}
    );

    final Map<RuDeclension, String[]> decimalRub = Map.of(
            NOMINATIVE, new String[]{"копейка", "копейки", "копеек"},
            GENITIVE, new String[]{"копейки", "копеек", "копеек"},
            DATIVE, new String[]{"копейке", "копейкам", "копейкам"},
            ACCUSATIVE, new String[]{"копейку", "копейки", "копеек"},
            INSTRUMENTAL, new String[]{"копейкой", "копейками", "копейками"},
            PREPOSITIONAL, new String[]{"копейке", "копейках", "копейках"}
    );

    final Map<RuDeclension, String[]> cent = Map.of(
            NOMINATIVE, new String[]{"цент", "цента", "центов"},
            GENITIVE, new String[]{"цента", "центов", "центов"},
            DATIVE, new String[]{"центу", "центам", "центам"},
            ACCUSATIVE, new String[]{"цент", "цента", "центов"},
            INSTRUMENTAL, new String[]{"центом", "центами", "центами"},
            PREPOSITIONAL, new String[]{"центе", "центах", "центах"}
    );

    final String[] decimal = new String[]{"", "десят", "сот", "тысячн", "десятитысячн", "стотысячн", "миллионн",
            "десятимиллионн", "стомиллионн", "миллиардн", "десятимиллиардн", "стомиллиардн", "триллионн",
            "десятитриллионн", "стотриллионн", "квадриллионн"
    };

    final Map<RuDeclension, String[]> decimalEndings = Map.of(
            NOMINATIVE, new String[]{"ая", "ых", "ых"},
            GENITIVE, new String[]{"ой", "ых", "ых"},
            DATIVE, new String[]{"ой", "ым", "ым"},
            ACCUSATIVE, new String[]{"ую", "ых", "ых"},
            INSTRUMENTAL, new String[]{"ой", "ми", "ми"},
            PREPOSITIONAL, new String[]{"ой", "ых", "ых"}
    );
}
