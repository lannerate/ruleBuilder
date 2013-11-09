package com.flagleader.builder.a.f;

import java.io.File;
import org.eclipse.swt.browser.Browser;

class dd
  implements Runnable
{
  dd(da paramda, File paramFile)
  {
  }

  public void run()
  {
    if ((da.h(this.a) != null) && (!da.h(this.a).isDisposed()))
    {
      da.h(this.a).setUrl(this.b.getPath());
      da.h(this.a).update();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dd
 * JD-Core Version:    0.6.0
 */