package io.github.haxzk.flora.bot.commands;

import io.github.haxzk.flora.bot.libraries.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.util.Arrays;
import java.util.List;

public class ShipCommand extends Command {

    public char getPrefix() {
        return '$';
    }

    public String getCommandName() {
        return "ship";
    }

    public List<String> getAliases() {
        return Arrays.asList("shippar");
    }

    public Permission getPermission() {
        return Permission.UNKNOWN;
    }

    public boolean canBotExecute() {
        return false;
    }

    public String withoutPermissionMessage(Member member) {
        return "Hey! " + member.getAsMention() + "";
    }

    public void execute(User user, Member member, MessageChannel channel, Guild guild, Message message) {

    }
}
