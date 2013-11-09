package com.flagleader.builder.widget.a;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class r
  implements LineStyleListener
{
  s a = new s(this);
  static int[] b;
  static Color[] c;
  private ArrayList u = new ArrayList();
  protected String d = "";
  protected String e = "";
  List f = new ArrayList();
  private StyledText v = null;
  public static final int g = -1;
  public static final int h = 12;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 5;
  public static final int n = 6;
  public static final int o = 7;
  public static final int p = 8;
  public static final int q = 9;
  public static final int r = 12;
  public static final int s = 10;
  public static final int t = 11;

  public r(StyledText paramStyledText)
  {
    this.v = paramStyledText;
    a();
    this.a = new s(this);
  }

  Color a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= b.length))
      return null;
    return c[b[paramInt]];
  }

  void a()
  {
    Display localDisplay = Display.getDefault();
    if (c == null)
      c = new Color[] { new Color(localDisplay, new RGB(0, 0, 0)), new Color(localDisplay, new RGB(255, 0, 0)), new Color(localDisplay, new RGB(0, 255, 0)), new Color(localDisplay, new RGB(0, 0, 255)), new Color(localDisplay, new RGB(150, 150, 150)), new Color(localDisplay, new RGB(225, 166, 40)), new Color(localDisplay, new RGB(255, 100, 0)), new Color(localDisplay, new RGB(155, 0, 0)) };
    if (b == null)
    {
      b = new int[12];
      b[0] = 0;
      b[1] = 0;
      b[2] = 3;
      b[3] = 5;
      b[5] = 2;
      b[6] = 0;
      b[8] = 1;
      b[9] = 4;
      b[7] = 6;
      b[10] = 1;
      b[11] = 7;
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
    if (!this.d.equals(this.v.getText()))
    {
      this.d = this.v.getText();
      a(this.d);
    }
    if (!a(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineOffset + paramLineStyleEvent.lineText.length()))
    {
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), a(9), null));
      paramLineStyleEvent.styles = new StyleRange[localVector.size()];
      localVector.copyInto(paramLineStyleEvent.styles);
      return;
    }
    Color localColor1 = ((Control)paramLineStyleEvent.widget).getForeground();
    this.a.a(paramLineStyleEvent.lineText, paramLineStyleEvent.lineOffset);
    for (int i1 = this.a.d(); i1 != -1; i1 = this.a.d())
    {
      if (i1 == 6)
        continue;
      StyleRange localStyleRange1;
      if (i1 != 1)
      {
        Color localColor2 = a(i1);
        if ((i1 != 2) && (i1 != 10) && (localColor2.equals(localColor1)))
          continue;
        StyleRange localStyleRange2 = new StyleRange(this.a.c() + paramLineStyleEvent.lineOffset, this.a.a(), localColor2, null);
        if (i1 == 10)
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
    StringReader localStringReader = new StringReader(paramString);
    int i2 = 0;
    int i3 = 0;
    int[] arrayOfInt = new int[2];
    int i4 = 0;
    try
    {
      this.u.clear();
      while (i4 == 0)
      {
        int i1;
        switch (i1 = localStringReader.read())
        {
        case -1:
          if (i2 != 0)
          {
            arrayOfInt[1] = i3;
            this.u.add(arrayOfInt);
          }
          i4 = 1;
          break;
        case 60:
          i1 = localStringReader.read();
          if ((i1 == 37) && (i2 == 0))
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
        case 37:
          if (i2 != 0)
          {
            i1 = localStringReader.read();
            i3++;
            if (i1 == 62)
            {
              i2 = 0;
              arrayOfInt[1] = i3;
              this.u.add(arrayOfInt);
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

  boolean a(int paramInt1, int paramInt2)
  {
    for (int i1 = 0; i1 < this.u.size(); i1++)
    {
      int[] arrayOfInt = (int[])this.u.get(i1);
      if ((arrayOfInt[0] >= paramInt1) && (arrayOfInt[0] <= paramInt2))
        return true;
      if ((arrayOfInt[1] >= paramInt1) && (arrayOfInt[1] <= paramInt2))
        return true;
      if ((arrayOfInt[0] <= paramInt1) && (arrayOfInt[1] >= paramInt2))
        return true;
    }
    return false;
  }

  public void b(String paramString)
  {
    this.e = paramString;
  }

  public void a(List paramList)
  {
    this.f = paramList;
    for (int i1 = 0; i1 < paramList.size(); i1++)
      this.a.a(paramList.get(i1));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.r
 * JD-Core Version:    0.6.0
 */