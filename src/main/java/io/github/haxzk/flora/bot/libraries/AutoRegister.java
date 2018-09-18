package io.github.haxzk.flora.bot.libraries;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.reflections.Reflections;

import java.util.Set;

public class AutoRegister {

    private Reflections reflections;
    private Set<Class<? extends Command>> commandClassSet;
    private Set<Class<? extends ListenerAdapter>> listenerClassSet;
    private Set<Class<?>> classToRegister;

    public AutoRegister(String pack) {
        this.reflections = new Reflections(pack);
        this.commandClassSet = reflections.getSubTypesOf(Command.class);
        this.listenerClassSet = reflections.getSubTypesOf(ListenerAdapter.class);
        this.classToRegister = new HashSet<>();
        this.classToRegister.add(this.commandClassSet);
        this.classToRegister.add(this.listenerClassSet);
    }

    public Set<Class<? extends Command>> getCommandClass() {
        return this.commandClassSet;
    }

    public Set<Class<? extends ListenerAdapter>> getListenerClass() {
        return this.listenerClassSet;
    }
    
    public Set<Class<?>> getClassToRegister() {
        return this.classToRegister;
    }
}
