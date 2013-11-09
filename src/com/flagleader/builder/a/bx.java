package com.flagleader.builder.a;

import com.flagleader.builder.BuilderConfig;
import java.util.Hashtable;
import org.eclipse.swt.widgets.Display;

class bx
  implements Runnable
{
  bx(bu parambu)
  {
  }

  public void run()
  {
    if (bu.i(this.a).size() > BuilderConfig.getInstance().getCompositeBuffer())
      for (int i = 0; i < 10; i++)
        this.a.f();
    Display.getCurrent().timerExec(-1, this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.bx
 * JD-Core Version:    0.6.0
 */