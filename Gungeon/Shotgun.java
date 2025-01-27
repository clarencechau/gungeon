import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shotgun Class - This class creates a shotgun with set characteristics and a shotgun bullet that shoots 5 pellets in different directions.
 * 
 * @author Aristos Theocharoulas 
 * @version Jan 2020
 */
public class Shotgun extends Weapon
{
    private GreenfootImage gun = new GreenfootImage("Shotgun.png");
    public Shotgun(ItemInfo itemInfo, Player player,int bulletDamage, int bulletSpeed, long fireRate, long bulletReadyTime, long reloadTime, int magSize, int ammoInMag, boolean reloadTimer)
    {
        super(itemInfo,player, bulletDamage, bulletSpeed, fireRate, bulletReadyTime, reloadTime, magSize, ammoInMag, reloadTimer);
        gun.scale(gun.getWidth()*150/100,gun.getHeight()*150/100);
        setImage(gun);
    }
    /**
     * createBullet - Creates a shotgun bullet that shoots 3 pellets in a different direction
     * 
     * @author Albert Lai
     */
    protected void createBullet(int xcoord, int ycoord)
    {
        this.mouseX = Greenfoot.getMouseInfo().getX();
        this.mouseY = Greenfoot.getMouseInfo().getY();
        double x2 = xcoord + (mouseX-xcoord)/10;
        double y2 = ycoord + (mouseY-ycoord)/10;
        double dis = Math.sqrt((xcoord-x2)*(xcoord-x2) + (ycoord-y2)*(ycoord-y2))*Math.tan(Math.PI/15); 
        if(Math.abs(ycoord - mouseY)<=9){
            if(dis>=6 && dis<=12){
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+20),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+6),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-6),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-20),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            }
            else if(dis>=12){
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+30),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+9),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-9),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-30),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            }
            else{
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+6),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2+3),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-3),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2),  (int)Math.ceil(y2-6),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            }
        }    
        else if(Math.abs(xcoord - mouseX)<=9){
            if(dis>=6 && dis<=12){
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2+20), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2+6), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2-6),  (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2-20),  (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            }
            else{
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2+6),  (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2+3), (int)Math.round(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.round(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2-3),  (int)Math.round(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
                getWorld().addObject(new ShotgunBullet((int)Math.round(x2-6),  (int)Math.ceil(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            }
        }
        else{
            double slopeperp = -(xcoord-x2)/(ycoord-y2);
            double dx = Math.sqrt(dis*dis/(1+slopeperp*slopeperp));
            double dy = slopeperp*dx;

            getWorld().addObject(new ShotgunBullet((int)Math.round(x2+2*dx), (int)Math.round(y2+2*dy),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            getWorld().addObject(new ShotgunBullet((int)Math.round(x2+dx), (int)Math.round(y2+dy),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            getWorld().addObject(new ShotgunBullet((int)Math.round(x2), (int)Math.round(y2),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            getWorld().addObject(new ShotgunBullet((int)Math.round(x2-dx),  (int)Math.round(y2-dy),bulletDamage,bulletSpeed, false),xcoord,ycoord);
            getWorld().addObject(new ShotgunBullet((int)Math.round(x2-2*dx),  (int)Math.round(y2-2*dy),bulletDamage,bulletSpeed, false),xcoord,ycoord);
        }  
    }
}
