package co.com.sofkau.dddchallenge.domain.catalog;

import co.com.sofkau.dddchallenge.common.CatalogId;
import co.com.sofkau.dddchallenge.domain.catalog.events.CatalogCreated;
import co.com.sofkau.dddchallenge.domain.catalog.values.GamesSold;
import co.com.sofkau.dddchallenge.domain.catalog.values.TotalGames;
import co.com.sofkau.dddchallenge.domain.catalog.values.TotalPublishers;
import co.com.sofkau.dddchallenge.generic.AggregateRoot;

import java.util.List;

public class Catalog extends AggregateRoot<CatalogId> {

    protected CatalogId catalogId;
    protected List<Game> games;
    protected List<Publisher> publishers;
    protected TotalGames totalGames;
    protected TotalPublishers totalPublishers;
    protected GamesSold gamesSold;

    public Catalog(CatalogId catalogId) {
        super(catalogId);
        subscribe(new CatalogEventChange(this));
        appendChange(new CatalogCreated(catalogId.value())).apply();
    }
}
