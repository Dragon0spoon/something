package org.tahomarobotics.robot.chassis;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.tahomarobotics.robot.RobotMap;

public class Chassis extends SubsystemBase {
    public static final Chassis INSTANCE = new Chassis();
    public static Chassis getInstance() {
        return INSTANCE;
    }
    private final TalonFX motorFR= new TalonFX(RobotMap.FRONT_RIGHT_MOTOR);
    private final TalonFX motorFL= new TalonFX(RobotMap.FRONT_lEFT_MOTOR);
    private final TalonFX motorBR= new TalonFX(RobotMap.BACK_RIGHT_MOTOR );
    private final TalonFX motorBL= new TalonFX(RobotMap.BACK_LEFT_MOTOR);
    private  Chassis() {
        //Following

        motorBR.follow(motorFR);
        motorBL.follow(motorFL);

        //breaking
        motorFR.setNeutralMode(NeutralMode.Brake);
        motorFL.setNeutralMode(NeutralMode.Brake);
        motorBR.setNeutralMode(NeutralMode.Brake);
        motorBL.setNeutralMode(NeutralMode.Brake);

        //invert
        motorFR.setInverted(TalonFXInvertType.CounterClockwise);
        motorFL.setInverted(TalonFXInvertType.Clockwise);




    }
    public Chassis initialize(){
        return  this;
    }

    public void driveRight(double value) {
        motorFR.set(TalonFXControlMode.PercentOutput, value);
    }
        public void driveLeft(double value) {
            motorFL.set(TalonFXControlMode.PercentOutput, value);



    }

    public void stop() {

        motorFL .set(TalonFXControlMode.PercentOutput, 0);
        motorFR .set(TalonFXControlMode.PercentOutput, 0);
    }




}
