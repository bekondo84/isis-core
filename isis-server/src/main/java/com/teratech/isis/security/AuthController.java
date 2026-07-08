package com.teratech.isis.security;

import com.teratech.beans.AuthRequest;
import com.teratech.beans.AuthResponse;
import com.teratech.dao.FlexibleSearch;
import com.teratech.dao.PersistenceManager;
import com.teratech.exceptions.ApplicationException;
import com.teratech.exceptions.ModelServiceException;
import com.teratech.model.security.UserModel;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final FlexibleSearch flexibleSearch;
    private final PersistenceManager persistenceManager;
    private final PasswordEncoder encoder;
    private final TransactionTemplate transactionTemplate;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, FlexibleSearch flexibleSearch, PersistenceManager persistenceManager, PasswordEncoder encoder, TransactionTemplate transactionTemplate) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.flexibleSearch = flexibleSearch;
        this.persistenceManager = persistenceManager;
        this.encoder = encoder;
        this.transactionTemplate = transactionTemplate;
    }

    @PostMapping("/init")
    public ResponseEntity<String> initialze() throws ApplicationException {
       try {
           transactionTemplate.execute(status -> {
               UserModel admin = null;
               try {
                   admin = flexibleSearch.find(new UserModel("admin"));
                   if (Objects.isNull(admin)) {
                       admin = new UserModel("admin");
                       admin.setPassword(encoder.encode("nimda"));
                       admin.setName("Super Administrator");
                       admin.setActive(true);
                       admin.setLocked(false);
                       admin.setEmail("teratech@gmail.com");
                       admin.setSurname("Super administrator");
                       persistenceManager.save(admin);
                   }
                   return status;
               } catch (Exception  e) {
                  e.printStackTrace();
                  return "FAILED";
               }

           });

       } catch (RuntimeException ex) {
          throw new ApplicationException(ex);
       }

          return ResponseEntity.ok("SUCCES");
    }

    @PostMapping ("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // Déclenche l'authentification Spring Security (vérifie le mot de passe)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Si aucune exception n'est levée, l'utilisateur est valide : on génère le token
        String token = jwtService.generateToken(request.getUsername());

        UserModel user = flexibleSearch.find(new UserModel(request.getUsername()));
        user.setToken(token);
        AuthResponse response = new AuthResponse()
                .setAccess_token(token)
                .setToken_type("bearer")
                .setUser(user.getCode())
                .setExpires_in(jwtService.extractExpireDate(token).getTime())
                .setLang(Objects.nonNull(user.getLanguage()) ? user.getLanguage().getCode() : "fr");

        return ResponseEntity.ok(response);
    }
}
