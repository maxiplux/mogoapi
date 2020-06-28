package api.mongodb.livemarket.business.mogoapi.auth;


import api.mongodb.livemarket.business.mogoapi.models.users.User;
import api.mongodb.livemarket.business.mogoapi.services.impl.UserDetailsServiceExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UserDetailsServiceExtra userDetailsService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        User usuario = userDetailsService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();
        //info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));

        info.put("username", usuario.getUsername());

        info.put("nombre", usuario.getFirstName());
        info.put("apellido", usuario.getLastName());

        info.put("firts_name", usuario.getFirstName());
        info.put("last_name", usuario.getLastName());

        info.put("email", usuario.getEmail());
        info.put("roles", usuario.getRoles());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }

}
