/* 
The NIST RCS (Real-time Control Systems) 
 library is public domain software, however it is preferred
 that the following disclaimers be attached.

Software Copywrite/Warranty Disclaimer

   This software was developed at the National Institute of Standards and
Technology by employees of the Federal Government in the course of their
official duties. Pursuant to title 17 Section 105 of the United States
Code this software is not subject to copyright protection and is in the
public domain. NIST Real-Time Control System software is an experimental
system. NIST assumes no responsibility whatsoever for its use by other
parties, and makes no guarantees, expressed or implied, about its
quality, reliability, or any other characteristic. We would appreciate
acknowledgement if the software is used. This software can be
redistributed and/or modified freely provided that any derivative works
bear some notice that they are derived from it, and any modified
versions bear some notice that they have been modified.



*/ 

/*
*       New Java File starts here.
*       This file should be named PM_QUATERNION.java
*/


// Set Package Name
package rcs.posemath;

// Import all NML, CMS, and RCS classes and interfaces
import rcs.nml.NMLFormatConverter;

/*
*       Class definition for PM_QUATERNION
*       Automatically generated by RCS Java Diagnostics Tool.
*       on Wed Jan 07 10:53:46 EST 1998
*/
public class PM_QUATERNION extends PmQuaternion implements Cloneable
{
  public void update(NMLFormatConverter nml_fc)
  {
    super.update(nml_fc);
  }

  public PM_QUATERNION()
  {
    super();
  }

  public PM_QUATERNION(double starts, double startx, double starty, double startz) throws PmException
  {
    super(starts,startx, startz, starty);
  }

  public PM_QUATERNION(PM_ROTATION_VECTOR rv) throws PmException
  {
    Posemath.pmRotNorm(rv,rv);
    Posemath.pmRotQuatConvert(rv,this);
  }
  public PM_QUATERNION clone()
  {
      PM_QUATERNION cloned_object = (PM_QUATERNION) super.clone();
      return cloned_object;
  }

}
