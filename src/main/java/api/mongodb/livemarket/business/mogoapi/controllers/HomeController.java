package api.mongodb.livemarket.business.mogoapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<?>  helloWorld(){
        Map<String, String> msg = new HashMap<String, String>();

        msg.put("msg", "running");


        return new ResponseEntity<Map<String, String>>(msg, HttpStatus.OK);

    }

    @Autowired
    private TokenStore tokenStore;


    @GetMapping("/protected")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> helloWorldProtected(OAuth2Authentication oAuth) {
        // how to get principal from OAuth2Authentication using spring boot 2.3
        // todo: improve openapi
        oAuth.getPrincipal();

        OAuth2AuthenticationDetails oAuthDetails = (OAuth2AuthenticationDetails) oAuth.getDetails();
        OAuth2AccessToken registeredToken = tokenStore.readAccessToken(oAuthDetails.getTokenValue());
        if (registeredToken == null) {

            DefaultOAuth2AccessToken newToken = new DefaultOAuth2AccessToken(oAuthDetails.getTokenValue());
            tokenStore.storeAccessToken(newToken, oAuth);
        }
        Map<String, String> msg = new HashMap<String, String>();



        msg.put("msg", "todo bien 10 10+"+oAuth.getPrincipal());


        return new ResponseEntity<Map<String, String>>(msg, HttpStatus.OK);

    }


}
