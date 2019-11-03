package br.com.placetoeat.api.v1.service;

import br.com.placetoeat.api.v1.model.Place;
import br.com.placetoeat.api.v1.model.User;
import br.com.placetoeat.api.v1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User buscar(String username){
        try {
            return this.repository.findByUsername(username);
        } catch (NullPointerException exception){
            throw new ServiceException("Usuario nao encontrado", exception);
        } catch (Exception exception){
            throw new ServiceException("Erro ao buscar usuario", exception);
        }
    }
}
