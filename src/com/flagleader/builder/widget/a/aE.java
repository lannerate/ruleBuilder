package com.flagleader.builder.widget.a;

import java.util.Vector;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class aE
  implements LineStyleListener
{
  private boolean n;
  aF a = new aF(this);
  static int[] b;
  static Color[] c;
  public static final int d = -1;
  public static final int e = 10;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;

  public aE()
  {
    a();
    this.a = new aF(this);
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
        StyleRange localStyleRange2 = new StyleRange(this.a.c() + paramLineStyleEvent.lineOffset, this.a.b(), localColor2, null);
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
        localStyleRange1.length += this.a.b();
      }
    }
    paramLineStyleEvent.styles = new StyleRange[localVector.size()];
    localVector.copyInto(paramLineStyleEvent.styles);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.aE
 * JD-Core Version:    0.6.0
 */