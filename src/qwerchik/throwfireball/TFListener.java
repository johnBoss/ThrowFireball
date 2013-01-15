package qwerchik.throwfireball;

import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TFListener implements Listener {

    @EventHandler
    public void fireball(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getTypeId() == 0x181) {
                SmallFireball sfb = player.getWorld().spawn(player.getLocation().add(0, 2, 0), SmallFireball.class);
                sfb.setDirection(player.getLocation().getDirection());
                player.playSound(player.getEyeLocation(), Sound.FIRE_IGNITE, 1, 1);
                player.sendMessage("fireball thrown");
            }
        }
    }

}
