package br.com.placetoeat.api.v1.rest;

import br.com.placetoeat.api.v1.model.User;
import br.com.placetoeat.api.v1.model.Voting;
import br.com.placetoeat.api.v1.service.UserService;
import br.com.placetoeat.api.v1.service.VotingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class VotingRest {

    private UserService userService;

    private VotingService votingService;

    public VotingRest(UserService userService, VotingService votingService) {
        this.userService = userService;
        this.votingService = votingService;
    }

    @PostMapping(value = "/votar")
    public ResponseEntity<String> votar(@RequestBody Voting voting){
        try {
            User user = this.userService.buscar(voting.getUser().getUsername());
            voting = this.votingService.configuraVoto(voting, user);
            if(this.votingService.validaVoto(voting)){
                this.votingService.salvar(voting);
                return new ResponseEntity<String>("Voto Aceito!", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Voce ja votou hoje!", HttpStatus.OK);
            }

        } catch (Exception exception) {
            return new ResponseEntity<String>( "Voto Recusado e " + exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
