package woktutorial.woktutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import woktutorial.woktutorial.command.Fly;
import woktutorial.woktutorial.command.Menu;
import woktutorial.woktutorial.handlers.Playerhandler;
import woktutorial.woktutorial.handlers.TorchHandler;
import woktutorial.woktutorial.util.ConfigUtil;
import woktutorial.woktutorial.util.DelayedTask;

import java.util.List;
import java.util.Objects;

public final class WOKTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Hello World");

        saveDefaultConfig();
        // other
        List<String> kitItems = (List<String>) getConfig().getList("kit");
        for (String itemname : kitItems) {
            Bukkit.getLogger().info(itemname);
        }

        ConfigUtil config = new ConfigUtil(this, "test.yml");
        config.getConfig().set("hello", "world");
        config.save();

        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));

        new TorchHandler(this);
        new Playerhandler(this);
        new DelayedTask(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Shutting down");
    }
}
