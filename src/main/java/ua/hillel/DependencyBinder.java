package ua.hillel;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.hillel.service.UserInMemoryService;
import ua.hillel.service.UserService;

public class DependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {

        bind(UserInMemoryService.class)
                .to(UserService.class)
                .in(Singleton.class);
    }
}
