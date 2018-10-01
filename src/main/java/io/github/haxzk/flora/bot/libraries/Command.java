package io.github.haxzk.flora.bot.libraries;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;


/*
Library feita por: Fabrício | Haxzk#2388
*/
public abstract class Command extends ListenerAdapter {

    public abstract char getPrefix();
    public abstract String getCommandName();
    public abstract List<String> getAliases();
    public abstract Permission getPermission();
    public abstract boolean canBotExecute();
    public abstract String withoutPermissionMessage(Member member);
    public abstract void execute(User user, Member member, MessageChannel channel, Guild guild, Message message);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) if (!canBotExecute()) return;
        if (event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(getPrefix() + getCommandName()) || getAliases().contains(event.getMessage().getContentRaw().split(" ")[0].equalsIgnoreCase(getPrefix() + getCommandName()))) {
            if (event.getMember().hasPermission(getPermission())) {
                execute(event.getAuthor(), event.getMember(), event.getChannel(), event.getGuild(), event.getMessage());
                return;
            } else {
                event.getChannel().sendMessage(withoutPermissionMessage(event.getMember())).queue();
            }
        }
    }
}
