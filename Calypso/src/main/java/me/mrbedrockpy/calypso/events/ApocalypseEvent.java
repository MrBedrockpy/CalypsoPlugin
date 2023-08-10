package me.mrbedrockpy.calypso.events;

import me.mrbedrockpy.calypso.Calypso;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ApocalypseEvent implements Listener {

    public Random random = new Random();

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
        LivingEntity entity = event.getEntity();
        if (Calypso.onApocalypseEvent) {
            if (event.getEntity() instanceof Zombie || event.getEntity() instanceof Skeleton) {

                if (random.nextInt(10) + 1 != 10) {
                    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.IRON_BOOTS);

                    entity.getEquipment().setHelmet(helmet);
                    entity.getEquipment().setChestplate(chestplate);
                    entity.getEquipment().setLeggings(leggings);
                    entity.getEquipment().setBoots(boots);
                } else {
                    ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);

                    entity.getEquipment().setHelmet(helmet);
                    entity.getEquipment().setChestplate(chestplate);
                    entity.getEquipment().setLeggings(leggings);
                    entity.getEquipment().setBoots(boots);
                }
            }
            if (entity instanceof Creeper) {
                Creeper creeper = (Creeper) entity;
                Location location = creeper.getLocation();
                World world = location.getWorld();
                world.strikeLightningEffect(location);
                creeper.setPowered(true);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (Calypso.onApocalypseEvent) {
            Player player = event.getEntity();
            Location location = player.getLocation();
            World world = location.getWorld();
            world.strikeLightningEffect(location);
        }
    }


}
