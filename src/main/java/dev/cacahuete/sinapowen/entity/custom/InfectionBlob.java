package dev.cacahuete.sinapowen.entity.custom;

import dev.cacahuete.sinapowen.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;

public class InfectionBlob extends Monster implements IAnimatable {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(InfectionBlob.class, EntityDataSerializers.BYTE);
    private AnimationFactory factory = new AnimationFactory(this);

    public InfectionBlob(EntityType<? extends InfectionBlob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes()
    {
        return InfectionBlob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_SPEED,  1.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.15f)
                .build();
    }

    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new FleeSunGoal(this, 1f));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new InfectionBlobAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        // The infection blob should attack the spider but not the mutant spider
        // So we use a predicate to do this
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, Spider.class,
                1, true, true, (entity) -> !(entity instanceof MutantSpider)));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if(event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.infection_blob.walk", true ));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.infection_blob.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void killed(ServerLevel level, LivingEntity entity) {
        if (!(entity instanceof Spider spider)) return;

        spider.convertTo(ModEntityTypes.MUTANT_SPIDER.get(), false);
        level.levelEvent((Player)null, 1026, this.blockPosition(), 0);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    protected void playStepSound(BlockPos pos, BlockState BlockIn) {
        this.playSound(SoundEvents.SLIME_SQUISH, 0.15f, 1.0f);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SLIME_SQUISH;
    }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SLIME_HURT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.SLIME_DEATH;
    }
    protected float getSoundVolume() {
        return 0.2f;
    }

    static class InfectionBlobAttackGoal extends MeleeAttackGoal {
        public InfectionBlobAttackGoal(InfectionBlob p_33822_) {
            super(p_33822_, 1.0D, true);
        }

        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }

        protected double getAttackReachSqr(LivingEntity p_33825_) {
            return (double)(4.0F + p_33825_.getBbWidth());
        }
    }
}





