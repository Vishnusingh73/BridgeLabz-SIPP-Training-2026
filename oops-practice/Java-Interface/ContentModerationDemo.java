interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text moderation checks for offensive content.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restricted = {"spam", "scam", "offensive"};
        if (post == null) {
            return false;
        }
        String lower = post.toLowerCase();
        for (String word : restricted) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam detection checks posts for repeated or unwanted content.");
    }
}

public class ContentModerator implements TextModeration, SpamDetection {
    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(String post) {
        if (post == null) {
            return false;
        }
        String lower = post.toLowerCase();
        return lower.contains("buy now") || lower.contains("click here") || lower.contains("free offer");
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static void main(String[] args) {
        String[] posts = {
            "Buy now and save big!",
            "This is a normal post about programming.",
            "This message contains offensive language.",
            "Click here for a free offer!"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();
        System.out.println();

        for (String post : posts) {
            if (moderator.isSpam(post)) {
                System.out.println("Spam post: " + post);
            } else if (moderator.isOffensive(post)) {
                System.out.println("Offensive post: " + post);
            } else {
                System.out.println("Valid post: " + post);
            }
        }
    }
}
