/*
 * plotSetPreserve.java
 *
 * Created on January 17, 2007, 4:41 AM
 *
 *
 * The NIST RCS (Real-time Control Systems)
 * library is public domain software, however it is preferred
 * that the following disclaimers be attached.
 *
 * Software Copywrite/Warranty Disclaimer
 *
 *   This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of their
 * official duties. Pursuant to title 17 Section 105 of the United States
 * Code this software is not subject to copyright protection and is in the
 * public domain. NIST Real-Time Control System software is an experimental
 * system. NIST assumes no responsibility whatsoever for its use by other
 * parties, and makes no guarantees, expressed or implied, about its
 * quality, reliability, or any other characteristic. We would appreciate
 * acknowledgement if the software is used. This software can be
 * redistributed and/or modified freely provided that any derivative works
 * bear some notice that they are derived from it, and any modified
 * versions bear some notice that they have been modified.
 *
 */
package diagapplet;

import java.util.Vector;

/**
 * Stores all of the information kept between sessions about a single PlotSet by the diagnostics tool.
 * Everything is accessed though getter/setter functions to be compatible with
 * XMLDecoder/XMLEncoder as the files are saved in XML
 * @author shackle
 */
public class plotSetPreserve {

    /**
     * Holds value of property plotList.
     */
    private Vector<plotTrackerPreserve> plotList;

    /**
     * Getter for property plotList.
     * @return Value of property plotList.
     */
    public Vector<plotTrackerPreserve> getPlotList() {
        return this.plotList;
    }

    /**
     * Setter for property plotList.
     * @param plotList New value of property plotList.
     */
    public void setPlotList(Vector<plotTrackerPreserve> plotList) {
        this.plotList = plotList;
    }

    /** Creates a new instance of plotSetPreserve */
    public plotSetPreserve() {
    }
    /**
     * Holds value of property graphFunction.
     */
    private int graphFunction;

    /**
     * Getter for property graphFunction.
     * @return Value of property graphFunction.
     */
    public int getGraphFunction() {
        return this.graphFunction;
    }

    /**
     * Setter for property graphFunction.
     * @param graphFunction New value of property graphFunction.
     */
    public void setGraphFunction(int graphFunction) {
        this.graphFunction = graphFunction;
    }
    /**
     * Holds value of property funcArg.
     */
    private int funcArg;

    /**
     * Getter for property funcArg.
     * @return Value of property funcArg.
     */
    public int getFuncArg() {
        return this.funcArg;
    }

    /**
     * Setter for property funcArg.
     * @param funcArg New value of property funcArg.
     */
    public void setFuncArg(int funcArg) {
        this.funcArg = funcArg;
    }
}
