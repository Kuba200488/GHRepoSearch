package com.mobicubes.ghreposearch.data.network;

import com.mobicubes.ghreposearch.data.network.entity.RepositoriesResponseJson;
import com.mobicubes.ghreposearch.data.network.entity.RepositoryJson;
import com.mobicubes.ghreposearch.data.network.entity.UserJson;
import com.mobicubes.ghreposearch.data.network.entity.UsersResponseJson;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kuba on 10/03/2018.
 */

public interface Service {

    @GET("search/repositories")
    Observable<RepositoriesResponseJson> searchRepositories(
            @HeaderMap Map<String, String> headers,
            @Query("q") String query
    );

    @GET("search/users")
    Observable<UsersResponseJson> searchUsers(
            @HeaderMap Map<String, String> headers,
            @Query("q") String query
    );

    @GET("users/{login}/followers")
    Observable<List<UserJson>> getFollowers(
            @Path("login") String login
    );

    @GET("users/{login}/repos")
    Observable<List<RepositoryJson>> getUserRepositories(
            @Path("login") String login
    );
}
