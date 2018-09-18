package io.github.haxzk.flora.bot;

import io.github.haxzk.flora.bot.libraries.AutoRegister;
import io.github.haxzk.flora.bot.libraries.Command;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class FloraIA {

    private JDABuilder jdaBuilderObject;
    private JDA jdaObject;

    private FloraIA() {
        try {
            jdaBuilderObject = new JDABuilder(AccountType.BOT).setToken("NDkxMjUzMzAxMDc4MzkyODMz.DoG8aA.lIXdcKhicHXjX5v85HiQsX6ufPY");
            for (Class<? extends Command> c : new AutoRegister("io.github.haxzk.flora.bot").getClassToRegister()) {
                jdaBuilderObject.addEventListener(c.newInstance());
                System.out.println("Comando | Evento: " + c.getName() + " registrado! ");
            }
            jdaObject = jdaBuilderObject.build();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FloraIA();
    }

    public JDA getJdaObject() {
        return jdaObject;
    }

}
