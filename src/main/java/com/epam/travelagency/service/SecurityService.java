package com.epam.travelagency.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
