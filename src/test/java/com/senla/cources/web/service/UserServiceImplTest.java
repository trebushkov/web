package com.senla.cources.web.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import eu.senla.orelregion.model.domain.User;
import eu.senla.orelregion.model.exception.BadDataException;
import eu.senla.orelregion.repository.UserRepository;
import eu.senla.orelregion.repository.UserStatusRepository;
import eu.senla.orelregion.service.configuration.TestApplicationProperties;
import eu.senla.orelregion.service.configuration.TestDatabaseConfiguration;
import eu.senla.orelregion.service.mail.EmailService;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestApplicationProperties.class, TestDatabaseConfiguration.class})
@DataJpaTest
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserStatusRepository userStatusRepository;

    @Mock
    private MessageSource messageSource;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private UserServiceImpl userService;

    private User createUser(String email) {
        User user = new User();
        user.setEmail(email);
        return user;
    }

    private User createUser(String email, String token) {
        User user = new User();
        user.setEmail(email);
        user.setActivationKey(token);
        return user;
    }

    @Test
    public void whenRegisterUserThenEmailWasSent() {
        val user1 = createUser("vasily@rr.ru");

        doNothing().when(emailService).sendRegisterMessage(anyString(), anyString(), any());
        given(userRepository.findByEmail("dmitry@rr.ru")).willReturn(Optional.of(user1));

        userService.registerUser(user1, Locale.getDefault());

        verify(userRepository).save(user1);
        verify(emailService).sendRegisterMessage(anyString(), anyString(), any());
    }

    @Test(expected = BadDataException.class)
    public void whenRegisterUserThenThrowBadDataException() {
        val user1 = createUser("vasily@rr.ru");

        doNothing().when(emailService).sendRegisterMessage(anyString(), anyString(), any());
        given(userRepository.findByEmail("vasily@rr.ru")).willReturn(Optional.of(user1));

        userService.registerUser(user1, Locale.getDefault());
    }

    @Test
    public void whenUserIsActivateThenOk() {
        String token = "1111";
        val user = createUser("ee", token);

        given(userRepository.findByActivationKey(token)).willReturn(Optional.of(user));

        userService.activateAccount(token);

        Assert.assertNull(user.getActivationKey());
        verify(userRepository).save(user);

    }

    @Test(expected = BadDataException.class)
    public void whenUserIsActivateThenThrowBadDataException() {
        String token = "1111";
        val user = createUser("ee", "1111");

        given(userRepository.findByActivationKey(token)).willReturn(Optional.of(user));

        userService.activateAccount("1112");
    }

}