package com.flagleader.builder.widget.a;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class t
  implements LineStyleListener
{
  u a = new u(this);
  private static int[] t;
  private static Color[] u;
  private static String[] v = { "abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "{", "}", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while" };
  private static String[] w = { "+", "-", "*", "/", "%", "=", "!", "<", ">", "&", "|", "^", "?", ":", ";", ",", "~", "[", "]", "(", ")", ".", "{", "}" };
  protected static HashMap b = null;
  protected static String c = "+-*/%=!<>&|^?:;,~[]().{}";
  ArrayList d = new ArrayList();
  List e = new ArrayList();
  protected String f = "";
  public static final int g = -1;
  public static final int h = 11;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 5;
  public static final int n = 6;
  public static final int o = 7;
  public static final int p = 11;
  public static final int q = 8;
  public static final int r = 9;
  public static final int s = 10;

  static
  {
    b = new HashMap();
    Integer localInteger = new Integer(2);
    for (int i1 = 0; i1 < v.length; i1++)
      b.put(v[i1], localInteger);
  }

  public t()
  {
    a();
    this.a = new u(this);
  }

  Color a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= t.length))
      return null;
    return u[t[paramInt]];
  }

  public boolean a(int paramInt1, int paramInt2)
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
    if (u == null)
      u = new Color[] { new Color(localDisplay, new RGB(0, 0, 0)), new Color(localDisplay, new RGB(100, 155, 100)), new Color(localDisplay, new RGB(255, 0, 0)), new Color(localDisplay, new RGB(0, 0, 255)), new Color(localDisplay, new RGB(100, 0, 255)), new Color(localDisplay, new RGB(0, 0, 155)), new Color(localDisplay, new RGB(255, 55, 155)), new Color(localDisplay, new RGB(155, 0, 0)) };
    if (t == null)
    {
      t = new int[11];
      t[0] = 0;
      t[1] = 0;
      t[2] = 3;
      t[3] = 1;
      t[5] = 2;
      t[6] = 0;
      t[7] = 6;
      t[8] = 4;
      t[9] = 5;
      t[10] = 7;
    }
  }

  public void b()
  {
    for (int i1 = 0; i1 < u.length; i1++)
      u[i1].dispose();
  }

  public void lineGetStyle(LineStyleEvent paramLineStyleEvent)
  {
    Vector localVector = new Vector();
    if (a(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineOffset + paramLineStyleEvent.lineText.length()))
    {
      localVector.add(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), a(3), null, 2));
      paramLineStyleEvent.styles = new StyleRange[localVector.size()];
      localVector.copyInto(paramLineStyleEvent.styles);
      return;
    }
    Color localColor1 = ((Control)paramLineStyleEvent.widget).getForeground();
    this.a.b(paramLineStyleEvent.lineText);
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
    this.f = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.t
 * JD-Core Version:    0.6.0
 */