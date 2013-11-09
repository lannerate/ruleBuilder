package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.AbstractRuleSet;
import com.flagleader.repository.tree.ITreeNode;

public class bd extends a
{
  public bd(bb parambb)
  {
  }

  public boolean b()
  {
    return !this.a.k().isLocked();
  }

  public String c()
  {
    return "RuleOrder";
  }

  public int g()
  {
    return 2;
  }

  public String[] i()
  {
    String[] arrayOfString = new String[this.a.k().getMaxPos() - this.a.k().getMinPos()];
    for (int i = 0; i < this.a.k().getMaxPos() - this.a.k().getMinPos(); i++)
      arrayOfString[i] = new Integer(this.a.k().getMinPos() + i + 1).toString();
    return arrayOfString;
  }

  public String j()
  {
    return new Integer(this.a.k().getPos() + 1).toString();
  }

  public boolean a(int paramInt)
  {
    if (this.a.k().getPos() != paramInt)
    {
      this.a.k().setPos(paramInt);
      this.a.k().setModified(true);
      if ((this.a.k().getParent() instanceof ITreeNode))
      {
        ((ITreeNode)this.a.k().getParent()).setModified(true);
        ((ITreeNode)this.a.k().getParent()).updateTree();
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bd
 * JD-Core Version:    0.6.0
 */