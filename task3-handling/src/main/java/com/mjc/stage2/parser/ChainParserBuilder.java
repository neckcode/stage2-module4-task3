package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        AbstractTextParser parser = null;
        if (parsers.size() > 1) {
            parser = parsers.get(0);
            for (int i = 1; i < parsers.size(); i++) {
                parser.setNextParser(parsers.get(i));
                parser = parsers.get(i);
            }
            parser = parsers.get(0);
        } else if (parsers.size() == 1) {
            parser = parsers.get(0);
        }
        return parser;
    }
}
