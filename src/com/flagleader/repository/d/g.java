package com.flagleader.repository.d;

import com.flagleader.repository.h;
import it.sauronsoftware.ftp4j.FTPCommunicationListener;

class g
  implements FTPCommunicationListener
{
  g(f paramf)
  {
  }

  public void received(String paramString)
  {
    this.a.f().f(paramString);
  }

  public void sent(String paramString)
  {
    this.a.f().f(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.g
 * JD-Core Version:    0.6.0
 */