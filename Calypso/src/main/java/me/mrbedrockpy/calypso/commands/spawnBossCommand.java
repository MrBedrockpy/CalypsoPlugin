package me.mrbedrockpy.calypso.commands;

import me.mrbedrockpy.calypso.Calypso;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class spawnBossCommand implements CommandExecutor {

    public Zombie bossZombie;

    public Zombie spawnBossZombie(Location location) {
        //босс зомби
        bossZombie = (Zombie) location.getWorld().spawnEntity(location, EntityType.ZOMBIE);

        //параметры
        bossZombie.setCustomName("Boss Zombie");
        bossZombie.setCustomNameVisible(true);
        bossZombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 20));
        bossZombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
        bossZombie.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 45));

        //зачарования на броню и меч
        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        helmet.addEnchantment(Enchantment.THORNS, 3);

        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        chestplate.addEnchantment(Enchantment.THORNS, 3);

        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        leggings.addEnchantment(Enchantment.THORNS, 3);

        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        boots.addEnchantment(Enchantment.THORNS, 3);

        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        sword.addEnchantment(Enchantment.KNOCKBACK, 2);

        bossZombie.getEquipment().setHelmet(helmet);
        bossZombie.getEquipment().setChestplate(chestplate);
        bossZombie.getEquipment().setLeggings(leggings);
        bossZombie.getEquipment().setBoots(boots);
        bossZombie.getEquipment().setItemInMainHand(sword);

        return bossZombie;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.isOp()) {

            if (!(Calypso.onBossEvent)) {

                if (Calypso.onEnderEvents()) {
                    commandSender.sendMessage("Два ивента запускать нельзя!");
                    return true;
                }

                Calypso.onBossEvent = true;
                commandSender.sendMessage("Ивент запущен. Босс вызывается!");

                World world = commandSender.getServer().getWorld("world");

                double x, y, z;

                x = -480;
                y = 66;
                z = 2450;

                Location location = new Location(world, x, y, z);

                Zombie boss = spawnBossZombie(location);



            } else {
                Calypso.onBossEvent = false;
                commandSender.sendMessage("Аварийное выключение Босса");

            }
            return true;

        }
        return false;
    }
}
