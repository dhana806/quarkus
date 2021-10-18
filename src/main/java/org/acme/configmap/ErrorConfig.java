package org.acme.configmap;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

import java.util.Map;

@ConfigMapping(prefix = "checkout", namingStrategy = ConfigMapping.NamingStrategy.VERBATIM)
public interface ErrorConfig {

    // store config values in key, value pair
    Map<String, ErrorInfo> error();

    Map<String, ErrorInfo> warning();

    // nested objects
    interface ErrorInfo {
        @WithDefault("code-not-found")
        String code();

        @WithDefault("reason-not-found")
        String reason();

        @WithDefault("messageType-not-found")
        String messageType();

        Description messageDescription();
    }

    // nested objects
    interface Description {
        @WithDefault("EngDescription-not-found")
        String en();

        @WithDefault("FrenchDescription-not-found")
        String fr();
    }

}
