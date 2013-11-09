package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.IApplication;
import org.eclipse.swt.browser.StatusTextEvent;
import org.eclipse.swt.browser.StatusTextListener;

class aZ
  implements StatusTextListener
{
  aZ(aX paramaX)
  {
  }

  public void changed(StatusTextEvent paramStatusTextEvent)
  {
    aX.e(this.a).getMainApp().setStatus(paramStatusTextEvent.text);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aZ
 * JD-Core Version:    0.6.0
 */