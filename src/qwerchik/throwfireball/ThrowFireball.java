package qwerchik.throwfireball;

import org.bukkit.plugin.java.JavaPlugin;

public final class ThrowFireball extends JavaPlugin {
    //hah

    public TFListener listener = new TFListener();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        return;
    }

}
