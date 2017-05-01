import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Luke on 25/04/2017.
 */
public class Server {
//    MongoCollection<Document> collection;
//    MongoDatabase db;
    String db;

    public Server() {
//        MongoClientURI connStr = new MongoClientURI("mongodb://localhost:27017");
//        MongoClient mongoClient = new MongoClient(connStr);
//
//        db = mongoClient.getDatabase("social_net");
//        collection = db.getCollection("tweets");
        db = "social_net";
    }

    public void loadDataToMongoDB() {
        String query = "mongoimport --drop --db social_net --collection tweets --type csv --file" +
                "/Users/Luke/Downloads/trainingandtestdata/training.1600000.processed.noemoticon.csv  --headerline";
        execute(query);
    }

    /**
     * 1. How many Twitter users are in our database?
     */
    public void distinctUsers() {
//        ArrayList<BsonValue> count = collection.distinct("user", BsonValue.class).
//        filter(new Document("user", new Document("$ne", null))).
//        into(new ArrayList<BsonValue>());
//        System.out.println(count.size());
        String query = "db.tweets.distinct('user').length";
        execute(query);
    }

    /**
     * 2. Which Twitter users link the most to other Twitter users?
     */
    public void findUsersThatLink() {
        String query = "db.tweets.aggregate([\n" +
                "{ $match: { text: { $regex: /@\\S+/g } } },\n" +
                "{ $group: { _id: '$user', count: { $sum: 1 } } },\n" +
                "{ $sort: { 'count': -1 } }," +
                "{ $limit: 10 }\n" +
                "])";
        execute(query);
    }

    /**
     * 3. Who are the most mentioned Twitter users?
     */
    public void findMostMentioned() {
        String query = "db.tweets.aggregate([\n" +
                "         { $match: { text: new RegExp('@\\w+', 'ig') } },\n" +
                "         { $group: { _id: '$user', tweets: { $sum: 1 } } },\n" +
                "         { $sort: { tweets: -1 } },\n" +
                "         { $limit: 5 },\n" +
                "         ]," +
                "         { allowDiskUse: true })";
        execute(query);
    }

    /**
     * 4. Who are the most active Twitter users?
     */
    public void findMostActive() {
        String query = "db.tweets.aggregate([\n" +
                "{ $group: { _id: '$user', count: { $sum:1 } } },\n" +
                "{ $sort: { count: -1 } },\n" +
                "{ $limit: 10 }\n" +
                "])";
        execute(query);
    }

    /**
     * 5. Who are the five most grumpy (most negative tweets)?
     */
    public void findMostGrumpy() {
        String query = "db.tweets.aggregate([\n" +
                "{ $match: { polarity: 0 } },\n" +
                "{ $group: { _id: '$user', count: { $sum: 1 } } },\n" +
                "{ $sort: { count: -1 } },\n" +
                "{ $limit: 5 }\n" +
                "])";
        execute(query);
    }

    /**
     * 5. Who are the five most happy (most positive tweets)?
     */
    public void findMostHappy() {
        String query = "db.tweets.aggregate([\n" +
                "{ $match: { polarity: 4 } },\n" +
                "{ $group: { _id: '$user', count: { $sum: 1 } } },\n" +
                "{ $sort: { count: -1 } },\n" +
                "{ $limit: 5 }\n" +
                "])";
        execute(query);
    }

    private void execute(String query) {
        Runtime rt = Runtime.getRuntime();
        try {
            // run a command from terminal. this line is equivalent to
            // mongo database --eval "db.col.find()"
            // it calls the mongo binary and execute the javascript you
            // passed in eval parameter
            Process pr = rt.exec(new String[]{"mongo", db, "--eval", query});
            // read the output of the command
            InputStream in = pr.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            int countLines = 1;
            while ((line = reader.readLine()) != null) {
                if (countLines > 2) {
                    out.append("\n").append(line);
                }
                countLines++;
            }

            // print the command and close outputstream reader
             System.out.println(out.toString());
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
