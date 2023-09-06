package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/api/api.properties"})

public interface ApiConfig extends Config {

    @Key("baseApiUrl")
    @DefaultValue("https://api2.ivi.ru/mobileapi")
    String getBaseApiUrl();

    @Key("session")
    String getSession();


}
