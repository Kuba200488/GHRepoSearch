package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.test.runner.AndroidJUnit4;

import com.mobicubes.ghreposearch.data.network.entity.UserJson;
import com.mobicubes.ghreposearch.domain.entity.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by kuba on 10/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class UserMapperTest {

    private static final Long TEST_ID = 1234L;
    private static final String TEST_LOGIN = "login";
    private static final String TEST_AVATAR_URL = "http://test.avatar.url";

    private static UserJson.Builder provideTestJsonBuilder() {
        return UserJson.newBuilder()
                .withId(TEST_ID)
                .withLogin(TEST_LOGIN)
                .withAvatarUrl(TEST_AVATAR_URL);
    }

    @Test
    public void shouldProperlyMapJsonToDomain() {

        final UserJson userJson = provideTestJsonBuilder().build();

        final User expected = User.newBuilder()
                .withId(TEST_ID)
                .withLogin(TEST_LOGIN)
                .withAvatarUrl(TEST_AVATAR_URL)
                .build();

        assertEquals(expected, UserMapper.map(userJson));
    }

    @Test
    public void shouldThrowExceptionForLackingId() {
        final UserJson userJson = provideTestJsonBuilder()
                .withId(null)
                .build();

        try {
            UserMapper.map(userJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }

    @Test
    public void shouldThrowExceptionForLackingLogin() {
        final UserJson userJson = provideTestJsonBuilder()
                .withLogin(null)
                .build();

        try {
            UserMapper.map(userJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }

    @Test
    public void shouldThrowExceptionForEmptyLogin() {
        final UserJson userJson = provideTestJsonBuilder()
                .withLogin("")
                .build();

        try {
            UserMapper.map(userJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }
}
