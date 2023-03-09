package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CreateSocialCommand extends Command {

    private final String socialId;

    public CreateSocialCommand(String socialId) {
        this.socialId = socialId;
    }

    public String getSocialId() {
        return socialId;
    }

}
