package by.bsuir.task.service;

import by.bsuir.task.domain.entity.User;
import by.bsuir.task.exception.DataSourceException;
import by.bsuir.task.exception.CustomException;
import by.bsuir.task.repository.creator.RepositoryCreator;
import by.bsuir.task.repository.impl.UserRepository;
import by.bsuir.task.query.user.FindByUsernameQuery;
import by.bsuir.task.query.user.FindByUsernameAndPasswordQuery;

import java.util.Optional;

public class UserService {

    public Optional<User> findByUsernameAndPassword(String username, String password) throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameAndPasswordQuery(username, password));

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public Optional<User> findByUsername(String username) throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameQuery(username));

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public void signUp(Integer id, String username, String password) throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, username, password);
            userRepository.save(user);

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

}
