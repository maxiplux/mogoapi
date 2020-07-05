package api.mongodb.livemarket.business.mogoapi.config;

import api.mongodb.livemarket.business.mogoapi.models.items.Category;
import api.mongodb.livemarket.business.mogoapi.models.items.Item;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
    {
        config.exposeIdsFor(Item.class);
        config.exposeIdsFor(Category.class);
    }
}
