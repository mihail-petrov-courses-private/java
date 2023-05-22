package service;

import model.User;

public class Auth {

    private static User userReference = null;



    public static boolean isAuthenticated() {
        return Auth.userReference != null;
    }

    public static void authenticate(String userEmail, String userPassword) {

        User authUser = User.findActiveUser(userEmail, userPassword);

        if(authUser != null) {
            Auth.auth(authUser);
        }

    }

    private static void auth(User userReference) {
        Auth.userReference = userReference;
    }

    public static User getUser() {
        return Auth.userReference;
    }
}
