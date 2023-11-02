package org.tahomarobotics.robot.chassis;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;
public class TeleportDriveCommand extends CommandBase {

    private DoubleSupplier leftSup, rightSup;

    private  final  Chassis chassis = Chassis.getInstance();

    public TeleportDriveCommand(DoubleSupplier leftSup, DoubleSupplier rightSup) {
        this.leftSup =leftSup;
        this.rightSup =  rightSup;
    }

  @Override
    public void execute() {
        chassis.driveLeft(leftSup.getAsDouble());
      chassis.driveRight(rightSup.getAsDouble());
  }

   }
