package woktutorial.woktutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import woktutorial.woktutorial.WOKTutorial;

public class TorchHandler implements Listener {
    public TorchHandler(WOKTutorial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TORCH) {
        }
        Bukkit.getLogger().info("A Torch placed");
    }
}
