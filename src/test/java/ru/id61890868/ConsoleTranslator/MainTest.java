package ru.id61890868.ConsoleTranslator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void translate() {
        assertEquals("[en-ru]: ключ", Main.translate("key"));
        assertEquals("[en-ru]: Следующие правила применяются при преобразовании:",
                Main.translate("The following rules are applied in the conversion:"));
    }
}