package qwerchik.throwfireball;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class TFListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void fireball(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().getTypeId() == 0x181) {
                if (player.getGameMode() != GameMode.CREATIVE) {
                    //Decrease amount of fireballs in inventory
                }
                player.launchProjectile(SmallFireball.class);
                player.playSound(player.getEyeLocation(), Sound.FIRE_IGNITE, 1, 1);
            }
        }
    }

    //Special for our server's players
    @EventHandler(priority = EventPriority.LOW)
    public void playerLogin(PlayerLoginEvent event) {
        String name = event.getPlayer().getName();
        if (name.equalsIgnoreCase("qwerchik")) event.getPlayer().setDisplayName("Евгений");
        else if (name.equalsIgnoreCase("alex")) event.getPlayer().setDisplayName("Алексей");
        else if (name.equalsIgnoreCase("Me")) event.getPlayer().setDisplayName("Серафим");
        else if (name.equalsIgnoreCase("Slevin")) event.getPlayer().setDisplayName("Антон");
        else if (name.equalsIgnoreCase("NightHunTerC")) event.getPlayer().setDisplayName("Тузик");
        else if (name.equalsIgnoreCase("ferkus")) event.getPlayer().setDisplayName("Влад");
        else if (name.equalsIgnoreCase("Smog")) event.getPlayer().setDisplayName("Пиздюк");
    }

    //Special for my friend Anton Sidorov (Slevin)
    @EventHandler(priority = EventPriority.LOW)
    public void slevinDeath(PlayerDeathEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getName().equalsIgnoreCase("Slevin"))
            event.setDeathMessage(ChatColor.WHITE + "ПОТРАЧЕНО");
    }

}
