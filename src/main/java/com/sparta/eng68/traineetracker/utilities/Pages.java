package com.sparta.eng68.traineetracker.utilities;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Pages {

    //LOGIN =========================================================================================
    public static final String HOME_PAGE = "/home";
    public static final String LOGIN_PAGE = "/login/login";

    //TRAINEE =======================================================================================
    public static final String TRAINEE_HOME = "/trainee/traineeHome";
    public static final String TRAINEE_GUIDE = "/trainee/traineeGuide";

    //TRAINER =======================================================================================
    public static final String TRAINER_HOME = "/trainer/trainerHome";

    //ERROR =========================================================================================
    public static final String ACCESS_ERROR = "/errors/accessError";

    public static String accessPage(String requiredRole, String page) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (request.isUserInRole(requiredRole) || requiredRole.equals(Roles.ANY)) {
            return page;
        } else {
            return ACCESS_ERROR;
        }
    }

}
