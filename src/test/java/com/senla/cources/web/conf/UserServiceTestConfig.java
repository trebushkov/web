package com.senla.cources.web.conf;

import com.senla.cources.web.domain.User;
import com.senla.cources.web.repository.UserRepository;
import com.senla.cources.web.service.UserService;
import com.senla.cources.web.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Configuration
public class UserServiceTestConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepository() {
            @Override
            public Optional<User> findByUsername(String username) {
                return Optional.empty();
            }

            @Override
            public List<User> findAll() {
                return null;
            }

            @Override
            public List<User> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<User> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends User> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends User> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<User> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public User getOne(Integer integer) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<User> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> S save(S s) {
                return null;
            }

            @Override
            public Optional<User> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(User user) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends User> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends User> boolean exists(Example<S> example) {
                return false;
            }
        };
    }

}
