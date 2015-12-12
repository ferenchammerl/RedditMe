package com.redditme.redditservice;

import net.dean.jraw.http.NetworkException;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.models.Submission;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ferenc on 12/8/2015.
 * This interface allows us to run the entire system with a mockup reddit client (for example one that needs no internet).
 */
public interface RedditService {
    public static final String VERSION_NAME = "0.1";
    public static final String PACKAGE_NAME = "com.redditme";
    public static final UserAgent REDDITME_USERAGENT = UserAgent.of("android", PACKAGE_NAME, VERSION_NAME, "cburstarts");
    public static final Credentials USERLESS = Credentials.userlessApp("hsro81jAMJgXhw", UUID.randomUUID());

    public void authenticateUserless() throws NetworkException;

    // loader methods: here go the methods that actually access remote resources (in our case: the reddit API server). The reason for separating them is synchronizaiton.
    public void loadSubmissions();

    public void loadSubmissionById(String id);

    // getter methods: methods that make the loaded resources accessible. The reason for separating them is synchronizaiton

    public List<Submission> getCurrentSubmissions();

    public Submission getSelectedSubmission();
}
