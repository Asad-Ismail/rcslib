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
 * ImageJFrame.java
 *
 * Created on December 15, 2006, 6:22 PM
 */

package diagapplet.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 * A swing Jframe that adds controls to an ImageJPanel to display
 * scale, and cycle through a  set of images.
 * @author  Will Shackleford <shackle@nist.gov>
 */
public class ImageJFrame extends javax.swing.JFrame
{
    
    private File image_files[]=null;
    private Timer swTimer=null;
    private SwingWorker backgroundSwingWorker = null;
    private int delay=2;
    int image_number=0;
    private boolean fit=true;
    private static final long serialVersionUID = 2613938L;
    
    /** Creates new form ImageJFrame */
    public ImageJFrame()
    {
	initComponents();
	jSpinnerZoom.setValue(new Integer(1));
	jSpinnerSpeed.setValue(new Integer(2));
	ReadLastDir();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jToggleButtonPause = new javax.swing.JToggleButton();
        imageJPanel1 = new diagapplet.utils.ImageJPanel();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerZoom = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerSpeed = new javax.swing.JSpinner();
        jCheckBoxFit = new javax.swing.JCheckBox();
        jLabelFrameNumber = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemFileOpen = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jToggleButtonPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diagapplet/plotter/Pause24.gif"))); // NOI18N
        jToggleButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPauseActionPerformed(evt);
            }
        });

        jLabel1.setText("Zoom:");

        jSpinnerZoom.setEnabled(false);
        jSpinnerZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerZoomStateChanged(evt);
            }
        });

        jLabel2.setText("Delay(ms):");

        jSpinnerSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSpeedStateChanged(evt);
            }
        });

        jCheckBoxFit.setSelected(true);
        jCheckBoxFit.setText("Fit");
        jCheckBoxFit.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBoxFit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxFitActionPerformed(evt);
            }
        });

        jLabelFrameNumber.setText("<<Frame>>");

        jMenu1.setText("File");

        jMenuItemFileOpen.setText("Open");
        jMenuItemFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFileOpenActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFileOpen);

        jMenuItemSaveAs.setText("Save As ...");
        jMenuItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveAsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSaveAs);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageJPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButtonPause)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxFit)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelFrameNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonPause)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jSpinnerZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jSpinnerSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBoxFit)
                                .addComponent(jLabelFrameNumber))
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    static private javax.swing.filechooser.FileFilter zipFileFilter  = null;
    static private javax.swing.filechooser.FileFilter imageFileFilter  = null;
    
    private static void init_filters()
    {
	if(null == zipFileFilter)
	{
	    zipFileFilter = new javax.swing.filechooser.FileFilter()
	    {
		public boolean accept(File f)
		{
		    return (f.isDirectory() ||
			    f.getName().endsWith(".images.zip"));
		}
                @Override
		public String getDescription()
		{ return "Zip of Images";}
	    };
	}
	if(null == imageFileFilter)
	{
	    imageFileFilter = new javax.swing.filechooser.FileFilter()
	    {
                @Override
		public boolean accept(File f)
		{
		    return (f.isDirectory() ||
			    f.getName().endsWith(".png") ||
			    f.getName().endsWith(".gif") ||
			    f.getName().endsWith(".jpeg") ||
			    f.getName().endsWith(".bmp") ||
			    f.getName().endsWith(".ppm") ||
			    f.getName().endsWith(".jpg"));
		}
                @Override
		public String getDescription()
		{ return "Images";}
	    };
	}
    }
    
    private void jMenuItemSaveAsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemSaveAsActionPerformed
    {//GEN-HEADEREND:event_jMenuItemSaveAsActionPerformed
	JFileChooser chooser = new JFileChooser();
	if(last_dir != null)
	{
	    chooser.setCurrentDirectory(last_dir);
	}
	else
	{
	    chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	}
	init_filters();
	//chooser.addChoosableFileFilter(imageFileFilter);
	chooser.setFileFilter(zipFileFilter);
	int returnVal = chooser.showSaveDialog(this);
	if(returnVal == JFileChooser.APPROVE_OPTION)
	{
//	    System.out.println("You chose to save as this file: " +
//		    chooser.getSelectedFile().getPath());
	    last_dir = chooser.getCurrentDirectory();
	    SaveLastDir();
	    rcs.utils.URL_and_FileLoader.current_directory =  last_dir.getPath();
	    rcs.utils.URL_and_FileLoader.AddToSearchPath(last_dir.getPath());
	    File save_as_file = chooser.getSelectedFile();
	    if(!save_as_file.getName().endsWith(".images.zip"))
	    {
		String n = save_as_file.getName();
		if(n.endsWith(".zip"))
		{
		    save_as_file = new File(save_as_file.getParent(),n.substring(0,n.length()-4)+".images.zip");
		}
		else
		{
		    save_as_file = new File(save_as_file.getParent(),n+".images.zip");
		}
	    }
	    try
	    {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(save_as_file));
		for(File image_file : image_files)
		{
		    FileInputStream fis = new FileInputStream(image_file);
		    ZipEntry ze = new ZipEntry(image_file.getName());
		    ze.setSize(fis.available());
		    zos.putNextEntry(ze);
		    int sz = 0;
		    while(fis.available() > 0)
		    {
			byte btemp[] = new byte[fis.available()];
			int bytes_read = fis.read(btemp);
			if(bytes_read < 1)
			{
			    break;
			}
			zos.write(btemp,0,bytes_read);
			sz += bytes_read;
			ze.setSize(sz);
		    }
		    fis.close();
		    zos.closeEntry();
		}
		zos.close();
	    }
	    catch (Exception ex)
	    {
		ex.printStackTrace();
	    }
	}
    }//GEN-LAST:event_jMenuItemSaveAsActionPerformed
    
    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
	try
	{
	    if(null != swTimer)
	    {
		swTimer.stop();
		swTimer=null;
	    }
	    setVisible(false);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }//GEN-LAST:event_formWindowClosed
    
    private void formComponentResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentResized
    {//GEN-HEADEREND:event_formComponentResized
	ReloadImage();
    }//GEN-LAST:event_formComponentResized
    
    private void jCheckBoxFitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jCheckBoxFitActionPerformed
    {//GEN-HEADEREND:event_jCheckBoxFitActionPerformed
	fit = jCheckBoxFit.isSelected();
	jSpinnerZoom.setEnabled(!fit);
	ReloadImage();
    }//GEN-LAST:event_jCheckBoxFitActionPerformed
    
    private void jSpinnerSpeedStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSpinnerSpeedStateChanged
    {//GEN-HEADEREND:event_jSpinnerSpeedStateChanged
	Number n = (Number) jSpinnerSpeed.getValue();
	delay = n.intValue();
	if(null != swTimer)
	{
	    boolean running = swTimer.isRunning();
	    if(running)
	    {
		swTimer.stop();
	    }
	    swTimer.setDelay(delay);
	    if(running)
	    {
		swTimer.start();
	    }
	}
	ReloadImage();
    }//GEN-LAST:event_jSpinnerSpeedStateChanged
    
    private void jSpinnerZoomStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSpinnerZoomStateChanged
    {//GEN-HEADEREND:event_jSpinnerZoomStateChanged
	Number n = (Number) jSpinnerZoom.getValue();
	int z = n.intValue();
	imageJPanel1.SetZoom(z);
	ReloadImage();
    }//GEN-LAST:event_jSpinnerZoomStateChanged
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSlider1StateChanged
    {//GEN-HEADEREND:event_jSlider1StateChanged
	image_number = jSlider1.getValue();
	jLabelFrameNumber.setText(Integer.toString(image_number));
	ReloadImage();
    }//GEN-LAST:event_jSlider1StateChanged
    
    private void ReloadImage()
    {
	if(null != image_files &&
		(null == backgroundSwingWorker ||  backgroundSwingWorker.isCancelled() || backgroundSwingWorker.isDone())
		)
	{
	    backgroundSwingWorker = new SwingWorker<Void,Void>()
	    {
		@Override
		protected Void doInBackground() throws Exception
		{
		    if(image_number > image_files.length - 1)
		    {
			image_number = image_files.length -1;
		    }
		    else if(image_number < 0)
		    {
			image_number = 0;
		    }
		    File f = image_files[image_number];
		    imageJPanel1.SetFit(fit);
		    imageJPanel1.LoadImageF(f);
		    return null;
		}
	    };
	    backgroundSwingWorker.execute();
	}
    }
    
    private void NextImage()
    {
	if(null != image_files && image_number < image_files.length &&
		(null == backgroundSwingWorker ||  backgroundSwingWorker.isCancelled() || backgroundSwingWorker.isDone())
		)
	{
	    backgroundSwingWorker = new SwingWorker<Void,Void>()
	    {
		@Override
		protected Void doInBackground() throws Exception
		{
		    File f = image_files[image_number];
		    imageJPanel1.SetFit(fit);
		    imageJPanel1.LoadImageF(f);
		    image_number++;
		    jSlider1.setValue(image_number);
		    while(delay < 1 && image_number < image_files.length)
		    {
			f = image_files[image_number];
			imageJPanel1.SetFit(fit);
			imageJPanel1.LoadImageF(f);
			image_number++;
			jSlider1.setValue(image_number);
		    }
		    return null;
		}
	    };
	    backgroundSwingWorker.execute();
	}
    }
    
    private void jToggleButtonPauseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jToggleButtonPauseActionPerformed
    {//GEN-HEADEREND:event_jToggleButtonPauseActionPerformed
	if(!jToggleButtonPause.isSelected())
	{
	    if(null == swTimer)
	    {
		swTimer = new Timer(delay,new ActionListener()
		{
                    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			NextImage();
		    }
		});
	    }
	    swTimer.start();
	}
	else if(null != swTimer)
	{
	    swTimer.stop();
	}
    }//GEN-LAST:event_jToggleButtonPauseActionPerformed
    
    
    private void LoadImages()
    {
	//System.out.println("LoadImages : image_files="+image_files);
	if(null != image_files)
	{
	    for(int i = 0 ; i < image_files.length; i++)
	    {
		File f = image_files[i];
		imageJPanel1.LoadImageF(f);
	    }
	}
    }
    
    private void ReadLastDir()
    {
	try
	{
	    File last_dir_file = new File(System.getProperty("user.home"),".last_dir_"+this.getClass().getName());
	    FileInputStream fis = new FileInputStream(last_dir_file);
	    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	    String last_dir_string = br.readLine();
	    last_dir = new File(last_dir_string);
	    fis.close();
	    br.close();
	    fis = null;
	    br = null;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    private void SaveLastDir()
    {
	try
	{
	    File last_dir_file = new File(System.getProperty("user.home"),".last_dir_"+this.getClass().getName());
	    FileOutputStream fos = new FileOutputStream(last_dir_file);
	    PrintStream ps = new PrintStream(fos);
	    ps.println(last_dir.getAbsolutePath());
	    ps.close();
	    fos.close();
	    ps = null;
	    fos = null;
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    
    public void LoadImageFileVector(Vector<File> image_file_vector)
    {
	try
	{
	    jSlider1.setValue(0);
	    image_files = new File[image_file_vector.size()];
	    image_files = image_file_vector.toArray(image_files);
	    if(null == swTimer)
	    {
		swTimer = new Timer(delay,new ActionListener()
		{
                    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			NextImage();
		    }
		});
	    }
	    swTimer.start();
	    jToggleButtonPause.setSelected(false);
	    jSlider1.setMaximum(image_files.length);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    private void OpenZips()
    {
	Vector<File> fv = new Vector<File>();
	for(File imageFile : image_files)
	{
	    //System.out.println("imageFile="+imageFile.getAbsolutePath());
	    if(imageFile.getName().endsWith(".zip"))
	    {
		//ZipFile = new ZipFile(chooser.getSelectedFile());
		try
		{
		    ZipInputStream zis = new ZipInputStream(new FileInputStream(imageFile));
		    ZipEntry ze = zis.getNextEntry();
		    while(null != ze)
		    {
			if(!ze.isDirectory() &&
				(ze.getName().endsWith(".png") ||
				ze.getName().endsWith(".jpg") ||
				ze.getName().endsWith(".jpeg") ||
				ze.getName().endsWith(".bmp") ||
				ze.getName().endsWith(".ppm") ||
				ze.getName().endsWith(".gif") ))
			{
			    File fileFromZip = new File(imageFile.getParentFile(),ze.getName());;
			    if(!imageFile.getParentFile().canWrite() && !fileFromZip.exists())
			    {
				fileFromZip = File.createTempFile(
					imageFile.getName()+"._"+ze.getName().substring(0,ze.getName().indexOf('.'))+"_",
					ze.getName().substring(ze.getName().indexOf('.'))
					);
			    }
			    //System.out.println("fileFromZip="+fileFromZip.getAbsolutePath()+ " ze.getSize()="+ze.getSize());
			    if(!fileFromZip.exists())
			    {
				FileOutputStream fos = new FileOutputStream(fileFromZip);
				try
				{
				    while(true) //zis.available() > 0)
				    {
					int sz = (int) ze.getSize();
					if(sz < 0)
					{
					    sz = zis.available();
					}
					if(sz <= 1024)
					{
					    sz = 1024;
					}
					else if(sz > (1024*1024))
					{
					    sz = (1024*1024);
					}
					//System.out.println("sz="+sz);
					byte btemp[] = new byte[sz];
					int bytes_read = zis.read(btemp,0,sz);
					//System.out.println("bytes_read="+bytes_read);
					if(bytes_read < 1)
					{
					    break;
					}
					fos.write(btemp,0,bytes_read);
				    }
				}
				catch(Exception ex)
				{
				    ex.printStackTrace();
				}
				fos.close();
			    }
			    fv.add(fileFromZip);
			}
			zis.closeEntry();
			ze = zis.getNextEntry();
		    }
		    zis.close();
		}
		catch(Exception ex)
		{
		    ex.printStackTrace();
		}
	    }
	    else
	    {
		fv.add(imageFile);
	    }
	}
	image_files = new File[fv.size()];
	image_files = fv.toArray(image_files);
    }
    
    private void jMenuItemFileOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItemFileOpenActionPerformed
    {//GEN-HEADEREND:event_jMenuItemFileOpenActionPerformed
	JFileChooser chooser = new JFileChooser();
	init_filters();
	chooser.addChoosableFileFilter(imageFileFilter);
	chooser.setFileFilter(zipFileFilter);
	if(last_dir != null)
	{
	    chooser.setCurrentDirectory(last_dir);
	}
	else
	{
	    chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	}
	chooser.setMultiSelectionEnabled(true);
	int returnVal = chooser.showOpenDialog(this);
	if(returnVal == JFileChooser.APPROVE_OPTION)
	{
//	    System.out.println("You chose to open this file: " +
//		    chooser.getSelectedFile().getPath());
	    last_dir = chooser.getCurrentDirectory();
	    SaveLastDir();
	    rcs.utils.URL_and_FileLoader.current_directory =  last_dir.getPath();
	    rcs.utils.URL_and_FileLoader.AddToSearchPath(last_dir.getPath());
	    image_files = chooser.getSelectedFiles();
	    OpenZips();
	    //System.out.println("image_files.length="+image_files.length);
	    jSlider1.setValue(0);
	    if(null == swTimer)
	    {
		swTimer = new Timer(delay,new ActionListener()
		{
                    @Override
		    public void actionPerformed(ActionEvent e)
		    {
			NextImage();
		    }
		});
	    }
	    swTimer.start();
	    jToggleButtonPause.setSelected(false);
	    jSlider1.setMaximum(image_files.length);
	}
    }//GEN-LAST:event_jMenuItemFileOpenActionPerformed
    
    private void LoadArgs(final String args[])
    {
	try
	{
	    if(args == null)
	    {
		return;
	    }
	    Vector<File> fv = new Vector<File>();
	    for(String arg: args)
	    {
		File f = new File(arg);
		if(f.exists())
		{
		    fv.add(f);
		}
	    }
	    if(fv.size() > 0)
	    {
		image_files = new File[fv.size()];
		image_files = fv.toArray(image_files);
		OpenZips();
		jSlider1.setValue(0);
		if(null == swTimer)
		{
		    swTimer = new Timer(delay,new ActionListener()
		    {
			public void actionPerformed(ActionEvent e)
			{
			    NextImage();
			}
		    });
		}
		swTimer.start();
		jToggleButtonPause.setSelected(false);
		jSlider1.setMaximum(image_files.length);
	    }
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
    }
    private File last_dir=null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(final String args[])
    {
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		ImageJFrame ijf = new ImageJFrame();
		ijf.setVisible(true);
		ijf.LoadArgs(args);
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private diagapplet.utils.ImageJPanel imageJPanel1;
    private javax.swing.JCheckBox jCheckBoxFit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFrameNumber;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemFileOpen;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinnerSpeed;
    private javax.swing.JSpinner jSpinnerZoom;
    private javax.swing.JToggleButton jToggleButtonPause;
    // End of variables declaration//GEN-END:variables
    
}
