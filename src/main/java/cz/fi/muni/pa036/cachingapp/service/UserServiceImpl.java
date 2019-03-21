package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.User;
import cz.fi.muni.pa036.cachingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listAllUsers () {
        return userRepository.findAll();
    }
}
