import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Super class for bosses, bosses are a type of enemy that you fight after finishing a certain amount of levels
 * 
 * @author Henry Ma
 * @version January 16, 2020
 */
public abstract class Boss extends Actor
{
    //Initialize variables and objects
    //Health of boss
    protected int healthPoints;
    //Animation for boss
    protected GreenfootImage[] animation = new GreenfootImage[4];
    //Keeps track if images for animation were created
    protected boolean createdImages = false;
    //Frames/acts before next image switch
    protected int frameRate = 8;
    //Keeps track of image currently on
    protected int imageNumber = 0;
    //Acts before firing
    protected int fireRate = 20;
    //Acts before big attack
    protected int bigAttackRate = 60;
    //Counter for number of acts gone by
    protected long animationCount = 0;
    //Used to find player
    protected ArrayList<Player> foundPlayers;
    protected Actor player;   
    //Health bar of the boss
    protected HealthBar healthBar;
    //Color of health bar
    protected Color green = new Color(0, 100, 0);
    /**
     * Animate by switching images
     */
    private void animate()
    {
        if(animationCount%frameRate == 0)
        {
            imageNumber = (imageNumber + 1)%(animation.length);
            setImage(animation[imageNumber]);
        } 
    }
    /**
     * All enemies must contain a method that creates the images for the animation
     */
    abstract void createImages();
    /**
     * Inflict damage dependent on the parameters given, also checks for death
     * 
     * @param damage    Amount of damage to deal
     */
    protected void getDamaged(int damage)
    {
        healthPoints -= damage;
        healthBar.update(healthPoints, green);
        if(healthPoints <= 0)
        {    
            getWorld().removeObject(healthBar);
            die();
        } 
    }
    /**
     * Remove this object from the world
     */
    private void die()
    {
        GameWorld world = (GameWorld) getWorld();
        world.updateScore(1000,1000);
        getWorld().removeObject(this);
    }
}
