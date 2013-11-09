package com.flagleader.builder.widget;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;

public class h
{
  public static final Color a = new Color(null, 0, 100, 166);
  public static final Color b = Display.getCurrent().getSystemColor(25);
  public static final Color c = Display.getDefault().getSystemColor(32);
  public static final Color d = Display.getDefault().getSystemColor(1);
  public static final Color e = Display.getDefault().getSystemColor(15);
  public static final Color f = Display.getDefault().getSystemColor(30);
  public static final Color g = new Color(null, 255, 0, 0);
  public static final Color h = new Color(null, 0, 255, 0);
  public static final Color i = new Color(null, 0, 0, 0);
  public static final Color j = new Color(null, 255, 155, 100);
  public static final Color k = new Color(null, 255, 100, 100);
  public static final Color l = new Color(null, 255, 100, 255);
  public static final int m = 20;
  private static Menu n = null;

  public static GridLayout a(int paramInt)
  {
    return a(paramInt, new int[4]);
  }

  public static GridLayout a(int paramInt, int[] paramArrayOfInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = paramInt;
    localGridLayout.marginHeight = paramArrayOfInt[0];
    localGridLayout.marginWidth = paramArrayOfInt[1];
    localGridLayout.horizontalSpacing = paramArrayOfInt[2];
    localGridLayout.verticalSpacing = paramArrayOfInt[3];
    return localGridLayout;
  }

  public static GridData b(int paramInt)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt;
    return localGridData;
  }

  public static GridData a(int paramInt1, int paramInt2)
  {
    GridData localGridData = new GridData();
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  public static GridData a(int paramInt1, int paramInt2, int paramInt3)
  {
    GridData localGridData = new GridData(paramInt3);
    localGridData.widthHint = paramInt1;
    localGridData.heightHint = paramInt2;
    return localGridData;
  }

  public static Menu a()
  {
    if ((n != null) && (!n.isDisposed()))
      n.dispose();
    n = new Menu(Display.getCurrent().getActiveShell(), 8);
    return n;
  }

  public static Menu b()
  {
    return n;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.h
 * JD-Core Version:    0.6.0
 */