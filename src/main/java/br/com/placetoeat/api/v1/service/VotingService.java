package br.com.placetoeat.api.v1.service;

import br.com.placetoeat.api.v1.model.User;
import br.com.placetoeat.api.v1.model.Voting;
import br.com.placetoeat.api.v1.repository.VotingRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VotingService {

    private VotingRepository votingRepository;

    public VotingService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    public void salvar (Voting voting) {
        try {
            this.votingRepository.saveAndFlush(voting);
        } catch (Exception exception) {
            throw new ServiceException("Nao foi possivel salvar voto", exception);
        }
    }

    public boolean validaVoto (Voting voting) {
        try {
            boolean podeVotar = true;
            Voting votings = this.votingRepository.findByUserAndTeamAndDate(voting.getUser(), voting.getTeam(), voting.getDate());
            if(votings != null){
                if(votings.equals(voting)){
                    podeVotar = false;
                }
            }
            return podeVotar;
        } catch (Exception exception) {
            throw new ServiceException("Nao foi possivel validar voto", exception);
        }
    }

    public Voting configuraVoto (Voting voting, User user) {
        try {
            voting.setUser(user);
            voting.setDate(configuraData(new Date()));
            voting.setTeam(user.getTeam());
            return voting;
        } catch (Exception exception) {
            throw new ServiceException("Nao foi possivel configurar voto", exception);
        }
    }

    public String configuraData (Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateF = format.format(date);
            return dateF;
        } catch (Exception exception) {
            throw new ServiceException("Nao foi possivel configurar data", exception);
        }
    }

}
