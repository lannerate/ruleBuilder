package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;

class aI extends SelectionAdapter
{
  aI(aF paramaF, TableItem paramTableItem)
  {
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if ((this.b.getData() != null) && ((this.b.getData() instanceof ITreeNode)))
    {
      ITreeNode localITreeNode = (ITreeNode)this.b.getData();
      aq.e(aF.a(this.a)).getProjectTree().c(localITreeNode);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.aI
 * JD-Core Version:    0.6.0
 */