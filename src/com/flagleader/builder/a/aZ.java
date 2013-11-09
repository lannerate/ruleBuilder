package com.flagleader.builder.a;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

class aZ extends SelectionAdapter
{
  aZ(aS paramaS, Thread paramThread, boolean paramBoolean)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    this.a.B();
    if ((this.b != null) && (this.b.isAlive()))
      if (this.c)
      {
        this.b.stop();
        this.a.o = 2;
        this.a.b(this.a.p);
      }
      else
      {
        this.a.o = 2;
        this.b.interrupt();
      }
    this.a.b(this.a.p);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aZ
 * JD-Core Version:    0.6.0
 */