package com.flagleader.builder.widget;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Vector;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class C
  implements LineStyleListener
{
  D a = new D(this);
  static int[] b;
  static Color[] c;
  ArrayList d = new ArrayList();
  public static final int e = -1;
  public static final int f = 10;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 5;
  public static final int l = 6;
  public static final int m = 7;
  public static final int n = 8;

  public C()
  {
    a();
    this.a = new D(this);
  }

  Color a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= b.length))
      return null;
    return c[b[paramInt]];
  }

  boolean a(int paramInt1, int paramInt2)
  {
    for (int i1 = 0; i1 < this.d.size(); i1++)
    {
      int[] arrayOfInt = (int[])this.d.get(i1);
      if ((arrayOfInt[0] >= paramInt1) && (arrayOfInt[0] <= paramInt2))
        return true;
      if ((arrayOfInt[1] >= paramInt1) && (arrayOfInt[1] <= paramInt2))
        return true;
      if ((arrayOfInt[0] <= paramInt1) && (arrayOfInt[1] >= paramInt2))
        return true;
    }
    return false;
  }

  void a()
  {
    Display localDisplay = Display.getDefault();
    if (c == null)
      c = new Color[] { new Color(localDisplay, new RGB(0, 0, 0)), new Color(localDisplay, new RGB(255, 0, 0)), new Color(localDisplay, new RGB(0, 255, 0)), new Color(localDisplay, new RGB(0, 0, 255)) };
    if (b == null)
    {
      b = new int[8];
      b[0] = 0;
      b[1] = 0;
      b[2] = 3;
      b[3] = 1;
      b[5] = 2;
      b[6] = 0;
      b[7] = 0;
    }
  }

  void b()
  {
    for (int i1 = 0; i1 < c.length; i1++)
      c[i1].dispose();
  }

  public void lineGetStyle(LineStyleEvent paramLineStyleEvent)
  {
    Vector localVector = new Vector();
    if (a(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineOffset + paramLineStyleEvent.lineText.length()))
    {
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), a(3), null));
      paramLineStyleEvent.styles = new StyleRange[localVector.size()];
      localVector.copyInto(paramLineStyleEvent.styles);
      return;
    }
    Color localColor1 = ((Control)paramLineStyleEvent.widget).getForeground();
    this.a.a(paramLineStyleEvent.lineText);
    for (int i1 = this.a.d(); i1 != -1; i1 = this.a.d())
    {
      if (i1 == 6)
        continue;
      StyleRange localStyleRange1;
      if (i1 != 1)
      {
        Color localColor2 = a(i1);
        if ((localColor2.equals(localColor1)) && (i1 != 2))
          continue;
        StyleRange localStyleRange2 = new StyleRange(this.a.c() + paramLineStyleEvent.lineOffset, this.a.a(), localColor2, null);
        if (i1 == 2)
          localStyleRange2.fontStyle = 1;
        if (localVector.isEmpty())
        {
          localVector.addElement(localStyleRange2);
        }
        else
        {
          localStyleRange1 = (StyleRange)localVector.lastElement();
          if ((localStyleRange1.similarTo(localStyleRange2)) && (localStyleRange1.start + localStyleRange1.length == localStyleRange2.start))
            localStyleRange1.length += localStyleRange2.length;
          else
            localVector.addElement(localStyleRange2);
        }
      }
      else
      {
        if ((localVector.isEmpty()) || ((localStyleRange1 = (StyleRange)localVector.lastElement()).fontStyle != 1))
          continue;
        int i2 = this.a.c() + paramLineStyleEvent.lineOffset;
        localStyleRange1 = (StyleRange)localVector.lastElement();
        if (localStyleRange1.start + localStyleRange1.length != i2)
          continue;
        localStyleRange1.length += this.a.a();
      }
    }
    paramLineStyleEvent.styles = new StyleRange[localVector.size()];
    localVector.copyInto(paramLineStyleEvent.styles);
  }

  public void a(String paramString)
  {
    this.d = new ArrayList();
    StringReader localStringReader = new StringReader(paramString);
    int i4 = 0;
    int i5 = 0;
    int[] arrayOfInt = new int[2];
    int i6 = 0;
    try
    {
      while (i6 == 0)
      {
        int i1;
        int i2;
        switch (i1 = localStringReader.read())
        {
        case -1:
          if (i4 != 0)
          {
            arrayOfInt[1] = i5;
            this.d.add(arrayOfInt);
          }
          i6 = 1;
          break;
        case 60:
          i1 = localStringReader.read();
          i2 = localStringReader.read();
          int i3 = localStringReader.read();
          if ((i1 == 33) && (i2 == 45) && (i3 == 45) && (i4 == 0))
          {
            arrayOfInt = new int[4];
            arrayOfInt[0] = i5;
            i4 = 1;
            i5 += 3;
          }
          else
          {
            i5 += 3;
          }
          i5 += 3;
          break;
        case 45:
          if (i4 != 0)
          {
            i1 = localStringReader.read();
            i2 = localStringReader.read();
            i5 += 2;
            if ((i1 == 45) && (i2 == 62))
            {
              i4 = 0;
              arrayOfInt[1] = i5;
              this.d.add(arrayOfInt);
            }
          }
          i5++;
          break;
        default:
          i5++;
        }
      }
    }
    catch (IOException localIOException)
    {
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.C
 * JD-Core Version:    0.6.0
 */