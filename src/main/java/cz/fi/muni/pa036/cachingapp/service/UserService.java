package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.User;

import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface UserService {

    List<User> listAllUsers ();

}
