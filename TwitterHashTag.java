import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/*@author Sangam Sahai
 * This application takes a hash tag as input and lists the
 * most recent 100 tweets of that Hash Tag ,as output.
 * */


public class TwitterHashTag {

	/**
	 * @param args
	 */

	//following are the consumer key details which link this application
	//to a unique twitter account.
	private final static String CONSUMER_KEY = "93mP7cnLdw8126WfYcIvq78aR";
	private final static String CONSUMER_KEY_SECRET ="bZVfaHNyi3RhL08xE4bVfRflZ8QVcHjXUKqeB7OBn3ZQIgnejx";

	public static void main(String[] args) throws TwitterException, IOException {
		// TODO Auto-generated method stub

		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);


		String accessToken = getSavedAccessToken();
		String accessTokenSecret = getSavedAccessTokenSecret();
		AccessToken oathAccessToken = new AccessToken(accessToken,
				accessTokenSecret);

		twitter.setOAuthAccessToken(oathAccessToken);


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the Hash Tag without the Hash(#) Symbol: ");
		String hashTag = br.readLine();//getting the Hash Tag as input from the user

		if(hashTag.equals("")==true)
		{
			System.out.println("Entered string is empty !! Please enter a valid string.");
			System.exit(0);
		}

		Query query = new Query(hashTag);
		query.count(100);//setting the count as 100 
		QueryResult result = twitter.search(query);//getting the results for the entered Hash Tag

		//In case the result is empty
		if(result.getTweets().isEmpty()==true)
		{
			System.out.println("The Hash Tag entered is wrong !!");
			System.exit(0);
		}
		List<Status> statusList=result.getTweets();

		System.out.println("The top 100 tweets for the Hash Tag  "+hashTag+" are as follows- ");
		for(int i=0;i<100;i++)
		{
			if(i<(statusList.size()))
			{
				Status status=statusList.get(i);

				if(status!=null)
				{
					System.out.println("\n\n Following is tweet number "+(i+1)+"\n");

					System.out.println("@" + status.getUser().getName() + " : " + status.getText() );
				}
			}
		}


	}//end of function  main

	private static  String getSavedAccessTokenSecret() {
		// this is method to get your previously saved  Secret Access Token
		return "GNEGvKAQCD2uJAyA8taJgj8cLddigOijsazDY41xO3f69";
	}

	private static String getSavedAccessToken() {
		// consider this is method to get your previously saved Access Token
		return "2996985029-6aYMXY4rNquxWC3xfwSGJ5ieKZTEEySXowCWmz9";
	}

}
