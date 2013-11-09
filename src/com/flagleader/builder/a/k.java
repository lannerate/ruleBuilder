package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

class k
  implements Listener
{
  k(j paramj, ITreeNode paramITreeNode)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    j.a(this.a).b.getProjectTree().c(this.b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.k
 * JD-Core Version:    0.6.0
 */