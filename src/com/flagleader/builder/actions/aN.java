package com.flagleader.builder.actions;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor.SERVICE_FORMATTED;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import org.eclipse.swt.custom.StyledText;

public class aN
  implements Printable
{
  private StyledText a;
  private int b = 0;
  private String c;

  public aN(StyledText paramStyledText)
  {
    this.a = paramStyledText;
  }

  public int print(Graphics paramGraphics, PageFormat paramPageFormat, int paramInt)
  {
    Graphics2D localGraphics2D = (Graphics2D)paramGraphics;
    localGraphics2D.setPaint(Color.black);
    if (paramInt >= this.b)
      return 1;
    localGraphics2D.translate(paramPageFormat.getImageableX(), paramPageFormat.getImageableY());
    a(localGraphics2D, paramPageFormat, paramInt);
    return 0;
  }

  private void a(Graphics2D paramGraphics2D, PageFormat paramPageFormat, int paramInt)
  {
    String str1 = a(this.c)[paramInt];
    float f = 16.0F;
    int j = this.a.getLineHeight();
    int k = 0;
    while ((str1.length() > 0) && (k < 54))
    {
      int i = str1.indexOf('\n');
      String str2;
      if (i != -1)
      {
        k++;
        str2 = str1.substring(0, i);
        paramGraphics2D.drawString(str2, 0.0F, f);
        if (str1.substring(i + 1).length() <= 0)
          continue;
        str1 = str1.substring(i + 1);
        f += j;
      }
      else
      {
        k++;
        str2 = str1;
        paramGraphics2D.drawString(str2, 0.0F, f);
        str1 = "";
      }
    }
  }

  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[this.b];
    for (int i = 0; i < this.b; i++)
      arrayOfString[i] = "";
    int j = 0;
    int k = 0;
    while (paramString.length() > 0)
      if (k < 54)
      {
        i = paramString.indexOf('\n');
        if (i != -1)
        {
          k++;
          arrayOfString[j] = (arrayOfString[j] + paramString.substring(0, i + 1));
          if (paramString.substring(i + 1).length() <= 0)
            continue;
          paramString = paramString.substring(i + 1);
        }
        else
        {
          k++;
          arrayOfString[j] = (arrayOfString[j] + paramString);
          paramString = "";
        }
      }
      else
      {
        k = 0;
        j++;
      }
    return arrayOfString;
  }

  public int b(String paramString)
  {
    int i = 0;
    int k = 0;
    String str = paramString;
    while (str.length() > 0)
    {
      int j = str.indexOf('\n');
      k++;
      if (j != -1)
        str = str.substring(j + 1);
      else
        str = "";
    }
    if (k > 0)
      i = k / 54 + 1;
    return i;
  }

  private void c()
  {
    this.c = this.a.getText().trim();
    if ((this.c != null) && (this.c.length() > 0))
    {
      this.b = b(this.c);
      PrinterJob localPrinterJob = PrinterJob.getPrinterJob();
      PageFormat localPageFormat = localPrinterJob.defaultPage();
      localPrinterJob.setPrintable(this, localPageFormat);
      if (localPrinterJob.printDialog())
        try
        {
          localPrinterJob.print();
        }
        catch (PrinterException localPrinterException)
        {
          localPrinterException.printStackTrace();
        }
    }
    else
    {
      Logger.getLogger("flagleader").log(Level.WARNING, "Sorry, Printer Job is Empty, Print Cancelled!");
    }
  }

  public void a()
  {
    this.c = this.a.getText().trim();
    if ((this.c != null) && (this.c.length() > 0))
    {
      this.b = b(this.c);
      DocFlavor.SERVICE_FORMATTED localSERVICE_FORMATTED = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
      PrintService localPrintService = PrintServiceLookup.lookupDefaultPrintService();
      DocPrintJob localDocPrintJob = localPrintService.createPrintJob();
      HashPrintRequestAttributeSet localHashPrintRequestAttributeSet = new HashPrintRequestAttributeSet();
      HashDocAttributeSet localHashDocAttributeSet = new HashDocAttributeSet();
      SimpleDoc localSimpleDoc = new SimpleDoc(this, localSERVICE_FORMATTED, localHashDocAttributeSet);
      try
      {
        localDocPrintJob.print(localSimpleDoc, localHashPrintRequestAttributeSet);
      }
      catch (PrintException localPrintException)
      {
        localPrintException.printStackTrace();
      }
    }
    else
    {
      Logger.getLogger("flagleader").log(Level.WARNING, "Sorry, Printer Job is Empty, Print Cancelled!");
    }
  }

  public void b()
  {
    c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aN
 * JD-Core Version:    0.6.0
 */