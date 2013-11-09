package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.SelectionEvent;

public class bj extends bi
{
  public bj(bf parambf)
  {
    super(parambf);
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (bf.a(this.a).getProjectTree().c() != null)
      bf.a(this.a).getProjectTree().c().updateTree();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bj
 * JD-Core Version:    0.6.0
 */