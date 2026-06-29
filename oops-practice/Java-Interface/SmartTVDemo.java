interface StreamingService {
    void playMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming service subscription active.");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming service subscription active.");
    }
}

public class SmartTV implements StreamingService, GamingService {
    @Override
    public void playMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    @Override
    public void showSubscriptionDetails() {
        System.out.println("Smart TV subscription includes streaming and gaming.");
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();
        String[] movies = {"Inception", "The Matrix"};
        String[] games = {"FIFA 24", "Zelda"};

        tv.showSubscriptionDetails();
        System.out.println("Available movies:");
        for (String movie : movies) {
            tv.playMovie(movie);
        }

        System.out.println("Available games:");
        for (String game : games) {
            tv.playGame(game);
        }
    }
}
