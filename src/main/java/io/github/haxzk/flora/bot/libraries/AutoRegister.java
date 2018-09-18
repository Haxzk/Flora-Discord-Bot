package io.github.haxzk.flora.bot.libraries;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.Set;

public class AutoRegister {

    private Reflections reflections;
    private Set<Class<? extends Command>> commandClassSet;
    private Set<Class<? extends ListenerAdapter>> listenerClassSet;

    public AutoRegister(String pack) {
        reflections = new Reflections(pack);
        commandClassSet = reflections.getSubTypesOf(Command.class);
        listenerClassSet = reflections.getSubTypesOf(ListenerAdapter.class);
    }

    public Set<Class<? extends Command>> getCommandClass() {
        return commandClassSet;
    }

    public Set<Class<? extends ListenerAdapter>> getListenerClass() {
        return listenerClassSet;
    }
}
