package com.a;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;

public class c
{
  private static HashMap e = new HashMap();
  private static HashMap f = new HashMap();
  private static HashMap g = new HashMap();
  private static final int h = 10;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private static HashMap i = new HashMap();
  private static HashMap j = new HashMap();
  private static HashMap k = new HashMap();

  public static void a()
  {
    c();
    d();
    b();
    e();
  }

  public static Color a(int paramInt)
  {
    Display localDisplay = Display.getCurrent();
    return localDisplay.getSystemColor(paramInt);
  }

  public static Color a(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(new RGB(paramInt1, paramInt2, paramInt3));
  }

  public static Color a(RGB paramRGB)
  {
    Color localColor = (Color)e.get(paramRGB);
    if (localColor == null)
    {
      Display localDisplay = Display.getCurrent();
      localColor = new Color(localDisplay, paramRGB);
      e.put(paramRGB, localColor);
    }
    return localColor;
  }

  public static void c()
  {
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext())
      ((Color)localIterator.next()).dispose();
    e.clear();
  }

  protected static Image a(InputStream paramInputStream)
  {
    Display localDisplay = Display.getCurrent();
    ImageData localImageData = new ImageData(paramInputStream);
    if (localImageData.transparentPixel > 0)
      return new Image(localDisplay, localImageData, localImageData.getTransparencyMask());
    return new Image(localDisplay, localImageData);
  }

  public static Image b(String paramString)
  {
    return a("default", paramString);
  }

  public static Image a(String paramString1, String paramString2)
  {
    String str = paramString1 + '|' + c.class.getName() + '|' + paramString2;
    Image localImage = (Image)f.get(str);
    if (localImage == null)
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString2);
        localImage = a(localFileInputStream);
        f.put(str, localImage);
        localFileInputStream.close();
      }
      catch (Exception localException)
      {
        localImage = f();
        f.put(str, localImage);
      }
    return localImage;
  }

  public static Image b(Class paramClass, String paramString)
  {
    String str1 = paramClass.getName() + '|' + paramString;
    Image localImage = (Image)f.get(str1);
    if (localImage == null)
      try
      {
        if ((paramString.length() > 0) && (paramString.charAt(0) == '/'))
        {
          String str2 = paramString.substring(1, paramString.length());
          localImage = a(new BufferedInputStream(paramClass.getClassLoader().getResourceAsStream(str2)));
        }
        else
        {
          localImage = a(paramClass.getResourceAsStream(paramString));
        }
        f.put(str1, localImage);
      }
      catch (Exception localException)
      {
        localImage = f();
        f.put(str1, localImage);
      }
    return localImage;
  }

  private static Image f()
  {
    Image localImage = new Image(Display.getCurrent(), 10, 10);
    GC localGC = new GC(localImage);
    localGC.setBackground(a(3));
    localGC.fillRectangle(0, 0, 10, 10);
    localGC.dispose();
    return localImage;
  }

  public static Image a(Image paramImage1, Image paramImage2)
  {
    return a(paramImage1, paramImage2, 4);
  }

  public static Image a(Image paramImage1, Image paramImage2, int paramInt)
  {
    HashMap localHashMap = (HashMap)g.get(paramImage1);
    if (localHashMap == null)
    {
      localHashMap = new HashMap();
      g.put(paramImage1, localHashMap);
    }
    Image localImage = (Image)localHashMap.get(paramImage2);
    if (localImage == null)
    {
      Rectangle localRectangle1 = paramImage1.getBounds();
      Rectangle localRectangle2 = paramImage2.getBounds();
      localImage = new Image(Display.getCurrent(), localRectangle1.width, localRectangle1.height);
      GC localGC = new GC(localImage);
      localGC.drawImage(paramImage1, 0, 0);
      if (paramInt == 1)
        localGC.drawImage(paramImage2, 0, 0);
      else if (paramInt == 2)
        localGC.drawImage(paramImage2, localRectangle1.width - localRectangle2.width - 1, 0);
      else if (paramInt == 3)
        localGC.drawImage(paramImage2, 0, localRectangle1.height - localRectangle2.height - 1);
      else if (paramInt == 4)
        localGC.drawImage(paramImage2, localRectangle1.width - localRectangle2.width - 1, localRectangle1.height - localRectangle2.height - 1);
      localGC.dispose();
      localHashMap.put(paramImage2, localImage);
    }
    return localImage;
  }

  public static void b()
  {
    Iterator localIterator1 = f.values().iterator();
    while (localIterator1.hasNext())
      ((Image)localIterator1.next()).dispose();
    f.clear();
    localIterator1 = g.values().iterator();
    while (localIterator1.hasNext())
    {
      HashMap localHashMap = (HashMap)localIterator1.next();
      Iterator localIterator2 = localHashMap.values().iterator();
      while (localIterator2.hasNext())
      {
        Image localImage = (Image)localIterator2.next();
        localImage.dispose();
      }
    }
  }

  public static void c(String paramString)
  {
    Iterator localIterator = f.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith(paramString + '|'))
        continue;
      Image localImage = (Image)f.get(str);
      localImage.dispose();
      localIterator.remove();
    }
  }

  public static Font a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, false, false);
  }

  public static Font a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = paramString + '|' + paramInt1 + '|' + paramInt2 + '|' + paramBoolean1 + '|' + paramBoolean2;
    Font localFont = (Font)i.get(str);
    if (localFont == null)
    {
      FontData localFontData = new FontData(paramString, paramInt1, paramInt2);
      if ((paramBoolean1) || (paramBoolean2))
        try
        {
          Class localClass = Class.forName("org.eclipse.swt.internal.win32.LOGFONT");
          Object localObject = FontData.class.getField("data").get(localFontData);
          if ((localObject != null) && (localClass != null))
          {
            if (paramBoolean1)
              localClass.getField("lfStrikeOut").set(localObject, new Byte(1));
            if (paramBoolean2)
              localClass.getField("lfUnderline").set(localObject, new Byte(1));
          }
        }
        catch (Throwable localThrowable)
        {
          System.err.println("Unable to set underline or strikeout (probably on a non-Windows platform). " + localThrowable);
        }
      localFont = new Font(Display.getCurrent(), localFontData);
      i.put(str, localFont);
    }
    return localFont;
  }

  public static Font a(Font paramFont)
  {
    Font localFont = (Font)j.get(paramFont);
    if (localFont == null)
    {
      FontData[] arrayOfFontData = paramFont.getFontData();
      FontData localFontData = arrayOfFontData[0];
      localFont = new Font(Display.getCurrent(), localFontData.getName(), localFontData.getHeight(), 1);
      j.put(paramFont, localFont);
    }
    return localFont;
  }

  public static void d()
  {
    Iterator localIterator = i.values().iterator();
    while (localIterator.hasNext())
      ((Font)localIterator.next()).dispose();
    i.clear();
    localIterator = j.values().iterator();
    while (localIterator.hasNext())
      ((Font)localIterator.next()).dispose();
    j.clear();
  }

  public static void a(CoolBar paramCoolBar)
  {
    CoolItem[] arrayOfCoolItem = paramCoolBar.getItems();
    CoolItem localCoolItem;
    for (int m = 0; m < arrayOfCoolItem.length; m++)
    {
      localCoolItem = arrayOfCoolItem[m];
      if (localCoolItem.getControl() != null)
        continue;
      localCoolItem.setControl(new d(paramCoolBar, 0));
    }
    for (m = 0; m < arrayOfCoolItem.length; m++)
    {
      localCoolItem = arrayOfCoolItem[m];
      Control localControl = localCoolItem.getControl();
      localControl.pack();
      Point localPoint = localControl.getSize();
      localCoolItem.setSize(localCoolItem.computeSize(localPoint.x, localPoint.y));
    }
  }

  public static Cursor b(int paramInt)
  {
    Integer localInteger = new Integer(paramInt);
    Cursor localCursor = (Cursor)k.get(localInteger);
    if (localCursor == null)
    {
      localCursor = new Cursor(Display.getDefault(), paramInt);
      k.put(localInteger, localCursor);
    }
    return localCursor;
  }

  public static void e()
  {
    Iterator localIterator = k.values().iterator();
    while (localIterator.hasNext())
      ((Cursor)localIterator.next()).dispose();
    k.clear();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.a.c
 * JD-Core Version:    0.6.0
 */