package co.com.sofkau.dddchallenge.domain.social.values;

import co.com.sofkau.dddchallenge.generic.ValueObject;

public class NickName implements ValueObject<String> {

    private final String nickName;

    public NickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String value() {
        return nickName;
    }

}
