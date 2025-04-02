package fun.lewisdev.deluxehub.action.actions;

import fun.lewisdev.deluxehub.DeluxeHubPlugin;
import fun.lewisdev.deluxehub.action.Action;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.entity.Player;

public class SoundAction implements Action {

	@Override
	public String getIdentifier() {
		return "SOUND";
	}

	@Override
	public void execute(DeluxeHubPlugin plugin, Player player, String data) {
		try {
			String soundName = data.toUpperCase().replace(".", "_");

			// Try, to get the Sound
			Object sound;
			try {
				sound = Enum.valueOf((Class<Enum>) Class.forName("org.bukkit.Sound"), soundName);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Bukkit Sound class not found!", e);
			}

			player.playSound(player.getLocation(), (org.bukkit.Sound) sound, 1.0F, 1.0F);
		} catch (Exception ex) {
			Bukkit.getLogger().warning("[DeluxeHub Action] Invalid sound name: " + data.toUpperCase());
		}
	}
}
