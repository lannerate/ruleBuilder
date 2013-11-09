package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.SelectionEvent;

public class bk extends bi
{
  protected ak a = null;

  public bk(bf parambf, ak paramak)
  {
    super(parambf);
    this.a = paramak;
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (this.a != null)
      return this.a.a(paramITreeNode);
    return false;
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    if (this.a != null)
      this.a.b(bf.a(this.b).getProjectTree().c());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bk
 * JD-Core Version:    0.6.0
 */