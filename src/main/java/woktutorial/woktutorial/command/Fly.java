package woktutorial.woktutorial.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("오직 사람만 이 기능을 사용할수 있습니다.");
            return true;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("날아다니는 기능 비활성화");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("날아다니는 기능 활성화");
        }

        return true;
    }
}
