package ru.ps.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.ps.converter.Converter;

import java.text.DecimalFormat;

/**
 * @author Pavel Sozonov
 * @since 27.02.2018
 */
@Component
public class SimpleTelegramInformerBot extends TelegramLongPollingBot {

    private final static Logger log = LoggerFactory.getLogger(SimpleTelegramInformerBot.class);

    @Value("${bot.username}")
    private String botUserName;

    @Value("${bot.token}")
    private String botToken;

    @Value("${balance.btc}")
    private String balance;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            sendReplyMessage(update);
        } else {
            showWarning("Warning: Update without text", update);
        }
    }

    public String getBotUsername() {
        return botUserName;
    }

    public String getBotToken() {
        return botToken;
    }

    private void sendReplyMessage(Update update) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        Double btcToRub = Converter.btcToRub(Double.parseDouble(balance));
        String replyMessage = balance + " btc = " + formatter.format(btcToRub) + " rub";
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId())
                .enableMarkdown(true)
                .setText(replyMessage);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Send reply message error", e);
        }
    }

    private void showWarning(String text, Update update) {
        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId())
                .enableMarkdown(true)
                .setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error sending warning", e);
        }
    }
}
