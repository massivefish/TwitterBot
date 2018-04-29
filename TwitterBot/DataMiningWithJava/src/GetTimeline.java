import twitter4j.*;
        import java.util.*;
        import twitter4j.conf.ConfigurationBuilder;
        import twitter4j.Status;
        import twitter4j.Twitter;
        import twitter4j.TwitterException;
        import twitter4j.TwitterFactory;
        import java.util.List;

/**
 * Created by nkol7066 on 5/19/2017.
 */

public class GetTimeline {
    public static void main(String[] args) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("gT7LPPBgNdppb9F5qdMQ0g1FJ")
                .setOAuthConsumerSecret("Pb3Y4eJLrAmKi5TAxiKGmOYVDxqrU1lrURfJu9YBTdXf6rr18Z")
                .setOAuthAccessToken("2821115575-JqrDudlbJCg8aiaD1Y8mmSnhGHHL5m96Sh4ZpFU")
                .setOAuthAccessTokenSecret("sdUJrr5FCFnxl9FVnS1aebzXfqMvXScsJyx3gCs9NjHKX");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = null;
        String user = null;
        if (args.length == 1) {
            user = args[0];
        }
        try {
            statuses = twitter.getUserTimeline(user);
            Paging page = new Paging(1, 1000);//page number, number per page
            statuses = twitter.getUserTimeline(user, page);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
        List<String> list = new ArrayList<String>();
        for (Status status : statuses) {
            System.out.println(status.getText());
        }
    }
}