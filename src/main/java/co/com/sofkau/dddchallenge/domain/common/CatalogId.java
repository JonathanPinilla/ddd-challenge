package co.com.sofkau.dddchallenge.domain.common;

import co.com.sofkau.dddchallenge.generic.Identity;

public class CatalogId extends Identity {

    public CatalogId(String uuid) {
        super(uuid);
    }

    public CatalogId() {
    }

    public static CatalogId of(String uuid) {
        return new CatalogId(uuid);
    }

}
