package org.agilemore.agilegrid;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;

public class ae
{
  private e a;
  private KeyListener b;

  public ae(e parame)
  {
    this(parame, true);
  }

  public ae(e parame, boolean paramBoolean)
  {
    this.a = parame;
    a(paramBoolean);
  }

  protected boolean a(ad paramad)
  {
    if ((paramad.h == 3) && (((MouseEvent)paramad.f).button == 1))
      return true;
    if ((paramad.h == 4) || (paramad.h == 5))
      return true;
    if (paramad.f.getClass() == KeyEvent.class)
    {
      KeyEvent localKeyEvent = (KeyEvent)paramad.f;
      switch (localKeyEvent.character)
      {
      case '\b':
      case '\r':
      case ' ':
      case '':
        return true;
      }
      if (((Character.isLetterOrDigit(localKeyEvent.character)) || (localKeyEvent.keyCode == 16777227) || ((localKeyEvent.keyCode > 32) && (localKeyEvent.keyCode < 254) && (localKeyEvent.keyCode != 127))) && (localKeyEvent.keyCode != 262144) && (localKeyEvent.keyCode != 65536) && ((localKeyEvent.stateMask & 0x40000) == 0) && ((localKeyEvent.stateMask & 0x10000) == 0))
        return true;
    }
    return false;
  }

  protected G a()
  {
    return this.a.A();
  }

  public e b()
  {
    return this.a;
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.b == null)
      {
        this.b = new af(this);
        this.a.addKeyListener(this.b);
      }
    }
    else if (this.b != null)
    {
      this.a.removeKeyListener(this.b);
      this.b = null;
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.ae
 * JD-Core Version:    0.6.0
 */