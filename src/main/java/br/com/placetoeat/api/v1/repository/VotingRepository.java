package br.com.placetoeat.api.v1.repository;

import br.com.placetoeat.api.v1.model.Team;
import br.com.placetoeat.api.v1.model.User;
import br.com.placetoeat.api.v1.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {

    Voting findByUserAndTeamAndDate(User user, Team team, String date);

}
