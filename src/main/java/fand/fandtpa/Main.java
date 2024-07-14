package fand.fandtpa;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getLogger().info(translateColorCodes("&a插件正在启用..."));

            this.getCommand("suicide").setExecutor(new SuicideCommand(this));

            // 注册事件监听器
            Bukkit.getPluginManager().registerEvents(this, this);
            getServer().getPluginManager().registerEvents(new AcceleratedFurnaceListener(this), this);


            getLogger().info(translateColorCodes("&a插件启用成功！"));
    }

    @Override
    public void onDisable() {
        getLogger().info(translateColorCodes("&a插件正在禁用..."));
        getLogger().info(translateColorCodes("&a插件已禁用"));
    }



    private String translateColorCodes(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }


    public class SuicideCommand implements CommandExecutor {

        private final JavaPlugin plugin;

        public SuicideCommand(JavaPlugin plugin) {
            this.plugin = plugin;
        }

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(0); // 设置玩家的生命值为0，导致自杀
                player.sendMessage("你已经自杀了！");
            } else {
                sender.sendMessage("只有玩家才能使用这个命令！");
            }
            return true;
        }
    }


    public class AcceleratedFurnaceListener implements Listener {

        private final JavaPlugin plugin;

        public AcceleratedFurnaceListener(JavaPlugin plugin) {
            this.plugin = plugin;
        }
    }
}
