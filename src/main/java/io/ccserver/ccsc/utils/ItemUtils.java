package io.ccserver.ccsc.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JJOL on 15/08/2015.
 */
public class ItemUtils {

    public ItemStack getItemStack(Material material, int amount, String name, String[] lore, short data) {
        return getItemStack(material, amount, name, Arrays.asList(lore), data);
    }
    public ItemStack getItemStack(Material material, int amount, String name, List<String> lore, short data) {
        ItemStack itemStack = new ItemStack(material, amount, data);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static class ItemStackBuilder {

        private ItemStack is;

        public ItemStackBuilder(Material material) {
            is = new ItemStack(material);
        }
        public ItemStackBuilder(ItemStack itemStack) {
            is = itemStack;
        }

        public ItemStackBuilder amount(final int amount) {
            is.setAmount(amount);
            return this;
        }

        public ItemStackBuilder type(Material material) {
            is.setType(material);
            return this;
        }

        public ItemStackBuilder name(final String name) {
            final ItemMeta im = is.getItemMeta();
            im.setDisplayName(name);
            is.setItemMeta(im);
            return this;
        }

        public ItemStackBuilder durability(final int durability) {
            is.setDurability((short) durability);
            return this;
        }

        public ItemStackBuilder lore(String lore) {
            final ItemMeta im = is.getItemMeta();
            List<String> lores = im.getLore();
            if(lores == null) {
                lores = new ArrayList<>();
            }
            lores.add(BukkitUtils.color(lore));
            im.setLore(lores);
            is.setItemMeta(im);

            return this;
        }

        public ItemStackBuilder lore(String... lores) {
            final ItemMeta meta = is.getItemMeta();
            meta.setLore(Arrays.asList(lores));
            is.setItemMeta(meta);
            return this;
        }

        public ItemStackBuilder lore(List<String> lore) {
            final ItemMeta meta = is.getItemMeta();
            meta.setLore(lore);
            is.setItemMeta(meta);
            return this;
        }

        public ItemStackBuilder enchantment(final Enchantment enchantment, final int level) {
            is.addUnsafeEnchantment(enchantment, level);
            return this;
        }

        public ItemStackBuilder enchantment(final Enchantment enchantment) {
            is.addUnsafeEnchantment(enchantment, 1);
            return this;
        }

        @SuppressWarnings("deprecation")
        public ItemStackBuilder data(final int data) {
            is.setData(new MaterialData(is.getType(), (byte) data));
            return this;
        }

        public ItemStackBuilder clearLore() {
            final ItemMeta meta = is.getItemMeta();
            meta.setLore(new ArrayList<String>());
            is.setItemMeta(meta);
            return this;
        }

        public ItemStackBuilder clearEnchantments() {
            for (Enchantment e : is.getEnchantments().keySet()) {
                is.removeEnchantment(e);
            }
            return this;
        }

        public ItemStackBuilder color(Color color) {
            if(is.getType() == Material.LEATHER_BOOTS || is.getType() == Material.LEATHER_HELMET
                || is.getType() == Material.LEATHER_CHESTPLATE || is.getType() == Material.LEATHER_LEGGINGS) {

                LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta();
                meta.setColor(color);
                is.setItemMeta(meta);

            } else {
                throw new IllegalArgumentException("Color is only applicable to leather armor");
            }
            return this;
        }


        public ItemStack build() {
            return is;
        }

    }

}
