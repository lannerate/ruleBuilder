package com.flagleader.builder.widget.a;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

class au
  implements LineStyleListener
{
  av a = new av(this);
  static int[] b;
  static Color[] c;
  ArrayList d = new ArrayList();
  List e = new ArrayList();
  public static final int f = -1;
  public static final int g = 11;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 7;
  public static final int o = 11;
  public static final int p = 8;
  public static final int q = 9;
  public static final int r = 10;

  public au()
  {
    a();
    this.a = new av(this);
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
      c = new Color[] { new Color(localDisplay, new RGB(0, 0, 0)), new Color(localDisplay, new RGB(100, 155, 100)), new Color(localDisplay, new RGB(255, 0, 0)), new Color(localDisplay, new RGB(0, 0, 255)), new Color(localDisplay, new RGB(100, 0, 255)), new Color(localDisplay, new RGB(0, 0, 155)), new Color(localDisplay, new RGB(255, 55, 155)), new Color(localDisplay, new RGB(255, 100, 0)) };
    if (b == null)
    {
      b = new int[11];
      b[0] = 0;
      b[1] = 0;
      b[2] = 3;
      b[3] = 1;
      b[5] = 2;
      b[6] = 0;
      b[7] = 6;
      b[8] = 4;
      b[9] = 5;
      b[10] = 7;
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
      localVector.add(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), a(3), null));
      paramLineStyleEvent.styles = new StyleRange[localVector.size()];
      localVector.copyInto(paramLineStyleEvent.styles);
      return;
    }
    Color localColor1 = ((Control)paramLineStyleEvent.widget).getForeground();
    this.a.c(paramLineStyleEvent.lineText);
    for (int i1 = this.a.d(); i1 != -1; i1 = this.a.d())
    {
      if (i1 == 6)
        continue;
      StyleRange localStyleRange1;
      if (i1 != 1)
      {
        Color localColor2 = a(i1);
        if ((localColor2.equals(localColor1)) && (i1 != 2) && (i1 != 10))
          continue;
        StyleRange localStyleRange2 = new StyleRange(this.a.c() + paramLineStyleEvent.lineOffset, this.a.a(), localColor2, null);
        if (i1 == 2)
          localStyleRange2.fontStyle = 1;
        else if (i1 == 10)
          localStyleRange2.fontStyle = 2;
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
    int i2 = 0;
    int i3 = 0;
    int[] arrayOfInt = new int[2];
    int i4 = 0;
    try
    {
      while (i4 == 0)
      {
        int i1;
        switch (i1 = localStringReader.read())
        {
        case -1:
          if (i2 != 0)
          {
            arrayOfInt[1] = i3;
            this.d.add(arrayOfInt);
          }
          i4 = 1;
          break;
        case 47:
          i1 = localStringReader.read();
          if ((i1 == 42) && (i2 == 0))
          {
            arrayOfInt = new int[2];
            arrayOfInt[0] = i3;
            i2 = 1;
            i3++;
          }
          else
          {
            i3++;
          }
          i3++;
          break;
        case 42:
          if (i2 != 0)
          {
            i1 = localStringReader.read();
            i3++;
            if (i1 == 47)
            {
              i2 = 0;
              arrayOfInt[1] = i3;
              this.d.add(arrayOfInt);
            }
          }
          i3++;
          break;
        default:
          i3++;
        }
      }
    }
    catch (IOException localIOException)
    {
    }
  }

  public void a(List paramList)
  {
    this.e = paramList;
    for (int i1 = 0; i1 < paramList.size(); i1++)
      this.a.a(paramList.get(i1));
  }

  public void b(String paramString)
  {
    this.a.a(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.au
 * JD-Core Version:    0.6.0
 */