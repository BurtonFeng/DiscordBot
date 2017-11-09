package Discord.Bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter {
	private static JDA jda;
	private final static String token = "Mzc4MDMyMzQ0MTMwMzg3OTcw.DOZwng.QM-Jzse-fLQHU1DEvwkUFt4gFKs";
    public static void main(String[] args) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
    	jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
    	jda.addEventListener(new App());
    	
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
    	Message msg = e.getMessage();
    	MessageChannel chn = e.getChannel();
    	User usr = e.getAuthor();
    	
    	if(msg.getContent().equals("hello"))
    		chn.sendMessage("Hello, " + usr.getAsMention() + "!").queue();
    }
}
