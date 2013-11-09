package com.flagleader.builder.actions;

import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;

class aM
  implements LineStyleListener
{
  private aM(aq paramaq)
  {
  }

  public void lineGetStyle(LineStyleEvent paramLineStyleEvent)
  {
    Vector localVector = new Vector();
    Level localLevel = (Level)aq.a(this.a).get(paramLineStyleEvent.lineText);
    if (localLevel == Level.WARNING)
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), aq.d(), null));
    else if (localLevel == Level.SEVERE)
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), aq.e(), null));
    else if (localLevel == Level.CONFIG)
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), aq.f(), null));
    else if (localLevel == Level.INFO)
      localVector.addElement(new StyleRange(paramLineStyleEvent.lineOffset, paramLineStyleEvent.lineText.length(), aq.g(), null));
    paramLineStyleEvent.styles = new StyleRange[localVector.size()];
    localVector.copyInto(paramLineStyleEvent.styles);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aM
 * JD-Core Version:    0.6.0
 */