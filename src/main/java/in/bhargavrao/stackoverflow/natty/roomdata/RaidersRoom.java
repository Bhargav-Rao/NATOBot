package in.bhargavrao.stackoverflow.natty.roomdata;

import in.bhargavrao.stackoverflow.natty.commandlists.TemporaryRoomCommandsList;
import in.bhargavrao.stackoverflow.natty.printers.PostPrinter;
import in.bhargavrao.stackoverflow.natty.printers.RaidersRoomPostPrinter;
import in.bhargavrao.stackoverflow.natty.services.ReplyHandlerService;
import in.bhargavrao.stackoverflow.natty.services.RunnerService;
import in.bhargavrao.stackoverflow.natty.utils.enums.Site;
import in.bhargavrao.stackoverflow.natty.validators.AllowAllAnswersValidator;
import in.bhargavrao.stackoverflow.natty.validators.Validator;
import org.sobotics.chatexchange.chat.ChatHost;
import org.sobotics.chatexchange.chat.Room;
import org.sobotics.chatexchange.chat.event.MessageReplyEvent;
import org.sobotics.chatexchange.chat.event.UserMentionedEvent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by bhargav.h on 28-Feb-17.
 */
public class RaidersRoom implements BotRoom{
    @Override
    public int getRoomId() {
        return 3877;
    }

    @Override
    public Consumer<UserMentionedEvent> getMention(Room room, RunnerService service) {
        return event->new TemporaryRoomCommandsList().mention(room, event,service, getSiteName(), getSiteUrl(), true);
    }

    @Override
    public Consumer<MessageReplyEvent> getReply(Room room) {
        return event->new ReplyHandlerService().reply(room,event,getSiteName(),getSiteUrl(),true);
    }

    @Override
    public Validator getValidator() {
        return new AllowAllAnswersValidator();
    }

    @Override
    public double getNaaValue() {
        return 3.0;
    }

    @Override
    public PostPrinter getPostPrinter() {
        return new RaidersRoomPostPrinter();
    }

    @Override
    public boolean getIsLogged() {
        return true;
    }

    @Override
    public ChatHost getHost() {
        return ChatHost.STACK_EXCHANGE;
    }

    @Override
    public List<Site> getSiteList() {
        return Arrays.asList(Site.ASK_UBUNTU);
    }

    @Override
    public String getSiteName() {
        return "askubuntu";
    }

    @Override
    public String getSiteUrl() {
        return "askubuntu.com";
    }

}
