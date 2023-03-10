package co.com.sofkau.dddchallenge.domain.social.commands;

import co.com.sofkau.dddchallenge.generic.Command;

public class ChangeSocialStateCommand extends Command{

        private final String socialId;
        private final String state;

        public ChangeSocialStateCommand(String socialId, String state) {
            this.socialId = socialId;
            this.state = state;
        }

        public String getSocialId() {
            return socialId;
        }

        public String getState() {
            return state;
        }

}
