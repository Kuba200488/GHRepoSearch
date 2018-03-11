package com.mobicubes.ghreposearch.data.network.mapper;

import android.support.test.runner.AndroidJUnit4;

import com.mobicubes.ghreposearch.data.network.entity.RepositoriesResponseJson;
import com.mobicubes.ghreposearch.data.network.entity.RepositoryJson;
import com.mobicubes.ghreposearch.domain.entity.RepositoryItem;

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
public final class RepositoryMapperTest {

    private static final Long TEST_ID = 1234L;
    private static final String TEST_NAME = "Name";
    private static final String TEST_DESCRIPTION = "Test description";

    private static RepositoryJson.Builder provideTestJsonBuilder() {
        return RepositoryJson.newBuilder()
                .withId(TEST_ID)
                .withName(TEST_NAME)
                .withDescription(TEST_DESCRIPTION);
    }

    private static RepositoryItem.Builder provideExpectedItemBuilder() {
        return RepositoryItem.newBuilder()
                .withId(TEST_ID)
                .withName(TEST_NAME)
                .withDescription(TEST_DESCRIPTION);
    }

    @Test
    public void shouldProperlyMapJsonToDomain() {

        final RepositoryJson repositoryJson = provideTestJsonBuilder().build();

        final RepositoryItem expected = RepositoryItem.newBuilder()
                .withId(TEST_ID)
                .withName(TEST_NAME)
                .withDescription(TEST_DESCRIPTION)
                .build();

        assertEquals(expected, RepositoryMapper.map(repositoryJson));
    }

    @Test
    public void shouldThrowExceptionForLackingId() {
        final RepositoryJson repositoryJson = provideTestJsonBuilder()
                .withId(null)
                .build();

        try {
            RepositoryMapper.map(repositoryJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }

    @Test
    public void shouldThrowExceptionForLackingName() {
        final RepositoryJson repositoryJson = provideTestJsonBuilder()
                .withName(null)
                .build();

        try {
            RepositoryMapper.map(repositoryJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }

    @Test
    public void shouldThrowExceptionForEmptyName() {
        final RepositoryJson repositoryJson = provideTestJsonBuilder()
                .withName("")
                .build();

        try {
            RepositoryMapper.map(repositoryJson);
            Assert.fail("Should throw proper exception");
        } catch (RuntimeException e) {
            // success
        }
    }

    @Test
    public void shouldIgnoreInvalidItems() {
        final RepositoriesResponseJson repositoriesResponseJson =
                RepositoriesResponseJson.newBuilder()
                        .withTotalCount(5L)
                        .withIncompleteResults(false)
                        .withItems(Arrays.asList(
                                provideTestJsonBuilder().build(),
                                provideTestJsonBuilder().withId(null).build(),
                                provideTestJsonBuilder().build(),
                                provideTestJsonBuilder().withName("").build(),
                                provideTestJsonBuilder().withName(null).build()
                        ))
                        .build();

        final List<RepositoryItem> expectedList = RepositoryMapper.mapList(repositoriesResponseJson);

        Assert.assertArrayEquals(
                Arrays.asList(
                        provideExpectedItemBuilder().build(),
                        provideExpectedItemBuilder().build()
                ).toArray(),
                expectedList.toArray()
        );
    }
}
