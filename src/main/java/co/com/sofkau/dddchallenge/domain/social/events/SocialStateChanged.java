package co.com.sofkau.dddchallenge.domain.social.events;

import co.com.sofkau.dddchallenge.generic.DomainEvent;

public class SocialStateChanged extends DomainEvent {

        private final String socialId;
        private final String state;

        public SocialStateChanged(String socialId, String state) {
            super("dddchallenge.social.socialStateChanged");
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
