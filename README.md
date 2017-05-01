# MongoDB-SP-Exercise
#### The program is a small application that executed commands to the MongoDB. It has a method for importing dataset of Twitter tweets from the CSV file into database.

####The project was done using Java language. Program calls the mongo binary and executes the javascript queries as commands from the terminal and prints out the following results.

#### Question 1:
How many Twitter users are in our database?
```
659774
```
#### Question 2:
Which Twitter users link the most to other Twitter users? (Provide the top 10)
```
{ "_id" : "lost_dog", "count" : 549 }
{ "_id" : "tweetpet", "count" : 310 }
{ "_id" : "VioletsCRUK", "count" : 251 }
{ "_id" : "what_bugs_u", "count" : 246 }
{ "_id" : "tsarnick", "count" : 245 }
{ "_id" : "SallytheShizzle", "count" : 229 }
{ "_id" : "mcraddictal", "count" : 217 }
{ "_id" : "Karen230683", "count" : 216 }
{ "_id" : "keza34", "count" : 211 }
{ "_id" : "TraceyHewins", "count" : 202 }
```
The `count` shows how many times user linked (using the @ sign ) to other users.

#### Question 3:
Who are the most mentioned Twitter users? (Provide the top 5)
```
{ "_id" : "WallTweet", "tweets" : 34 }
{ "_id" : "Anime81", "tweets" : 20 }
{ "_id" : "Jinxie_G", "tweets" : 16 }
{ "_id" : "CateP36", "tweets" : 15 }
{ "_id" : "MiDesfileNegro", "tweets" : 15 }
```
The `count` in this case shows how many times the user was mentioned by other users

#### Question 4:
Who are the most active Twitter users? (Provide the top 10)
```
{ "_id" : "lost_dog", "count" : 549 }
{ "_id" : "webwoke", "count" : 345 }
{ "_id" : "tweetpet", "count" : 310 }
{ "_id" : "SallytheShizzle", "count" : 281 }
{ "_id" : "VioletsCRUK", "count" : 279 }
{ "_id" : "mcraddictal", "count" : 276 }
{ "_id" : "tsarnick", "count" : 248 }
{ "_id" : "what_bugs_u", "count" : 246 }
{ "_id" : "Karen230683", "count" : 238 }
{ "_id" : "DarkPiano", "count" : 236 }
```
The `count` counts all the user's posts they've written.

#### Question 5 (grumpy):
Who are the five most grumpy (most negative tweets)?
```
{ "_id" : "lost_dog", "count" : 549 }
{ "_id" : "tweetpet", "count" : 310 }
{ "_id" : "webwoke", "count" : 264 }
{ "_id" : "wowlew", "count" : 210 }
{ "_id" : "mcraddictal", "count" : 210 }
```
The `count` shows the amount of the tweets that were negative. (polarity: 0)

** looks like all the posts of the user `lost_dog` were grumpy... (549/549)

#### Question 5 (happy):
Who are the five most happy (most positive tweets)?
```
{ "_id" : "what_bugs_u", "count" : 246 }
{ "_id" : "DarkPiano", "count" : 231 }
{ "_id" : "VioletsCRUK", "count" : 218 }
{ "_id" : "tsarnick", "count" : 212 }
{ "_id" : "keza34", "count" : 211 }
```
The `count` shows the amount of the tweets that were positive. (polarity: 4)


### You can test it yourself.
##### Clone a project and go to `target/classes` dir. There execute a command `java Main`. You must have all the data setup in the db first though.