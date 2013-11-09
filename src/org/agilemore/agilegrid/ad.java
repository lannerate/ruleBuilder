package org.agilemore.agilegrid;

import java.util.EventObject;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.TraverseEvent;

public class ad extends EventObject
{
  private static final long n = 1L;
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public EventObject f;
  public int g;
  public int h;
  public int i;
  public char j;
  public int k;
  public boolean l = false;
  public J m;

  public ad(G paramG, J paramJ)
  {
    super(paramG);
    this.m = paramJ;
    this.h = 4;
  }

  public ad(G paramG, J paramJ, MouseEvent paramMouseEvent, int paramInt)
  {
    super(paramG);
    this.m = paramJ;
    this.h = paramInt;
    this.f = paramMouseEvent;
    this.g = paramMouseEvent.time;
  }

  public ad(G paramG, J paramJ, KeyEvent paramKeyEvent)
  {
    super(paramG);
    this.m = paramJ;
    this.h = 1;
    this.f = paramKeyEvent;
    this.g = 0;
    this.i = paramKeyEvent.keyCode;
    this.j = paramKeyEvent.character;
    this.k = paramKeyEvent.stateMask;
  }

  public ad(G paramG, J paramJ, TraverseEvent paramTraverseEvent)
  {
    super(paramG);
    this.m = paramJ;
    this.h = 5;
    this.f = paramTraverseEvent;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.ad
 * JD-Core Version:    0.6.0
 */