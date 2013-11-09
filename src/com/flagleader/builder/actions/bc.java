package com.flagleader.builder.actions;

import com.flagleader.repository.c.f;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.TreeItem;

class bc extends f
{
  bc(aO paramaO, TreeItem paramTreeItem, ITreeNode paramITreeNode)
  {
  }

  public void update()
  {
    if ((this.b != null) && (!this.b.isDisposed()))
      aO.a(this.a, this.b);
  }

  public void updateColor()
  {
    if ((this.b != null) && (!this.b.isDisposed()))
      aO.b(this.a, this.b);
  }

  public void updateText()
  {
    if ((this.b != null) && (!this.b.isDisposed()))
    {
      this.b.setText(this.c.getDisplayName());
      aO.b(this.c, this.b);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bc
 * JD-Core Version:    0.6.0
 */