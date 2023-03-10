package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class CreateSocialCommand extends Command {

    private final String socialId;
    private final String state;
    private final String catalogId;

    public CreateSocialCommand(String socialId, String state, String catalogId) {
        this.socialId = socialId;
        this.state = state;
        this.catalogId = catalogId;
    }

    public String getSocialId() {
        return socialId;
    }

    public String getState() {
        return state;
    }

    public String getCatalogId() {
        return catalogId;
    }

}
