import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucas
 */
public class MyAmazingBot extends TelegramLongPollingBot {
    
    /*This method must always return your Bot Token (If you don't know it, 
    you may want to talk with @BotFather). May look like:*/
    @Override
    public String getBotToken() {
        return "xxx";
    }
    
    /*This method will be called when an Update is received by your bot. 
    In this example, this method will just read messages and echo the same text:*/
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                sendMessage(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    
    //This method must always return your Bot username. May look like:
    @Override
    public String getBotUsername() {
        return "myamazingbot";
    }
    
}
