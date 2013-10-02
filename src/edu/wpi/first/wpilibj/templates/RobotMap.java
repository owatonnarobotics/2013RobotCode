package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //The drive systems for the wheels      2  JAGUAR
    public static final int FIRSTDRIVE = 9;
    public static final int SECONDDRIVE = 10;
    
    //The motor that spins the frizbee         JAGUAR
    public static final int WHEELMOTOR = 3;
    
    //The motor that tilts the shooter         JAGUAR
    public static final int TILTSHOOTER = 2;
    
    //The linear feeder motor                  Victor(ish)
    public static final int LINEARFEEDERMOTOR = 4;
    
    //The sensors                              DIGITAL
    public static final int DIGITALBACKSENSOR = 4;
    public static final int DIGITALFRONTSENSOR = 1;
    public static final int DIGITALTOPSENSOR = 6;
    public static final int DIGITALBOTTOMSENSOR = 10;
    public static final int DIGITALPOTENTIOMETER = 13;
    
    //Shooter Speed Constant
    public static final double WHEELCONSTANT = -.6;
}
