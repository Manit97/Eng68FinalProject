package com.sparta.eng68.traineetracker;

import com.sparta.eng68.traineetracker.security.SecurityConfig;
import org.junit.jupiter.api.Test;

public class SecurityConfigTests {

    @Test
    void testPasswordEncoding() {
        SecurityConfig securityConfig = new SecurityConfig(null);
        System.out.println(securityConfig.passwordEncoder().encode("tinman"));

    }

}
