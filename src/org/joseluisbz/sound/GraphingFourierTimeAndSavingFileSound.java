
package org.joseluisbz.sound;

//import org.joseluisbz.sound.PanelChart;
//import org.joseluisbz.sound.FourierTransform;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joseluisbz@gmail.com
 */
public class GraphingFourierTimeAndSavingFileSound extends javax.swing.JFrame {
  
  private Thread thrdRecording = null;
  private Thread thrdSaving = null;
  private File fileRecordedWav = null;
  private AudioInputStream aisRecording = null;
  /**
   * Creates new form GraphingFourierTimeAndSavingFileSound
   */
  public GraphingFourierTimeAndSavingFileSound() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jpMakeSound = new javax.swing.JPanel();
    jspMakeSound = new javax.swing.JSplitPane();
    jpMakeSoundTimeExt = new javax.swing.JPanel();
    jpMakeSoundTime = new javax.swing.JPanel();
    jpMakeSoundFFTExt = new javax.swing.JPanel();
    jpMakeSoundFFT = new javax.swing.JPanel();
    jpControls = new javax.swing.JPanel();
    jtbCapture = new javax.swing.JToggleButton();
    jlblFile = new javax.swing.JLabel();
    jtfFile = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addInputMethodListener(new java.awt.event.InputMethodListener() {
      public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        formInputMethodTextChanged(evt);
      }
      public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
      }
    });

    jspMakeSound.setDividerLocation(512);
    jspMakeSound.setOneTouchExpandable(true);

    jpMakeSoundTimeExt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout jpMakeSoundTimeLayout = new javax.swing.GroupLayout(jpMakeSoundTime);
    jpMakeSoundTime.setLayout(jpMakeSoundTimeLayout);
    jpMakeSoundTimeLayout.setHorizontalGroup(
      jpMakeSoundTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jpMakeSoundTimeLayout.setVerticalGroup(
      jpMakeSoundTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 257, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jpMakeSoundTimeExtLayout = new javax.swing.GroupLayout(jpMakeSoundTimeExt);
    jpMakeSoundTimeExt.setLayout(jpMakeSoundTimeExtLayout);
    jpMakeSoundTimeExtLayout.setHorizontalGroup(
      jpMakeSoundTimeExtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jpMakeSoundTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jpMakeSoundTimeExtLayout.setVerticalGroup(
      jpMakeSoundTimeExtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jpMakeSoundTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jspMakeSound.setLeftComponent(jpMakeSoundTimeExt);

    jpMakeSoundFFTExt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout jpMakeSoundFFTLayout = new javax.swing.GroupLayout(jpMakeSoundFFT);
    jpMakeSoundFFT.setLayout(jpMakeSoundFFTLayout);
    jpMakeSoundFFTLayout.setHorizontalGroup(
      jpMakeSoundFFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    jpMakeSoundFFTLayout.setVerticalGroup(
      jpMakeSoundFFTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 257, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout jpMakeSoundFFTExtLayout = new javax.swing.GroupLayout(jpMakeSoundFFTExt);
    jpMakeSoundFFTExt.setLayout(jpMakeSoundFFTExtLayout);
    jpMakeSoundFFTExtLayout.setHorizontalGroup(
      jpMakeSoundFFTExtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jpMakeSoundFFT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jpMakeSoundFFTExtLayout.setVerticalGroup(
      jpMakeSoundFFTExtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jpMakeSoundFFT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jspMakeSound.setRightComponent(jpMakeSoundFFTExt);

    javax.swing.GroupLayout jpMakeSoundLayout = new javax.swing.GroupLayout(jpMakeSound);
    jpMakeSound.setLayout(jpMakeSoundLayout);
    jpMakeSoundLayout.setHorizontalGroup(
      jpMakeSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jspMakeSound, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    jpMakeSoundLayout.setVerticalGroup(
      jpMakeSoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jspMakeSound, javax.swing.GroupLayout.Alignment.TRAILING)
    );

    jpControls.setToolTipText("Save File:");

    jtbCapture.setText("Start Capture");
    jtbCapture.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtbCaptureActionPerformed(evt);
      }
    });

    jlblFile.setText("Save File:");

    jtfFile.setEditable(false);

    javax.swing.GroupLayout jpControlsLayout = new javax.swing.GroupLayout(jpControls);
    jpControls.setLayout(jpControlsLayout);
    jpControlsLayout.setHorizontalGroup(
      jpControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jpControlsLayout.createSequentialGroup()
        .addComponent(jtbCapture)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jlblFile)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jtfFile, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
    );
    jpControlsLayout.setVerticalGroup(
      jpControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jpControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
        .addComponent(jtbCapture)
        .addComponent(jlblFile))
      .addComponent(jtfFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jpControls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jpMakeSound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jpControls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(jpMakeSound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jtbCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbCaptureActionPerformed
    
    final AudioFormat audioformat = new AudioFormat(16000 /*Frequency*/,
      16 /* two bytes per sample */, 2 /*Stereo*/, true /*Signed*/, true /*bigEndian*/);
    final DataLine.Info dlInfo = new DataLine.Info(TargetDataLine.class, audioformat);
    if (!AudioSystem.isLineSupported(dlInfo)) {
      System.out.println("Line not supported");
    }
    try {
      final TargetDataLine tdLine = (TargetDataLine) AudioSystem.getLine(dlInfo);
      if (jtbCapture.isSelected()) {
        jtfFile.setText(getPathParent(this.getClass()) + "Recorded_" 
            + new SimpleDateFormat("yyyyMMdd-HHmmss.SSS").format(Calendar.getInstance().getTime()) + ".wav");
        fileRecordedWav = new File(jtfFile.getText());
        final AudioFileFormat.Type afType = AudioFileFormat.Type.WAVE;
        thrdRecording = new Thread() {
          @Override
          public void run() {
            try {
              tdLine.open(audioformat);
        
              int bufferSize = (int) audioformat.getSampleRate() 
                  * audioformat.getFrameSize(); //1Sec/40 = 25 milli Second
              
              System.out.println("bufferSize:" + bufferSize);
              
              //INI Save File 
              final PipedOutputStream SrcSavePOStream = new PipedOutputStream();
              final PipedInputStream SrcSavePIStream = new PipedInputStream();
              SrcSavePIStream.connect(SrcSavePOStream);
              aisRecording = new AudioInputStream((InputStream)SrcSavePIStream,
                  audioformat, AudioSystem.NOT_SPECIFIED);
              Runnable runnableSave = () -> {
                try {
                  AudioSystem.write(aisRecording, afType, fileRecordedWav);
                } catch (IOException ex) { /*Pipe broken*/}
              };
              Thread threadSave = new Thread(runnableSave);
              threadSave.start();
              //END Save File
              
              // INI Graph File
              final PipedOutputStream SrcPlotPOStream = new PipedOutputStream();
              final PipedInputStream SnkPlotPIStream = new PipedInputStream();
              SnkPlotPIStream.connect(SrcPlotPOStream);
              Runnable runnablePlot = () -> {
                try {
                  int qtyBytes;
                  byte[] incomingBytes = new byte[bufferSize];
                  int numBytesPerSample = audioformat.getSampleSizeInBits()/8;
                  int numChannels = audioformat.getChannels();
                  int frameSize = audioformat.getFrameSize();
                  int bytesframeSize = numBytesPerSample*numChannels;
                  Double sampleRateTime = (double)audioformat.getSampleRate();
                  
                  while ((qtyBytes = SnkPlotPIStream.read(incomingBytes)) != -1) {
                    byte[] bytesSamples = new byte[qtyBytes];
                    System.arraycopy(incomingBytes, 0, bytesSamples, 0, qtyBytes);
                    int qtySamples = qtyBytes/frameSize;
                    
                    double[] samplesTime = getSamplesBuffer(bytesSamples, 
                        numBytesPerSample, numChannels, "left", 0, qtySamples);
                    
                    double pow = Math.floor(Math.log(qtySamples) / Math.log(2.0));
                    int sizePower2 = (int)Math.pow(2.0, pow);
                    
                    double[] freqs = new double[qtySamples];
                    double[] samplesPower2 = new double[sizePower2];
                    System.arraycopy(samplesTime, 0, samplesPower2, 0, sizePower2);
                    
                    double[] time = new double[qtySamples];
                    double counter = 0.0;
                    for (int i = 0; i < time.length; i++) {
                      time[i] = counter / sampleRateTime;//
                      counter++;
                      freqs[i] = (double)i/qtySamples*sampleRateTime/1000.0;
                    }
                    
                    // INI Time
                    SwingWorker swingWorkerPlotTime = new SwingWorker() {
                      PanelChart panelChartTimeSound = new PanelChart();
                      @Override protected Void doInBackground() throws Exception {
                        panelChartTimeSound.restoreDefaultValues();
                        panelChartTimeSound.setNameVbleX("time");
                        panelChartTimeSound.setNameVbleY("sound(time)");
                        panelChartTimeSound.setFracX(3);
                        panelChartTimeSound.setFracY(3);
                        int maxValue = (256*8) - 1;//8192:(256*32) - 1, //32767:(256*128) - 1 = 
                        panelChartTimeSound.setMaxY(maxValue);
                        panelChartTimeSound.setMinY(-maxValue);
                        //panelChartTimeSound.useMaxY(true);
                        //panelChartTimeSound.useMinY(true);
                        panelChartTimeSound.setGridDivHorzX(8);
                        panelChartTimeSound.setGridDivVertY(8);
                        panelChartTimeSound.setNameTitleX("Time");
                        panelChartTimeSound.addVble("sound", time, samplesTime, Color.GREEN);
                        return null;
                      }
                      @Override protected void done() {
                        if (panelChartTimeSound.hasPlottable()) {
                          setPanelInPanel(jpMakeSoundTime, 
                              panelChartTimeSound.getChart(jpMakeSoundTime.getWidth(), jpMakeSoundTime.getHeight()));
                          panelChartTimeSound.delAllVble();
                          panelChartTimeSound = null;
                        }
                      }
                    };
                    swingWorkerPlotTime.execute();
                    // END Time
                   
                    // INI FFT
                    double[] fft = FourierTransform.customFFT(samplesPower2);
                    double[] halfFFT = new double[sizePower2/2];
                    double[] halfFreq = new double[sizePower2/2];
                    System.arraycopy(freqs, 0, halfFreq, 0, halfFreq.length);
                    System.arraycopy(fft, 0, halfFFT, 0, halfFFT.length);
                    
                    SwingWorker swingWorkerPlotFreq = new SwingWorker() {
                      PanelChart panelChartFreqSound = new PanelChart();
                      @Override protected Void doInBackground() throws Exception {
                        panelChartFreqSound.restoreDefaultValues();
                        panelChartFreqSound.useColorBack(false);
                        panelChartFreqSound.setNameVbleX("freq");
                        panelChartFreqSound.setNameVbleY("sound(freq)");
                        panelChartFreqSound.setGridDivHorzX(8);
                        panelChartFreqSound.setGridDivVertY(8);
                        panelChartFreqSound.setNameTitleX("FFT");
                        panelChartFreqSound.addVble("sound", halfFreq, halfFFT, new Color(0, 255, 192));
                        return null;
                      }
                      @Override protected void done() {
                        if (panelChartFreqSound.hasPlottable()) {
                          setPanelInPanel(jpMakeSoundFFT, 
                              panelChartFreqSound.getChart(jpMakeSoundFFT.getWidth(), jpMakeSoundFFT.getHeight()));
                          panelChartFreqSound.delAllVble();
                          panelChartFreqSound = null;
                        }
                      }
                    };
                    swingWorkerPlotFreq.execute();
                    // END FFT
                  }
                } catch (IOException ex) {
                  System.out.println("runnablePlot:" + ex.toString());
                }
              };
              Thread threadPlot = new Thread(runnablePlot);
              threadPlot.start();
              // END Graph File
              
              byte[] buffer = new byte[bufferSize];
              tdLine.start();   // start capturing
              while (true) {
                int count = tdLine.read(buffer, 0, buffer.length);
                if (count > 0) {
                  SrcSavePOStream.write(buffer);
                  SrcPlotPOStream.write(buffer);
                }
              }
            } catch (LineUnavailableException | IOException ex) {
              System.out.println("thrdRecording.run:" + ex.toString());
            }
          }
        };
        jtbCapture.setToolTipText("Stop Capture");
        thrdRecording.start();
      } else {
        if (!(thrdRecording == null)) {
          thrdSaving = new Thread() {
            @Override
            public void run() {
              try {
                Thread.sleep(100);
              } catch (InterruptedException ex) {
                System.out.println(ex.toString());
              }
              try {
                aisRecording.close();
              } catch (IOException ex) {
                System.out.println(ex.toString());
              } finally {
                tdLine.stop();
                try {
                  tdLine.close();
                } catch (SecurityException e) {
                }
              }
            }
          };
          thrdSaving.start();
        }
        jtbCapture.setToolTipText("Start Capture");
      }
    } catch (LineUnavailableException ex) {
      System.out.println(ex.toString());
    }
  }//GEN-LAST:event_jtbCaptureActionPerformed

  private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
    // TODO add your handling code here:
  }//GEN-LAST:event_formInputMethodTextChanged

  private void setPanelInPanel(JPanel jpContainer, JPanel jpContained) {
    jpContainer.removeAll();
    jpContainer.setLayout(new GridLayout(1, 1));
    jpContainer.add(jpContained);
    jpContained.repaint();
  }
  
  private double[] getSamplesBuffer(byte[] buffer, int numBytesPerSample,
      int numChannels, String channel, int start, int quantity) {
    
    if (!(quantity > 0)) {
      //Quantity (Num Required Samples) must be greater than zero
      return null;
    }
    int blockAlign = numBytesPerSample * numChannels; //  numBytes*NumChannels
    int numSamplePerChannel = (int) Math.floor(buffer.length / blockAlign); //NumSamplePerChannel
    if ((start < 0) || (start > (numSamplePerChannel - 1))) {
      //Verify that the limits are not exceeded
      return null;
    }
    if ((start + quantity) > (numSamplePerChannel - 1)) {
      //Resize according to samples actually available
      quantity = numSamplePerChannel - start;
    }
    int startingPositionSample = start * blockAlign; //StartingPositionSample
    if (isSecondChannel(channel) && numChannels == 2) {
      startingPositionSample += numBytesPerSample;
    }
    int jump = blockAlign;
    double[] samples = new double[quantity];
    for (int i = 0; i < quantity; i++) {
      int position = startingPositionSample + i * jump;
      if (numBytesPerSample == 2) {
        samples[i] = (double) Byte2IntLit(
            buffer[position + 0], buffer[position + 1]);
      }
      if (numBytesPerSample == 1) {
        samples[i] = (double)byte2intSmpl(buffer[position]);
      }
    }
    return samples;
  }
  
  private int Byte2IntLit(byte Byte00, byte Byte08) {
    //Bytes To Integer – Little Endianness
    return (((Byte08) << 8) | ((Byte00 & 0xFF)));
  }
  
  private int byte2intSmpl(byte theByte) {
    return (short)(((theByte - 128) & 0xFF) << 8);
  }
  
  private boolean isSecondChannel(String channel) {
    return channel.equalsIgnoreCase("last") || channel.equalsIgnoreCase("right");
  }
  
  private String getPathParent(Class c) {
    String p = c.getProtectionDomain().getCodeSource().getLocation().getPath();
    String drp = new File(p).getParent();
    return drp + System.getProperty("file.separator");
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(GraphingFourierTimeAndSavingFileSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(GraphingFourierTimeAndSavingFileSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(GraphingFourierTimeAndSavingFileSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(GraphingFourierTimeAndSavingFileSound.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new GraphingFourierTimeAndSavingFileSound().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jlblFile;
  private javax.swing.JPanel jpControls;
  private javax.swing.JPanel jpMakeSound;
  private javax.swing.JPanel jpMakeSoundFFT;
  private javax.swing.JPanel jpMakeSoundFFTExt;
  private javax.swing.JPanel jpMakeSoundTime;
  private javax.swing.JPanel jpMakeSoundTimeExt;
  private javax.swing.JSplitPane jspMakeSound;
  private javax.swing.JToggleButton jtbCapture;
  private javax.swing.JTextField jtfFile;
  // End of variables declaration//GEN-END:variables
}
