package com.ashish.MovieBooking.services;

import com.ashish.MovieBooking.entities.User;
import com.ashish.MovieBooking.exceptions.UserDetailsNotFoundException;
import com.ashish.MovieBooking.exceptions.UserNameAlreadyExistsException;
import com.ashish.MovieBooking.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {

    //Allow the creation of user
    //I should also not allow to create an existing user/ duplicate user
    //I should also not allow to create a user of wrong type

    public User acceptUserDetails(User user)throws UserNameAlreadyExistsException,
            UserTypeDetailsNotFoundException;

    //Fetch the user details based on userId

    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    //Fetch the user by Name

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

    // Update User Details

    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException,
            UserTypeDetailsNotFoundException;

}
