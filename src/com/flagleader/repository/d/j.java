package com.flagleader.repository.d;

import com.flagleader.repository.h;
import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;

class j
  implements ProtocolCommandListener
{
  j(i parami)
  {
  }

  public void protocolCommandSent(ProtocolCommandEvent paramProtocolCommandEvent)
  {
    this.a.f().f(paramProtocolCommandEvent.getMessage());
  }

  public void protocolReplyReceived(ProtocolCommandEvent paramProtocolCommandEvent)
  {
    this.a.f().f(paramProtocolCommandEvent.getMessage());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.j
 * JD-Core Version:    0.6.0
 */