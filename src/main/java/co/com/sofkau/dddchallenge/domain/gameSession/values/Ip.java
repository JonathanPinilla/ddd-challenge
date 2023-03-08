package co.com.sofkau.dddchallenge.domain.gameSession.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class Ip implements ValueObject<String> {

    private final String ip;

    public Ip(String ip) {
        this.ip = ip;
    }

    @Override
    public String value() {
        return ip;
    }

}
