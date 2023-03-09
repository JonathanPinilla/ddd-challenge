package co.com.sofkau.dddchallenge.domain.social.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class Content implements ValueObject<String> {

    private final String content;

    public Content(String content) {
        this.content = content;
    }

    @Override
    public String value() {
        return content;
    }

}
