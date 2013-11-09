package com.flagleader.builder.a;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;

class bb
  implements Runnable
{
  bb(aS paramaS, int paramInt)
  {
  }

  public void run()
  {
    if ((this.a.m != null) && (!this.a.m.isDisposed()))
      if (this.a.p > this.b)
      {
        this.a.m.setSelection(this.b);
      }
      else
      {
        this.a.m.dispose();
        this.a.n.dispose();
        this.a.j.setSize(this.a.j.computeSize(-1, -1));
        this.a.j.redraw();
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bb
 * JD-Core Version:    0.6.0
 */