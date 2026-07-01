public class InterviewBot {
    String botName;
    String technology;

    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println(botName + " is conducting an interview for " + technology + ".");
    }

    public static void main(String[] args) {
        InterviewBot bot1 = new InterviewBot("BotA", "Java");
        InterviewBot bot2 = new InterviewBot("BotB", "Python");
        InterviewBot bot3 = new InterviewBot("BotC", "Machine Learning");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}
