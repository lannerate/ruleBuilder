package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class e
  implements Listener
{
  e(d paramd, ITreeNode paramITreeNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    d.a(this.a).b.getProjectTree().c(this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.e
 * JD-Core Version:    0.6.0
 */