package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.test.runner.AndroidJUnit4;

import com.mobicubes.ghreposearch.data.network.entity.UserJson;
import com.mobicubes.ghreposearch.data.network.entity.UsersResponseJson;
import com.mobicubes.ghreposearch.domain.entity.UserItem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kuba on 10/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class UserItemMapperTest {

    private static final Long TEST_ID = 1234L;
    private static final String TEST_LOGIN = "login";
    private static final String TEST_AVATAR_URL = "http://test.avatar.url";

    private static UserJson.Builder provideTestJsonBuilder() {
        return UserJson.newBuilder()
                .withId(TEST_ID)
                .withLogin(TEST_LOGIN)
                .withAvatarUrl(TEST_AVATAR_URL);
    }

    private static UserItem.Builder provideExpectedItemBuilder() {
        return UserItem.newBuilder()
                .withId(TEST_ID)
                .withLogin(TEST_LOGIN)
                .withAvatarUrl(TEST_AVATAR_URL);
    }

    @Test
    public void shouldProperlyMapJsonToDomain() {

        final UserJson userJson = provideTestJsonBuilder().build();

        final UserItem expected = UserItem.newBuilder()
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

    @Test
    public void shouldIgnoreInvalidItems() {
        final UsersResponseJson usersResponseJson =
                UsersResponseJson.newBuilder()
                        .withTotalCount(5L)
                        .withIncompleteResults(false)
                        .withItems(Arrays.asList(
                                provideTestJsonBuilder().build(),
                                provideTestJsonBuilder().withId(null).build(),
                                provideTestJsonBuilder().build(),
                                provideTestJsonBuilder().withLogin("").build(),
                                provideTestJsonBuilder().withLogin(null).build()
                        ))
                        .build();

        final List<UserItem> expectedList = UserMapper.mapList(usersResponseJson);

        Assert.assertArrayEquals(
                Arrays.asList(
                        provideExpectedItemBuilder().build(),
                        provideExpectedItemBuilder().build()
                ).toArray(),
                expectedList.toArray()
        );
    }
}
