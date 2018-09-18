package io.github.haxzk.flora.bot.commands;

import io.github.haxzk.flora.bot.libraries.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.util.Arrays;
import java.util.List;

public class Inverter extends Command {
    public char getPrefix() {
        return '+';
    }

    public String getCommandName() {
        return "inverter";
    }

    public List<String> getAliases() {
        return Arrays.asList("embaralhar");
    }

    public Permission getPermission() {
        return Permission.UNKNOWN;
    }

    public boolean canBotExecute() {
        return false;
    }

    public String withoutPermissionMessage(Member member) {
        return "";
    }

    public void execute(User user, Member member, MessageChannel channel, Guild guild, Message message) {
        String m = message.getContentRaw();
        String mN = "";
        for (int i = m.length() -1 ; i > 0; i--) {
            mN += m.charAt(i);
        }
        channel.sendMessage(mN).queue();
    }
}
