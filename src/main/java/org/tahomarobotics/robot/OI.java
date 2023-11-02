// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.tahomarobotics.robot;


import edu.wpi.first.wpilibj.XboxController;
import org.tahomarobotics.robot.chassis.Chassis;
import org.tahomarobotics.robot.chassis.TeleportDriveCommand;
public class OI {

    private static final OI INSTANCE = new OI();

    public static OI getInstance() {return INSTANCE;}



    private final XboxController driveController = new XboxController(0);
    public OI() {


        Chassis chassis = Chassis.getInstance();

        chassis.setDefaultCommand(new TeleportDriveCommand(
                this::getLeftY, this::getRightY
        ));
    }
    public double getLeftY() {
        return driveController.getLeftY();
    }
    public double getRightY() {
        return driveController.getRightY();
    }


}

