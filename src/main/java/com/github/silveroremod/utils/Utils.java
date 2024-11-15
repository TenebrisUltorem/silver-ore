package com.github.silveroremod.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Zombie;

import java.util.List;

public class Utils {
    private Utils() {}

    private static final List<Class<? extends PathfinderMob>> UNDEAD_CREATURE_CLASSES = List.of(
            AbstractSkeleton.class,
            SkeletonHorse.class,
            Zombie.class,
            ZombieHorse.class
    );

    public static boolean isUndead(Entity entity) {
        return UNDEAD_CREATURE_CLASSES.stream().anyMatch((mobClass) -> mobClass.isInstance(entity));
    }

}
