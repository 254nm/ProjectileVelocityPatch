package me.txmc.projectilevelocitypatch;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author 254n_m
 * @since 2022-11-02 / 12:25 p.m.
 * This file was created as a part of ProjectileVelocityPatch
 */
public final class ProjectileVelocityPatch extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onProjectile(ProjectileLaunchEvent event) {
                if (!(event.getEntity().getShooter() instanceof Player)) return;
                Projectile projectile = event.getEntity();
                event.setCancelled(projectile.getVelocity().lengthSquared() > 10);
            }
        }, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
