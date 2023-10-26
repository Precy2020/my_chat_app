package org.precious.data.repository;
import org.junit.jupiter.api.Test;
import org.precious.data.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;


@DataMongoTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void canSave(){
        User user = new User();
        userRepository.save(user);
        assertThat(user.getId(), is(notNullValue()));

    }


}