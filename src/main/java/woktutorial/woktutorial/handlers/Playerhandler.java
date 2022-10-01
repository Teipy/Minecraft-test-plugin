package woktutorial.woktutorial.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import woktutorial.woktutorial.WOKTutorial;
import woktutorial.woktutorial.util.DelayedTask;

public class Playerhandler implements Listener {
    public Playerhandler(WOKTutorial plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.GRASS, 10);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("심영이");
        item.setItemMeta(meta);

        inv.addItem(item);
        inv.setItem(8, item);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof  Player && event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
            return;
        }

        Player player = (Player) event.getEntity();
        DelayedTask task = new DelayedTask(() -> {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
        }, 20 * 5);

        Bukkit.getScheduler().cancelTask(task.getId());
    }
}
