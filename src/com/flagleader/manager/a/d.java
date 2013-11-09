package com.flagleader.manager.a;

import com.flagleader.manager.builder.a;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IEnvionment;
import java.io.IOException;

class d extends a
{
  private IEnvionment b = null;

  public d(c paramc, IEnvionment paramIEnvionment)
  {
    this.b = paramIEnvionment;
  }

  public void cancel()
  {
    super.cancel();
  }

  public void ok()
  {
    try
    {
      this.b.save();
    }
    catch (IOException localIOException)
    {
      this.a.a.j().b(localIOException.getMessage());
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.d
 * JD-Core Version:    0.6.0
 */