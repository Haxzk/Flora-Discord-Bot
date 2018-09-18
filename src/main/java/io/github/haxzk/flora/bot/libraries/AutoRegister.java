package io.github.haxzk.flora.bot.libraries;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

/*
Library feita por: Fabrício | Haxzk#2388
*/

public class AutoRegister {

    private Reflections reflections;
    private Set<Class<? extends Command>> commandClassSet;
    private Set<Class<? extends ListenerAdapter>> listenerClassSet;
    private Set<Class<?>> classSet;

    public AutoRegister(String pack) {
        reflections = new Reflections(pack);
        commandClassSet = reflections.getSubTypesOf(Command.class);
        listenerClassSet = reflections.getSubTypesOf(ListenerAdapter.class);
        classSet = new HashSet<Class<?>>();
        classSet.addAll(commandClassSet);
        classSet.addAll(listenerClassSet);
    }

    public Set<Class<? extends Command>> getCommandClass() {
        return this.commandClassSet;
    }

    public Set<Class<? extends ListenerAdapter>> getListenerClass() {
        return this.listenerClassSet;
    }
    
    public Set<Class<?>> getAllClass() {
        return classSet;
    }
}
