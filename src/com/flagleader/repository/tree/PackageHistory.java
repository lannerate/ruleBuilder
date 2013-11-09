package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.List;

public class PackageHistory extends AbstractPackageElement
{
  private boolean visible = false;

  public PackageHistory(PackageHistory paramPackageHistory)
  {
    super(paramPackageHistory);
  }

  public PackageHistory()
  {
  }

  public String getName()
  {
    return "PackageHistory";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitPackageHistory(this);
  }

  public IElement deepClone()
  {
    return new PackageHistory(this);
  }

  public IPackageElement findRuleHistory(String paramString1, String paramString2)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof RuleHistory))
        continue;
      RuleHistory localRuleHistory = (RuleHistory)a().get(i);
      if ((localRuleHistory.getUuid().equals(paramString1)) || (localRuleHistory.getDisplayName().equals(paramString2)))
        return localRuleHistory.getTreeNode();
    }
    return null;
  }

  public void save()
  {
  }

  public boolean canCopy()
  {
    return false;
  }

  public boolean canCut()
  {
    return false;
  }

  public boolean canRedo()
  {
    return false;
  }

  public boolean canRename()
  {
    return false;
  }

  public boolean canUndo()
  {
    return false;
  }

  public boolean isModified()
  {
    return false;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public boolean paste(IElement paramIElement)
  {
    return false;
  }

  public void setModified(boolean paramBoolean)
  {
  }

  public boolean isLocked()
  {
    return true;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.PackageHistory
 * JD-Core Version:    0.6.0
 */