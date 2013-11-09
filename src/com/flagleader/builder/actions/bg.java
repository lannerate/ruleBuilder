package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.events.SelectionEvent;

public class bg extends bi
{
  protected IRuleSet a = null;
  protected IRuleTree b = null;

  public bg(bf parambf, IRuleSet paramIRuleSet, IRuleTree paramIRuleTree)
  {
    super(parambf);
    this.a = paramIRuleSet;
    this.b = paramIRuleTree;
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if ((this.a != null) && (this.b != null))
      return this.a.acceptNode(this.b);
    return false;
  }

  public void widgetSelected(SelectionEvent paramSelectionEvent)
  {
    ITreeNode localITreeNode = (ITreeNode)this.b.deepClone();
    this.a.addChildElement(localITreeNode);
    this.a.updateTree();
    bf.a(this.c).getProjectTree().b(localITreeNode);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bg
 * JD-Core Version:    0.6.0
 */